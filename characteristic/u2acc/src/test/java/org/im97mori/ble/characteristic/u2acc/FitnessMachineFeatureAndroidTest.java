package org.im97mori.ble.characteristic.u2acc;

import android.os.Build;
import android.os.Parcel;

import org.im97mori.ble.test.TestBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@SuppressWarnings({"unused", "ConstantConditions"})
@RunWith(RobolectricTestRunner.class)
@Config(instrumentedPackages = {
        // required to access final members on androidx.loader.content.ModernAsyncTask
        "androidx.loader.content"}
        , sdk = Build.VERSION_CODES.JELLY_BEAN_MR2)
public class FitnessMachineFeatureAndroidTest extends TestBase {

    //@formatter:off
    private static final byte[] data_00001;
    static {
        byte[] data = new byte[8];
        int fitnessMachineFeatureFlag = FitnessMachineFeature.FITNESS_MACHINE_FEATURES_AVERAGE_SPEED_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_CADENCE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_TOTAL_DISTANCE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_INCLINATION_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_ELEVATION_GAIN_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_PACE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_STEP_COUNT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_RESISTANCE_LEVEL_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_STRIDE_COUNT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_EXPENDED_ENERGY_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_HEART_RATE_MEASUREMENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_METABOLIC_EQUIVALENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_ELAPSED_TIME_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_REMAINING_TIME_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_POWER_MEASUREMENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_FORCE_ON_BELT_AND_POWER_OUTPUT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_USER_DATA_RETENTION_SUPPORTED_FALSE;
        int targetSettingFeature = FitnessMachineFeature.TARGET_SETTING_FEATURES_SPEED_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_INCLINATION_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_RESISTANCE_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_POWER_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_HEART_RATE_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_EXPENDED_ENERGY_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_STEP_NUMBER_CONFIGRATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_STRIDE_NUMBER_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_DISTANCE_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TRAINING_TIME_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_TWO_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_THREE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_FIVE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_INDOOR_BIKE_SIMULATION_PARAMETERS_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_WHEEL_CIRCUMFERENCE_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_SPIN_DOWN_CONTROL_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_CADENCE_CONFIGURATION_SUPPORTED_FALSE;
        data[ 0] = (byte) fitnessMachineFeatureFlag;
        data[ 1] = (byte) (fitnessMachineFeatureFlag >> 8);
        data[ 2] = (byte) (fitnessMachineFeatureFlag >> 16);
        data[ 3] = (byte) (fitnessMachineFeatureFlag >> 24);
        data[ 4] = (byte) targetSettingFeature;
        data[ 5] = (byte) (targetSettingFeature >> 8);
        data[ 6] = (byte) (targetSettingFeature >> 16);
        data[ 7] = (byte) (targetSettingFeature >> 24);
        data_00001 = data;
    }

    private static final byte[] data_00002;
    static {
        byte[] data = new byte[8];
        int fitnessMachineFeatureFlag = FitnessMachineFeature.FITNESS_MACHINE_FEATURES_AVERAGE_SPEED_SUPPORTED_TRUE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_CADENCE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_TOTAL_DISTANCE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_INCLINATION_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_ELEVATION_GAIN_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_PACE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_STEP_COUNT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_RESISTANCE_LEVEL_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_STRIDE_COUNT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_EXPENDED_ENERGY_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_HEART_RATE_MEASUREMENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_METABOLIC_EQUIVALENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_ELAPSED_TIME_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_REMAINING_TIME_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_POWER_MEASUREMENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_FORCE_ON_BELT_AND_POWER_OUTPUT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_USER_DATA_RETENTION_SUPPORTED_FALSE;
        int targetSettingFeature = FitnessMachineFeature.TARGET_SETTING_FEATURES_SPEED_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_INCLINATION_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_RESISTANCE_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_POWER_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_HEART_RATE_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_EXPENDED_ENERGY_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_STEP_NUMBER_CONFIGRATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_STRIDE_NUMBER_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_DISTANCE_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TRAINING_TIME_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_TWO_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_THREE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_FIVE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_INDOOR_BIKE_SIMULATION_PARAMETERS_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_WHEEL_CIRCUMFERENCE_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_SPIN_DOWN_CONTROL_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_CADENCE_CONFIGURATION_SUPPORTED_FALSE;
        data[ 0] = (byte) fitnessMachineFeatureFlag;
        data[ 1] = (byte) (fitnessMachineFeatureFlag >> 8);
        data[ 2] = (byte) (fitnessMachineFeatureFlag >> 16);
        data[ 3] = (byte) (fitnessMachineFeatureFlag >> 24);
        data[ 4] = (byte) targetSettingFeature;
        data[ 5] = (byte) (targetSettingFeature >> 8);
        data[ 6] = (byte) (targetSettingFeature >> 16);
        data[ 7] = (byte) (targetSettingFeature >> 24);
        data_00002 = data;
    }

    private static final byte[] data_00101;
    static {
        byte[] data = new byte[8];
        int fitnessMachineFeatureFlag = FitnessMachineFeature.FITNESS_MACHINE_FEATURES_AVERAGE_SPEED_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_CADENCE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_TOTAL_DISTANCE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_INCLINATION_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_ELEVATION_GAIN_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_PACE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_STEP_COUNT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_RESISTANCE_LEVEL_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_STRIDE_COUNT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_EXPENDED_ENERGY_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_HEART_RATE_MEASUREMENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_METABOLIC_EQUIVALENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_ELAPSED_TIME_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_REMAINING_TIME_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_POWER_MEASUREMENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_FORCE_ON_BELT_AND_POWER_OUTPUT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_USER_DATA_RETENTION_SUPPORTED_FALSE;
        int targetSettingFeature = FitnessMachineFeature.TARGET_SETTING_FEATURES_SPEED_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_INCLINATION_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_RESISTANCE_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_POWER_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_HEART_RATE_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_EXPENDED_ENERGY_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_STEP_NUMBER_CONFIGRATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_STRIDE_NUMBER_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_DISTANCE_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TRAINING_TIME_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_TWO_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_THREE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_FIVE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_INDOOR_BIKE_SIMULATION_PARAMETERS_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_WHEEL_CIRCUMFERENCE_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_SPIN_DOWN_CONTROL_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_CADENCE_CONFIGURATION_SUPPORTED_FALSE;
        data[ 0] = (byte) fitnessMachineFeatureFlag;
        data[ 1] = (byte) (fitnessMachineFeatureFlag >> 8);
        data[ 2] = (byte) (fitnessMachineFeatureFlag >> 16);
        data[ 3] = (byte) (fitnessMachineFeatureFlag >> 24);
        data[ 4] = (byte) targetSettingFeature;
        data[ 5] = (byte) (targetSettingFeature >> 8);
        data[ 6] = (byte) (targetSettingFeature >> 16);
        data[ 7] = (byte) (targetSettingFeature >> 24);
        data_00101 = data;
    }

    private static final byte[] data_00102;
    static {
        byte[] data = new byte[8];
        int fitnessMachineFeatureFlag = FitnessMachineFeature.FITNESS_MACHINE_FEATURES_AVERAGE_SPEED_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_CADENCE_SUPPORTED_TRUE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_TOTAL_DISTANCE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_INCLINATION_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_ELEVATION_GAIN_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_PACE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_STEP_COUNT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_RESISTANCE_LEVEL_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_STRIDE_COUNT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_EXPENDED_ENERGY_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_HEART_RATE_MEASUREMENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_METABOLIC_EQUIVALENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_ELAPSED_TIME_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_REMAINING_TIME_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_POWER_MEASUREMENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_FORCE_ON_BELT_AND_POWER_OUTPUT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_USER_DATA_RETENTION_SUPPORTED_FALSE;
        int targetSettingFeature = FitnessMachineFeature.TARGET_SETTING_FEATURES_SPEED_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_INCLINATION_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_RESISTANCE_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_POWER_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_HEART_RATE_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_EXPENDED_ENERGY_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_STEP_NUMBER_CONFIGRATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_STRIDE_NUMBER_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_DISTANCE_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TRAINING_TIME_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_TWO_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_THREE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_FIVE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_INDOOR_BIKE_SIMULATION_PARAMETERS_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_WHEEL_CIRCUMFERENCE_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_SPIN_DOWN_CONTROL_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_CADENCE_CONFIGURATION_SUPPORTED_FALSE;
        data[ 0] = (byte) fitnessMachineFeatureFlag;
        data[ 1] = (byte) (fitnessMachineFeatureFlag >> 8);
        data[ 2] = (byte) (fitnessMachineFeatureFlag >> 16);
        data[ 3] = (byte) (fitnessMachineFeatureFlag >> 24);
        data[ 4] = (byte) targetSettingFeature;
        data[ 5] = (byte) (targetSettingFeature >> 8);
        data[ 6] = (byte) (targetSettingFeature >> 16);
        data[ 7] = (byte) (targetSettingFeature >> 24);
        data_00102 = data;
    }

    private static final byte[] data_00201;
    static {
        byte[] data = new byte[8];
        int fitnessMachineFeatureFlag = FitnessMachineFeature.FITNESS_MACHINE_FEATURES_AVERAGE_SPEED_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_CADENCE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_TOTAL_DISTANCE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_INCLINATION_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_ELEVATION_GAIN_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_PACE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_STEP_COUNT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_RESISTANCE_LEVEL_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_STRIDE_COUNT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_EXPENDED_ENERGY_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_HEART_RATE_MEASUREMENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_METABOLIC_EQUIVALENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_ELAPSED_TIME_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_REMAINING_TIME_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_POWER_MEASUREMENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_FORCE_ON_BELT_AND_POWER_OUTPUT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_USER_DATA_RETENTION_SUPPORTED_FALSE;
        int targetSettingFeature = FitnessMachineFeature.TARGET_SETTING_FEATURES_SPEED_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_INCLINATION_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_RESISTANCE_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_POWER_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_HEART_RATE_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_EXPENDED_ENERGY_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_STEP_NUMBER_CONFIGRATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_STRIDE_NUMBER_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_DISTANCE_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TRAINING_TIME_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_TWO_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_THREE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_FIVE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_INDOOR_BIKE_SIMULATION_PARAMETERS_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_WHEEL_CIRCUMFERENCE_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_SPIN_DOWN_CONTROL_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_CADENCE_CONFIGURATION_SUPPORTED_FALSE;
        data[ 0] = (byte) fitnessMachineFeatureFlag;
        data[ 1] = (byte) (fitnessMachineFeatureFlag >> 8);
        data[ 2] = (byte) (fitnessMachineFeatureFlag >> 16);
        data[ 3] = (byte) (fitnessMachineFeatureFlag >> 24);
        data[ 4] = (byte) targetSettingFeature;
        data[ 5] = (byte) (targetSettingFeature >> 8);
        data[ 6] = (byte) (targetSettingFeature >> 16);
        data[ 7] = (byte) (targetSettingFeature >> 24);
        data_00201 = data;
    }

    private static final byte[] data_00202;
    static {
        byte[] data = new byte[8];
        int fitnessMachineFeatureFlag = FitnessMachineFeature.FITNESS_MACHINE_FEATURES_AVERAGE_SPEED_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_CADENCE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_TOTAL_DISTANCE_SUPPORTED_TRUE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_INCLINATION_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_ELEVATION_GAIN_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_PACE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_STEP_COUNT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_RESISTANCE_LEVEL_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_STRIDE_COUNT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_EXPENDED_ENERGY_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_HEART_RATE_MEASUREMENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_METABOLIC_EQUIVALENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_ELAPSED_TIME_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_REMAINING_TIME_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_POWER_MEASUREMENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_FORCE_ON_BELT_AND_POWER_OUTPUT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_USER_DATA_RETENTION_SUPPORTED_FALSE;
        int targetSettingFeature = FitnessMachineFeature.TARGET_SETTING_FEATURES_SPEED_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_INCLINATION_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_RESISTANCE_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_POWER_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_HEART_RATE_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_EXPENDED_ENERGY_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_STEP_NUMBER_CONFIGRATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_STRIDE_NUMBER_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_DISTANCE_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TRAINING_TIME_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_TWO_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_THREE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_FIVE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_INDOOR_BIKE_SIMULATION_PARAMETERS_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_WHEEL_CIRCUMFERENCE_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_SPIN_DOWN_CONTROL_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_CADENCE_CONFIGURATION_SUPPORTED_FALSE;
        data[ 0] = (byte) fitnessMachineFeatureFlag;
        data[ 1] = (byte) (fitnessMachineFeatureFlag >> 8);
        data[ 2] = (byte) (fitnessMachineFeatureFlag >> 16);
        data[ 3] = (byte) (fitnessMachineFeatureFlag >> 24);
        data[ 4] = (byte) targetSettingFeature;
        data[ 5] = (byte) (targetSettingFeature >> 8);
        data[ 6] = (byte) (targetSettingFeature >> 16);
        data[ 7] = (byte) (targetSettingFeature >> 24);
        data_00202 = data;
    }

    private static final byte[] data_00301;
    static {
        byte[] data = new byte[8];
        int fitnessMachineFeatureFlag = FitnessMachineFeature.FITNESS_MACHINE_FEATURES_AVERAGE_SPEED_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_CADENCE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_TOTAL_DISTANCE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_INCLINATION_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_ELEVATION_GAIN_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_PACE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_STEP_COUNT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_RESISTANCE_LEVEL_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_STRIDE_COUNT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_EXPENDED_ENERGY_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_HEART_RATE_MEASUREMENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_METABOLIC_EQUIVALENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_ELAPSED_TIME_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_REMAINING_TIME_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_POWER_MEASUREMENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_FORCE_ON_BELT_AND_POWER_OUTPUT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_USER_DATA_RETENTION_SUPPORTED_FALSE;
        int targetSettingFeature = FitnessMachineFeature.TARGET_SETTING_FEATURES_SPEED_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_INCLINATION_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_RESISTANCE_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_POWER_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_HEART_RATE_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_EXPENDED_ENERGY_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_STEP_NUMBER_CONFIGRATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_STRIDE_NUMBER_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_DISTANCE_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TRAINING_TIME_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_TWO_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_THREE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_FIVE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_INDOOR_BIKE_SIMULATION_PARAMETERS_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_WHEEL_CIRCUMFERENCE_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_SPIN_DOWN_CONTROL_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_CADENCE_CONFIGURATION_SUPPORTED_FALSE;
        data[ 0] = (byte) fitnessMachineFeatureFlag;
        data[ 1] = (byte) (fitnessMachineFeatureFlag >> 8);
        data[ 2] = (byte) (fitnessMachineFeatureFlag >> 16);
        data[ 3] = (byte) (fitnessMachineFeatureFlag >> 24);
        data[ 4] = (byte) targetSettingFeature;
        data[ 5] = (byte) (targetSettingFeature >> 8);
        data[ 6] = (byte) (targetSettingFeature >> 16);
        data[ 7] = (byte) (targetSettingFeature >> 24);
        data_00301 = data;
    }

    private static final byte[] data_00302;
    static {
        byte[] data = new byte[8];
        int fitnessMachineFeatureFlag = FitnessMachineFeature.FITNESS_MACHINE_FEATURES_AVERAGE_SPEED_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_CADENCE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_TOTAL_DISTANCE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_INCLINATION_SUPPORTED_TRUE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_ELEVATION_GAIN_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_PACE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_STEP_COUNT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_RESISTANCE_LEVEL_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_STRIDE_COUNT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_EXPENDED_ENERGY_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_HEART_RATE_MEASUREMENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_METABOLIC_EQUIVALENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_ELAPSED_TIME_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_REMAINING_TIME_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_POWER_MEASUREMENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_FORCE_ON_BELT_AND_POWER_OUTPUT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_USER_DATA_RETENTION_SUPPORTED_FALSE;
        int targetSettingFeature = FitnessMachineFeature.TARGET_SETTING_FEATURES_SPEED_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_INCLINATION_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_RESISTANCE_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_POWER_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_HEART_RATE_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_EXPENDED_ENERGY_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_STEP_NUMBER_CONFIGRATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_STRIDE_NUMBER_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_DISTANCE_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TRAINING_TIME_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_TWO_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_THREE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_FIVE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_INDOOR_BIKE_SIMULATION_PARAMETERS_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_WHEEL_CIRCUMFERENCE_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_SPIN_DOWN_CONTROL_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_CADENCE_CONFIGURATION_SUPPORTED_FALSE;
        data[ 0] = (byte) fitnessMachineFeatureFlag;
        data[ 1] = (byte) (fitnessMachineFeatureFlag >> 8);
        data[ 2] = (byte) (fitnessMachineFeatureFlag >> 16);
        data[ 3] = (byte) (fitnessMachineFeatureFlag >> 24);
        data[ 4] = (byte) targetSettingFeature;
        data[ 5] = (byte) (targetSettingFeature >> 8);
        data[ 6] = (byte) (targetSettingFeature >> 16);
        data[ 7] = (byte) (targetSettingFeature >> 24);
        data_00302 = data;
    }

    private static final byte[] data_00401;
    static {
        byte[] data = new byte[8];
        int fitnessMachineFeatureFlag = FitnessMachineFeature.FITNESS_MACHINE_FEATURES_AVERAGE_SPEED_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_CADENCE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_TOTAL_DISTANCE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_INCLINATION_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_ELEVATION_GAIN_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_PACE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_STEP_COUNT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_RESISTANCE_LEVEL_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_STRIDE_COUNT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_EXPENDED_ENERGY_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_HEART_RATE_MEASUREMENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_METABOLIC_EQUIVALENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_ELAPSED_TIME_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_REMAINING_TIME_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_POWER_MEASUREMENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_FORCE_ON_BELT_AND_POWER_OUTPUT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_USER_DATA_RETENTION_SUPPORTED_FALSE;
        int targetSettingFeature = FitnessMachineFeature.TARGET_SETTING_FEATURES_SPEED_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_INCLINATION_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_RESISTANCE_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_POWER_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_HEART_RATE_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_EXPENDED_ENERGY_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_STEP_NUMBER_CONFIGRATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_STRIDE_NUMBER_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_DISTANCE_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TRAINING_TIME_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_TWO_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_THREE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_FIVE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_INDOOR_BIKE_SIMULATION_PARAMETERS_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_WHEEL_CIRCUMFERENCE_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_SPIN_DOWN_CONTROL_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_CADENCE_CONFIGURATION_SUPPORTED_FALSE;
        data[ 0] = (byte) fitnessMachineFeatureFlag;
        data[ 1] = (byte) (fitnessMachineFeatureFlag >> 8);
        data[ 2] = (byte) (fitnessMachineFeatureFlag >> 16);
        data[ 3] = (byte) (fitnessMachineFeatureFlag >> 24);
        data[ 4] = (byte) targetSettingFeature;
        data[ 5] = (byte) (targetSettingFeature >> 8);
        data[ 6] = (byte) (targetSettingFeature >> 16);
        data[ 7] = (byte) (targetSettingFeature >> 24);
        data_00401 = data;
    }

    private static final byte[] data_00402;
    static {
        byte[] data = new byte[8];
        int fitnessMachineFeatureFlag = FitnessMachineFeature.FITNESS_MACHINE_FEATURES_AVERAGE_SPEED_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_CADENCE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_TOTAL_DISTANCE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_INCLINATION_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_ELEVATION_GAIN_SUPPORTED_TRUE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_PACE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_STEP_COUNT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_RESISTANCE_LEVEL_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_STRIDE_COUNT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_EXPENDED_ENERGY_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_HEART_RATE_MEASUREMENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_METABOLIC_EQUIVALENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_ELAPSED_TIME_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_REMAINING_TIME_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_POWER_MEASUREMENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_FORCE_ON_BELT_AND_POWER_OUTPUT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_USER_DATA_RETENTION_SUPPORTED_FALSE;
        int targetSettingFeature = FitnessMachineFeature.TARGET_SETTING_FEATURES_SPEED_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_INCLINATION_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_RESISTANCE_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_POWER_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_HEART_RATE_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_EXPENDED_ENERGY_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_STEP_NUMBER_CONFIGRATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_STRIDE_NUMBER_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_DISTANCE_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TRAINING_TIME_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_TWO_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_THREE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_FIVE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_INDOOR_BIKE_SIMULATION_PARAMETERS_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_WHEEL_CIRCUMFERENCE_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_SPIN_DOWN_CONTROL_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_CADENCE_CONFIGURATION_SUPPORTED_FALSE;
        data[ 0] = (byte) fitnessMachineFeatureFlag;
        data[ 1] = (byte) (fitnessMachineFeatureFlag >> 8);
        data[ 2] = (byte) (fitnessMachineFeatureFlag >> 16);
        data[ 3] = (byte) (fitnessMachineFeatureFlag >> 24);
        data[ 4] = (byte) targetSettingFeature;
        data[ 5] = (byte) (targetSettingFeature >> 8);
        data[ 6] = (byte) (targetSettingFeature >> 16);
        data[ 7] = (byte) (targetSettingFeature >> 24);
        data_00402 = data;
    }

    private static final byte[] data_00501;
    static {
        byte[] data = new byte[8];
        int fitnessMachineFeatureFlag = FitnessMachineFeature.FITNESS_MACHINE_FEATURES_AVERAGE_SPEED_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_CADENCE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_TOTAL_DISTANCE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_INCLINATION_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_ELEVATION_GAIN_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_PACE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_STEP_COUNT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_RESISTANCE_LEVEL_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_STRIDE_COUNT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_EXPENDED_ENERGY_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_HEART_RATE_MEASUREMENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_METABOLIC_EQUIVALENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_ELAPSED_TIME_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_REMAINING_TIME_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_POWER_MEASUREMENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_FORCE_ON_BELT_AND_POWER_OUTPUT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_USER_DATA_RETENTION_SUPPORTED_FALSE;
        int targetSettingFeature = FitnessMachineFeature.TARGET_SETTING_FEATURES_SPEED_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_INCLINATION_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_RESISTANCE_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_POWER_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_HEART_RATE_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_EXPENDED_ENERGY_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_STEP_NUMBER_CONFIGRATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_STRIDE_NUMBER_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_DISTANCE_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TRAINING_TIME_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_TWO_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_THREE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_FIVE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_INDOOR_BIKE_SIMULATION_PARAMETERS_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_WHEEL_CIRCUMFERENCE_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_SPIN_DOWN_CONTROL_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_CADENCE_CONFIGURATION_SUPPORTED_FALSE;
        data[ 0] = (byte) fitnessMachineFeatureFlag;
        data[ 1] = (byte) (fitnessMachineFeatureFlag >> 8);
        data[ 2] = (byte) (fitnessMachineFeatureFlag >> 16);
        data[ 3] = (byte) (fitnessMachineFeatureFlag >> 24);
        data[ 4] = (byte) targetSettingFeature;
        data[ 5] = (byte) (targetSettingFeature >> 8);
        data[ 6] = (byte) (targetSettingFeature >> 16);
        data[ 7] = (byte) (targetSettingFeature >> 24);
        data_00501 = data;
    }

    private static final byte[] data_00502;
    static {
        byte[] data = new byte[8];
        int fitnessMachineFeatureFlag = FitnessMachineFeature.FITNESS_MACHINE_FEATURES_AVERAGE_SPEED_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_CADENCE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_TOTAL_DISTANCE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_INCLINATION_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_ELEVATION_GAIN_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_PACE_SUPPORTED_TRUE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_STEP_COUNT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_RESISTANCE_LEVEL_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_STRIDE_COUNT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_EXPENDED_ENERGY_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_HEART_RATE_MEASUREMENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_METABOLIC_EQUIVALENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_ELAPSED_TIME_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_REMAINING_TIME_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_POWER_MEASUREMENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_FORCE_ON_BELT_AND_POWER_OUTPUT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_USER_DATA_RETENTION_SUPPORTED_FALSE;
        int targetSettingFeature = FitnessMachineFeature.TARGET_SETTING_FEATURES_SPEED_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_INCLINATION_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_RESISTANCE_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_POWER_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_HEART_RATE_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_EXPENDED_ENERGY_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_STEP_NUMBER_CONFIGRATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_STRIDE_NUMBER_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_DISTANCE_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TRAINING_TIME_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_TWO_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_THREE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_FIVE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_INDOOR_BIKE_SIMULATION_PARAMETERS_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_WHEEL_CIRCUMFERENCE_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_SPIN_DOWN_CONTROL_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_CADENCE_CONFIGURATION_SUPPORTED_FALSE;
        data[ 0] = (byte) fitnessMachineFeatureFlag;
        data[ 1] = (byte) (fitnessMachineFeatureFlag >> 8);
        data[ 2] = (byte) (fitnessMachineFeatureFlag >> 16);
        data[ 3] = (byte) (fitnessMachineFeatureFlag >> 24);
        data[ 4] = (byte) targetSettingFeature;
        data[ 5] = (byte) (targetSettingFeature >> 8);
        data[ 6] = (byte) (targetSettingFeature >> 16);
        data[ 7] = (byte) (targetSettingFeature >> 24);
        data_00502 = data;
    }

    private static final byte[] data_00601;
    static {
        byte[] data = new byte[8];
        int fitnessMachineFeatureFlag = FitnessMachineFeature.FITNESS_MACHINE_FEATURES_AVERAGE_SPEED_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_CADENCE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_TOTAL_DISTANCE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_INCLINATION_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_ELEVATION_GAIN_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_PACE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_STEP_COUNT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_RESISTANCE_LEVEL_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_STRIDE_COUNT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_EXPENDED_ENERGY_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_HEART_RATE_MEASUREMENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_METABOLIC_EQUIVALENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_ELAPSED_TIME_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_REMAINING_TIME_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_POWER_MEASUREMENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_FORCE_ON_BELT_AND_POWER_OUTPUT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_USER_DATA_RETENTION_SUPPORTED_FALSE;
        int targetSettingFeature = FitnessMachineFeature.TARGET_SETTING_FEATURES_SPEED_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_INCLINATION_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_RESISTANCE_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_POWER_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_HEART_RATE_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_EXPENDED_ENERGY_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_STEP_NUMBER_CONFIGRATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_STRIDE_NUMBER_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_DISTANCE_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TRAINING_TIME_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_TWO_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_THREE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_FIVE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_INDOOR_BIKE_SIMULATION_PARAMETERS_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_WHEEL_CIRCUMFERENCE_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_SPIN_DOWN_CONTROL_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_CADENCE_CONFIGURATION_SUPPORTED_FALSE;
        data[ 0] = (byte) fitnessMachineFeatureFlag;
        data[ 1] = (byte) (fitnessMachineFeatureFlag >> 8);
        data[ 2] = (byte) (fitnessMachineFeatureFlag >> 16);
        data[ 3] = (byte) (fitnessMachineFeatureFlag >> 24);
        data[ 4] = (byte) targetSettingFeature;
        data[ 5] = (byte) (targetSettingFeature >> 8);
        data[ 6] = (byte) (targetSettingFeature >> 16);
        data[ 7] = (byte) (targetSettingFeature >> 24);
        data_00601 = data;
    }

    private static final byte[] data_00602;
    static {
        byte[] data = new byte[8];
        int fitnessMachineFeatureFlag = FitnessMachineFeature.FITNESS_MACHINE_FEATURES_AVERAGE_SPEED_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_CADENCE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_TOTAL_DISTANCE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_INCLINATION_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_ELEVATION_GAIN_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_PACE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_STEP_COUNT_SUPPORTED_TRUE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_RESISTANCE_LEVEL_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_STRIDE_COUNT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_EXPENDED_ENERGY_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_HEART_RATE_MEASUREMENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_METABOLIC_EQUIVALENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_ELAPSED_TIME_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_REMAINING_TIME_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_POWER_MEASUREMENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_FORCE_ON_BELT_AND_POWER_OUTPUT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_USER_DATA_RETENTION_SUPPORTED_FALSE;
        int targetSettingFeature = FitnessMachineFeature.TARGET_SETTING_FEATURES_SPEED_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_INCLINATION_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_RESISTANCE_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_POWER_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_HEART_RATE_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_EXPENDED_ENERGY_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_STEP_NUMBER_CONFIGRATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_STRIDE_NUMBER_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_DISTANCE_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TRAINING_TIME_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_TWO_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_THREE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_FIVE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_INDOOR_BIKE_SIMULATION_PARAMETERS_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_WHEEL_CIRCUMFERENCE_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_SPIN_DOWN_CONTROL_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_CADENCE_CONFIGURATION_SUPPORTED_FALSE;
        data[ 0] = (byte) fitnessMachineFeatureFlag;
        data[ 1] = (byte) (fitnessMachineFeatureFlag >> 8);
        data[ 2] = (byte) (fitnessMachineFeatureFlag >> 16);
        data[ 3] = (byte) (fitnessMachineFeatureFlag >> 24);
        data[ 4] = (byte) targetSettingFeature;
        data[ 5] = (byte) (targetSettingFeature >> 8);
        data[ 6] = (byte) (targetSettingFeature >> 16);
        data[ 7] = (byte) (targetSettingFeature >> 24);
        data_00602 = data;
    }

    private static final byte[] data_00701;
    static {
        byte[] data = new byte[8];
        int fitnessMachineFeatureFlag = FitnessMachineFeature.FITNESS_MACHINE_FEATURES_AVERAGE_SPEED_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_CADENCE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_TOTAL_DISTANCE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_INCLINATION_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_ELEVATION_GAIN_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_PACE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_STEP_COUNT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_RESISTANCE_LEVEL_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_STRIDE_COUNT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_EXPENDED_ENERGY_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_HEART_RATE_MEASUREMENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_METABOLIC_EQUIVALENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_ELAPSED_TIME_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_REMAINING_TIME_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_POWER_MEASUREMENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_FORCE_ON_BELT_AND_POWER_OUTPUT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_USER_DATA_RETENTION_SUPPORTED_FALSE;
        int targetSettingFeature = FitnessMachineFeature.TARGET_SETTING_FEATURES_SPEED_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_INCLINATION_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_RESISTANCE_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_POWER_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_HEART_RATE_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_EXPENDED_ENERGY_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_STEP_NUMBER_CONFIGRATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_STRIDE_NUMBER_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_DISTANCE_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TRAINING_TIME_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_TWO_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_THREE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_FIVE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_INDOOR_BIKE_SIMULATION_PARAMETERS_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_WHEEL_CIRCUMFERENCE_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_SPIN_DOWN_CONTROL_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_CADENCE_CONFIGURATION_SUPPORTED_FALSE;
        data[ 0] = (byte) fitnessMachineFeatureFlag;
        data[ 1] = (byte) (fitnessMachineFeatureFlag >> 8);
        data[ 2] = (byte) (fitnessMachineFeatureFlag >> 16);
        data[ 3] = (byte) (fitnessMachineFeatureFlag >> 24);
        data[ 4] = (byte) targetSettingFeature;
        data[ 5] = (byte) (targetSettingFeature >> 8);
        data[ 6] = (byte) (targetSettingFeature >> 16);
        data[ 7] = (byte) (targetSettingFeature >> 24);
        data_00701 = data;
    }

    private static final byte[] data_00702;
    static {
        byte[] data = new byte[8];
        int fitnessMachineFeatureFlag = FitnessMachineFeature.FITNESS_MACHINE_FEATURES_AVERAGE_SPEED_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_CADENCE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_TOTAL_DISTANCE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_INCLINATION_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_ELEVATION_GAIN_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_PACE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_STEP_COUNT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_RESISTANCE_LEVEL_SUPPORTED_TRUE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_STRIDE_COUNT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_EXPENDED_ENERGY_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_HEART_RATE_MEASUREMENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_METABOLIC_EQUIVALENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_ELAPSED_TIME_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_REMAINING_TIME_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_POWER_MEASUREMENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_FORCE_ON_BELT_AND_POWER_OUTPUT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_USER_DATA_RETENTION_SUPPORTED_FALSE;
        int targetSettingFeature = FitnessMachineFeature.TARGET_SETTING_FEATURES_SPEED_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_INCLINATION_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_RESISTANCE_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_POWER_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_HEART_RATE_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_EXPENDED_ENERGY_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_STEP_NUMBER_CONFIGRATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_STRIDE_NUMBER_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_DISTANCE_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TRAINING_TIME_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_TWO_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_THREE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_FIVE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_INDOOR_BIKE_SIMULATION_PARAMETERS_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_WHEEL_CIRCUMFERENCE_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_SPIN_DOWN_CONTROL_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_CADENCE_CONFIGURATION_SUPPORTED_FALSE;
        data[ 0] = (byte) fitnessMachineFeatureFlag;
        data[ 1] = (byte) (fitnessMachineFeatureFlag >> 8);
        data[ 2] = (byte) (fitnessMachineFeatureFlag >> 16);
        data[ 3] = (byte) (fitnessMachineFeatureFlag >> 24);
        data[ 4] = (byte) targetSettingFeature;
        data[ 5] = (byte) (targetSettingFeature >> 8);
        data[ 6] = (byte) (targetSettingFeature >> 16);
        data[ 7] = (byte) (targetSettingFeature >> 24);
        data_00702 = data;
    }

    private static final byte[] data_00801;
    static {
        byte[] data = new byte[8];
        int fitnessMachineFeatureFlag = FitnessMachineFeature.FITNESS_MACHINE_FEATURES_AVERAGE_SPEED_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_CADENCE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_TOTAL_DISTANCE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_INCLINATION_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_ELEVATION_GAIN_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_PACE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_STEP_COUNT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_RESISTANCE_LEVEL_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_STRIDE_COUNT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_EXPENDED_ENERGY_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_HEART_RATE_MEASUREMENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_METABOLIC_EQUIVALENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_ELAPSED_TIME_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_REMAINING_TIME_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_POWER_MEASUREMENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_FORCE_ON_BELT_AND_POWER_OUTPUT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_USER_DATA_RETENTION_SUPPORTED_FALSE;
        int targetSettingFeature = FitnessMachineFeature.TARGET_SETTING_FEATURES_SPEED_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_INCLINATION_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_RESISTANCE_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_POWER_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_HEART_RATE_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_EXPENDED_ENERGY_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_STEP_NUMBER_CONFIGRATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_STRIDE_NUMBER_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_DISTANCE_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TRAINING_TIME_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_TWO_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_THREE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_FIVE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_INDOOR_BIKE_SIMULATION_PARAMETERS_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_WHEEL_CIRCUMFERENCE_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_SPIN_DOWN_CONTROL_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_CADENCE_CONFIGURATION_SUPPORTED_FALSE;
        data[ 0] = (byte) fitnessMachineFeatureFlag;
        data[ 1] = (byte) (fitnessMachineFeatureFlag >> 8);
        data[ 2] = (byte) (fitnessMachineFeatureFlag >> 16);
        data[ 3] = (byte) (fitnessMachineFeatureFlag >> 24);
        data[ 4] = (byte) targetSettingFeature;
        data[ 5] = (byte) (targetSettingFeature >> 8);
        data[ 6] = (byte) (targetSettingFeature >> 16);
        data[ 7] = (byte) (targetSettingFeature >> 24);
        data_00801 = data;
    }

    private static final byte[] data_00802;
    static {
        byte[] data = new byte[8];
        int fitnessMachineFeatureFlag = FitnessMachineFeature.FITNESS_MACHINE_FEATURES_AVERAGE_SPEED_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_CADENCE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_TOTAL_DISTANCE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_INCLINATION_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_ELEVATION_GAIN_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_PACE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_STEP_COUNT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_RESISTANCE_LEVEL_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_STRIDE_COUNT_SUPPORTED_TRUE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_EXPENDED_ENERGY_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_HEART_RATE_MEASUREMENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_METABOLIC_EQUIVALENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_ELAPSED_TIME_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_REMAINING_TIME_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_POWER_MEASUREMENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_FORCE_ON_BELT_AND_POWER_OUTPUT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_USER_DATA_RETENTION_SUPPORTED_FALSE;
        int targetSettingFeature = FitnessMachineFeature.TARGET_SETTING_FEATURES_SPEED_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_INCLINATION_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_RESISTANCE_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_POWER_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_HEART_RATE_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_EXPENDED_ENERGY_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_STEP_NUMBER_CONFIGRATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_STRIDE_NUMBER_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_DISTANCE_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TRAINING_TIME_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_TWO_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_THREE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_FIVE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_INDOOR_BIKE_SIMULATION_PARAMETERS_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_WHEEL_CIRCUMFERENCE_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_SPIN_DOWN_CONTROL_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_CADENCE_CONFIGURATION_SUPPORTED_FALSE;
        data[ 0] = (byte) fitnessMachineFeatureFlag;
        data[ 1] = (byte) (fitnessMachineFeatureFlag >> 8);
        data[ 2] = (byte) (fitnessMachineFeatureFlag >> 16);
        data[ 3] = (byte) (fitnessMachineFeatureFlag >> 24);
        data[ 4] = (byte) targetSettingFeature;
        data[ 5] = (byte) (targetSettingFeature >> 8);
        data[ 6] = (byte) (targetSettingFeature >> 16);
        data[ 7] = (byte) (targetSettingFeature >> 24);
        data_00802 = data;
    }

    private static final byte[] data_00901;
    static {
        byte[] data = new byte[8];
        int fitnessMachineFeatureFlag = FitnessMachineFeature.FITNESS_MACHINE_FEATURES_AVERAGE_SPEED_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_CADENCE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_TOTAL_DISTANCE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_INCLINATION_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_ELEVATION_GAIN_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_PACE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_STEP_COUNT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_RESISTANCE_LEVEL_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_STRIDE_COUNT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_EXPENDED_ENERGY_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_HEART_RATE_MEASUREMENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_METABOLIC_EQUIVALENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_ELAPSED_TIME_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_REMAINING_TIME_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_POWER_MEASUREMENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_FORCE_ON_BELT_AND_POWER_OUTPUT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_USER_DATA_RETENTION_SUPPORTED_FALSE;
        int targetSettingFeature = FitnessMachineFeature.TARGET_SETTING_FEATURES_SPEED_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_INCLINATION_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_RESISTANCE_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_POWER_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_HEART_RATE_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_EXPENDED_ENERGY_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_STEP_NUMBER_CONFIGRATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_STRIDE_NUMBER_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_DISTANCE_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TRAINING_TIME_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_TWO_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_THREE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_FIVE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_INDOOR_BIKE_SIMULATION_PARAMETERS_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_WHEEL_CIRCUMFERENCE_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_SPIN_DOWN_CONTROL_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_CADENCE_CONFIGURATION_SUPPORTED_FALSE;
        data[ 0] = (byte) fitnessMachineFeatureFlag;
        data[ 1] = (byte) (fitnessMachineFeatureFlag >> 8);
        data[ 2] = (byte) (fitnessMachineFeatureFlag >> 16);
        data[ 3] = (byte) (fitnessMachineFeatureFlag >> 24);
        data[ 4] = (byte) targetSettingFeature;
        data[ 5] = (byte) (targetSettingFeature >> 8);
        data[ 6] = (byte) (targetSettingFeature >> 16);
        data[ 7] = (byte) (targetSettingFeature >> 24);
        data_00901 = data;
    }

    private static final byte[] data_00902;
    static {
        byte[] data = new byte[8];
        int fitnessMachineFeatureFlag = FitnessMachineFeature.FITNESS_MACHINE_FEATURES_AVERAGE_SPEED_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_CADENCE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_TOTAL_DISTANCE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_INCLINATION_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_ELEVATION_GAIN_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_PACE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_STEP_COUNT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_RESISTANCE_LEVEL_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_STRIDE_COUNT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_EXPENDED_ENERGY_SUPPORTED_TRUE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_HEART_RATE_MEASUREMENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_METABOLIC_EQUIVALENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_ELAPSED_TIME_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_REMAINING_TIME_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_POWER_MEASUREMENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_FORCE_ON_BELT_AND_POWER_OUTPUT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_USER_DATA_RETENTION_SUPPORTED_FALSE;
        int targetSettingFeature = FitnessMachineFeature.TARGET_SETTING_FEATURES_SPEED_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_INCLINATION_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_RESISTANCE_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_POWER_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_HEART_RATE_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_EXPENDED_ENERGY_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_STEP_NUMBER_CONFIGRATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_STRIDE_NUMBER_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_DISTANCE_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TRAINING_TIME_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_TWO_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_THREE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_FIVE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_INDOOR_BIKE_SIMULATION_PARAMETERS_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_WHEEL_CIRCUMFERENCE_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_SPIN_DOWN_CONTROL_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_CADENCE_CONFIGURATION_SUPPORTED_FALSE;
        data[ 0] = (byte) fitnessMachineFeatureFlag;
        data[ 1] = (byte) (fitnessMachineFeatureFlag >> 8);
        data[ 2] = (byte) (fitnessMachineFeatureFlag >> 16);
        data[ 3] = (byte) (fitnessMachineFeatureFlag >> 24);
        data[ 4] = (byte) targetSettingFeature;
        data[ 5] = (byte) (targetSettingFeature >> 8);
        data[ 6] = (byte) (targetSettingFeature >> 16);
        data[ 7] = (byte) (targetSettingFeature >> 24);
        data_00902 = data;
    }

    private static final byte[] data_01001;
    static {
        byte[] data = new byte[8];
        int fitnessMachineFeatureFlag = FitnessMachineFeature.FITNESS_MACHINE_FEATURES_AVERAGE_SPEED_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_CADENCE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_TOTAL_DISTANCE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_INCLINATION_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_ELEVATION_GAIN_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_PACE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_STEP_COUNT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_RESISTANCE_LEVEL_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_STRIDE_COUNT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_EXPENDED_ENERGY_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_HEART_RATE_MEASUREMENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_METABOLIC_EQUIVALENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_ELAPSED_TIME_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_REMAINING_TIME_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_POWER_MEASUREMENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_FORCE_ON_BELT_AND_POWER_OUTPUT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_USER_DATA_RETENTION_SUPPORTED_FALSE;
        int targetSettingFeature = FitnessMachineFeature.TARGET_SETTING_FEATURES_SPEED_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_INCLINATION_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_RESISTANCE_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_POWER_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_HEART_RATE_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_EXPENDED_ENERGY_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_STEP_NUMBER_CONFIGRATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_STRIDE_NUMBER_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_DISTANCE_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TRAINING_TIME_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_TWO_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_THREE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_FIVE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_INDOOR_BIKE_SIMULATION_PARAMETERS_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_WHEEL_CIRCUMFERENCE_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_SPIN_DOWN_CONTROL_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_CADENCE_CONFIGURATION_SUPPORTED_FALSE;
        data[ 0] = (byte) fitnessMachineFeatureFlag;
        data[ 1] = (byte) (fitnessMachineFeatureFlag >> 8);
        data[ 2] = (byte) (fitnessMachineFeatureFlag >> 16);
        data[ 3] = (byte) (fitnessMachineFeatureFlag >> 24);
        data[ 4] = (byte) targetSettingFeature;
        data[ 5] = (byte) (targetSettingFeature >> 8);
        data[ 6] = (byte) (targetSettingFeature >> 16);
        data[ 7] = (byte) (targetSettingFeature >> 24);
        data_01001 = data;
    }

    private static final byte[] data_01002;
    static {
        byte[] data = new byte[8];
        int fitnessMachineFeatureFlag = FitnessMachineFeature.FITNESS_MACHINE_FEATURES_AVERAGE_SPEED_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_CADENCE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_TOTAL_DISTANCE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_INCLINATION_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_ELEVATION_GAIN_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_PACE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_STEP_COUNT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_RESISTANCE_LEVEL_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_STRIDE_COUNT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_EXPENDED_ENERGY_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_HEART_RATE_MEASUREMENT_SUPPORTED_TRUE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_METABOLIC_EQUIVALENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_ELAPSED_TIME_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_REMAINING_TIME_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_POWER_MEASUREMENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_FORCE_ON_BELT_AND_POWER_OUTPUT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_USER_DATA_RETENTION_SUPPORTED_FALSE;
        int targetSettingFeature = FitnessMachineFeature.TARGET_SETTING_FEATURES_SPEED_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_INCLINATION_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_RESISTANCE_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_POWER_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_HEART_RATE_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_EXPENDED_ENERGY_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_STEP_NUMBER_CONFIGRATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_STRIDE_NUMBER_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_DISTANCE_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TRAINING_TIME_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_TWO_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_THREE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_FIVE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_INDOOR_BIKE_SIMULATION_PARAMETERS_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_WHEEL_CIRCUMFERENCE_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_SPIN_DOWN_CONTROL_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_CADENCE_CONFIGURATION_SUPPORTED_FALSE;
        data[ 0] = (byte) fitnessMachineFeatureFlag;
        data[ 1] = (byte) (fitnessMachineFeatureFlag >> 8);
        data[ 2] = (byte) (fitnessMachineFeatureFlag >> 16);
        data[ 3] = (byte) (fitnessMachineFeatureFlag >> 24);
        data[ 4] = (byte) targetSettingFeature;
        data[ 5] = (byte) (targetSettingFeature >> 8);
        data[ 6] = (byte) (targetSettingFeature >> 16);
        data[ 7] = (byte) (targetSettingFeature >> 24);
        data_01002 = data;
    }

    private static final byte[] data_01101;
    static {
        byte[] data = new byte[8];
        int fitnessMachineFeatureFlag = FitnessMachineFeature.FITNESS_MACHINE_FEATURES_AVERAGE_SPEED_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_CADENCE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_TOTAL_DISTANCE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_INCLINATION_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_ELEVATION_GAIN_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_PACE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_STEP_COUNT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_RESISTANCE_LEVEL_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_STRIDE_COUNT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_EXPENDED_ENERGY_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_HEART_RATE_MEASUREMENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_METABOLIC_EQUIVALENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_ELAPSED_TIME_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_REMAINING_TIME_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_POWER_MEASUREMENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_FORCE_ON_BELT_AND_POWER_OUTPUT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_USER_DATA_RETENTION_SUPPORTED_FALSE;
        int targetSettingFeature = FitnessMachineFeature.TARGET_SETTING_FEATURES_SPEED_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_INCLINATION_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_RESISTANCE_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_POWER_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_HEART_RATE_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_EXPENDED_ENERGY_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_STEP_NUMBER_CONFIGRATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_STRIDE_NUMBER_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_DISTANCE_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TRAINING_TIME_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_TWO_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_THREE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_FIVE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_INDOOR_BIKE_SIMULATION_PARAMETERS_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_WHEEL_CIRCUMFERENCE_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_SPIN_DOWN_CONTROL_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_CADENCE_CONFIGURATION_SUPPORTED_FALSE;
        data[ 0] = (byte) fitnessMachineFeatureFlag;
        data[ 1] = (byte) (fitnessMachineFeatureFlag >> 8);
        data[ 2] = (byte) (fitnessMachineFeatureFlag >> 16);
        data[ 3] = (byte) (fitnessMachineFeatureFlag >> 24);
        data[ 4] = (byte) targetSettingFeature;
        data[ 5] = (byte) (targetSettingFeature >> 8);
        data[ 6] = (byte) (targetSettingFeature >> 16);
        data[ 7] = (byte) (targetSettingFeature >> 24);
        data_01101 = data;
    }

    private static final byte[] data_01102;
    static {
        byte[] data = new byte[8];
        int fitnessMachineFeatureFlag = FitnessMachineFeature.FITNESS_MACHINE_FEATURES_AVERAGE_SPEED_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_CADENCE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_TOTAL_DISTANCE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_INCLINATION_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_ELEVATION_GAIN_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_PACE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_STEP_COUNT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_RESISTANCE_LEVEL_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_STRIDE_COUNT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_EXPENDED_ENERGY_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_HEART_RATE_MEASUREMENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_METABOLIC_EQUIVALENT_SUPPORTED_TRUE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_ELAPSED_TIME_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_REMAINING_TIME_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_POWER_MEASUREMENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_FORCE_ON_BELT_AND_POWER_OUTPUT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_USER_DATA_RETENTION_SUPPORTED_FALSE;
        int targetSettingFeature = FitnessMachineFeature.TARGET_SETTING_FEATURES_SPEED_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_INCLINATION_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_RESISTANCE_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_POWER_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_HEART_RATE_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_EXPENDED_ENERGY_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_STEP_NUMBER_CONFIGRATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_STRIDE_NUMBER_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_DISTANCE_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TRAINING_TIME_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_TWO_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_THREE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_FIVE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_INDOOR_BIKE_SIMULATION_PARAMETERS_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_WHEEL_CIRCUMFERENCE_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_SPIN_DOWN_CONTROL_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_CADENCE_CONFIGURATION_SUPPORTED_FALSE;
        data[ 0] = (byte) fitnessMachineFeatureFlag;
        data[ 1] = (byte) (fitnessMachineFeatureFlag >> 8);
        data[ 2] = (byte) (fitnessMachineFeatureFlag >> 16);
        data[ 3] = (byte) (fitnessMachineFeatureFlag >> 24);
        data[ 4] = (byte) targetSettingFeature;
        data[ 5] = (byte) (targetSettingFeature >> 8);
        data[ 6] = (byte) (targetSettingFeature >> 16);
        data[ 7] = (byte) (targetSettingFeature >> 24);
        data_01102 = data;
    }

    private static final byte[] data_01201;
    static {
        byte[] data = new byte[8];
        int fitnessMachineFeatureFlag = FitnessMachineFeature.FITNESS_MACHINE_FEATURES_AVERAGE_SPEED_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_CADENCE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_TOTAL_DISTANCE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_INCLINATION_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_ELEVATION_GAIN_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_PACE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_STEP_COUNT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_RESISTANCE_LEVEL_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_STRIDE_COUNT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_EXPENDED_ENERGY_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_HEART_RATE_MEASUREMENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_METABOLIC_EQUIVALENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_ELAPSED_TIME_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_REMAINING_TIME_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_POWER_MEASUREMENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_FORCE_ON_BELT_AND_POWER_OUTPUT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_USER_DATA_RETENTION_SUPPORTED_FALSE;
        int targetSettingFeature = FitnessMachineFeature.TARGET_SETTING_FEATURES_SPEED_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_INCLINATION_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_RESISTANCE_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_POWER_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_HEART_RATE_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_EXPENDED_ENERGY_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_STEP_NUMBER_CONFIGRATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_STRIDE_NUMBER_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_DISTANCE_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TRAINING_TIME_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_TWO_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_THREE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_FIVE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_INDOOR_BIKE_SIMULATION_PARAMETERS_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_WHEEL_CIRCUMFERENCE_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_SPIN_DOWN_CONTROL_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_CADENCE_CONFIGURATION_SUPPORTED_FALSE;
        data[ 0] = (byte) fitnessMachineFeatureFlag;
        data[ 1] = (byte) (fitnessMachineFeatureFlag >> 8);
        data[ 2] = (byte) (fitnessMachineFeatureFlag >> 16);
        data[ 3] = (byte) (fitnessMachineFeatureFlag >> 24);
        data[ 4] = (byte) targetSettingFeature;
        data[ 5] = (byte) (targetSettingFeature >> 8);
        data[ 6] = (byte) (targetSettingFeature >> 16);
        data[ 7] = (byte) (targetSettingFeature >> 24);
        data_01201 = data;
    }

    private static final byte[] data_01202;
    static {
        byte[] data = new byte[8];
        int fitnessMachineFeatureFlag = FitnessMachineFeature.FITNESS_MACHINE_FEATURES_AVERAGE_SPEED_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_CADENCE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_TOTAL_DISTANCE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_INCLINATION_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_ELEVATION_GAIN_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_PACE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_STEP_COUNT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_RESISTANCE_LEVEL_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_STRIDE_COUNT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_EXPENDED_ENERGY_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_HEART_RATE_MEASUREMENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_METABOLIC_EQUIVALENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_ELAPSED_TIME_SUPPORTED_TRUE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_REMAINING_TIME_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_POWER_MEASUREMENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_FORCE_ON_BELT_AND_POWER_OUTPUT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_USER_DATA_RETENTION_SUPPORTED_FALSE;
        int targetSettingFeature = FitnessMachineFeature.TARGET_SETTING_FEATURES_SPEED_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_INCLINATION_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_RESISTANCE_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_POWER_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_HEART_RATE_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_EXPENDED_ENERGY_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_STEP_NUMBER_CONFIGRATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_STRIDE_NUMBER_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_DISTANCE_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TRAINING_TIME_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_TWO_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_THREE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_FIVE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_INDOOR_BIKE_SIMULATION_PARAMETERS_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_WHEEL_CIRCUMFERENCE_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_SPIN_DOWN_CONTROL_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_CADENCE_CONFIGURATION_SUPPORTED_FALSE;
        data[ 0] = (byte) fitnessMachineFeatureFlag;
        data[ 1] = (byte) (fitnessMachineFeatureFlag >> 8);
        data[ 2] = (byte) (fitnessMachineFeatureFlag >> 16);
        data[ 3] = (byte) (fitnessMachineFeatureFlag >> 24);
        data[ 4] = (byte) targetSettingFeature;
        data[ 5] = (byte) (targetSettingFeature >> 8);
        data[ 6] = (byte) (targetSettingFeature >> 16);
        data[ 7] = (byte) (targetSettingFeature >> 24);
        data_01202 = data;
    }

    private static final byte[] data_01301;
    static {
        byte[] data = new byte[8];
        int fitnessMachineFeatureFlag = FitnessMachineFeature.FITNESS_MACHINE_FEATURES_AVERAGE_SPEED_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_CADENCE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_TOTAL_DISTANCE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_INCLINATION_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_ELEVATION_GAIN_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_PACE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_STEP_COUNT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_RESISTANCE_LEVEL_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_STRIDE_COUNT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_EXPENDED_ENERGY_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_HEART_RATE_MEASUREMENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_METABOLIC_EQUIVALENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_ELAPSED_TIME_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_REMAINING_TIME_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_POWER_MEASUREMENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_FORCE_ON_BELT_AND_POWER_OUTPUT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_USER_DATA_RETENTION_SUPPORTED_FALSE;
        int targetSettingFeature = FitnessMachineFeature.TARGET_SETTING_FEATURES_SPEED_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_INCLINATION_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_RESISTANCE_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_POWER_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_HEART_RATE_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_EXPENDED_ENERGY_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_STEP_NUMBER_CONFIGRATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_STRIDE_NUMBER_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_DISTANCE_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TRAINING_TIME_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_TWO_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_THREE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_FIVE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_INDOOR_BIKE_SIMULATION_PARAMETERS_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_WHEEL_CIRCUMFERENCE_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_SPIN_DOWN_CONTROL_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_CADENCE_CONFIGURATION_SUPPORTED_FALSE;
        data[ 0] = (byte) fitnessMachineFeatureFlag;
        data[ 1] = (byte) (fitnessMachineFeatureFlag >> 8);
        data[ 2] = (byte) (fitnessMachineFeatureFlag >> 16);
        data[ 3] = (byte) (fitnessMachineFeatureFlag >> 24);
        data[ 4] = (byte) targetSettingFeature;
        data[ 5] = (byte) (targetSettingFeature >> 8);
        data[ 6] = (byte) (targetSettingFeature >> 16);
        data[ 7] = (byte) (targetSettingFeature >> 24);
        data_01301 = data;
    }

    private static final byte[] data_01302;
    static {
        byte[] data = new byte[8];
        int fitnessMachineFeatureFlag = FitnessMachineFeature.FITNESS_MACHINE_FEATURES_AVERAGE_SPEED_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_CADENCE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_TOTAL_DISTANCE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_INCLINATION_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_ELEVATION_GAIN_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_PACE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_STEP_COUNT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_RESISTANCE_LEVEL_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_STRIDE_COUNT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_EXPENDED_ENERGY_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_HEART_RATE_MEASUREMENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_METABOLIC_EQUIVALENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_ELAPSED_TIME_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_REMAINING_TIME_SUPPORTED_TRUE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_POWER_MEASUREMENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_FORCE_ON_BELT_AND_POWER_OUTPUT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_USER_DATA_RETENTION_SUPPORTED_FALSE;
        int targetSettingFeature = FitnessMachineFeature.TARGET_SETTING_FEATURES_SPEED_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_INCLINATION_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_RESISTANCE_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_POWER_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_HEART_RATE_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_EXPENDED_ENERGY_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_STEP_NUMBER_CONFIGRATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_STRIDE_NUMBER_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_DISTANCE_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TRAINING_TIME_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_TWO_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_THREE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_FIVE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_INDOOR_BIKE_SIMULATION_PARAMETERS_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_WHEEL_CIRCUMFERENCE_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_SPIN_DOWN_CONTROL_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_CADENCE_CONFIGURATION_SUPPORTED_FALSE;
        data[ 0] = (byte) fitnessMachineFeatureFlag;
        data[ 1] = (byte) (fitnessMachineFeatureFlag >> 8);
        data[ 2] = (byte) (fitnessMachineFeatureFlag >> 16);
        data[ 3] = (byte) (fitnessMachineFeatureFlag >> 24);
        data[ 4] = (byte) targetSettingFeature;
        data[ 5] = (byte) (targetSettingFeature >> 8);
        data[ 6] = (byte) (targetSettingFeature >> 16);
        data[ 7] = (byte) (targetSettingFeature >> 24);
        data_01302 = data;
    }

    private static final byte[] data_01401;
    static {
        byte[] data = new byte[8];
        int fitnessMachineFeatureFlag = FitnessMachineFeature.FITNESS_MACHINE_FEATURES_AVERAGE_SPEED_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_CADENCE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_TOTAL_DISTANCE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_INCLINATION_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_ELEVATION_GAIN_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_PACE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_STEP_COUNT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_RESISTANCE_LEVEL_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_STRIDE_COUNT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_EXPENDED_ENERGY_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_HEART_RATE_MEASUREMENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_METABOLIC_EQUIVALENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_ELAPSED_TIME_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_REMAINING_TIME_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_POWER_MEASUREMENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_FORCE_ON_BELT_AND_POWER_OUTPUT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_USER_DATA_RETENTION_SUPPORTED_FALSE;
        int targetSettingFeature = FitnessMachineFeature.TARGET_SETTING_FEATURES_SPEED_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_INCLINATION_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_RESISTANCE_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_POWER_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_HEART_RATE_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_EXPENDED_ENERGY_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_STEP_NUMBER_CONFIGRATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_STRIDE_NUMBER_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_DISTANCE_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TRAINING_TIME_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_TWO_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_THREE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_FIVE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_INDOOR_BIKE_SIMULATION_PARAMETERS_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_WHEEL_CIRCUMFERENCE_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_SPIN_DOWN_CONTROL_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_CADENCE_CONFIGURATION_SUPPORTED_FALSE;
        data[ 0] = (byte) fitnessMachineFeatureFlag;
        data[ 1] = (byte) (fitnessMachineFeatureFlag >> 8);
        data[ 2] = (byte) (fitnessMachineFeatureFlag >> 16);
        data[ 3] = (byte) (fitnessMachineFeatureFlag >> 24);
        data[ 4] = (byte) targetSettingFeature;
        data[ 5] = (byte) (targetSettingFeature >> 8);
        data[ 6] = (byte) (targetSettingFeature >> 16);
        data[ 7] = (byte) (targetSettingFeature >> 24);
        data_01401 = data;
    }

    private static final byte[] data_01402;
    static {
        byte[] data = new byte[8];
        int fitnessMachineFeatureFlag = FitnessMachineFeature.FITNESS_MACHINE_FEATURES_AVERAGE_SPEED_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_CADENCE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_TOTAL_DISTANCE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_INCLINATION_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_ELEVATION_GAIN_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_PACE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_STEP_COUNT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_RESISTANCE_LEVEL_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_STRIDE_COUNT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_EXPENDED_ENERGY_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_HEART_RATE_MEASUREMENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_METABOLIC_EQUIVALENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_ELAPSED_TIME_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_REMAINING_TIME_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_POWER_MEASUREMENT_SUPPORTED_TRUE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_FORCE_ON_BELT_AND_POWER_OUTPUT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_USER_DATA_RETENTION_SUPPORTED_FALSE;
        int targetSettingFeature = FitnessMachineFeature.TARGET_SETTING_FEATURES_SPEED_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_INCLINATION_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_RESISTANCE_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_POWER_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_HEART_RATE_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_EXPENDED_ENERGY_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_STEP_NUMBER_CONFIGRATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_STRIDE_NUMBER_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_DISTANCE_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TRAINING_TIME_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_TWO_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_THREE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_FIVE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_INDOOR_BIKE_SIMULATION_PARAMETERS_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_WHEEL_CIRCUMFERENCE_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_SPIN_DOWN_CONTROL_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_CADENCE_CONFIGURATION_SUPPORTED_FALSE;
        data[ 0] = (byte) fitnessMachineFeatureFlag;
        data[ 1] = (byte) (fitnessMachineFeatureFlag >> 8);
        data[ 2] = (byte) (fitnessMachineFeatureFlag >> 16);
        data[ 3] = (byte) (fitnessMachineFeatureFlag >> 24);
        data[ 4] = (byte) targetSettingFeature;
        data[ 5] = (byte) (targetSettingFeature >> 8);
        data[ 6] = (byte) (targetSettingFeature >> 16);
        data[ 7] = (byte) (targetSettingFeature >> 24);
        data_01402 = data;
    }

    private static final byte[] data_01501;
    static {
        byte[] data = new byte[8];
        int fitnessMachineFeatureFlag = FitnessMachineFeature.FITNESS_MACHINE_FEATURES_AVERAGE_SPEED_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_CADENCE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_TOTAL_DISTANCE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_INCLINATION_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_ELEVATION_GAIN_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_PACE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_STEP_COUNT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_RESISTANCE_LEVEL_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_STRIDE_COUNT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_EXPENDED_ENERGY_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_HEART_RATE_MEASUREMENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_METABOLIC_EQUIVALENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_ELAPSED_TIME_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_REMAINING_TIME_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_POWER_MEASUREMENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_FORCE_ON_BELT_AND_POWER_OUTPUT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_USER_DATA_RETENTION_SUPPORTED_FALSE;
        int targetSettingFeature = FitnessMachineFeature.TARGET_SETTING_FEATURES_SPEED_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_INCLINATION_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_RESISTANCE_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_POWER_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_HEART_RATE_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_EXPENDED_ENERGY_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_STEP_NUMBER_CONFIGRATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_STRIDE_NUMBER_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_DISTANCE_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TRAINING_TIME_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_TWO_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_THREE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_FIVE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_INDOOR_BIKE_SIMULATION_PARAMETERS_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_WHEEL_CIRCUMFERENCE_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_SPIN_DOWN_CONTROL_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_CADENCE_CONFIGURATION_SUPPORTED_FALSE;
        data[ 0] = (byte) fitnessMachineFeatureFlag;
        data[ 1] = (byte) (fitnessMachineFeatureFlag >> 8);
        data[ 2] = (byte) (fitnessMachineFeatureFlag >> 16);
        data[ 3] = (byte) (fitnessMachineFeatureFlag >> 24);
        data[ 4] = (byte) targetSettingFeature;
        data[ 5] = (byte) (targetSettingFeature >> 8);
        data[ 6] = (byte) (targetSettingFeature >> 16);
        data[ 7] = (byte) (targetSettingFeature >> 24);
        data_01501 = data;
    }

    private static final byte[] data_01502;
    static {
        byte[] data = new byte[8];
        int fitnessMachineFeatureFlag = FitnessMachineFeature.FITNESS_MACHINE_FEATURES_AVERAGE_SPEED_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_CADENCE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_TOTAL_DISTANCE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_INCLINATION_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_ELEVATION_GAIN_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_PACE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_STEP_COUNT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_RESISTANCE_LEVEL_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_STRIDE_COUNT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_EXPENDED_ENERGY_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_HEART_RATE_MEASUREMENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_METABOLIC_EQUIVALENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_ELAPSED_TIME_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_REMAINING_TIME_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_POWER_MEASUREMENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_FORCE_ON_BELT_AND_POWER_OUTPUT_SUPPORTED_TRUE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_USER_DATA_RETENTION_SUPPORTED_FALSE;
        int targetSettingFeature = FitnessMachineFeature.TARGET_SETTING_FEATURES_SPEED_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_INCLINATION_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_RESISTANCE_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_POWER_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_HEART_RATE_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_EXPENDED_ENERGY_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_STEP_NUMBER_CONFIGRATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_STRIDE_NUMBER_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_DISTANCE_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TRAINING_TIME_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_TWO_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_THREE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_FIVE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_INDOOR_BIKE_SIMULATION_PARAMETERS_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_WHEEL_CIRCUMFERENCE_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_SPIN_DOWN_CONTROL_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_CADENCE_CONFIGURATION_SUPPORTED_FALSE;
        data[ 0] = (byte) fitnessMachineFeatureFlag;
        data[ 1] = (byte) (fitnessMachineFeatureFlag >> 8);
        data[ 2] = (byte) (fitnessMachineFeatureFlag >> 16);
        data[ 3] = (byte) (fitnessMachineFeatureFlag >> 24);
        data[ 4] = (byte) targetSettingFeature;
        data[ 5] = (byte) (targetSettingFeature >> 8);
        data[ 6] = (byte) (targetSettingFeature >> 16);
        data[ 7] = (byte) (targetSettingFeature >> 24);
        data_01502 = data;
    }

    private static final byte[] data_01601;
    static {
        byte[] data = new byte[8];
        int fitnessMachineFeatureFlag = FitnessMachineFeature.FITNESS_MACHINE_FEATURES_AVERAGE_SPEED_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_CADENCE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_TOTAL_DISTANCE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_INCLINATION_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_ELEVATION_GAIN_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_PACE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_STEP_COUNT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_RESISTANCE_LEVEL_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_STRIDE_COUNT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_EXPENDED_ENERGY_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_HEART_RATE_MEASUREMENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_METABOLIC_EQUIVALENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_ELAPSED_TIME_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_REMAINING_TIME_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_POWER_MEASUREMENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_FORCE_ON_BELT_AND_POWER_OUTPUT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_USER_DATA_RETENTION_SUPPORTED_FALSE;
        int targetSettingFeature = FitnessMachineFeature.TARGET_SETTING_FEATURES_SPEED_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_INCLINATION_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_RESISTANCE_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_POWER_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_HEART_RATE_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_EXPENDED_ENERGY_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_STEP_NUMBER_CONFIGRATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_STRIDE_NUMBER_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_DISTANCE_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TRAINING_TIME_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_TWO_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_THREE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_FIVE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_INDOOR_BIKE_SIMULATION_PARAMETERS_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_WHEEL_CIRCUMFERENCE_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_SPIN_DOWN_CONTROL_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_CADENCE_CONFIGURATION_SUPPORTED_FALSE;
        data[ 0] = (byte) fitnessMachineFeatureFlag;
        data[ 1] = (byte) (fitnessMachineFeatureFlag >> 8);
        data[ 2] = (byte) (fitnessMachineFeatureFlag >> 16);
        data[ 3] = (byte) (fitnessMachineFeatureFlag >> 24);
        data[ 4] = (byte) targetSettingFeature;
        data[ 5] = (byte) (targetSettingFeature >> 8);
        data[ 6] = (byte) (targetSettingFeature >> 16);
        data[ 7] = (byte) (targetSettingFeature >> 24);
        data_01601 = data;
    }

    private static final byte[] data_01602;
    static {
        byte[] data = new byte[8];
        int fitnessMachineFeatureFlag = FitnessMachineFeature.FITNESS_MACHINE_FEATURES_AVERAGE_SPEED_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_CADENCE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_TOTAL_DISTANCE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_INCLINATION_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_ELEVATION_GAIN_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_PACE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_STEP_COUNT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_RESISTANCE_LEVEL_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_STRIDE_COUNT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_EXPENDED_ENERGY_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_HEART_RATE_MEASUREMENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_METABOLIC_EQUIVALENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_ELAPSED_TIME_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_REMAINING_TIME_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_POWER_MEASUREMENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_FORCE_ON_BELT_AND_POWER_OUTPUT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_USER_DATA_RETENTION_SUPPORTED_TRUE;
        int targetSettingFeature = FitnessMachineFeature.TARGET_SETTING_FEATURES_SPEED_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_INCLINATION_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_RESISTANCE_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_POWER_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_HEART_RATE_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_EXPENDED_ENERGY_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_STEP_NUMBER_CONFIGRATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_STRIDE_NUMBER_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_DISTANCE_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TRAINING_TIME_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_TWO_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_THREE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_FIVE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_INDOOR_BIKE_SIMULATION_PARAMETERS_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_WHEEL_CIRCUMFERENCE_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_SPIN_DOWN_CONTROL_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_CADENCE_CONFIGURATION_SUPPORTED_FALSE;
        data[ 0] = (byte) fitnessMachineFeatureFlag;
        data[ 1] = (byte) (fitnessMachineFeatureFlag >> 8);
        data[ 2] = (byte) (fitnessMachineFeatureFlag >> 16);
        data[ 3] = (byte) (fitnessMachineFeatureFlag >> 24);
        data[ 4] = (byte) targetSettingFeature;
        data[ 5] = (byte) (targetSettingFeature >> 8);
        data[ 6] = (byte) (targetSettingFeature >> 16);
        data[ 7] = (byte) (targetSettingFeature >> 24);
        data_01602 = data;
    }

    private static final byte[] data_10001;
    static {
        byte[] data = new byte[8];
        int fitnessMachineFeatureFlag = FitnessMachineFeature.FITNESS_MACHINE_FEATURES_AVERAGE_SPEED_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_CADENCE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_TOTAL_DISTANCE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_INCLINATION_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_ELEVATION_GAIN_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_PACE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_STEP_COUNT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_RESISTANCE_LEVEL_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_STRIDE_COUNT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_EXPENDED_ENERGY_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_HEART_RATE_MEASUREMENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_METABOLIC_EQUIVALENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_ELAPSED_TIME_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_REMAINING_TIME_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_POWER_MEASUREMENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_FORCE_ON_BELT_AND_POWER_OUTPUT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_USER_DATA_RETENTION_SUPPORTED_FALSE;
        int targetSettingFeature = FitnessMachineFeature.TARGET_SETTING_FEATURES_SPEED_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_INCLINATION_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_RESISTANCE_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_POWER_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_HEART_RATE_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_EXPENDED_ENERGY_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_STEP_NUMBER_CONFIGRATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_STRIDE_NUMBER_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_DISTANCE_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TRAINING_TIME_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_TWO_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_THREE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_FIVE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_INDOOR_BIKE_SIMULATION_PARAMETERS_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_WHEEL_CIRCUMFERENCE_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_SPIN_DOWN_CONTROL_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_CADENCE_CONFIGURATION_SUPPORTED_FALSE;
        data[ 0] = (byte) fitnessMachineFeatureFlag;
        data[ 1] = (byte) (fitnessMachineFeatureFlag >> 8);
        data[ 2] = (byte) (fitnessMachineFeatureFlag >> 16);
        data[ 3] = (byte) (fitnessMachineFeatureFlag >> 24);
        data[ 4] = (byte) targetSettingFeature;
        data[ 5] = (byte) (targetSettingFeature >> 8);
        data[ 6] = (byte) (targetSettingFeature >> 16);
        data[ 7] = (byte) (targetSettingFeature >> 24);
        data_10001 = data;
    }

    private static final byte[] data_10002;
    static {
        byte[] data = new byte[8];
        int fitnessMachineFeatureFlag = FitnessMachineFeature.FITNESS_MACHINE_FEATURES_AVERAGE_SPEED_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_CADENCE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_TOTAL_DISTANCE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_INCLINATION_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_ELEVATION_GAIN_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_PACE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_STEP_COUNT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_RESISTANCE_LEVEL_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_STRIDE_COUNT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_EXPENDED_ENERGY_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_HEART_RATE_MEASUREMENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_METABOLIC_EQUIVALENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_ELAPSED_TIME_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_REMAINING_TIME_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_POWER_MEASUREMENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_FORCE_ON_BELT_AND_POWER_OUTPUT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_USER_DATA_RETENTION_SUPPORTED_FALSE;
        int targetSettingFeature = FitnessMachineFeature.TARGET_SETTING_FEATURES_SPEED_TARGET_SETTING_SUPPORTED_TRUE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_INCLINATION_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_RESISTANCE_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_POWER_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_HEART_RATE_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_EXPENDED_ENERGY_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_STEP_NUMBER_CONFIGRATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_STRIDE_NUMBER_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_DISTANCE_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TRAINING_TIME_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_TWO_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_THREE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_FIVE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_INDOOR_BIKE_SIMULATION_PARAMETERS_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_WHEEL_CIRCUMFERENCE_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_SPIN_DOWN_CONTROL_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_CADENCE_CONFIGURATION_SUPPORTED_FALSE;
        data[ 0] = (byte) fitnessMachineFeatureFlag;
        data[ 1] = (byte) (fitnessMachineFeatureFlag >> 8);
        data[ 2] = (byte) (fitnessMachineFeatureFlag >> 16);
        data[ 3] = (byte) (fitnessMachineFeatureFlag >> 24);
        data[ 4] = (byte) targetSettingFeature;
        data[ 5] = (byte) (targetSettingFeature >> 8);
        data[ 6] = (byte) (targetSettingFeature >> 16);
        data[ 7] = (byte) (targetSettingFeature >> 24);
        data_10002 = data;
    }

    private static final byte[] data_10101;
    static {
        byte[] data = new byte[8];
        int fitnessMachineFeatureFlag = FitnessMachineFeature.FITNESS_MACHINE_FEATURES_AVERAGE_SPEED_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_CADENCE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_TOTAL_DISTANCE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_INCLINATION_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_ELEVATION_GAIN_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_PACE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_STEP_COUNT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_RESISTANCE_LEVEL_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_STRIDE_COUNT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_EXPENDED_ENERGY_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_HEART_RATE_MEASUREMENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_METABOLIC_EQUIVALENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_ELAPSED_TIME_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_REMAINING_TIME_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_POWER_MEASUREMENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_FORCE_ON_BELT_AND_POWER_OUTPUT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_USER_DATA_RETENTION_SUPPORTED_FALSE;
        int targetSettingFeature = FitnessMachineFeature.TARGET_SETTING_FEATURES_SPEED_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_INCLINATION_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_RESISTANCE_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_POWER_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_HEART_RATE_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_EXPENDED_ENERGY_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_STEP_NUMBER_CONFIGRATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_STRIDE_NUMBER_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_DISTANCE_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TRAINING_TIME_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_TWO_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_THREE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_FIVE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_INDOOR_BIKE_SIMULATION_PARAMETERS_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_WHEEL_CIRCUMFERENCE_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_SPIN_DOWN_CONTROL_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_CADENCE_CONFIGURATION_SUPPORTED_FALSE;
        data[ 0] = (byte) fitnessMachineFeatureFlag;
        data[ 1] = (byte) (fitnessMachineFeatureFlag >> 8);
        data[ 2] = (byte) (fitnessMachineFeatureFlag >> 16);
        data[ 3] = (byte) (fitnessMachineFeatureFlag >> 24);
        data[ 4] = (byte) targetSettingFeature;
        data[ 5] = (byte) (targetSettingFeature >> 8);
        data[ 6] = (byte) (targetSettingFeature >> 16);
        data[ 7] = (byte) (targetSettingFeature >> 24);
        data_10101 = data;
    }

    private static final byte[] data_10102;
    static {
        byte[] data = new byte[8];
        int fitnessMachineFeatureFlag = FitnessMachineFeature.FITNESS_MACHINE_FEATURES_AVERAGE_SPEED_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_CADENCE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_TOTAL_DISTANCE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_INCLINATION_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_ELEVATION_GAIN_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_PACE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_STEP_COUNT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_RESISTANCE_LEVEL_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_STRIDE_COUNT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_EXPENDED_ENERGY_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_HEART_RATE_MEASUREMENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_METABOLIC_EQUIVALENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_ELAPSED_TIME_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_REMAINING_TIME_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_POWER_MEASUREMENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_FORCE_ON_BELT_AND_POWER_OUTPUT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_USER_DATA_RETENTION_SUPPORTED_FALSE;
        int targetSettingFeature = FitnessMachineFeature.TARGET_SETTING_FEATURES_SPEED_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_INCLINATION_TARGET_SETTING_SUPPORTED_TRUE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_RESISTANCE_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_POWER_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_HEART_RATE_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_EXPENDED_ENERGY_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_STEP_NUMBER_CONFIGRATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_STRIDE_NUMBER_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_DISTANCE_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TRAINING_TIME_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_TWO_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_THREE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_FIVE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_INDOOR_BIKE_SIMULATION_PARAMETERS_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_WHEEL_CIRCUMFERENCE_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_SPIN_DOWN_CONTROL_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_CADENCE_CONFIGURATION_SUPPORTED_FALSE;
        data[ 0] = (byte) fitnessMachineFeatureFlag;
        data[ 1] = (byte) (fitnessMachineFeatureFlag >> 8);
        data[ 2] = (byte) (fitnessMachineFeatureFlag >> 16);
        data[ 3] = (byte) (fitnessMachineFeatureFlag >> 24);
        data[ 4] = (byte) targetSettingFeature;
        data[ 5] = (byte) (targetSettingFeature >> 8);
        data[ 6] = (byte) (targetSettingFeature >> 16);
        data[ 7] = (byte) (targetSettingFeature >> 24);
        data_10102 = data;
    }

    private static final byte[] data_10201;
    static {
        byte[] data = new byte[8];
        int fitnessMachineFeatureFlag = FitnessMachineFeature.FITNESS_MACHINE_FEATURES_AVERAGE_SPEED_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_CADENCE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_TOTAL_DISTANCE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_INCLINATION_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_ELEVATION_GAIN_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_PACE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_STEP_COUNT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_RESISTANCE_LEVEL_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_STRIDE_COUNT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_EXPENDED_ENERGY_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_HEART_RATE_MEASUREMENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_METABOLIC_EQUIVALENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_ELAPSED_TIME_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_REMAINING_TIME_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_POWER_MEASUREMENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_FORCE_ON_BELT_AND_POWER_OUTPUT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_USER_DATA_RETENTION_SUPPORTED_FALSE;
        int targetSettingFeature = FitnessMachineFeature.TARGET_SETTING_FEATURES_SPEED_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_INCLINATION_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_RESISTANCE_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_POWER_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_HEART_RATE_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_EXPENDED_ENERGY_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_STEP_NUMBER_CONFIGRATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_STRIDE_NUMBER_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_DISTANCE_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TRAINING_TIME_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_TWO_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_THREE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_FIVE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_INDOOR_BIKE_SIMULATION_PARAMETERS_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_WHEEL_CIRCUMFERENCE_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_SPIN_DOWN_CONTROL_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_CADENCE_CONFIGURATION_SUPPORTED_FALSE;
        data[ 0] = (byte) fitnessMachineFeatureFlag;
        data[ 1] = (byte) (fitnessMachineFeatureFlag >> 8);
        data[ 2] = (byte) (fitnessMachineFeatureFlag >> 16);
        data[ 3] = (byte) (fitnessMachineFeatureFlag >> 24);
        data[ 4] = (byte) targetSettingFeature;
        data[ 5] = (byte) (targetSettingFeature >> 8);
        data[ 6] = (byte) (targetSettingFeature >> 16);
        data[ 7] = (byte) (targetSettingFeature >> 24);
        data_10201 = data;
    }

    private static final byte[] data_10202;
    static {
        byte[] data = new byte[8];
        int fitnessMachineFeatureFlag = FitnessMachineFeature.FITNESS_MACHINE_FEATURES_AVERAGE_SPEED_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_CADENCE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_TOTAL_DISTANCE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_INCLINATION_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_ELEVATION_GAIN_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_PACE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_STEP_COUNT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_RESISTANCE_LEVEL_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_STRIDE_COUNT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_EXPENDED_ENERGY_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_HEART_RATE_MEASUREMENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_METABOLIC_EQUIVALENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_ELAPSED_TIME_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_REMAINING_TIME_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_POWER_MEASUREMENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_FORCE_ON_BELT_AND_POWER_OUTPUT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_USER_DATA_RETENTION_SUPPORTED_FALSE;
        int targetSettingFeature = FitnessMachineFeature.TARGET_SETTING_FEATURES_SPEED_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_INCLINATION_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_RESISTANCE_TARGET_SETTING_SUPPORTED_TRUE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_POWER_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_HEART_RATE_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_EXPENDED_ENERGY_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_STEP_NUMBER_CONFIGRATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_STRIDE_NUMBER_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_DISTANCE_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TRAINING_TIME_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_TWO_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_THREE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_FIVE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_INDOOR_BIKE_SIMULATION_PARAMETERS_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_WHEEL_CIRCUMFERENCE_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_SPIN_DOWN_CONTROL_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_CADENCE_CONFIGURATION_SUPPORTED_FALSE;
        data[ 0] = (byte) fitnessMachineFeatureFlag;
        data[ 1] = (byte) (fitnessMachineFeatureFlag >> 8);
        data[ 2] = (byte) (fitnessMachineFeatureFlag >> 16);
        data[ 3] = (byte) (fitnessMachineFeatureFlag >> 24);
        data[ 4] = (byte) targetSettingFeature;
        data[ 5] = (byte) (targetSettingFeature >> 8);
        data[ 6] = (byte) (targetSettingFeature >> 16);
        data[ 7] = (byte) (targetSettingFeature >> 24);
        data_10202 = data;
    }

    private static final byte[] data_10301;
    static {
        byte[] data = new byte[8];
        int fitnessMachineFeatureFlag = FitnessMachineFeature.FITNESS_MACHINE_FEATURES_AVERAGE_SPEED_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_CADENCE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_TOTAL_DISTANCE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_INCLINATION_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_ELEVATION_GAIN_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_PACE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_STEP_COUNT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_RESISTANCE_LEVEL_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_STRIDE_COUNT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_EXPENDED_ENERGY_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_HEART_RATE_MEASUREMENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_METABOLIC_EQUIVALENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_ELAPSED_TIME_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_REMAINING_TIME_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_POWER_MEASUREMENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_FORCE_ON_BELT_AND_POWER_OUTPUT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_USER_DATA_RETENTION_SUPPORTED_FALSE;
        int targetSettingFeature = FitnessMachineFeature.TARGET_SETTING_FEATURES_SPEED_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_INCLINATION_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_RESISTANCE_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_POWER_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_HEART_RATE_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_EXPENDED_ENERGY_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_STEP_NUMBER_CONFIGRATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_STRIDE_NUMBER_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_DISTANCE_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TRAINING_TIME_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_TWO_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_THREE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_FIVE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_INDOOR_BIKE_SIMULATION_PARAMETERS_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_WHEEL_CIRCUMFERENCE_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_SPIN_DOWN_CONTROL_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_CADENCE_CONFIGURATION_SUPPORTED_FALSE;
        data[ 0] = (byte) fitnessMachineFeatureFlag;
        data[ 1] = (byte) (fitnessMachineFeatureFlag >> 8);
        data[ 2] = (byte) (fitnessMachineFeatureFlag >> 16);
        data[ 3] = (byte) (fitnessMachineFeatureFlag >> 24);
        data[ 4] = (byte) targetSettingFeature;
        data[ 5] = (byte) (targetSettingFeature >> 8);
        data[ 6] = (byte) (targetSettingFeature >> 16);
        data[ 7] = (byte) (targetSettingFeature >> 24);
        data_10301 = data;
    }

    private static final byte[] data_10302;
    static {
        byte[] data = new byte[8];
        int fitnessMachineFeatureFlag = FitnessMachineFeature.FITNESS_MACHINE_FEATURES_AVERAGE_SPEED_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_CADENCE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_TOTAL_DISTANCE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_INCLINATION_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_ELEVATION_GAIN_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_PACE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_STEP_COUNT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_RESISTANCE_LEVEL_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_STRIDE_COUNT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_EXPENDED_ENERGY_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_HEART_RATE_MEASUREMENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_METABOLIC_EQUIVALENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_ELAPSED_TIME_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_REMAINING_TIME_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_POWER_MEASUREMENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_FORCE_ON_BELT_AND_POWER_OUTPUT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_USER_DATA_RETENTION_SUPPORTED_FALSE;
        int targetSettingFeature = FitnessMachineFeature.TARGET_SETTING_FEATURES_SPEED_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_INCLINATION_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_RESISTANCE_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_POWER_TARGET_SETTING_SUPPORTED_TRUE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_HEART_RATE_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_EXPENDED_ENERGY_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_STEP_NUMBER_CONFIGRATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_STRIDE_NUMBER_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_DISTANCE_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TRAINING_TIME_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_TWO_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_THREE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_FIVE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_INDOOR_BIKE_SIMULATION_PARAMETERS_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_WHEEL_CIRCUMFERENCE_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_SPIN_DOWN_CONTROL_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_CADENCE_CONFIGURATION_SUPPORTED_FALSE;
        data[ 0] = (byte) fitnessMachineFeatureFlag;
        data[ 1] = (byte) (fitnessMachineFeatureFlag >> 8);
        data[ 2] = (byte) (fitnessMachineFeatureFlag >> 16);
        data[ 3] = (byte) (fitnessMachineFeatureFlag >> 24);
        data[ 4] = (byte) targetSettingFeature;
        data[ 5] = (byte) (targetSettingFeature >> 8);
        data[ 6] = (byte) (targetSettingFeature >> 16);
        data[ 7] = (byte) (targetSettingFeature >> 24);
        data_10302 = data;
    }

    private static final byte[] data_10401;
    static {
        byte[] data = new byte[8];
        int fitnessMachineFeatureFlag = FitnessMachineFeature.FITNESS_MACHINE_FEATURES_AVERAGE_SPEED_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_CADENCE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_TOTAL_DISTANCE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_INCLINATION_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_ELEVATION_GAIN_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_PACE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_STEP_COUNT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_RESISTANCE_LEVEL_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_STRIDE_COUNT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_EXPENDED_ENERGY_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_HEART_RATE_MEASUREMENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_METABOLIC_EQUIVALENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_ELAPSED_TIME_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_REMAINING_TIME_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_POWER_MEASUREMENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_FORCE_ON_BELT_AND_POWER_OUTPUT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_USER_DATA_RETENTION_SUPPORTED_FALSE;
        int targetSettingFeature = FitnessMachineFeature.TARGET_SETTING_FEATURES_SPEED_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_INCLINATION_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_RESISTANCE_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_POWER_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_HEART_RATE_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_EXPENDED_ENERGY_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_STEP_NUMBER_CONFIGRATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_STRIDE_NUMBER_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_DISTANCE_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TRAINING_TIME_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_TWO_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_THREE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_FIVE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_INDOOR_BIKE_SIMULATION_PARAMETERS_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_WHEEL_CIRCUMFERENCE_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_SPIN_DOWN_CONTROL_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_CADENCE_CONFIGURATION_SUPPORTED_FALSE;
        data[ 0] = (byte) fitnessMachineFeatureFlag;
        data[ 1] = (byte) (fitnessMachineFeatureFlag >> 8);
        data[ 2] = (byte) (fitnessMachineFeatureFlag >> 16);
        data[ 3] = (byte) (fitnessMachineFeatureFlag >> 24);
        data[ 4] = (byte) targetSettingFeature;
        data[ 5] = (byte) (targetSettingFeature >> 8);
        data[ 6] = (byte) (targetSettingFeature >> 16);
        data[ 7] = (byte) (targetSettingFeature >> 24);
        data_10401 = data;
    }

    private static final byte[] data_10402;
    static {
        byte[] data = new byte[8];
        int fitnessMachineFeatureFlag = FitnessMachineFeature.FITNESS_MACHINE_FEATURES_AVERAGE_SPEED_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_CADENCE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_TOTAL_DISTANCE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_INCLINATION_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_ELEVATION_GAIN_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_PACE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_STEP_COUNT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_RESISTANCE_LEVEL_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_STRIDE_COUNT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_EXPENDED_ENERGY_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_HEART_RATE_MEASUREMENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_METABOLIC_EQUIVALENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_ELAPSED_TIME_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_REMAINING_TIME_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_POWER_MEASUREMENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_FORCE_ON_BELT_AND_POWER_OUTPUT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_USER_DATA_RETENTION_SUPPORTED_FALSE;
        int targetSettingFeature = FitnessMachineFeature.TARGET_SETTING_FEATURES_SPEED_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_INCLINATION_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_RESISTANCE_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_POWER_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_HEART_RATE_TARGET_SETTING_SUPPORTED_TRUE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_EXPENDED_ENERGY_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_STEP_NUMBER_CONFIGRATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_STRIDE_NUMBER_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_DISTANCE_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TRAINING_TIME_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_TWO_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_THREE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_FIVE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_INDOOR_BIKE_SIMULATION_PARAMETERS_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_WHEEL_CIRCUMFERENCE_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_SPIN_DOWN_CONTROL_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_CADENCE_CONFIGURATION_SUPPORTED_FALSE;
        data[ 0] = (byte) fitnessMachineFeatureFlag;
        data[ 1] = (byte) (fitnessMachineFeatureFlag >> 8);
        data[ 2] = (byte) (fitnessMachineFeatureFlag >> 16);
        data[ 3] = (byte) (fitnessMachineFeatureFlag >> 24);
        data[ 4] = (byte) targetSettingFeature;
        data[ 5] = (byte) (targetSettingFeature >> 8);
        data[ 6] = (byte) (targetSettingFeature >> 16);
        data[ 7] = (byte) (targetSettingFeature >> 24);
        data_10402 = data;
    }

    private static final byte[] data_10501;
    static {
        byte[] data = new byte[8];
        int fitnessMachineFeatureFlag = FitnessMachineFeature.FITNESS_MACHINE_FEATURES_AVERAGE_SPEED_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_CADENCE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_TOTAL_DISTANCE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_INCLINATION_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_ELEVATION_GAIN_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_PACE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_STEP_COUNT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_RESISTANCE_LEVEL_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_STRIDE_COUNT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_EXPENDED_ENERGY_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_HEART_RATE_MEASUREMENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_METABOLIC_EQUIVALENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_ELAPSED_TIME_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_REMAINING_TIME_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_POWER_MEASUREMENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_FORCE_ON_BELT_AND_POWER_OUTPUT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_USER_DATA_RETENTION_SUPPORTED_FALSE;
        int targetSettingFeature = FitnessMachineFeature.TARGET_SETTING_FEATURES_SPEED_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_INCLINATION_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_RESISTANCE_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_POWER_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_HEART_RATE_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_EXPENDED_ENERGY_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_STEP_NUMBER_CONFIGRATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_STRIDE_NUMBER_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_DISTANCE_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TRAINING_TIME_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_TWO_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_THREE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_FIVE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_INDOOR_BIKE_SIMULATION_PARAMETERS_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_WHEEL_CIRCUMFERENCE_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_SPIN_DOWN_CONTROL_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_CADENCE_CONFIGURATION_SUPPORTED_FALSE;
        data[ 0] = (byte) fitnessMachineFeatureFlag;
        data[ 1] = (byte) (fitnessMachineFeatureFlag >> 8);
        data[ 2] = (byte) (fitnessMachineFeatureFlag >> 16);
        data[ 3] = (byte) (fitnessMachineFeatureFlag >> 24);
        data[ 4] = (byte) targetSettingFeature;
        data[ 5] = (byte) (targetSettingFeature >> 8);
        data[ 6] = (byte) (targetSettingFeature >> 16);
        data[ 7] = (byte) (targetSettingFeature >> 24);
        data_10501 = data;
    }

    private static final byte[] data_10502;
    static {
        byte[] data = new byte[8];
        int fitnessMachineFeatureFlag = FitnessMachineFeature.FITNESS_MACHINE_FEATURES_AVERAGE_SPEED_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_CADENCE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_TOTAL_DISTANCE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_INCLINATION_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_ELEVATION_GAIN_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_PACE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_STEP_COUNT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_RESISTANCE_LEVEL_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_STRIDE_COUNT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_EXPENDED_ENERGY_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_HEART_RATE_MEASUREMENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_METABOLIC_EQUIVALENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_ELAPSED_TIME_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_REMAINING_TIME_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_POWER_MEASUREMENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_FORCE_ON_BELT_AND_POWER_OUTPUT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_USER_DATA_RETENTION_SUPPORTED_FALSE;
        int targetSettingFeature = FitnessMachineFeature.TARGET_SETTING_FEATURES_SPEED_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_INCLINATION_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_RESISTANCE_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_POWER_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_HEART_RATE_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_EXPENDED_ENERGY_CONFIGURATION_SUPPORTED_TRUE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_STEP_NUMBER_CONFIGRATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_STRIDE_NUMBER_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_DISTANCE_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TRAINING_TIME_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_TWO_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_THREE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_FIVE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_INDOOR_BIKE_SIMULATION_PARAMETERS_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_WHEEL_CIRCUMFERENCE_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_SPIN_DOWN_CONTROL_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_CADENCE_CONFIGURATION_SUPPORTED_FALSE;
        data[ 0] = (byte) fitnessMachineFeatureFlag;
        data[ 1] = (byte) (fitnessMachineFeatureFlag >> 8);
        data[ 2] = (byte) (fitnessMachineFeatureFlag >> 16);
        data[ 3] = (byte) (fitnessMachineFeatureFlag >> 24);
        data[ 4] = (byte) targetSettingFeature;
        data[ 5] = (byte) (targetSettingFeature >> 8);
        data[ 6] = (byte) (targetSettingFeature >> 16);
        data[ 7] = (byte) (targetSettingFeature >> 24);
        data_10502 = data;
    }

    private static final byte[] data_10601;
    static {
        byte[] data = new byte[8];
        int fitnessMachineFeatureFlag = FitnessMachineFeature.FITNESS_MACHINE_FEATURES_AVERAGE_SPEED_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_CADENCE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_TOTAL_DISTANCE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_INCLINATION_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_ELEVATION_GAIN_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_PACE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_STEP_COUNT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_RESISTANCE_LEVEL_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_STRIDE_COUNT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_EXPENDED_ENERGY_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_HEART_RATE_MEASUREMENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_METABOLIC_EQUIVALENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_ELAPSED_TIME_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_REMAINING_TIME_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_POWER_MEASUREMENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_FORCE_ON_BELT_AND_POWER_OUTPUT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_USER_DATA_RETENTION_SUPPORTED_FALSE;
        int targetSettingFeature = FitnessMachineFeature.TARGET_SETTING_FEATURES_SPEED_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_INCLINATION_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_RESISTANCE_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_POWER_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_HEART_RATE_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_EXPENDED_ENERGY_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_STEP_NUMBER_CONFIGRATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_STRIDE_NUMBER_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_DISTANCE_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TRAINING_TIME_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_TWO_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_THREE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_FIVE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_INDOOR_BIKE_SIMULATION_PARAMETERS_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_WHEEL_CIRCUMFERENCE_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_SPIN_DOWN_CONTROL_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_CADENCE_CONFIGURATION_SUPPORTED_FALSE;
        data[ 0] = (byte) fitnessMachineFeatureFlag;
        data[ 1] = (byte) (fitnessMachineFeatureFlag >> 8);
        data[ 2] = (byte) (fitnessMachineFeatureFlag >> 16);
        data[ 3] = (byte) (fitnessMachineFeatureFlag >> 24);
        data[ 4] = (byte) targetSettingFeature;
        data[ 5] = (byte) (targetSettingFeature >> 8);
        data[ 6] = (byte) (targetSettingFeature >> 16);
        data[ 7] = (byte) (targetSettingFeature >> 24);
        data_10601 = data;
    }

    private static final byte[] data_10602;
    static {
        byte[] data = new byte[8];
        int fitnessMachineFeatureFlag = FitnessMachineFeature.FITNESS_MACHINE_FEATURES_AVERAGE_SPEED_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_CADENCE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_TOTAL_DISTANCE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_INCLINATION_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_ELEVATION_GAIN_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_PACE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_STEP_COUNT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_RESISTANCE_LEVEL_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_STRIDE_COUNT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_EXPENDED_ENERGY_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_HEART_RATE_MEASUREMENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_METABOLIC_EQUIVALENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_ELAPSED_TIME_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_REMAINING_TIME_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_POWER_MEASUREMENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_FORCE_ON_BELT_AND_POWER_OUTPUT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_USER_DATA_RETENTION_SUPPORTED_FALSE;
        int targetSettingFeature = FitnessMachineFeature.TARGET_SETTING_FEATURES_SPEED_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_INCLINATION_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_RESISTANCE_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_POWER_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_HEART_RATE_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_EXPENDED_ENERGY_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_STEP_NUMBER_CONFIGRATION_SUPPORTED_TRUE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_STRIDE_NUMBER_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_DISTANCE_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TRAINING_TIME_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_TWO_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_THREE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_FIVE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_INDOOR_BIKE_SIMULATION_PARAMETERS_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_WHEEL_CIRCUMFERENCE_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_SPIN_DOWN_CONTROL_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_CADENCE_CONFIGURATION_SUPPORTED_FALSE;
        data[ 0] = (byte) fitnessMachineFeatureFlag;
        data[ 1] = (byte) (fitnessMachineFeatureFlag >> 8);
        data[ 2] = (byte) (fitnessMachineFeatureFlag >> 16);
        data[ 3] = (byte) (fitnessMachineFeatureFlag >> 24);
        data[ 4] = (byte) targetSettingFeature;
        data[ 5] = (byte) (targetSettingFeature >> 8);
        data[ 6] = (byte) (targetSettingFeature >> 16);
        data[ 7] = (byte) (targetSettingFeature >> 24);
        data_10602 = data;
    }

    private static final byte[] data_10701;
    static {
        byte[] data = new byte[8];
        int fitnessMachineFeatureFlag = FitnessMachineFeature.FITNESS_MACHINE_FEATURES_AVERAGE_SPEED_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_CADENCE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_TOTAL_DISTANCE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_INCLINATION_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_ELEVATION_GAIN_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_PACE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_STEP_COUNT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_RESISTANCE_LEVEL_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_STRIDE_COUNT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_EXPENDED_ENERGY_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_HEART_RATE_MEASUREMENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_METABOLIC_EQUIVALENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_ELAPSED_TIME_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_REMAINING_TIME_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_POWER_MEASUREMENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_FORCE_ON_BELT_AND_POWER_OUTPUT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_USER_DATA_RETENTION_SUPPORTED_FALSE;
        int targetSettingFeature = FitnessMachineFeature.TARGET_SETTING_FEATURES_SPEED_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_INCLINATION_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_RESISTANCE_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_POWER_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_HEART_RATE_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_EXPENDED_ENERGY_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_STEP_NUMBER_CONFIGRATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_STRIDE_NUMBER_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_DISTANCE_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TRAINING_TIME_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_TWO_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_THREE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_FIVE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_INDOOR_BIKE_SIMULATION_PARAMETERS_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_WHEEL_CIRCUMFERENCE_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_SPIN_DOWN_CONTROL_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_CADENCE_CONFIGURATION_SUPPORTED_FALSE;
        data[ 0] = (byte) fitnessMachineFeatureFlag;
        data[ 1] = (byte) (fitnessMachineFeatureFlag >> 8);
        data[ 2] = (byte) (fitnessMachineFeatureFlag >> 16);
        data[ 3] = (byte) (fitnessMachineFeatureFlag >> 24);
        data[ 4] = (byte) targetSettingFeature;
        data[ 5] = (byte) (targetSettingFeature >> 8);
        data[ 6] = (byte) (targetSettingFeature >> 16);
        data[ 7] = (byte) (targetSettingFeature >> 24);
        data_10701 = data;
    }

    private static final byte[] data_10702;
    static {
        byte[] data = new byte[8];
        int fitnessMachineFeatureFlag = FitnessMachineFeature.FITNESS_MACHINE_FEATURES_AVERAGE_SPEED_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_CADENCE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_TOTAL_DISTANCE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_INCLINATION_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_ELEVATION_GAIN_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_PACE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_STEP_COUNT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_RESISTANCE_LEVEL_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_STRIDE_COUNT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_EXPENDED_ENERGY_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_HEART_RATE_MEASUREMENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_METABOLIC_EQUIVALENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_ELAPSED_TIME_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_REMAINING_TIME_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_POWER_MEASUREMENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_FORCE_ON_BELT_AND_POWER_OUTPUT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_USER_DATA_RETENTION_SUPPORTED_FALSE;
        int targetSettingFeature = FitnessMachineFeature.TARGET_SETTING_FEATURES_SPEED_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_INCLINATION_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_RESISTANCE_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_POWER_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_HEART_RATE_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_EXPENDED_ENERGY_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_STEP_NUMBER_CONFIGRATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_STRIDE_NUMBER_CONFIGURATION_SUPPORTED_TRUE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_DISTANCE_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TRAINING_TIME_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_TWO_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_THREE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_FIVE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_INDOOR_BIKE_SIMULATION_PARAMETERS_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_WHEEL_CIRCUMFERENCE_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_SPIN_DOWN_CONTROL_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_CADENCE_CONFIGURATION_SUPPORTED_FALSE;
        data[ 0] = (byte) fitnessMachineFeatureFlag;
        data[ 1] = (byte) (fitnessMachineFeatureFlag >> 8);
        data[ 2] = (byte) (fitnessMachineFeatureFlag >> 16);
        data[ 3] = (byte) (fitnessMachineFeatureFlag >> 24);
        data[ 4] = (byte) targetSettingFeature;
        data[ 5] = (byte) (targetSettingFeature >> 8);
        data[ 6] = (byte) (targetSettingFeature >> 16);
        data[ 7] = (byte) (targetSettingFeature >> 24);
        data_10702 = data;
    }

    private static final byte[] data_10801;
    static {
        byte[] data = new byte[8];
        int fitnessMachineFeatureFlag = FitnessMachineFeature.FITNESS_MACHINE_FEATURES_AVERAGE_SPEED_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_CADENCE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_TOTAL_DISTANCE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_INCLINATION_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_ELEVATION_GAIN_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_PACE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_STEP_COUNT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_RESISTANCE_LEVEL_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_STRIDE_COUNT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_EXPENDED_ENERGY_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_HEART_RATE_MEASUREMENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_METABOLIC_EQUIVALENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_ELAPSED_TIME_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_REMAINING_TIME_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_POWER_MEASUREMENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_FORCE_ON_BELT_AND_POWER_OUTPUT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_USER_DATA_RETENTION_SUPPORTED_FALSE;
        int targetSettingFeature = FitnessMachineFeature.TARGET_SETTING_FEATURES_SPEED_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_INCLINATION_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_RESISTANCE_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_POWER_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_HEART_RATE_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_EXPENDED_ENERGY_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_STEP_NUMBER_CONFIGRATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_STRIDE_NUMBER_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_DISTANCE_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TRAINING_TIME_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_TWO_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_THREE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_FIVE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_INDOOR_BIKE_SIMULATION_PARAMETERS_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_WHEEL_CIRCUMFERENCE_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_SPIN_DOWN_CONTROL_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_CADENCE_CONFIGURATION_SUPPORTED_FALSE;
        data[ 0] = (byte) fitnessMachineFeatureFlag;
        data[ 1] = (byte) (fitnessMachineFeatureFlag >> 8);
        data[ 2] = (byte) (fitnessMachineFeatureFlag >> 16);
        data[ 3] = (byte) (fitnessMachineFeatureFlag >> 24);
        data[ 4] = (byte) targetSettingFeature;
        data[ 5] = (byte) (targetSettingFeature >> 8);
        data[ 6] = (byte) (targetSettingFeature >> 16);
        data[ 7] = (byte) (targetSettingFeature >> 24);
        data_10801 = data;
    }

    private static final byte[] data_10802;
    static {
        byte[] data = new byte[8];
        int fitnessMachineFeatureFlag = FitnessMachineFeature.FITNESS_MACHINE_FEATURES_AVERAGE_SPEED_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_CADENCE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_TOTAL_DISTANCE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_INCLINATION_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_ELEVATION_GAIN_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_PACE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_STEP_COUNT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_RESISTANCE_LEVEL_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_STRIDE_COUNT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_EXPENDED_ENERGY_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_HEART_RATE_MEASUREMENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_METABOLIC_EQUIVALENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_ELAPSED_TIME_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_REMAINING_TIME_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_POWER_MEASUREMENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_FORCE_ON_BELT_AND_POWER_OUTPUT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_USER_DATA_RETENTION_SUPPORTED_FALSE;
        int targetSettingFeature = FitnessMachineFeature.TARGET_SETTING_FEATURES_SPEED_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_INCLINATION_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_RESISTANCE_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_POWER_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_HEART_RATE_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_EXPENDED_ENERGY_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_STEP_NUMBER_CONFIGRATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_STRIDE_NUMBER_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_DISTANCE_CONFIGURATION_SUPPORTED_TRUE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TRAINING_TIME_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_TWO_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_THREE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_FIVE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_INDOOR_BIKE_SIMULATION_PARAMETERS_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_WHEEL_CIRCUMFERENCE_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_SPIN_DOWN_CONTROL_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_CADENCE_CONFIGURATION_SUPPORTED_FALSE;
        data[ 0] = (byte) fitnessMachineFeatureFlag;
        data[ 1] = (byte) (fitnessMachineFeatureFlag >> 8);
        data[ 2] = (byte) (fitnessMachineFeatureFlag >> 16);
        data[ 3] = (byte) (fitnessMachineFeatureFlag >> 24);
        data[ 4] = (byte) targetSettingFeature;
        data[ 5] = (byte) (targetSettingFeature >> 8);
        data[ 6] = (byte) (targetSettingFeature >> 16);
        data[ 7] = (byte) (targetSettingFeature >> 24);
        data_10802 = data;
    }

    private static final byte[] data_10901;
    static {
        byte[] data = new byte[8];
        int fitnessMachineFeatureFlag = FitnessMachineFeature.FITNESS_MACHINE_FEATURES_AVERAGE_SPEED_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_CADENCE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_TOTAL_DISTANCE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_INCLINATION_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_ELEVATION_GAIN_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_PACE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_STEP_COUNT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_RESISTANCE_LEVEL_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_STRIDE_COUNT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_EXPENDED_ENERGY_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_HEART_RATE_MEASUREMENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_METABOLIC_EQUIVALENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_ELAPSED_TIME_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_REMAINING_TIME_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_POWER_MEASUREMENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_FORCE_ON_BELT_AND_POWER_OUTPUT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_USER_DATA_RETENTION_SUPPORTED_FALSE;
        int targetSettingFeature = FitnessMachineFeature.TARGET_SETTING_FEATURES_SPEED_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_INCLINATION_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_RESISTANCE_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_POWER_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_HEART_RATE_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_EXPENDED_ENERGY_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_STEP_NUMBER_CONFIGRATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_STRIDE_NUMBER_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_DISTANCE_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TRAINING_TIME_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_TWO_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_THREE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_FIVE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_INDOOR_BIKE_SIMULATION_PARAMETERS_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_WHEEL_CIRCUMFERENCE_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_SPIN_DOWN_CONTROL_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_CADENCE_CONFIGURATION_SUPPORTED_FALSE;
        data[ 0] = (byte) fitnessMachineFeatureFlag;
        data[ 1] = (byte) (fitnessMachineFeatureFlag >> 8);
        data[ 2] = (byte) (fitnessMachineFeatureFlag >> 16);
        data[ 3] = (byte) (fitnessMachineFeatureFlag >> 24);
        data[ 4] = (byte) targetSettingFeature;
        data[ 5] = (byte) (targetSettingFeature >> 8);
        data[ 6] = (byte) (targetSettingFeature >> 16);
        data[ 7] = (byte) (targetSettingFeature >> 24);
        data_10901 = data;
    }

    private static final byte[] data_10902;
    static {
        byte[] data = new byte[8];
        int fitnessMachineFeatureFlag = FitnessMachineFeature.FITNESS_MACHINE_FEATURES_AVERAGE_SPEED_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_CADENCE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_TOTAL_DISTANCE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_INCLINATION_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_ELEVATION_GAIN_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_PACE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_STEP_COUNT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_RESISTANCE_LEVEL_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_STRIDE_COUNT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_EXPENDED_ENERGY_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_HEART_RATE_MEASUREMENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_METABOLIC_EQUIVALENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_ELAPSED_TIME_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_REMAINING_TIME_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_POWER_MEASUREMENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_FORCE_ON_BELT_AND_POWER_OUTPUT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_USER_DATA_RETENTION_SUPPORTED_FALSE;
        int targetSettingFeature = FitnessMachineFeature.TARGET_SETTING_FEATURES_SPEED_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_INCLINATION_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_RESISTANCE_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_POWER_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_HEART_RATE_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_EXPENDED_ENERGY_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_STEP_NUMBER_CONFIGRATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_STRIDE_NUMBER_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_DISTANCE_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TRAINING_TIME_CONFIGURATION_SUPPORTED_TRUE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_TWO_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_THREE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_FIVE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_INDOOR_BIKE_SIMULATION_PARAMETERS_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_WHEEL_CIRCUMFERENCE_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_SPIN_DOWN_CONTROL_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_CADENCE_CONFIGURATION_SUPPORTED_FALSE;
        data[ 0] = (byte) fitnessMachineFeatureFlag;
        data[ 1] = (byte) (fitnessMachineFeatureFlag >> 8);
        data[ 2] = (byte) (fitnessMachineFeatureFlag >> 16);
        data[ 3] = (byte) (fitnessMachineFeatureFlag >> 24);
        data[ 4] = (byte) targetSettingFeature;
        data[ 5] = (byte) (targetSettingFeature >> 8);
        data[ 6] = (byte) (targetSettingFeature >> 16);
        data[ 7] = (byte) (targetSettingFeature >> 24);
        data_10902 = data;
    }

    private static final byte[] data_11001;
    static {
        byte[] data = new byte[8];
        int fitnessMachineFeatureFlag = FitnessMachineFeature.FITNESS_MACHINE_FEATURES_AVERAGE_SPEED_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_CADENCE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_TOTAL_DISTANCE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_INCLINATION_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_ELEVATION_GAIN_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_PACE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_STEP_COUNT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_RESISTANCE_LEVEL_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_STRIDE_COUNT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_EXPENDED_ENERGY_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_HEART_RATE_MEASUREMENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_METABOLIC_EQUIVALENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_ELAPSED_TIME_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_REMAINING_TIME_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_POWER_MEASUREMENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_FORCE_ON_BELT_AND_POWER_OUTPUT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_USER_DATA_RETENTION_SUPPORTED_FALSE;
        int targetSettingFeature = FitnessMachineFeature.TARGET_SETTING_FEATURES_SPEED_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_INCLINATION_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_RESISTANCE_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_POWER_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_HEART_RATE_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_EXPENDED_ENERGY_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_STEP_NUMBER_CONFIGRATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_STRIDE_NUMBER_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_DISTANCE_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TRAINING_TIME_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_TWO_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_THREE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_FIVE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_INDOOR_BIKE_SIMULATION_PARAMETERS_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_WHEEL_CIRCUMFERENCE_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_SPIN_DOWN_CONTROL_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_CADENCE_CONFIGURATION_SUPPORTED_FALSE;
        data[ 0] = (byte) fitnessMachineFeatureFlag;
        data[ 1] = (byte) (fitnessMachineFeatureFlag >> 8);
        data[ 2] = (byte) (fitnessMachineFeatureFlag >> 16);
        data[ 3] = (byte) (fitnessMachineFeatureFlag >> 24);
        data[ 4] = (byte) targetSettingFeature;
        data[ 5] = (byte) (targetSettingFeature >> 8);
        data[ 6] = (byte) (targetSettingFeature >> 16);
        data[ 7] = (byte) (targetSettingFeature >> 24);
        data_11001 = data;
    }

    private static final byte[] data_11002;
    static {
        byte[] data = new byte[8];
        int fitnessMachineFeatureFlag = FitnessMachineFeature.FITNESS_MACHINE_FEATURES_AVERAGE_SPEED_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_CADENCE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_TOTAL_DISTANCE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_INCLINATION_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_ELEVATION_GAIN_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_PACE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_STEP_COUNT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_RESISTANCE_LEVEL_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_STRIDE_COUNT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_EXPENDED_ENERGY_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_HEART_RATE_MEASUREMENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_METABOLIC_EQUIVALENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_ELAPSED_TIME_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_REMAINING_TIME_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_POWER_MEASUREMENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_FORCE_ON_BELT_AND_POWER_OUTPUT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_USER_DATA_RETENTION_SUPPORTED_FALSE;
        int targetSettingFeature = FitnessMachineFeature.TARGET_SETTING_FEATURES_SPEED_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_INCLINATION_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_RESISTANCE_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_POWER_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_HEART_RATE_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_EXPENDED_ENERGY_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_STEP_NUMBER_CONFIGRATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_STRIDE_NUMBER_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_DISTANCE_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TRAINING_TIME_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_TWO_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_TRUE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_THREE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_FIVE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_INDOOR_BIKE_SIMULATION_PARAMETERS_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_WHEEL_CIRCUMFERENCE_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_SPIN_DOWN_CONTROL_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_CADENCE_CONFIGURATION_SUPPORTED_FALSE;
        data[ 0] = (byte) fitnessMachineFeatureFlag;
        data[ 1] = (byte) (fitnessMachineFeatureFlag >> 8);
        data[ 2] = (byte) (fitnessMachineFeatureFlag >> 16);
        data[ 3] = (byte) (fitnessMachineFeatureFlag >> 24);
        data[ 4] = (byte) targetSettingFeature;
        data[ 5] = (byte) (targetSettingFeature >> 8);
        data[ 6] = (byte) (targetSettingFeature >> 16);
        data[ 7] = (byte) (targetSettingFeature >> 24);
        data_11002 = data;
    }

    private static final byte[] data_11101;
    static {
        byte[] data = new byte[8];
        int fitnessMachineFeatureFlag = FitnessMachineFeature.FITNESS_MACHINE_FEATURES_AVERAGE_SPEED_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_CADENCE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_TOTAL_DISTANCE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_INCLINATION_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_ELEVATION_GAIN_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_PACE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_STEP_COUNT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_RESISTANCE_LEVEL_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_STRIDE_COUNT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_EXPENDED_ENERGY_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_HEART_RATE_MEASUREMENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_METABOLIC_EQUIVALENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_ELAPSED_TIME_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_REMAINING_TIME_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_POWER_MEASUREMENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_FORCE_ON_BELT_AND_POWER_OUTPUT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_USER_DATA_RETENTION_SUPPORTED_FALSE;
        int targetSettingFeature = FitnessMachineFeature.TARGET_SETTING_FEATURES_SPEED_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_INCLINATION_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_RESISTANCE_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_POWER_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_HEART_RATE_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_EXPENDED_ENERGY_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_STEP_NUMBER_CONFIGRATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_STRIDE_NUMBER_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_DISTANCE_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TRAINING_TIME_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_TWO_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_THREE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_FIVE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_INDOOR_BIKE_SIMULATION_PARAMETERS_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_WHEEL_CIRCUMFERENCE_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_SPIN_DOWN_CONTROL_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_CADENCE_CONFIGURATION_SUPPORTED_FALSE;
        data[ 0] = (byte) fitnessMachineFeatureFlag;
        data[ 1] = (byte) (fitnessMachineFeatureFlag >> 8);
        data[ 2] = (byte) (fitnessMachineFeatureFlag >> 16);
        data[ 3] = (byte) (fitnessMachineFeatureFlag >> 24);
        data[ 4] = (byte) targetSettingFeature;
        data[ 5] = (byte) (targetSettingFeature >> 8);
        data[ 6] = (byte) (targetSettingFeature >> 16);
        data[ 7] = (byte) (targetSettingFeature >> 24);
        data_11101 = data;
    }

    private static final byte[] data_11102;
    static {
        byte[] data = new byte[8];
        int fitnessMachineFeatureFlag = FitnessMachineFeature.FITNESS_MACHINE_FEATURES_AVERAGE_SPEED_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_CADENCE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_TOTAL_DISTANCE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_INCLINATION_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_ELEVATION_GAIN_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_PACE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_STEP_COUNT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_RESISTANCE_LEVEL_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_STRIDE_COUNT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_EXPENDED_ENERGY_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_HEART_RATE_MEASUREMENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_METABOLIC_EQUIVALENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_ELAPSED_TIME_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_REMAINING_TIME_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_POWER_MEASUREMENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_FORCE_ON_BELT_AND_POWER_OUTPUT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_USER_DATA_RETENTION_SUPPORTED_FALSE;
        int targetSettingFeature = FitnessMachineFeature.TARGET_SETTING_FEATURES_SPEED_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_INCLINATION_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_RESISTANCE_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_POWER_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_HEART_RATE_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_EXPENDED_ENERGY_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_STEP_NUMBER_CONFIGRATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_STRIDE_NUMBER_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_DISTANCE_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TRAINING_TIME_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_TWO_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_THREE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_TRUE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_FIVE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_INDOOR_BIKE_SIMULATION_PARAMETERS_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_WHEEL_CIRCUMFERENCE_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_SPIN_DOWN_CONTROL_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_CADENCE_CONFIGURATION_SUPPORTED_FALSE;
        data[ 0] = (byte) fitnessMachineFeatureFlag;
        data[ 1] = (byte) (fitnessMachineFeatureFlag >> 8);
        data[ 2] = (byte) (fitnessMachineFeatureFlag >> 16);
        data[ 3] = (byte) (fitnessMachineFeatureFlag >> 24);
        data[ 4] = (byte) targetSettingFeature;
        data[ 5] = (byte) (targetSettingFeature >> 8);
        data[ 6] = (byte) (targetSettingFeature >> 16);
        data[ 7] = (byte) (targetSettingFeature >> 24);
        data_11102 = data;
    }

    private static final byte[] data_11201;
    static {
        byte[] data = new byte[8];
        int fitnessMachineFeatureFlag = FitnessMachineFeature.FITNESS_MACHINE_FEATURES_AVERAGE_SPEED_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_CADENCE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_TOTAL_DISTANCE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_INCLINATION_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_ELEVATION_GAIN_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_PACE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_STEP_COUNT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_RESISTANCE_LEVEL_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_STRIDE_COUNT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_EXPENDED_ENERGY_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_HEART_RATE_MEASUREMENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_METABOLIC_EQUIVALENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_ELAPSED_TIME_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_REMAINING_TIME_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_POWER_MEASUREMENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_FORCE_ON_BELT_AND_POWER_OUTPUT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_USER_DATA_RETENTION_SUPPORTED_FALSE;
        int targetSettingFeature = FitnessMachineFeature.TARGET_SETTING_FEATURES_SPEED_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_INCLINATION_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_RESISTANCE_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_POWER_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_HEART_RATE_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_EXPENDED_ENERGY_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_STEP_NUMBER_CONFIGRATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_STRIDE_NUMBER_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_DISTANCE_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TRAINING_TIME_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_TWO_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_THREE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_FIVE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_INDOOR_BIKE_SIMULATION_PARAMETERS_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_WHEEL_CIRCUMFERENCE_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_SPIN_DOWN_CONTROL_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_CADENCE_CONFIGURATION_SUPPORTED_FALSE;
        data[ 0] = (byte) fitnessMachineFeatureFlag;
        data[ 1] = (byte) (fitnessMachineFeatureFlag >> 8);
        data[ 2] = (byte) (fitnessMachineFeatureFlag >> 16);
        data[ 3] = (byte) (fitnessMachineFeatureFlag >> 24);
        data[ 4] = (byte) targetSettingFeature;
        data[ 5] = (byte) (targetSettingFeature >> 8);
        data[ 6] = (byte) (targetSettingFeature >> 16);
        data[ 7] = (byte) (targetSettingFeature >> 24);
        data_11201 = data;
    }

    private static final byte[] data_11202;
    static {
        byte[] data = new byte[8];
        int fitnessMachineFeatureFlag = FitnessMachineFeature.FITNESS_MACHINE_FEATURES_AVERAGE_SPEED_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_CADENCE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_TOTAL_DISTANCE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_INCLINATION_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_ELEVATION_GAIN_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_PACE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_STEP_COUNT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_RESISTANCE_LEVEL_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_STRIDE_COUNT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_EXPENDED_ENERGY_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_HEART_RATE_MEASUREMENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_METABOLIC_EQUIVALENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_ELAPSED_TIME_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_REMAINING_TIME_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_POWER_MEASUREMENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_FORCE_ON_BELT_AND_POWER_OUTPUT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_USER_DATA_RETENTION_SUPPORTED_FALSE;
        int targetSettingFeature = FitnessMachineFeature.TARGET_SETTING_FEATURES_SPEED_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_INCLINATION_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_RESISTANCE_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_POWER_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_HEART_RATE_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_EXPENDED_ENERGY_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_STEP_NUMBER_CONFIGRATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_STRIDE_NUMBER_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_DISTANCE_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TRAINING_TIME_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_TWO_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_THREE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_FIVE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_TRUE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_INDOOR_BIKE_SIMULATION_PARAMETERS_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_WHEEL_CIRCUMFERENCE_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_SPIN_DOWN_CONTROL_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_CADENCE_CONFIGURATION_SUPPORTED_FALSE;
        data[ 0] = (byte) fitnessMachineFeatureFlag;
        data[ 1] = (byte) (fitnessMachineFeatureFlag >> 8);
        data[ 2] = (byte) (fitnessMachineFeatureFlag >> 16);
        data[ 3] = (byte) (fitnessMachineFeatureFlag >> 24);
        data[ 4] = (byte) targetSettingFeature;
        data[ 5] = (byte) (targetSettingFeature >> 8);
        data[ 6] = (byte) (targetSettingFeature >> 16);
        data[ 7] = (byte) (targetSettingFeature >> 24);
        data_11202 = data;
    }

    private static final byte[] data_11301;
    static {
        byte[] data = new byte[8];
        int fitnessMachineFeatureFlag = FitnessMachineFeature.FITNESS_MACHINE_FEATURES_AVERAGE_SPEED_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_CADENCE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_TOTAL_DISTANCE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_INCLINATION_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_ELEVATION_GAIN_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_PACE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_STEP_COUNT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_RESISTANCE_LEVEL_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_STRIDE_COUNT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_EXPENDED_ENERGY_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_HEART_RATE_MEASUREMENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_METABOLIC_EQUIVALENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_ELAPSED_TIME_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_REMAINING_TIME_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_POWER_MEASUREMENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_FORCE_ON_BELT_AND_POWER_OUTPUT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_USER_DATA_RETENTION_SUPPORTED_FALSE;
        int targetSettingFeature = FitnessMachineFeature.TARGET_SETTING_FEATURES_SPEED_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_INCLINATION_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_RESISTANCE_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_POWER_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_HEART_RATE_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_EXPENDED_ENERGY_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_STEP_NUMBER_CONFIGRATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_STRIDE_NUMBER_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_DISTANCE_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TRAINING_TIME_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_TWO_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_THREE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_FIVE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_INDOOR_BIKE_SIMULATION_PARAMETERS_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_WHEEL_CIRCUMFERENCE_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_SPIN_DOWN_CONTROL_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_CADENCE_CONFIGURATION_SUPPORTED_FALSE;
        data[ 0] = (byte) fitnessMachineFeatureFlag;
        data[ 1] = (byte) (fitnessMachineFeatureFlag >> 8);
        data[ 2] = (byte) (fitnessMachineFeatureFlag >> 16);
        data[ 3] = (byte) (fitnessMachineFeatureFlag >> 24);
        data[ 4] = (byte) targetSettingFeature;
        data[ 5] = (byte) (targetSettingFeature >> 8);
        data[ 6] = (byte) (targetSettingFeature >> 16);
        data[ 7] = (byte) (targetSettingFeature >> 24);
        data_11301 = data;
    }

    private static final byte[] data_11302;
    static {
        byte[] data = new byte[8];
        int fitnessMachineFeatureFlag = FitnessMachineFeature.FITNESS_MACHINE_FEATURES_AVERAGE_SPEED_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_CADENCE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_TOTAL_DISTANCE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_INCLINATION_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_ELEVATION_GAIN_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_PACE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_STEP_COUNT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_RESISTANCE_LEVEL_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_STRIDE_COUNT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_EXPENDED_ENERGY_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_HEART_RATE_MEASUREMENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_METABOLIC_EQUIVALENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_ELAPSED_TIME_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_REMAINING_TIME_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_POWER_MEASUREMENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_FORCE_ON_BELT_AND_POWER_OUTPUT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_USER_DATA_RETENTION_SUPPORTED_FALSE;
        int targetSettingFeature = FitnessMachineFeature.TARGET_SETTING_FEATURES_SPEED_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_INCLINATION_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_RESISTANCE_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_POWER_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_HEART_RATE_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_EXPENDED_ENERGY_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_STEP_NUMBER_CONFIGRATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_STRIDE_NUMBER_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_DISTANCE_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TRAINING_TIME_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_TWO_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_THREE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_FIVE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_INDOOR_BIKE_SIMULATION_PARAMETERS_SUPPORTED_TRUE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_WHEEL_CIRCUMFERENCE_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_SPIN_DOWN_CONTROL_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_CADENCE_CONFIGURATION_SUPPORTED_FALSE;
        data[ 0] = (byte) fitnessMachineFeatureFlag;
        data[ 1] = (byte) (fitnessMachineFeatureFlag >> 8);
        data[ 2] = (byte) (fitnessMachineFeatureFlag >> 16);
        data[ 3] = (byte) (fitnessMachineFeatureFlag >> 24);
        data[ 4] = (byte) targetSettingFeature;
        data[ 5] = (byte) (targetSettingFeature >> 8);
        data[ 6] = (byte) (targetSettingFeature >> 16);
        data[ 7] = (byte) (targetSettingFeature >> 24);
        data_11302 = data;
    }

    private static final byte[] data_11401;
    static {
        byte[] data = new byte[8];
        int fitnessMachineFeatureFlag = FitnessMachineFeature.FITNESS_MACHINE_FEATURES_AVERAGE_SPEED_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_CADENCE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_TOTAL_DISTANCE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_INCLINATION_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_ELEVATION_GAIN_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_PACE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_STEP_COUNT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_RESISTANCE_LEVEL_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_STRIDE_COUNT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_EXPENDED_ENERGY_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_HEART_RATE_MEASUREMENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_METABOLIC_EQUIVALENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_ELAPSED_TIME_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_REMAINING_TIME_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_POWER_MEASUREMENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_FORCE_ON_BELT_AND_POWER_OUTPUT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_USER_DATA_RETENTION_SUPPORTED_FALSE;
        int targetSettingFeature = FitnessMachineFeature.TARGET_SETTING_FEATURES_SPEED_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_INCLINATION_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_RESISTANCE_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_POWER_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_HEART_RATE_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_EXPENDED_ENERGY_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_STEP_NUMBER_CONFIGRATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_STRIDE_NUMBER_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_DISTANCE_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TRAINING_TIME_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_TWO_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_THREE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_FIVE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_INDOOR_BIKE_SIMULATION_PARAMETERS_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_WHEEL_CIRCUMFERENCE_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_SPIN_DOWN_CONTROL_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_CADENCE_CONFIGURATION_SUPPORTED_FALSE;
        data[ 0] = (byte) fitnessMachineFeatureFlag;
        data[ 1] = (byte) (fitnessMachineFeatureFlag >> 8);
        data[ 2] = (byte) (fitnessMachineFeatureFlag >> 16);
        data[ 3] = (byte) (fitnessMachineFeatureFlag >> 24);
        data[ 4] = (byte) targetSettingFeature;
        data[ 5] = (byte) (targetSettingFeature >> 8);
        data[ 6] = (byte) (targetSettingFeature >> 16);
        data[ 7] = (byte) (targetSettingFeature >> 24);
        data_11401 = data;
    }

    private static final byte[] data_11402;
    static {
        byte[] data = new byte[8];
        int fitnessMachineFeatureFlag = FitnessMachineFeature.FITNESS_MACHINE_FEATURES_AVERAGE_SPEED_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_CADENCE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_TOTAL_DISTANCE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_INCLINATION_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_ELEVATION_GAIN_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_PACE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_STEP_COUNT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_RESISTANCE_LEVEL_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_STRIDE_COUNT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_EXPENDED_ENERGY_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_HEART_RATE_MEASUREMENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_METABOLIC_EQUIVALENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_ELAPSED_TIME_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_REMAINING_TIME_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_POWER_MEASUREMENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_FORCE_ON_BELT_AND_POWER_OUTPUT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_USER_DATA_RETENTION_SUPPORTED_FALSE;
        int targetSettingFeature = FitnessMachineFeature.TARGET_SETTING_FEATURES_SPEED_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_INCLINATION_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_RESISTANCE_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_POWER_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_HEART_RATE_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_EXPENDED_ENERGY_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_STEP_NUMBER_CONFIGRATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_STRIDE_NUMBER_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_DISTANCE_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TRAINING_TIME_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_TWO_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_THREE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_FIVE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_INDOOR_BIKE_SIMULATION_PARAMETERS_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_WHEEL_CIRCUMFERENCE_CONFIGURATION_SUPPORTED_TRUE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_SPIN_DOWN_CONTROL_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_CADENCE_CONFIGURATION_SUPPORTED_FALSE;
        data[ 0] = (byte) fitnessMachineFeatureFlag;
        data[ 1] = (byte) (fitnessMachineFeatureFlag >> 8);
        data[ 2] = (byte) (fitnessMachineFeatureFlag >> 16);
        data[ 3] = (byte) (fitnessMachineFeatureFlag >> 24);
        data[ 4] = (byte) targetSettingFeature;
        data[ 5] = (byte) (targetSettingFeature >> 8);
        data[ 6] = (byte) (targetSettingFeature >> 16);
        data[ 7] = (byte) (targetSettingFeature >> 24);
        data_11402 = data;
    }

    private static final byte[] data_11501;
    static {
        byte[] data = new byte[8];
        int fitnessMachineFeatureFlag = FitnessMachineFeature.FITNESS_MACHINE_FEATURES_AVERAGE_SPEED_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_CADENCE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_TOTAL_DISTANCE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_INCLINATION_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_ELEVATION_GAIN_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_PACE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_STEP_COUNT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_RESISTANCE_LEVEL_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_STRIDE_COUNT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_EXPENDED_ENERGY_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_HEART_RATE_MEASUREMENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_METABOLIC_EQUIVALENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_ELAPSED_TIME_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_REMAINING_TIME_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_POWER_MEASUREMENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_FORCE_ON_BELT_AND_POWER_OUTPUT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_USER_DATA_RETENTION_SUPPORTED_FALSE;
        int targetSettingFeature = FitnessMachineFeature.TARGET_SETTING_FEATURES_SPEED_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_INCLINATION_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_RESISTANCE_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_POWER_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_HEART_RATE_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_EXPENDED_ENERGY_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_STEP_NUMBER_CONFIGRATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_STRIDE_NUMBER_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_DISTANCE_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TRAINING_TIME_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_TWO_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_THREE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_FIVE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_INDOOR_BIKE_SIMULATION_PARAMETERS_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_WHEEL_CIRCUMFERENCE_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_SPIN_DOWN_CONTROL_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_CADENCE_CONFIGURATION_SUPPORTED_FALSE;
        data[ 0] = (byte) fitnessMachineFeatureFlag;
        data[ 1] = (byte) (fitnessMachineFeatureFlag >> 8);
        data[ 2] = (byte) (fitnessMachineFeatureFlag >> 16);
        data[ 3] = (byte) (fitnessMachineFeatureFlag >> 24);
        data[ 4] = (byte) targetSettingFeature;
        data[ 5] = (byte) (targetSettingFeature >> 8);
        data[ 6] = (byte) (targetSettingFeature >> 16);
        data[ 7] = (byte) (targetSettingFeature >> 24);
        data_11501 = data;
    }

    private static final byte[] data_11502;
    static {
        byte[] data = new byte[8];
        int fitnessMachineFeatureFlag = FitnessMachineFeature.FITNESS_MACHINE_FEATURES_AVERAGE_SPEED_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_CADENCE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_TOTAL_DISTANCE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_INCLINATION_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_ELEVATION_GAIN_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_PACE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_STEP_COUNT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_RESISTANCE_LEVEL_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_STRIDE_COUNT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_EXPENDED_ENERGY_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_HEART_RATE_MEASUREMENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_METABOLIC_EQUIVALENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_ELAPSED_TIME_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_REMAINING_TIME_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_POWER_MEASUREMENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_FORCE_ON_BELT_AND_POWER_OUTPUT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_USER_DATA_RETENTION_SUPPORTED_FALSE;
        int targetSettingFeature = FitnessMachineFeature.TARGET_SETTING_FEATURES_SPEED_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_INCLINATION_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_RESISTANCE_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_POWER_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_HEART_RATE_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_EXPENDED_ENERGY_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_STEP_NUMBER_CONFIGRATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_STRIDE_NUMBER_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_DISTANCE_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TRAINING_TIME_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_TWO_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_THREE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_FIVE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_INDOOR_BIKE_SIMULATION_PARAMETERS_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_WHEEL_CIRCUMFERENCE_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_SPIN_DOWN_CONTROL_SUPPORTED_TRUE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_CADENCE_CONFIGURATION_SUPPORTED_FALSE;
        data[ 0] = (byte) fitnessMachineFeatureFlag;
        data[ 1] = (byte) (fitnessMachineFeatureFlag >> 8);
        data[ 2] = (byte) (fitnessMachineFeatureFlag >> 16);
        data[ 3] = (byte) (fitnessMachineFeatureFlag >> 24);
        data[ 4] = (byte) targetSettingFeature;
        data[ 5] = (byte) (targetSettingFeature >> 8);
        data[ 6] = (byte) (targetSettingFeature >> 16);
        data[ 7] = (byte) (targetSettingFeature >> 24);
        data_11502 = data;
    }

    private static final byte[] data_11601;
    static {
        byte[] data = new byte[8];
        int fitnessMachineFeatureFlag = FitnessMachineFeature.FITNESS_MACHINE_FEATURES_AVERAGE_SPEED_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_CADENCE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_TOTAL_DISTANCE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_INCLINATION_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_ELEVATION_GAIN_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_PACE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_STEP_COUNT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_RESISTANCE_LEVEL_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_STRIDE_COUNT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_EXPENDED_ENERGY_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_HEART_RATE_MEASUREMENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_METABOLIC_EQUIVALENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_ELAPSED_TIME_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_REMAINING_TIME_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_POWER_MEASUREMENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_FORCE_ON_BELT_AND_POWER_OUTPUT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_USER_DATA_RETENTION_SUPPORTED_FALSE;
        int targetSettingFeature = FitnessMachineFeature.TARGET_SETTING_FEATURES_SPEED_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_INCLINATION_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_RESISTANCE_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_POWER_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_HEART_RATE_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_EXPENDED_ENERGY_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_STEP_NUMBER_CONFIGRATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_STRIDE_NUMBER_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_DISTANCE_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TRAINING_TIME_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_TWO_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_THREE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_FIVE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_INDOOR_BIKE_SIMULATION_PARAMETERS_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_WHEEL_CIRCUMFERENCE_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_SPIN_DOWN_CONTROL_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_CADENCE_CONFIGURATION_SUPPORTED_FALSE;
        data[ 0] = (byte) fitnessMachineFeatureFlag;
        data[ 1] = (byte) (fitnessMachineFeatureFlag >> 8);
        data[ 2] = (byte) (fitnessMachineFeatureFlag >> 16);
        data[ 3] = (byte) (fitnessMachineFeatureFlag >> 24);
        data[ 4] = (byte) targetSettingFeature;
        data[ 5] = (byte) (targetSettingFeature >> 8);
        data[ 6] = (byte) (targetSettingFeature >> 16);
        data[ 7] = (byte) (targetSettingFeature >> 24);
        data_11601 = data;
    }

    private static final byte[] data_11602;
    static {
        byte[] data = new byte[8];
        int fitnessMachineFeatureFlag = FitnessMachineFeature.FITNESS_MACHINE_FEATURES_AVERAGE_SPEED_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_CADENCE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_TOTAL_DISTANCE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_INCLINATION_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_ELEVATION_GAIN_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_PACE_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_STEP_COUNT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_RESISTANCE_LEVEL_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_STRIDE_COUNT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_EXPENDED_ENERGY_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_HEART_RATE_MEASUREMENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_METABOLIC_EQUIVALENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_ELAPSED_TIME_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_REMAINING_TIME_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_POWER_MEASUREMENT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_FORCE_ON_BELT_AND_POWER_OUTPUT_SUPPORTED_FALSE
                | FitnessMachineFeature.FITNESS_MACHINE_FEATURES_USER_DATA_RETENTION_SUPPORTED_FALSE;
        int targetSettingFeature = FitnessMachineFeature.TARGET_SETTING_FEATURES_SPEED_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_INCLINATION_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_RESISTANCE_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_POWER_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_HEART_RATE_TARGET_SETTING_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_EXPENDED_ENERGY_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_STEP_NUMBER_CONFIGRATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_STRIDE_NUMBER_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_DISTANCE_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TRAINING_TIME_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_TWO_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_THREE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_FIVE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_INDOOR_BIKE_SIMULATION_PARAMETERS_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_WHEEL_CIRCUMFERENCE_CONFIGURATION_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_SPIN_DOWN_CONTROL_SUPPORTED_FALSE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_CADENCE_CONFIGURATION_SUPPORTED_TRUE;
        data[ 0] = (byte) fitnessMachineFeatureFlag;
        data[ 1] = (byte) (fitnessMachineFeatureFlag >> 8);
        data[ 2] = (byte) (fitnessMachineFeatureFlag >> 16);
        data[ 3] = (byte) (fitnessMachineFeatureFlag >> 24);
        data[ 4] = (byte) targetSettingFeature;
        data[ 5] = (byte) (targetSettingFeature >> 8);
        data[ 6] = (byte) (targetSettingFeature >> 16);
        data[ 7] = (byte) (targetSettingFeature >> 24);
        data_11602 = data;
    }
    //@formatter:on

    @Test
    public void test_constructor_00001() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 4), result1.getFitnessMachineFeatures());
        assertTrue(result1.isFitnessMachineFeaturesAverageSpeedNotSupported());
        assertFalse(result1.isFitnessMachineFeaturesAverageSpeedSupported());
        assertArrayEquals(Arrays.copyOfRange(data, 4, 8), result1.getTargetSettingFeatures());
    }

    @Test
    public void test_constructor_00002() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 4), result1.getFitnessMachineFeatures());
        assertFalse(result1.isFitnessMachineFeaturesAverageSpeedNotSupported());
        assertTrue(result1.isFitnessMachineFeaturesAverageSpeedSupported());
        assertArrayEquals(Arrays.copyOfRange(data, 4, 8), result1.getTargetSettingFeatures());
    }

    @Test
    public void test_constructor_00101() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 4), result1.getFitnessMachineFeatures());
        assertTrue(result1.isFitnessMachineFeaturesCadenceNotSupported());
        assertFalse(result1.isFitnessMachineFeaturesCadenceSupported());
        assertArrayEquals(Arrays.copyOfRange(data, 4, 8), result1.getTargetSettingFeatures());
    }

    @Test
    public void test_constructor_00102() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 4), result1.getFitnessMachineFeatures());
        assertFalse(result1.isFitnessMachineFeaturesCadenceNotSupported());
        assertTrue(result1.isFitnessMachineFeaturesCadenceSupported());
        assertArrayEquals(Arrays.copyOfRange(data, 4, 8), result1.getTargetSettingFeatures());
    }

    @Test
    public void test_constructor_00201() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 4), result1.getFitnessMachineFeatures());
        assertTrue(result1.isFitnessMachineFeaturesTotalDistanceNotSupported());
        assertFalse(result1.isFitnessMachineFeaturesTotalDistanceSupported());
        assertArrayEquals(Arrays.copyOfRange(data, 4, 8), result1.getTargetSettingFeatures());
    }

    @Test
    public void test_constructor_00202() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 4), result1.getFitnessMachineFeatures());
        assertFalse(result1.isFitnessMachineFeaturesTotalDistanceNotSupported());
        assertTrue(result1.isFitnessMachineFeaturesTotalDistanceSupported());
        assertArrayEquals(Arrays.copyOfRange(data, 4, 8), result1.getTargetSettingFeatures());
    }

    @Test
    public void test_constructor_00301() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 4), result1.getFitnessMachineFeatures());
        assertTrue(result1.isFitnessMachineFeaturesInclinationNotSupported());
        assertFalse(result1.isFitnessMachineFeaturesInclinationSupported());
        assertArrayEquals(Arrays.copyOfRange(data, 4, 8), result1.getTargetSettingFeatures());
    }

    @Test
    public void test_constructor_00302() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 4), result1.getFitnessMachineFeatures());
        assertFalse(result1.isFitnessMachineFeaturesInclinationNotSupported());
        assertTrue(result1.isFitnessMachineFeaturesInclinationSupported());
        assertArrayEquals(Arrays.copyOfRange(data, 4, 8), result1.getTargetSettingFeatures());
    }

    @Test
    public void test_constructor_00401() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 4), result1.getFitnessMachineFeatures());
        assertTrue(result1.isFitnessMachineFeaturesElevationGainNotSupported());
        assertFalse(result1.isFitnessMachineFeaturesElevationGainSupported());
        assertArrayEquals(Arrays.copyOfRange(data, 4, 8), result1.getTargetSettingFeatures());
    }

    @Test
    public void test_constructor_00402() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 4), result1.getFitnessMachineFeatures());
        assertFalse(result1.isFitnessMachineFeaturesElevationGainNotSupported());
        assertTrue(result1.isFitnessMachineFeaturesElevationGainSupported());
        assertArrayEquals(Arrays.copyOfRange(data, 4, 8), result1.getTargetSettingFeatures());
    }

    @Test
    public void test_constructor_00501() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 4), result1.getFitnessMachineFeatures());
        assertTrue(result1.isFitnessMachineFeaturesPaceNotSupported());
        assertFalse(result1.isFitnessMachineFeaturesPaceSupported());
        assertArrayEquals(Arrays.copyOfRange(data, 4, 8), result1.getTargetSettingFeatures());
    }

    @Test
    public void test_constructor_00502() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 4), result1.getFitnessMachineFeatures());
        assertFalse(result1.isFitnessMachineFeaturesPaceNotSupported());
        assertTrue(result1.isFitnessMachineFeaturesPaceSupported());
        assertArrayEquals(Arrays.copyOfRange(data, 4, 8), result1.getTargetSettingFeatures());
    }

    @Test
    public void test_constructor_00601() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 4), result1.getFitnessMachineFeatures());
        assertTrue(result1.isFitnessMachineFeaturesStepCountNotSupported());
        assertFalse(result1.isFitnessMachineFeaturesStepCountSupported());
        assertArrayEquals(Arrays.copyOfRange(data, 4, 8), result1.getTargetSettingFeatures());
    }

    @Test
    public void test_constructor_00602() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 4), result1.getFitnessMachineFeatures());
        assertFalse(result1.isFitnessMachineFeaturesStepCountNotSupported());
        assertTrue(result1.isFitnessMachineFeaturesStepCountSupported());
        assertArrayEquals(Arrays.copyOfRange(data, 4, 8), result1.getTargetSettingFeatures());
    }

    @Test
    public void test_constructor_00701() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 4), result1.getFitnessMachineFeatures());
        assertTrue(result1.isFitnessMachineFeaturesResistanceLevelNotSupported());
        assertFalse(result1.isFitnessMachineFeaturesResistanceLevelSupported());
        assertArrayEquals(Arrays.copyOfRange(data, 4, 8), result1.getTargetSettingFeatures());
    }

    @Test
    public void test_constructor_00702() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 4), result1.getFitnessMachineFeatures());
        assertFalse(result1.isFitnessMachineFeaturesResistanceLevelNotSupported());
        assertTrue(result1.isFitnessMachineFeaturesResistanceLevelSupported());
        assertArrayEquals(Arrays.copyOfRange(data, 4, 8), result1.getTargetSettingFeatures());
    }

    @Test
    public void test_constructor_00801() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 4), result1.getFitnessMachineFeatures());
        assertTrue(result1.isFitnessMachineFeaturesStrideCountNotSupported());
        assertFalse(result1.isFitnessMachineFeaturesStrideCountSupported());
        assertArrayEquals(Arrays.copyOfRange(data, 4, 8), result1.getTargetSettingFeatures());
    }

    @Test
    public void test_constructor_00802() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 4), result1.getFitnessMachineFeatures());
        assertFalse(result1.isFitnessMachineFeaturesStrideCountNotSupported());
        assertTrue(result1.isFitnessMachineFeaturesStrideCountSupported());
        assertArrayEquals(Arrays.copyOfRange(data, 4, 8), result1.getTargetSettingFeatures());
    }

    @Test
    public void test_constructor_00901() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 4), result1.getFitnessMachineFeatures());
        assertTrue(result1.isFitnessMachineFeaturesExpendedEnergyNotSupported());
        assertFalse(result1.isFitnessMachineFeaturesExpendedEnergySupported());
        assertArrayEquals(Arrays.copyOfRange(data, 4, 8), result1.getTargetSettingFeatures());
    }

    @Test
    public void test_constructor_00902() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 4), result1.getFitnessMachineFeatures());
        assertFalse(result1.isFitnessMachineFeaturesExpendedEnergyNotSupported());
        assertTrue(result1.isFitnessMachineFeaturesExpendedEnergySupported());
        assertArrayEquals(Arrays.copyOfRange(data, 4, 8), result1.getTargetSettingFeatures());
    }

    @Test
    public void test_constructor_01001() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 4), result1.getFitnessMachineFeatures());
        assertTrue(result1.isFitnessMachineFeaturesHeartRateMeasurementNotSupported());
        assertFalse(result1.isFitnessMachineFeaturesHeartRateMeasurementSupported());
        assertArrayEquals(Arrays.copyOfRange(data, 4, 8), result1.getTargetSettingFeatures());
    }

    @Test
    public void test_constructor_01002() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 4), result1.getFitnessMachineFeatures());
        assertFalse(result1.isFitnessMachineFeaturesHeartRateMeasurementNotSupported());
        assertTrue(result1.isFitnessMachineFeaturesHeartRateMeasurementSupported());
        assertArrayEquals(Arrays.copyOfRange(data, 4, 8), result1.getTargetSettingFeatures());
    }

    @Test
    public void test_constructor_01101() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 4), result1.getFitnessMachineFeatures());
        assertTrue(result1.isFitnessMachineFeaturesMetabolicEquivalentNotSupported());
        assertFalse(result1.isFitnessMachineFeaturesMetabolicEquivalentSupported());
        assertArrayEquals(Arrays.copyOfRange(data, 4, 8), result1.getTargetSettingFeatures());
    }

    @Test
    public void test_constructor_01102() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 4), result1.getFitnessMachineFeatures());
        assertFalse(result1.isFitnessMachineFeaturesMetabolicEquivalentNotSupported());
        assertTrue(result1.isFitnessMachineFeaturesMetabolicEquivalentSupported());
        assertArrayEquals(Arrays.copyOfRange(data, 4, 8), result1.getTargetSettingFeatures());
    }

    @Test
    public void test_constructor_01201() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 4), result1.getFitnessMachineFeatures());
        assertTrue(result1.isFitnessMachineFeaturesElapsedTimeNotSupported());
        assertFalse(result1.isFitnessMachineFeaturesElapsedTimeSupported());
        assertArrayEquals(Arrays.copyOfRange(data, 4, 8), result1.getTargetSettingFeatures());
    }

    @Test
    public void test_constructor_01202() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 4), result1.getFitnessMachineFeatures());
        assertFalse(result1.isFitnessMachineFeaturesElapsedTimeNotSupported());
        assertTrue(result1.isFitnessMachineFeaturesElapsedTimeSupported());
        assertArrayEquals(Arrays.copyOfRange(data, 4, 8), result1.getTargetSettingFeatures());
    }

    @Test
    public void test_constructor_01301() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 4), result1.getFitnessMachineFeatures());
        assertTrue(result1.isFitnessMachineFeaturesRemainingTimeNotSupported());
        assertFalse(result1.isFitnessMachineFeaturesRemainingTimeSupported());
        assertArrayEquals(Arrays.copyOfRange(data, 4, 8), result1.getTargetSettingFeatures());
    }

    @Test
    public void test_constructor_01302() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 4), result1.getFitnessMachineFeatures());
        assertFalse(result1.isFitnessMachineFeaturesRemainingTimeNotSupported());
        assertTrue(result1.isFitnessMachineFeaturesRemainingTimeSupported());
        assertArrayEquals(Arrays.copyOfRange(data, 4, 8), result1.getTargetSettingFeatures());
    }

    @Test
    public void test_constructor_01401() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 4), result1.getFitnessMachineFeatures());
        assertTrue(result1.isFitnessMachineFeaturesPowerMeasurementNotSupported());
        assertFalse(result1.isFitnessMachineFeaturesPowerMeasurementSupported());
        assertArrayEquals(Arrays.copyOfRange(data, 4, 8), result1.getTargetSettingFeatures());
    }

    @Test
    public void test_constructor_01402() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 4), result1.getFitnessMachineFeatures());
        assertFalse(result1.isFitnessMachineFeaturesPowerMeasurementNotSupported());
        assertTrue(result1.isFitnessMachineFeaturesPowerMeasurementSupported());
        assertArrayEquals(Arrays.copyOfRange(data, 4, 8), result1.getTargetSettingFeatures());
    }

    @Test
    public void test_constructor_01501() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 4), result1.getFitnessMachineFeatures());
        assertTrue(result1.isFitnessMachineFeaturesForceOnBeltAndPowerOutputNotSupported());
        assertFalse(result1.isFitnessMachineFeaturesForceOnBeltAndPowerOutputSupported());
        assertArrayEquals(Arrays.copyOfRange(data, 4, 8), result1.getTargetSettingFeatures());
    }

    @Test
    public void test_constructor_01502() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 4), result1.getFitnessMachineFeatures());
        assertFalse(result1.isFitnessMachineFeaturesForceOnBeltAndPowerOutputNotSupported());
        assertTrue(result1.isFitnessMachineFeaturesForceOnBeltAndPowerOutputSupported());
        assertArrayEquals(Arrays.copyOfRange(data, 4, 8), result1.getTargetSettingFeatures());
    }

    @Test
    public void test_constructor_01601() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 4), result1.getFitnessMachineFeatures());
        assertTrue(result1.isFitnessMachineFeaturesUserDataRetentionNotSupported());
        assertFalse(result1.isFitnessMachineFeaturesUserDataRetentionSupported());
        assertArrayEquals(Arrays.copyOfRange(data, 4, 8), result1.getTargetSettingFeatures());
    }

    @Test
    public void test_constructor_01602() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 4), result1.getFitnessMachineFeatures());
        assertFalse(result1.isFitnessMachineFeaturesUserDataRetentionNotSupported());
        assertTrue(result1.isFitnessMachineFeaturesUserDataRetentionSupported());
        assertArrayEquals(Arrays.copyOfRange(data, 4, 8), result1.getTargetSettingFeatures());
    }

    @Test
    public void test_constructor_10001() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 4), result1.getFitnessMachineFeatures());
        assertArrayEquals(Arrays.copyOfRange(data, 4, 8), result1.getTargetSettingFeatures());
        assertTrue(result1.isTargetSettingFeaturesSpeedTargetSettingNotSupported());
        assertFalse(result1.isTargetSettingFeaturesSpeedTargetSettingSupported());
    }

    @Test
    public void test_constructor_10002() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 4), result1.getFitnessMachineFeatures());
        assertArrayEquals(Arrays.copyOfRange(data, 4, 8), result1.getTargetSettingFeatures());
        assertFalse(result1.isTargetSettingFeaturesSpeedTargetSettingNotSupported());
        assertTrue(result1.isTargetSettingFeaturesSpeedTargetSettingSupported());
    }

    @Test
    public void test_constructor_10101() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 4), result1.getFitnessMachineFeatures());
        assertArrayEquals(Arrays.copyOfRange(data, 4, 8), result1.getTargetSettingFeatures());
        assertTrue(result1.isTargetSettingFeaturesInclinationTargetSettinNotSupported());
        assertFalse(result1.isTargetSettingFeaturesInclinationTargetSettingSupported());
    }

    @Test
    public void test_constructor_10102() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 4), result1.getFitnessMachineFeatures());
        assertArrayEquals(Arrays.copyOfRange(data, 4, 8), result1.getTargetSettingFeatures());
        assertFalse(result1.isTargetSettingFeaturesInclinationTargetSettinNotSupported());
        assertTrue(result1.isTargetSettingFeaturesInclinationTargetSettingSupported());
    }

    @Test
    public void test_constructor_10201() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 4), result1.getFitnessMachineFeatures());
        assertArrayEquals(Arrays.copyOfRange(data, 4, 8), result1.getTargetSettingFeatures());
        assertTrue(result1.isTargetSettingFeaturesResistanceTargetSettingNotSupported());
        assertFalse(result1.isTargetSettingFeaturesResistanceTargetSettingSupported());
    }

    @Test
    public void test_constructor_10202() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 4), result1.getFitnessMachineFeatures());
        assertArrayEquals(Arrays.copyOfRange(data, 4, 8), result1.getTargetSettingFeatures());
        assertFalse(result1.isTargetSettingFeaturesResistanceTargetSettingNotSupported());
        assertTrue(result1.isTargetSettingFeaturesResistanceTargetSettingSupported());
    }

    @Test
    public void test_constructor_10301() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 4), result1.getFitnessMachineFeatures());
        assertArrayEquals(Arrays.copyOfRange(data, 4, 8), result1.getTargetSettingFeatures());
        assertTrue(result1.isTargetSettingFeaturesPowerTargetSettingNotSupported());
        assertFalse(result1.isTargetSettingFeaturesPowerTargetSettingSupported());
    }

    @Test
    public void test_constructor_10302() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 4), result1.getFitnessMachineFeatures());
        assertArrayEquals(Arrays.copyOfRange(data, 4, 8), result1.getTargetSettingFeatures());
        assertFalse(result1.isTargetSettingFeaturesPowerTargetSettingNotSupported());
        assertTrue(result1.isTargetSettingFeaturesPowerTargetSettingSupported());
    }

    @Test
    public void test_constructor_10401() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 4), result1.getFitnessMachineFeatures());
        assertArrayEquals(Arrays.copyOfRange(data, 4, 8), result1.getTargetSettingFeatures());
        assertTrue(result1.isTargetSettingFeaturesHeartRateTargetSettingNotSupported());
        assertFalse(result1.isTargetSettingFeaturesHeartRateTargetSettingSupported());
    }

    @Test
    public void test_constructor_10402() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 4), result1.getFitnessMachineFeatures());
        assertArrayEquals(Arrays.copyOfRange(data, 4, 8), result1.getTargetSettingFeatures());
        assertFalse(result1.isTargetSettingFeaturesHeartRateTargetSettingNotSupported());
        assertTrue(result1.isTargetSettingFeaturesHeartRateTargetSettingSupported());
    }

    @Test
    public void test_constructor_10501() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 4), result1.getFitnessMachineFeatures());
        assertArrayEquals(Arrays.copyOfRange(data, 4, 8), result1.getTargetSettingFeatures());
        assertTrue(result1.isTargetSettingFeaturesTargetedExpendedEnergyConfigurationNotSupported());
        assertFalse(result1.isTargetSettingFeaturesTargetedExpendedEnergyConfigurationSupported());
    }

    @Test
    public void test_constructor_10502() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 4), result1.getFitnessMachineFeatures());
        assertArrayEquals(Arrays.copyOfRange(data, 4, 8), result1.getTargetSettingFeatures());
        assertFalse(result1.isTargetSettingFeaturesTargetedExpendedEnergyConfigurationNotSupported());
        assertTrue(result1.isTargetSettingFeaturesTargetedExpendedEnergyConfigurationSupported());
    }

    @Test
    public void test_constructor_10601() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 4), result1.getFitnessMachineFeatures());
        assertArrayEquals(Arrays.copyOfRange(data, 4, 8), result1.getTargetSettingFeatures());
        assertTrue(result1.isTargetSettingFeaturesTargetedStepNumberConfigurationNotSupported());
        assertFalse(result1.isTargetSettingFeaturesTargetedStepNumberConfigurationSupported());
    }

    @Test
    public void test_constructor_10602() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 4), result1.getFitnessMachineFeatures());
        assertArrayEquals(Arrays.copyOfRange(data, 4, 8), result1.getTargetSettingFeatures());
        assertFalse(result1.isTargetSettingFeaturesTargetedStepNumberConfigurationNotSupported());
        assertTrue(result1.isTargetSettingFeaturesTargetedStepNumberConfigurationSupported());
    }

    @Test
    public void test_constructor_10701() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 4), result1.getFitnessMachineFeatures());
        assertArrayEquals(Arrays.copyOfRange(data, 4, 8), result1.getTargetSettingFeatures());
        assertTrue(result1.isTargetSettingFeaturesTargetedStrideNumberConfigurationNotSupported());
        assertFalse(result1.isTargetSettingFeaturesTargetedStrideNumberConfigurationSupported());
    }

    @Test
    public void test_constructor_10702() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 4), result1.getFitnessMachineFeatures());
        assertArrayEquals(Arrays.copyOfRange(data, 4, 8), result1.getTargetSettingFeatures());
        assertFalse(result1.isTargetSettingFeaturesTargetedStrideNumberConfigurationNotSupported());
        assertTrue(result1.isTargetSettingFeaturesTargetedStrideNumberConfigurationSupported());
    }

    @Test
    public void test_constructor_10801() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 4), result1.getFitnessMachineFeatures());
        assertArrayEquals(Arrays.copyOfRange(data, 4, 8), result1.getTargetSettingFeatures());
        assertTrue(result1.isTargetSettingFeaturesTargetedDistanceConfigurationNotSupported());
        assertFalse(result1.isTargetSettingFeaturesTargetedDistanceConfigurationSupported());
    }

    @Test
    public void test_constructor_10802() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 4), result1.getFitnessMachineFeatures());
        assertArrayEquals(Arrays.copyOfRange(data, 4, 8), result1.getTargetSettingFeatures());
        assertFalse(result1.isTargetSettingFeaturesTargetedDistanceConfigurationNotSupported());
        assertTrue(result1.isTargetSettingFeaturesTargetedDistanceConfigurationSupported());
    }

    @Test
    public void test_constructor_10901() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 4), result1.getFitnessMachineFeatures());
        assertArrayEquals(Arrays.copyOfRange(data, 4, 8), result1.getTargetSettingFeatures());
        assertTrue(result1.isTargetSettingFeaturesTargetedTrainingTimeConfigurationNotSupported());
        assertFalse(result1.isTargetSettingFeaturesTargetedTrainingTimeConfigurationSupported());
    }

    @Test
    public void test_constructor_10902() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 4), result1.getFitnessMachineFeatures());
        assertArrayEquals(Arrays.copyOfRange(data, 4, 8), result1.getTargetSettingFeatures());
        assertFalse(result1.isTargetSettingFeaturesTargetedTrainingTimeConfigurationNotSupported());
        assertTrue(result1.isTargetSettingFeaturesTargetedTrainingTimeConfigurationSupported());
    }

    @Test
    public void test_constructor_11001() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 4), result1.getFitnessMachineFeatures());
        assertArrayEquals(Arrays.copyOfRange(data, 4, 8), result1.getTargetSettingFeatures());
        assertTrue(result1.isTargetSettingFeaturesTargetedTimeInTwoHeartRateZonesConfigurationNotSupported());
        assertFalse(result1.isTargetSettingFeaturesTargetedTimeInTwoHeartRateZonesConfigurationSupported());
    }

    @Test
    public void test_constructor_11002() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 4), result1.getFitnessMachineFeatures());
        assertArrayEquals(Arrays.copyOfRange(data, 4, 8), result1.getTargetSettingFeatures());
        assertFalse(result1.isTargetSettingFeaturesTargetedTimeInTwoHeartRateZonesConfigurationNotSupported());
        assertTrue(result1.isTargetSettingFeaturesTargetedTimeInTwoHeartRateZonesConfigurationSupported());
    }

    @Test
    public void test_constructor_11101() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 4), result1.getFitnessMachineFeatures());
        assertArrayEquals(Arrays.copyOfRange(data, 4, 8), result1.getTargetSettingFeatures());
        assertTrue(result1.isTargetSettingFeaturesTargetedTimeInThreeHeartRateZonesConfigurationNotSupported());
        assertFalse(result1.isTargetSettingFeaturesTargetedTimeInThreeHeartRateZonesConfigurationSupported());
    }

    @Test
    public void test_constructor_11102() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 4), result1.getFitnessMachineFeatures());
        assertArrayEquals(Arrays.copyOfRange(data, 4, 8), result1.getTargetSettingFeatures());
        assertFalse(result1.isTargetSettingFeaturesTargetedTimeInThreeHeartRateZonesConfigurationNotSupported());
        assertTrue(result1.isTargetSettingFeaturesTargetedTimeInThreeHeartRateZonesConfigurationSupported());
    }

    @Test
    public void test_constructor_11201() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 4), result1.getFitnessMachineFeatures());
        assertArrayEquals(Arrays.copyOfRange(data, 4, 8), result1.getTargetSettingFeatures());
        assertTrue(result1.isTargetSettingFeaturesTargetedTimeInFiveHeartRateZonesConfigurationNotSupported());
        assertFalse(result1.isTargetSettingFeaturesTargetedTimeInFiveHeartRateZonesConfigurationSupported());
    }

    @Test
    public void test_constructor_11202() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 4), result1.getFitnessMachineFeatures());
        assertArrayEquals(Arrays.copyOfRange(data, 4, 8), result1.getTargetSettingFeatures());
        assertFalse(result1.isTargetSettingFeaturesTargetedTimeInFiveHeartRateZonesConfigurationNotSupported());
        assertTrue(result1.isTargetSettingFeaturesTargetedTimeInFiveHeartRateZonesConfigurationSupported());
    }

    @Test
    public void test_constructor_11301() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 4), result1.getFitnessMachineFeatures());
        assertArrayEquals(Arrays.copyOfRange(data, 4, 8), result1.getTargetSettingFeatures());
        assertTrue(result1.isTargetSettingFeaturesIndoorBikeSimulationParametersNotSupported());
        assertFalse(result1.isTargetSettingFeaturesIndoorBikeSimulationParametersSupported());
    }

    @Test
    public void test_constructor_11302() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 4), result1.getFitnessMachineFeatures());
        assertArrayEquals(Arrays.copyOfRange(data, 4, 8), result1.getTargetSettingFeatures());
        assertFalse(result1.isTargetSettingFeaturesIndoorBikeSimulationParametersNotSupported());
        assertTrue(result1.isTargetSettingFeaturesIndoorBikeSimulationParametersSupported());
    }

    @Test
    public void test_constructor_11401() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 4), result1.getFitnessMachineFeatures());
        assertArrayEquals(Arrays.copyOfRange(data, 4, 8), result1.getTargetSettingFeatures());
        assertTrue(result1.isTargetSettingFeaturesWheelCircumferenceConfigurationNotSupported());
        assertFalse(result1.isTargetSettingFeaturesWheelCircumferenceConfigurationSupported());
    }

    @Test
    public void test_constructor_11402() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 4), result1.getFitnessMachineFeatures());
        assertArrayEquals(Arrays.copyOfRange(data, 4, 8), result1.getTargetSettingFeatures());
        assertFalse(result1.isTargetSettingFeaturesWheelCircumferenceConfigurationNotSupported());
        assertTrue(result1.isTargetSettingFeaturesWheelCircumferenceConfigurationSupported());
    }

    @Test
    public void test_constructor_11501() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 4), result1.getFitnessMachineFeatures());
        assertArrayEquals(Arrays.copyOfRange(data, 4, 8), result1.getTargetSettingFeatures());
        assertTrue(result1.isTargetSettingFeaturesSpinDownControlNotSupported());
        assertFalse(result1.isTargetSettingFeaturesSpinDownControlSupported());
    }

    @Test
    public void test_constructor_11502() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 4), result1.getFitnessMachineFeatures());
        assertArrayEquals(Arrays.copyOfRange(data, 4, 8), result1.getTargetSettingFeatures());
        assertFalse(result1.isTargetSettingFeaturesSpinDownControlNotSupported());
        assertTrue(result1.isTargetSettingFeaturesSpinDownControlSupported());
    }

    @Test
    public void test_constructor_11601() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 4), result1.getFitnessMachineFeatures());
        assertArrayEquals(Arrays.copyOfRange(data, 4, 8), result1.getTargetSettingFeatures());
        assertTrue(result1.isTargetSettingFeaturesTargetedCadenceConfigurationNotSupported());
        assertFalse(result1.isTargetSettingFeaturesTargetedCadenceConfigurationSupported());
    }

    @Test
    public void test_constructor_11602() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 4), result1.getFitnessMachineFeatures());
        assertArrayEquals(Arrays.copyOfRange(data, 4, 8), result1.getTargetSettingFeatures());
        assertFalse(result1.isTargetSettingFeaturesTargetedCadenceConfigurationNotSupported());
        assertTrue(result1.isTargetSettingFeaturesTargetedCadenceConfigurationSupported());
    }

    @Test
    public void test_constructor_11603() {
        byte[] fitnessMachineFeatures = new byte[] { 1 };
        byte[] targetSettingFeatures = new byte[] { 2 };

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(fitnessMachineFeatures, targetSettingFeatures);
        assertArrayEquals(fitnessMachineFeatures, result1.getFitnessMachineFeatures());
        assertArrayEquals(targetSettingFeatures, result1.getTargetSettingFeatures());
    }

    @Test
    public void test_parcelable_1_00001() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineFeatureAndroid result2 = FitnessMachineFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFitnessMachineFeatures(), result2.getFitnessMachineFeatures());
        assertArrayEquals(result1.getTargetSettingFeatures(), result2.getTargetSettingFeatures());
    }

    @Test
    public void test_parcelable_1_00002() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineFeatureAndroid result2 = FitnessMachineFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFitnessMachineFeatures(), result2.getFitnessMachineFeatures());
        assertArrayEquals(result1.getTargetSettingFeatures(), result2.getTargetSettingFeatures());
    }

    @Test
    public void test_parcelable_1_00101() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineFeatureAndroid result2 = FitnessMachineFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFitnessMachineFeatures(), result2.getFitnessMachineFeatures());
        assertArrayEquals(result1.getTargetSettingFeatures(), result2.getTargetSettingFeatures());
    }

    @Test
    public void test_parcelable_1_00102() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineFeatureAndroid result2 = FitnessMachineFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFitnessMachineFeatures(), result2.getFitnessMachineFeatures());
        assertArrayEquals(result1.getTargetSettingFeatures(), result2.getTargetSettingFeatures());
    }

    @Test
    public void test_parcelable_1_00201() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineFeatureAndroid result2 = FitnessMachineFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFitnessMachineFeatures(), result2.getFitnessMachineFeatures());
        assertArrayEquals(result1.getTargetSettingFeatures(), result2.getTargetSettingFeatures());
    }

    @Test
    public void test_parcelable_1_00202() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineFeatureAndroid result2 = FitnessMachineFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFitnessMachineFeatures(), result2.getFitnessMachineFeatures());
        assertArrayEquals(result1.getTargetSettingFeatures(), result2.getTargetSettingFeatures());
    }

    @Test
    public void test_parcelable_1_00301() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineFeatureAndroid result2 = FitnessMachineFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFitnessMachineFeatures(), result2.getFitnessMachineFeatures());
        assertArrayEquals(result1.getTargetSettingFeatures(), result2.getTargetSettingFeatures());
    }

    @Test
    public void test_parcelable_1_00302() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineFeatureAndroid result2 = FitnessMachineFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFitnessMachineFeatures(), result2.getFitnessMachineFeatures());
        assertArrayEquals(result1.getTargetSettingFeatures(), result2.getTargetSettingFeatures());
    }

    @Test
    public void test_parcelable_1_00401() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineFeatureAndroid result2 = FitnessMachineFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFitnessMachineFeatures(), result2.getFitnessMachineFeatures());
        assertArrayEquals(result1.getTargetSettingFeatures(), result2.getTargetSettingFeatures());
    }

    @Test
    public void test_parcelable_1_00402() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineFeatureAndroid result2 = FitnessMachineFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFitnessMachineFeatures(), result2.getFitnessMachineFeatures());
        assertArrayEquals(result1.getTargetSettingFeatures(), result2.getTargetSettingFeatures());
    }

    @Test
    public void test_parcelable_1_00501() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineFeatureAndroid result2 = FitnessMachineFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFitnessMachineFeatures(), result2.getFitnessMachineFeatures());
        assertArrayEquals(result1.getTargetSettingFeatures(), result2.getTargetSettingFeatures());
    }

    @Test
    public void test_parcelable_1_00502() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineFeatureAndroid result2 = FitnessMachineFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFitnessMachineFeatures(), result2.getFitnessMachineFeatures());
        assertArrayEquals(result1.getTargetSettingFeatures(), result2.getTargetSettingFeatures());
    }

    @Test
    public void test_parcelable_1_00601() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineFeatureAndroid result2 = FitnessMachineFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFitnessMachineFeatures(), result2.getFitnessMachineFeatures());
        assertArrayEquals(result1.getTargetSettingFeatures(), result2.getTargetSettingFeatures());
    }

    @Test
    public void test_parcelable_1_00602() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineFeatureAndroid result2 = FitnessMachineFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFitnessMachineFeatures(), result2.getFitnessMachineFeatures());
        assertArrayEquals(result1.getTargetSettingFeatures(), result2.getTargetSettingFeatures());
    }

    @Test
    public void test_parcelable_1_00701() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineFeatureAndroid result2 = FitnessMachineFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFitnessMachineFeatures(), result2.getFitnessMachineFeatures());
        assertArrayEquals(result1.getTargetSettingFeatures(), result2.getTargetSettingFeatures());
    }

    @Test
    public void test_parcelable_1_00702() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineFeatureAndroid result2 = FitnessMachineFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFitnessMachineFeatures(), result2.getFitnessMachineFeatures());
        assertArrayEquals(result1.getTargetSettingFeatures(), result2.getTargetSettingFeatures());
    }

    @Test
    public void test_parcelable_1_00801() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineFeatureAndroid result2 = FitnessMachineFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFitnessMachineFeatures(), result2.getFitnessMachineFeatures());
        assertArrayEquals(result1.getTargetSettingFeatures(), result2.getTargetSettingFeatures());
    }

    @Test
    public void test_parcelable_1_00802() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineFeatureAndroid result2 = FitnessMachineFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFitnessMachineFeatures(), result2.getFitnessMachineFeatures());
        assertArrayEquals(result1.getTargetSettingFeatures(), result2.getTargetSettingFeatures());
    }

    @Test
    public void test_parcelable_1_00901() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineFeatureAndroid result2 = FitnessMachineFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFitnessMachineFeatures(), result2.getFitnessMachineFeatures());
        assertArrayEquals(result1.getTargetSettingFeatures(), result2.getTargetSettingFeatures());
    }

    @Test
    public void test_parcelable_1_00902() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineFeatureAndroid result2 = FitnessMachineFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFitnessMachineFeatures(), result2.getFitnessMachineFeatures());
        assertArrayEquals(result1.getTargetSettingFeatures(), result2.getTargetSettingFeatures());
    }

    @Test
    public void test_parcelable_1_01001() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineFeatureAndroid result2 = FitnessMachineFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFitnessMachineFeatures(), result2.getFitnessMachineFeatures());
        assertArrayEquals(result1.getTargetSettingFeatures(), result2.getTargetSettingFeatures());
    }

    @Test
    public void test_parcelable_1_01002() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineFeatureAndroid result2 = FitnessMachineFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFitnessMachineFeatures(), result2.getFitnessMachineFeatures());
        assertArrayEquals(result1.getTargetSettingFeatures(), result2.getTargetSettingFeatures());
    }

    @Test
    public void test_parcelable_1_01101() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineFeatureAndroid result2 = FitnessMachineFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFitnessMachineFeatures(), result2.getFitnessMachineFeatures());
        assertArrayEquals(result1.getTargetSettingFeatures(), result2.getTargetSettingFeatures());
    }

    @Test
    public void test_parcelable_1_01102() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineFeatureAndroid result2 = FitnessMachineFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFitnessMachineFeatures(), result2.getFitnessMachineFeatures());
        assertArrayEquals(result1.getTargetSettingFeatures(), result2.getTargetSettingFeatures());
    }

    @Test
    public void test_parcelable_1_01201() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineFeatureAndroid result2 = FitnessMachineFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFitnessMachineFeatures(), result2.getFitnessMachineFeatures());
        assertArrayEquals(result1.getTargetSettingFeatures(), result2.getTargetSettingFeatures());
    }

    @Test
    public void test_parcelable_1_01202() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineFeatureAndroid result2 = FitnessMachineFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFitnessMachineFeatures(), result2.getFitnessMachineFeatures());
        assertArrayEquals(result1.getTargetSettingFeatures(), result2.getTargetSettingFeatures());
    }

    @Test
    public void test_parcelable_1_01301() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineFeatureAndroid result2 = FitnessMachineFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFitnessMachineFeatures(), result2.getFitnessMachineFeatures());
        assertArrayEquals(result1.getTargetSettingFeatures(), result2.getTargetSettingFeatures());
    }

    @Test
    public void test_parcelable_1_01302() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineFeatureAndroid result2 = FitnessMachineFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFitnessMachineFeatures(), result2.getFitnessMachineFeatures());
        assertArrayEquals(result1.getTargetSettingFeatures(), result2.getTargetSettingFeatures());
    }

    @Test
    public void test_parcelable_1_01401() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineFeatureAndroid result2 = FitnessMachineFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFitnessMachineFeatures(), result2.getFitnessMachineFeatures());
        assertArrayEquals(result1.getTargetSettingFeatures(), result2.getTargetSettingFeatures());
    }

    @Test
    public void test_parcelable_1_01402() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineFeatureAndroid result2 = FitnessMachineFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFitnessMachineFeatures(), result2.getFitnessMachineFeatures());
        assertArrayEquals(result1.getTargetSettingFeatures(), result2.getTargetSettingFeatures());
    }

    @Test
    public void test_parcelable_1_01501() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineFeatureAndroid result2 = FitnessMachineFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFitnessMachineFeatures(), result2.getFitnessMachineFeatures());
        assertArrayEquals(result1.getTargetSettingFeatures(), result2.getTargetSettingFeatures());
    }

    @Test
    public void test_parcelable_1_01502() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineFeatureAndroid result2 = FitnessMachineFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFitnessMachineFeatures(), result2.getFitnessMachineFeatures());
        assertArrayEquals(result1.getTargetSettingFeatures(), result2.getTargetSettingFeatures());
    }

    @Test
    public void test_parcelable_1_01601() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineFeatureAndroid result2 = FitnessMachineFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFitnessMachineFeatures(), result2.getFitnessMachineFeatures());
        assertArrayEquals(result1.getTargetSettingFeatures(), result2.getTargetSettingFeatures());
    }

    @Test
    public void test_parcelable_1_01602() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineFeatureAndroid result2 = FitnessMachineFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFitnessMachineFeatures(), result2.getFitnessMachineFeatures());
        assertArrayEquals(result1.getTargetSettingFeatures(), result2.getTargetSettingFeatures());
    }

    @Test
    public void test_parcelable_1_10001() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineFeatureAndroid result2 = FitnessMachineFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFitnessMachineFeatures(), result2.getFitnessMachineFeatures());
        assertArrayEquals(result1.getTargetSettingFeatures(), result2.getTargetSettingFeatures());
    }

    @Test
    public void test_parcelable_1_10002() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineFeatureAndroid result2 = FitnessMachineFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFitnessMachineFeatures(), result2.getFitnessMachineFeatures());
        assertArrayEquals(result1.getTargetSettingFeatures(), result2.getTargetSettingFeatures());
    }

    @Test
    public void test_parcelable_1_10101() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineFeatureAndroid result2 = FitnessMachineFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFitnessMachineFeatures(), result2.getFitnessMachineFeatures());
        assertArrayEquals(result1.getTargetSettingFeatures(), result2.getTargetSettingFeatures());
    }

    @Test
    public void test_parcelable_1_10102() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineFeatureAndroid result2 = FitnessMachineFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFitnessMachineFeatures(), result2.getFitnessMachineFeatures());
        assertArrayEquals(result1.getTargetSettingFeatures(), result2.getTargetSettingFeatures());
    }

    @Test
    public void test_parcelable_1_10201() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineFeatureAndroid result2 = FitnessMachineFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFitnessMachineFeatures(), result2.getFitnessMachineFeatures());
        assertArrayEquals(result1.getTargetSettingFeatures(), result2.getTargetSettingFeatures());
    }

    @Test
    public void test_parcelable_1_10202() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineFeatureAndroid result2 = FitnessMachineFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFitnessMachineFeatures(), result2.getFitnessMachineFeatures());
        assertArrayEquals(result1.getTargetSettingFeatures(), result2.getTargetSettingFeatures());
    }

    @Test
    public void test_parcelable_1_10301() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineFeatureAndroid result2 = FitnessMachineFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFitnessMachineFeatures(), result2.getFitnessMachineFeatures());
        assertArrayEquals(result1.getTargetSettingFeatures(), result2.getTargetSettingFeatures());
    }

    @Test
    public void test_parcelable_1_10302() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineFeatureAndroid result2 = FitnessMachineFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFitnessMachineFeatures(), result2.getFitnessMachineFeatures());
        assertArrayEquals(result1.getTargetSettingFeatures(), result2.getTargetSettingFeatures());
    }

    @Test
    public void test_parcelable_1_10401() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineFeatureAndroid result2 = FitnessMachineFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFitnessMachineFeatures(), result2.getFitnessMachineFeatures());
        assertArrayEquals(result1.getTargetSettingFeatures(), result2.getTargetSettingFeatures());
    }

    @Test
    public void test_parcelable_1_10402() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineFeatureAndroid result2 = FitnessMachineFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFitnessMachineFeatures(), result2.getFitnessMachineFeatures());
        assertArrayEquals(result1.getTargetSettingFeatures(), result2.getTargetSettingFeatures());
    }

    @Test
    public void test_parcelable_1_10501() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineFeatureAndroid result2 = FitnessMachineFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFitnessMachineFeatures(), result2.getFitnessMachineFeatures());
        assertArrayEquals(result1.getTargetSettingFeatures(), result2.getTargetSettingFeatures());
    }

    @Test
    public void test_parcelable_1_10502() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineFeatureAndroid result2 = FitnessMachineFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFitnessMachineFeatures(), result2.getFitnessMachineFeatures());
        assertArrayEquals(result1.getTargetSettingFeatures(), result2.getTargetSettingFeatures());
    }

    @Test
    public void test_parcelable_1_10601() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineFeatureAndroid result2 = FitnessMachineFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFitnessMachineFeatures(), result2.getFitnessMachineFeatures());
        assertArrayEquals(result1.getTargetSettingFeatures(), result2.getTargetSettingFeatures());
    }

    @Test
    public void test_parcelable_1_10602() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineFeatureAndroid result2 = FitnessMachineFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFitnessMachineFeatures(), result2.getFitnessMachineFeatures());
        assertArrayEquals(result1.getTargetSettingFeatures(), result2.getTargetSettingFeatures());
    }

    @Test
    public void test_parcelable_1_10701() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineFeatureAndroid result2 = FitnessMachineFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFitnessMachineFeatures(), result2.getFitnessMachineFeatures());
        assertArrayEquals(result1.getTargetSettingFeatures(), result2.getTargetSettingFeatures());
    }

    @Test
    public void test_parcelable_1_10702() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineFeatureAndroid result2 = FitnessMachineFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFitnessMachineFeatures(), result2.getFitnessMachineFeatures());
        assertArrayEquals(result1.getTargetSettingFeatures(), result2.getTargetSettingFeatures());
    }

    @Test
    public void test_parcelable_1_10801() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineFeatureAndroid result2 = FitnessMachineFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFitnessMachineFeatures(), result2.getFitnessMachineFeatures());
        assertArrayEquals(result1.getTargetSettingFeatures(), result2.getTargetSettingFeatures());
    }

    @Test
    public void test_parcelable_1_10802() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineFeatureAndroid result2 = FitnessMachineFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFitnessMachineFeatures(), result2.getFitnessMachineFeatures());
        assertArrayEquals(result1.getTargetSettingFeatures(), result2.getTargetSettingFeatures());
    }

    @Test
    public void test_parcelable_1_10901() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineFeatureAndroid result2 = FitnessMachineFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFitnessMachineFeatures(), result2.getFitnessMachineFeatures());
        assertArrayEquals(result1.getTargetSettingFeatures(), result2.getTargetSettingFeatures());
    }

    @Test
    public void test_parcelable_1_10902() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineFeatureAndroid result2 = FitnessMachineFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFitnessMachineFeatures(), result2.getFitnessMachineFeatures());
        assertArrayEquals(result1.getTargetSettingFeatures(), result2.getTargetSettingFeatures());
    }

    @Test
    public void test_parcelable_1_11001() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineFeatureAndroid result2 = FitnessMachineFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFitnessMachineFeatures(), result2.getFitnessMachineFeatures());
        assertArrayEquals(result1.getTargetSettingFeatures(), result2.getTargetSettingFeatures());
    }

    @Test
    public void test_parcelable_1_11002() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineFeatureAndroid result2 = FitnessMachineFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFitnessMachineFeatures(), result2.getFitnessMachineFeatures());
        assertArrayEquals(result1.getTargetSettingFeatures(), result2.getTargetSettingFeatures());
    }

    @Test
    public void test_parcelable_1_11101() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineFeatureAndroid result2 = FitnessMachineFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFitnessMachineFeatures(), result2.getFitnessMachineFeatures());
        assertArrayEquals(result1.getTargetSettingFeatures(), result2.getTargetSettingFeatures());
    }

    @Test
    public void test_parcelable_1_11102() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineFeatureAndroid result2 = FitnessMachineFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFitnessMachineFeatures(), result2.getFitnessMachineFeatures());
        assertArrayEquals(result1.getTargetSettingFeatures(), result2.getTargetSettingFeatures());
    }

    @Test
    public void test_parcelable_1_11201() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineFeatureAndroid result2 = FitnessMachineFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFitnessMachineFeatures(), result2.getFitnessMachineFeatures());
        assertArrayEquals(result1.getTargetSettingFeatures(), result2.getTargetSettingFeatures());
    }

    @Test
    public void test_parcelable_1_11202() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineFeatureAndroid result2 = FitnessMachineFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFitnessMachineFeatures(), result2.getFitnessMachineFeatures());
        assertArrayEquals(result1.getTargetSettingFeatures(), result2.getTargetSettingFeatures());
    }

    @Test
    public void test_parcelable_1_11301() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineFeatureAndroid result2 = FitnessMachineFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFitnessMachineFeatures(), result2.getFitnessMachineFeatures());
        assertArrayEquals(result1.getTargetSettingFeatures(), result2.getTargetSettingFeatures());
    }

    @Test
    public void test_parcelable_1_11302() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineFeatureAndroid result2 = FitnessMachineFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFitnessMachineFeatures(), result2.getFitnessMachineFeatures());
        assertArrayEquals(result1.getTargetSettingFeatures(), result2.getTargetSettingFeatures());
    }

    @Test
    public void test_parcelable_1_11401() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineFeatureAndroid result2 = FitnessMachineFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFitnessMachineFeatures(), result2.getFitnessMachineFeatures());
        assertArrayEquals(result1.getTargetSettingFeatures(), result2.getTargetSettingFeatures());
    }

    @Test
    public void test_parcelable_1_11402() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineFeatureAndroid result2 = FitnessMachineFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFitnessMachineFeatures(), result2.getFitnessMachineFeatures());
        assertArrayEquals(result1.getTargetSettingFeatures(), result2.getTargetSettingFeatures());
    }

    @Test
    public void test_parcelable_1_11501() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineFeatureAndroid result2 = FitnessMachineFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFitnessMachineFeatures(), result2.getFitnessMachineFeatures());
        assertArrayEquals(result1.getTargetSettingFeatures(), result2.getTargetSettingFeatures());
    }

    @Test
    public void test_parcelable_1_11502() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineFeatureAndroid result2 = FitnessMachineFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFitnessMachineFeatures(), result2.getFitnessMachineFeatures());
        assertArrayEquals(result1.getTargetSettingFeatures(), result2.getTargetSettingFeatures());
    }

    @Test
    public void test_parcelable_1_11601() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineFeatureAndroid result2 = FitnessMachineFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFitnessMachineFeatures(), result2.getFitnessMachineFeatures());
        assertArrayEquals(result1.getTargetSettingFeatures(), result2.getTargetSettingFeatures());
    }

    @Test
    public void test_parcelable_1_11602() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineFeatureAndroid result2 = FitnessMachineFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFitnessMachineFeatures(), result2.getFitnessMachineFeatures());
        assertArrayEquals(result1.getTargetSettingFeatures(), result2.getTargetSettingFeatures());
    }

    @Test
    public void test_parcelable_2_00001() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00002() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00101() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00102() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00201() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00202() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00301() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00302() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00401() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00402() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00501() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00502() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00601() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00602() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00701() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00702() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00801() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00802() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00901() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00902() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01001() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01002() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01101() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01102() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01201() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01202() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01301() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01302() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01401() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01402() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01501() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01502() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01601() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01602() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_10001() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_10002() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_10101() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_10102() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_10201() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_10202() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_10301() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_10302() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_10401() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_10402() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_10501() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_10502() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_10601() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_10602() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_10701() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_10702() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_10801() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_10802() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_10901() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_10902() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_11001() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_11002() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_11101() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_11102() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_11201() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_11202() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_11301() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_11302() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_11401() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_11402() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_11501() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_11502() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_11601() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_11602() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_3_00001() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        FitnessMachineFeatureAndroid result2 = FitnessMachineFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00002() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        FitnessMachineFeatureAndroid result2 = FitnessMachineFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00101() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        FitnessMachineFeatureAndroid result2 = FitnessMachineFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00102() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        FitnessMachineFeatureAndroid result2 = FitnessMachineFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00201() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        FitnessMachineFeatureAndroid result2 = FitnessMachineFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00202() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        FitnessMachineFeatureAndroid result2 = FitnessMachineFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00301() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        FitnessMachineFeatureAndroid result2 = FitnessMachineFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00302() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        FitnessMachineFeatureAndroid result2 = FitnessMachineFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00401() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        FitnessMachineFeatureAndroid result2 = FitnessMachineFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00402() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        FitnessMachineFeatureAndroid result2 = FitnessMachineFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00501() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        FitnessMachineFeatureAndroid result2 = FitnessMachineFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00502() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        FitnessMachineFeatureAndroid result2 = FitnessMachineFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00601() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        FitnessMachineFeatureAndroid result2 = FitnessMachineFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00602() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        FitnessMachineFeatureAndroid result2 = FitnessMachineFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00701() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        FitnessMachineFeatureAndroid result2 = FitnessMachineFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00702() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        FitnessMachineFeatureAndroid result2 = FitnessMachineFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00801() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        FitnessMachineFeatureAndroid result2 = FitnessMachineFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00802() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        FitnessMachineFeatureAndroid result2 = FitnessMachineFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00901() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        FitnessMachineFeatureAndroid result2 = FitnessMachineFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00902() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        FitnessMachineFeatureAndroid result2 = FitnessMachineFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01001() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        FitnessMachineFeatureAndroid result2 = FitnessMachineFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01002() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        FitnessMachineFeatureAndroid result2 = FitnessMachineFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01101() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        FitnessMachineFeatureAndroid result2 = FitnessMachineFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01102() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        FitnessMachineFeatureAndroid result2 = FitnessMachineFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01201() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        FitnessMachineFeatureAndroid result2 = FitnessMachineFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01202() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        FitnessMachineFeatureAndroid result2 = FitnessMachineFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01301() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        FitnessMachineFeatureAndroid result2 = FitnessMachineFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01302() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        FitnessMachineFeatureAndroid result2 = FitnessMachineFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01401() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        FitnessMachineFeatureAndroid result2 = FitnessMachineFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01402() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        FitnessMachineFeatureAndroid result2 = FitnessMachineFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01501() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        FitnessMachineFeatureAndroid result2 = FitnessMachineFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01502() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        FitnessMachineFeatureAndroid result2 = FitnessMachineFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01601() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        FitnessMachineFeatureAndroid result2 = FitnessMachineFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01602() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        FitnessMachineFeatureAndroid result2 = FitnessMachineFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_10001() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        FitnessMachineFeatureAndroid result2 = FitnessMachineFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_10002() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        FitnessMachineFeatureAndroid result2 = FitnessMachineFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_10101() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        FitnessMachineFeatureAndroid result2 = FitnessMachineFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_10102() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        FitnessMachineFeatureAndroid result2 = FitnessMachineFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_10201() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        FitnessMachineFeatureAndroid result2 = FitnessMachineFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_10202() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        FitnessMachineFeatureAndroid result2 = FitnessMachineFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_10301() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        FitnessMachineFeatureAndroid result2 = FitnessMachineFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_10302() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        FitnessMachineFeatureAndroid result2 = FitnessMachineFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_10401() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        FitnessMachineFeatureAndroid result2 = FitnessMachineFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_10402() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        FitnessMachineFeatureAndroid result2 = FitnessMachineFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_10501() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        FitnessMachineFeatureAndroid result2 = FitnessMachineFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_10502() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        FitnessMachineFeatureAndroid result2 = FitnessMachineFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_10601() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        FitnessMachineFeatureAndroid result2 = FitnessMachineFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_10602() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        FitnessMachineFeatureAndroid result2 = FitnessMachineFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_10701() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        FitnessMachineFeatureAndroid result2 = FitnessMachineFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_10702() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        FitnessMachineFeatureAndroid result2 = FitnessMachineFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_10801() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        FitnessMachineFeatureAndroid result2 = FitnessMachineFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_10802() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        FitnessMachineFeatureAndroid result2 = FitnessMachineFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_10901() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        FitnessMachineFeatureAndroid result2 = FitnessMachineFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_10902() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        FitnessMachineFeatureAndroid result2 = FitnessMachineFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_11001() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        FitnessMachineFeatureAndroid result2 = FitnessMachineFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_11002() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        FitnessMachineFeatureAndroid result2 = FitnessMachineFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_11101() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        FitnessMachineFeatureAndroid result2 = FitnessMachineFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_11102() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        FitnessMachineFeatureAndroid result2 = FitnessMachineFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_11201() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        FitnessMachineFeatureAndroid result2 = FitnessMachineFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_11202() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        FitnessMachineFeatureAndroid result2 = FitnessMachineFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_11301() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        FitnessMachineFeatureAndroid result2 = FitnessMachineFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_11302() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        FitnessMachineFeatureAndroid result2 = FitnessMachineFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_11401() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        FitnessMachineFeatureAndroid result2 = FitnessMachineFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_11402() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        FitnessMachineFeatureAndroid result2 = FitnessMachineFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_11501() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        FitnessMachineFeatureAndroid result2 = FitnessMachineFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_11502() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        FitnessMachineFeatureAndroid result2 = FitnessMachineFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_11601() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        FitnessMachineFeatureAndroid result2 = FitnessMachineFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_11602() {
        byte[] data = getData();

        FitnessMachineFeatureAndroid result1 = new FitnessMachineFeatureAndroid(data);
        FitnessMachineFeatureAndroid result2 = FitnessMachineFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
