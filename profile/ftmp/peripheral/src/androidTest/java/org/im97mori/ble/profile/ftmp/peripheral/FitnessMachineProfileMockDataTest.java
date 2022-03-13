package org.im97mori.ble.profile.ftmp.peripheral;

import static org.im97mori.ble.constants.CharacteristicUUID.AEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.AEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.AEROBIC_THRESHOLD_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.AGE_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.ANAEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.ANAEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.ANAEROBIC_THRESHOLD_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.CROSS_TRAINER_DATA_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.DATABASE_CHANGE_INCREMENT_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.DATE_OF_BIRTH_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.DATE_OF_THRESHOLD_ASSESSMENT_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.EMAIL_ADDRESS_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.FAT_BURN_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.FAT_BURN_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.FIRST_NAME_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.FITNESS_MACHINE_FEATURE_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.FIVE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.GENDER_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.HEART_RATE_MAX_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.HEIGHT_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.HIP_CIRCUMFERENCE_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.INDOOR_BIKE_DATA_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.LANGUAGE_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.LAST_NAME_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.MAXIMUM_RECOMMENDED_HEART_RATE_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.REGISTERED_USER_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.RESTING_HEART_RATE_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.ROWER_DATA_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.SPORT_TYPE_FOR_AEROBIC_AND_ANAEROBIC_THRESHOLDS_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.STAIR_CLIMBER_DATA_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.STEP_CLIMBER_DATA_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.SUPPORTED_POWER_RANGE_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.SUPPORTED_SPEED_RANGE_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.THREE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.TRAINING_STATUS_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.TREADMILL_DATA_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.TWO_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.USER_INDEX_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.VO2_MAX_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.WAIST_CIRCUMFERENCE_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.WEIGHT_CHARACTERISTIC;
import static org.im97mori.ble.constants.ServiceUUID.DEVICE_INFORMATION_SERVICE;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import android.bluetooth.BluetoothGattService;
import android.os.Parcel;

import com.google.gson.Gson;

import org.im97mori.ble.CharacteristicData;
import org.im97mori.ble.ServiceData;
import org.im97mori.ble.service.ftms.peripheral.FitnessMachineControlPointCharacteristicData;
import org.im97mori.ble.service.ftms.peripheral.FitnessMachineServiceData;
import org.im97mori.ble.service.ftms.peripheral.FitnessMachineStatusCharacteristicData;
import org.im97mori.ble.service.uds.peripheral.UDSCharacteristicData;
import org.im97mori.ble.service.uds.peripheral.UserControlPointCharacteristicData;
import org.im97mori.ble.service.uds.peripheral.UserDataServiceData;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class FitnessMachineProfileMockDataTest {

    @Test
    public void test_constructor_00001() {
        CharacteristicData fitnessMachineFeature = new CharacteristicData(FITNESS_MACHINE_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData treadmillData = new CharacteristicData(TREADMILL_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData crossTrainerData = new CharacteristicData(CROSS_TRAINER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stepClimberData = new CharacteristicData(STEP_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stairClimberData = new CharacteristicData(STAIR_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData rowerData = new CharacteristicData(ROWER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData indoorBikeData = new CharacteristicData(INDOOR_BIKE_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData trainingStatus = new CharacteristicData(TRAINING_STATUS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedSpeedRange = new CharacteristicData(SUPPORTED_SPEED_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedInclinationRange = new CharacteristicData(SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedResistanceLevelRange = new CharacteristicData(SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedPowerRange = new CharacteristicData(SUPPORTED_POWER_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedHeartRateRange = new CharacteristicData(SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        FitnessMachineControlPointCharacteristicData fitnessMachineControlPoint = new FitnessMachineControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , 9
                , 10
                , 11
                , 12
                , 13
                , 14
                , 15
                , 16
                , 17
                , 18
                , 19
                , 20
                , 21
                , new byte[]{22}
                , 23);
        FitnessMachineStatusCharacteristicData fitnessMachineStatus = new FitnessMachineStatusCharacteristicData(new ArrayList<>()
                , 1);

        FitnessMachineServiceData fitnessMachine = new FitnessMachineServiceData(fitnessMachineFeature
                , treadmillData
                , crossTrainerData
                , stepClimberData
                , stairClimberData
                , rowerData
                , indoorBikeData
                , trainingStatus
                , supportedSpeedRange
                , supportedInclinationRange
                , supportedResistanceLevelRange
                , supportedPowerRange
                , supportedHeartRateRange
                , fitnessMachineControlPoint
                , fitnessMachineStatus);

        UDSCharacteristicData firstName = new UDSCharacteristicData(FIRST_NAME_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData lastName = new UDSCharacteristicData(LAST_NAME_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData emailAddress = new UDSCharacteristicData(EMAIL_ADDRESS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData age = new UDSCharacteristicData(AGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData dateOfBirth = new UDSCharacteristicData(DATE_OF_BIRTH_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData gender = new UDSCharacteristicData(GENDER_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData weight = new UDSCharacteristicData(WEIGHT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData height = new UDSCharacteristicData(HEIGHT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData vo2Max = new UDSCharacteristicData(VO2_MAX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData heartRateMax = new UDSCharacteristicData(HEART_RATE_MAX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData restingHeartRate = new UDSCharacteristicData(RESTING_HEART_RATE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData maximumRecommendedHeartRate = new UDSCharacteristicData(MAXIMUM_RECOMMENDED_HEART_RATE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData aerobicThreshold = new UDSCharacteristicData(AEROBIC_THRESHOLD_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData anaerobicThreshold = new UDSCharacteristicData(ANAEROBIC_THRESHOLD_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData sportTypeForAerobicAndAnaerobicThresholds = new UDSCharacteristicData(SPORT_TYPE_FOR_AEROBIC_AND_ANAEROBIC_THRESHOLDS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData dateOfThresholdAssessment = new UDSCharacteristicData(DATE_OF_THRESHOLD_ASSESSMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData waistCircumference = new UDSCharacteristicData(WAIST_CIRCUMFERENCE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData hipCircumference = new UDSCharacteristicData(HIP_CIRCUMFERENCE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData fatBurnHeartRateLowerLimit = new UDSCharacteristicData(FAT_BURN_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData fatBurnHeartRateUpperLimit = new UDSCharacteristicData(FAT_BURN_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData aerobicHeartRateLowerLimit = new UDSCharacteristicData(AEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData aerobicHeartRateUpperLimit = new UDSCharacteristicData(AEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData anaerobicHeartRateLowerLimit = new UDSCharacteristicData(ANAEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData anaerobicHeartRateUpperLimit = new UDSCharacteristicData(ANAEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData fiveZoneHeartRateLimits = new UDSCharacteristicData(FIVE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData threeZoneHeartRateLimits = new UDSCharacteristicData(THREE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData twoZoneHeartRateLimit = new UDSCharacteristicData(TWO_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData language = new UDSCharacteristicData(LANGUAGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData databaseChangeIncrement = new CharacteristicData(DATABASE_CHANGE_INCREMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData userIndex = new CharacteristicData(USER_INDEX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UserControlPointCharacteristicData userControlPoint = new UserControlPointCharacteristicData(1
                , 2
                , new ArrayList<>()
                , 3
                , 5
                , 6
                , 7
                , 8
                , 9);
        CharacteristicData registeredUser = new CharacteristicData(REGISTERED_USER_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);

        UserDataServiceData userData = new UserDataServiceData(firstName
                , lastName
                , emailAddress
                , age
                , dateOfBirth
                , gender
                , weight
                , height
                , vo2Max
                , heartRateMax
                , restingHeartRate
                , maximumRecommendedHeartRate
                , aerobicThreshold
                , anaerobicThreshold
                , sportTypeForAerobicAndAnaerobicThresholds
                , dateOfThresholdAssessment
                , waistCircumference
                , hipCircumference
                , fatBurnHeartRateLowerLimit
                , fatBurnHeartRateUpperLimit
                , aerobicHeartRateLowerLimit
                , aerobicHeartRateUpperLimit
                , anaerobicHeartRateLowerLimit
                , anaerobicHeartRateUpperLimit
                , fiveZoneHeartRateLimits
                , threeZoneHeartRateLimits
                , twoZoneHeartRateLimit
                , language
                , databaseChangeIncrement
                , userIndex
                , userControlPoint
                , registeredUser);

        ServiceData deviceInformation = new ServiceData(DEVICE_INFORMATION_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList());

        FitnessMachineProfileMockData result1 = new FitnessMachineProfileMockData(fitnessMachine, userData, deviceInformation);

        Gson gson = new Gson();
        FitnessMachineProfileMockData result2 = gson.fromJson(gson.toJson(result1), FitnessMachineProfileMockData.class);

        assertNotNull(result2.serviceDataList);
        assertEquals(result1.serviceDataList.size(), result2.serviceDataList.size());
        assertArrayEquals(result1.serviceDataList.toArray(), result2.serviceDataList.toArray());
        assertEquals(result1.fitnessMachine, result2.fitnessMachine);
        assertEquals(result1.userData, result2.userData);
        assertEquals(result1.deviceInformation, result2.deviceInformation);
    }

    @Test
    public void test_constructor_00002() {
        CharacteristicData fitnessMachineFeature = new CharacteristicData(FITNESS_MACHINE_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData treadmillData = new CharacteristicData(TREADMILL_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData crossTrainerData = new CharacteristicData(CROSS_TRAINER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stepClimberData = new CharacteristicData(STEP_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stairClimberData = new CharacteristicData(STAIR_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData rowerData = new CharacteristicData(ROWER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData indoorBikeData = new CharacteristicData(INDOOR_BIKE_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData trainingStatus = new CharacteristicData(TRAINING_STATUS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedSpeedRange = new CharacteristicData(SUPPORTED_SPEED_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedInclinationRange = new CharacteristicData(SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedResistanceLevelRange = new CharacteristicData(SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedPowerRange = new CharacteristicData(SUPPORTED_POWER_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedHeartRateRange = new CharacteristicData(SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        FitnessMachineControlPointCharacteristicData fitnessMachineControlPoint = new FitnessMachineControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , 9
                , 10
                , 11
                , 12
                , 13
                , 14
                , 15
                , 16
                , 17
                , 18
                , 19
                , 20
                , 21
                , new byte[]{22}
                , 23);
        FitnessMachineStatusCharacteristicData fitnessMachineStatus = new FitnessMachineStatusCharacteristicData(new ArrayList<>()
                , 1);

        FitnessMachineServiceData fitnessMachine = new FitnessMachineServiceData(fitnessMachineFeature
                , treadmillData
                , crossTrainerData
                , stepClimberData
                , stairClimberData
                , rowerData
                , indoorBikeData
                , trainingStatus
                , supportedSpeedRange
                , supportedInclinationRange
                , supportedResistanceLevelRange
                , supportedPowerRange
                , supportedHeartRateRange
                , fitnessMachineControlPoint
                , fitnessMachineStatus);

        ServiceData deviceInformation = new ServiceData(DEVICE_INFORMATION_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList());

        FitnessMachineProfileMockData result1 = new FitnessMachineProfileMockData(fitnessMachine, null, deviceInformation);

        Gson gson = new Gson();
        FitnessMachineProfileMockData result2 = gson.fromJson(gson.toJson(result1), FitnessMachineProfileMockData.class);

        assertNotNull(result2.serviceDataList);
        assertEquals(result1.serviceDataList.size(), result2.serviceDataList.size());
        assertArrayEquals(result1.serviceDataList.toArray(), result2.serviceDataList.toArray());
        assertEquals(result1.fitnessMachine, result2.fitnessMachine);
        assertEquals(result1.userData, result2.userData);
        assertEquals(result1.deviceInformation, result2.deviceInformation);
    }

    @Test
    public void test_constructor_00003() {
        CharacteristicData fitnessMachineFeature = new CharacteristicData(FITNESS_MACHINE_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData treadmillData = new CharacteristicData(TREADMILL_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData crossTrainerData = new CharacteristicData(CROSS_TRAINER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stepClimberData = new CharacteristicData(STEP_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stairClimberData = new CharacteristicData(STAIR_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData rowerData = new CharacteristicData(ROWER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData indoorBikeData = new CharacteristicData(INDOOR_BIKE_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData trainingStatus = new CharacteristicData(TRAINING_STATUS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedSpeedRange = new CharacteristicData(SUPPORTED_SPEED_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedInclinationRange = new CharacteristicData(SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedResistanceLevelRange = new CharacteristicData(SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedPowerRange = new CharacteristicData(SUPPORTED_POWER_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedHeartRateRange = new CharacteristicData(SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        FitnessMachineControlPointCharacteristicData fitnessMachineControlPoint = new FitnessMachineControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , 9
                , 10
                , 11
                , 12
                , 13
                , 14
                , 15
                , 16
                , 17
                , 18
                , 19
                , 20
                , 21
                , new byte[]{22}
                , 23);
        FitnessMachineStatusCharacteristicData fitnessMachineStatus = new FitnessMachineStatusCharacteristicData(new ArrayList<>()
                , 1);

        FitnessMachineServiceData fitnessMachine = new FitnessMachineServiceData(fitnessMachineFeature
                , treadmillData
                , crossTrainerData
                , stepClimberData
                , stairClimberData
                , rowerData
                , indoorBikeData
                , trainingStatus
                , supportedSpeedRange
                , supportedInclinationRange
                , supportedResistanceLevelRange
                , supportedPowerRange
                , supportedHeartRateRange
                , fitnessMachineControlPoint
                , fitnessMachineStatus);

        UDSCharacteristicData firstName = new UDSCharacteristicData(FIRST_NAME_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData lastName = new UDSCharacteristicData(LAST_NAME_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData emailAddress = new UDSCharacteristicData(EMAIL_ADDRESS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData age = new UDSCharacteristicData(AGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData dateOfBirth = new UDSCharacteristicData(DATE_OF_BIRTH_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData gender = new UDSCharacteristicData(GENDER_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData weight = new UDSCharacteristicData(WEIGHT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData height = new UDSCharacteristicData(HEIGHT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData vo2Max = new UDSCharacteristicData(VO2_MAX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData heartRateMax = new UDSCharacteristicData(HEART_RATE_MAX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData restingHeartRate = new UDSCharacteristicData(RESTING_HEART_RATE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData maximumRecommendedHeartRate = new UDSCharacteristicData(MAXIMUM_RECOMMENDED_HEART_RATE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData aerobicThreshold = new UDSCharacteristicData(AEROBIC_THRESHOLD_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData anaerobicThreshold = new UDSCharacteristicData(ANAEROBIC_THRESHOLD_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData sportTypeForAerobicAndAnaerobicThresholds = new UDSCharacteristicData(SPORT_TYPE_FOR_AEROBIC_AND_ANAEROBIC_THRESHOLDS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData dateOfThresholdAssessment = new UDSCharacteristicData(DATE_OF_THRESHOLD_ASSESSMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData waistCircumference = new UDSCharacteristicData(WAIST_CIRCUMFERENCE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData hipCircumference = new UDSCharacteristicData(HIP_CIRCUMFERENCE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData fatBurnHeartRateLowerLimit = new UDSCharacteristicData(FAT_BURN_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData fatBurnHeartRateUpperLimit = new UDSCharacteristicData(FAT_BURN_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData aerobicHeartRateLowerLimit = new UDSCharacteristicData(AEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData aerobicHeartRateUpperLimit = new UDSCharacteristicData(AEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData anaerobicHeartRateLowerLimit = new UDSCharacteristicData(ANAEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData anaerobicHeartRateUpperLimit = new UDSCharacteristicData(ANAEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData fiveZoneHeartRateLimits = new UDSCharacteristicData(FIVE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData threeZoneHeartRateLimits = new UDSCharacteristicData(THREE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData twoZoneHeartRateLimit = new UDSCharacteristicData(TWO_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData language = new UDSCharacteristicData(LANGUAGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData databaseChangeIncrement = new CharacteristicData(DATABASE_CHANGE_INCREMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData userIndex = new CharacteristicData(USER_INDEX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UserControlPointCharacteristicData userControlPoint = new UserControlPointCharacteristicData(1
                , 2
                , new ArrayList<>()
                , 3
                , 5
                , 6
                , 7
                , 8
                , 9);
        CharacteristicData registeredUser = new CharacteristicData(REGISTERED_USER_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);

        UserDataServiceData userData = new UserDataServiceData(firstName
                , lastName
                , emailAddress
                , age
                , dateOfBirth
                , gender
                , weight
                , height
                , vo2Max
                , heartRateMax
                , restingHeartRate
                , maximumRecommendedHeartRate
                , aerobicThreshold
                , anaerobicThreshold
                , sportTypeForAerobicAndAnaerobicThresholds
                , dateOfThresholdAssessment
                , waistCircumference
                , hipCircumference
                , fatBurnHeartRateLowerLimit
                , fatBurnHeartRateUpperLimit
                , aerobicHeartRateLowerLimit
                , aerobicHeartRateUpperLimit
                , anaerobicHeartRateLowerLimit
                , anaerobicHeartRateUpperLimit
                , fiveZoneHeartRateLimits
                , threeZoneHeartRateLimits
                , twoZoneHeartRateLimit
                , language
                , databaseChangeIncrement
                , userIndex
                , userControlPoint
                , registeredUser);

        FitnessMachineProfileMockData result1 = new FitnessMachineProfileMockData(fitnessMachine, userData, null);

        Gson gson = new Gson();
        FitnessMachineProfileMockData result2 = gson.fromJson(gson.toJson(result1), FitnessMachineProfileMockData.class);

        assertNotNull(result2.serviceDataList);
        assertEquals(result1.serviceDataList.size(), result2.serviceDataList.size());
        assertArrayEquals(result1.serviceDataList.toArray(), result2.serviceDataList.toArray());
        assertEquals(result1.fitnessMachine, result2.fitnessMachine);
        assertEquals(result1.userData, result2.userData);
        assertEquals(result1.deviceInformation, result2.deviceInformation);
    }

    @Test
    public void test_constructor_00101() {
        FitnessMachineProfileMockData result1 = new FitnessMachineProfileMockData();

        assertNull(result1.fitnessMachine);
        assertNull(result1.userData);
        assertNull(result1.deviceInformation);
    }

    @Test
    public void test_getServiceDataList_00001() {
        CharacteristicData fitnessMachineFeature = new CharacteristicData(FITNESS_MACHINE_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData treadmillData = new CharacteristicData(TREADMILL_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData crossTrainerData = new CharacteristicData(CROSS_TRAINER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stepClimberData = new CharacteristicData(STEP_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stairClimberData = new CharacteristicData(STAIR_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData rowerData = new CharacteristicData(ROWER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData indoorBikeData = new CharacteristicData(INDOOR_BIKE_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData trainingStatus = new CharacteristicData(TRAINING_STATUS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedSpeedRange = new CharacteristicData(SUPPORTED_SPEED_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedInclinationRange = new CharacteristicData(SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedResistanceLevelRange = new CharacteristicData(SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedPowerRange = new CharacteristicData(SUPPORTED_POWER_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedHeartRateRange = new CharacteristicData(SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        FitnessMachineControlPointCharacteristicData fitnessMachineControlPoint = new FitnessMachineControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , 9
                , 10
                , 11
                , 12
                , 13
                , 14
                , 15
                , 16
                , 17
                , 18
                , 19
                , 20
                , 21
                , new byte[]{22}
                , 23);
        FitnessMachineStatusCharacteristicData fitnessMachineStatus = new FitnessMachineStatusCharacteristicData(new ArrayList<>()
                , 1);

        FitnessMachineServiceData fitnessMachine = new FitnessMachineServiceData(fitnessMachineFeature
                , treadmillData
                , crossTrainerData
                , stepClimberData
                , stairClimberData
                , rowerData
                , indoorBikeData
                , trainingStatus
                , supportedSpeedRange
                , supportedInclinationRange
                , supportedResistanceLevelRange
                , supportedPowerRange
                , supportedHeartRateRange
                , fitnessMachineControlPoint
                , fitnessMachineStatus);

        UDSCharacteristicData firstName = new UDSCharacteristicData(FIRST_NAME_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData lastName = new UDSCharacteristicData(LAST_NAME_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData emailAddress = new UDSCharacteristicData(EMAIL_ADDRESS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData age = new UDSCharacteristicData(AGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData dateOfBirth = new UDSCharacteristicData(DATE_OF_BIRTH_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData gender = new UDSCharacteristicData(GENDER_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData weight = new UDSCharacteristicData(WEIGHT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData height = new UDSCharacteristicData(HEIGHT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData vo2Max = new UDSCharacteristicData(VO2_MAX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData heartRateMax = new UDSCharacteristicData(HEART_RATE_MAX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData restingHeartRate = new UDSCharacteristicData(RESTING_HEART_RATE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData maximumRecommendedHeartRate = new UDSCharacteristicData(MAXIMUM_RECOMMENDED_HEART_RATE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData aerobicThreshold = new UDSCharacteristicData(AEROBIC_THRESHOLD_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData anaerobicThreshold = new UDSCharacteristicData(ANAEROBIC_THRESHOLD_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData sportTypeForAerobicAndAnaerobicThresholds = new UDSCharacteristicData(SPORT_TYPE_FOR_AEROBIC_AND_ANAEROBIC_THRESHOLDS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData dateOfThresholdAssessment = new UDSCharacteristicData(DATE_OF_THRESHOLD_ASSESSMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData waistCircumference = new UDSCharacteristicData(WAIST_CIRCUMFERENCE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData hipCircumference = new UDSCharacteristicData(HIP_CIRCUMFERENCE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData fatBurnHeartRateLowerLimit = new UDSCharacteristicData(FAT_BURN_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData fatBurnHeartRateUpperLimit = new UDSCharacteristicData(FAT_BURN_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData aerobicHeartRateLowerLimit = new UDSCharacteristicData(AEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData aerobicHeartRateUpperLimit = new UDSCharacteristicData(AEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData anaerobicHeartRateLowerLimit = new UDSCharacteristicData(ANAEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData anaerobicHeartRateUpperLimit = new UDSCharacteristicData(ANAEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData fiveZoneHeartRateLimits = new UDSCharacteristicData(FIVE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData threeZoneHeartRateLimits = new UDSCharacteristicData(THREE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData twoZoneHeartRateLimit = new UDSCharacteristicData(TWO_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData language = new UDSCharacteristicData(LANGUAGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData databaseChangeIncrement = new CharacteristicData(DATABASE_CHANGE_INCREMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData userIndex = new CharacteristicData(USER_INDEX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UserControlPointCharacteristicData userControlPoint = new UserControlPointCharacteristicData(1
                , 2
                , new ArrayList<>()
                , 3
                , 5
                , 6
                , 7
                , 8
                , 9);
        CharacteristicData registeredUser = new CharacteristicData(REGISTERED_USER_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);

        UserDataServiceData userData = new UserDataServiceData(firstName
                , lastName
                , emailAddress
                , age
                , dateOfBirth
                , gender
                , weight
                , height
                , vo2Max
                , heartRateMax
                , restingHeartRate
                , maximumRecommendedHeartRate
                , aerobicThreshold
                , anaerobicThreshold
                , sportTypeForAerobicAndAnaerobicThresholds
                , dateOfThresholdAssessment
                , waistCircumference
                , hipCircumference
                , fatBurnHeartRateLowerLimit
                , fatBurnHeartRateUpperLimit
                , aerobicHeartRateLowerLimit
                , aerobicHeartRateUpperLimit
                , anaerobicHeartRateLowerLimit
                , anaerobicHeartRateUpperLimit
                , fiveZoneHeartRateLimits
                , threeZoneHeartRateLimits
                , twoZoneHeartRateLimit
                , language
                , databaseChangeIncrement
                , userIndex
                , userControlPoint
                , registeredUser);

        ServiceData deviceInformation = new ServiceData(DEVICE_INFORMATION_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList());

        FitnessMachineProfileMockData result1 = new FitnessMachineProfileMockData(fitnessMachine, userData, deviceInformation);

        List<ServiceData> list = new ArrayList<>();
        list.add(fitnessMachine);
        list.add(userData);
        list.add(deviceInformation);
        assertArrayEquals(list.toArray(), result1.getServiceDataList().toArray());
    }

    @Test
    public void test_getServiceDataList_00002() {
        CharacteristicData fitnessMachineFeature = new CharacteristicData(FITNESS_MACHINE_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData treadmillData = new CharacteristicData(TREADMILL_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData crossTrainerData = new CharacteristicData(CROSS_TRAINER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stepClimberData = new CharacteristicData(STEP_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stairClimberData = new CharacteristicData(STAIR_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData rowerData = new CharacteristicData(ROWER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData indoorBikeData = new CharacteristicData(INDOOR_BIKE_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData trainingStatus = new CharacteristicData(TRAINING_STATUS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedSpeedRange = new CharacteristicData(SUPPORTED_SPEED_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedInclinationRange = new CharacteristicData(SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedResistanceLevelRange = new CharacteristicData(SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedPowerRange = new CharacteristicData(SUPPORTED_POWER_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedHeartRateRange = new CharacteristicData(SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        FitnessMachineControlPointCharacteristicData fitnessMachineControlPoint = new FitnessMachineControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , 9
                , 10
                , 11
                , 12
                , 13
                , 14
                , 15
                , 16
                , 17
                , 18
                , 19
                , 20
                , 21
                , new byte[]{22}
                , 23);
        FitnessMachineStatusCharacteristicData fitnessMachineStatus = new FitnessMachineStatusCharacteristicData(new ArrayList<>()
                , 1);

        FitnessMachineServiceData fitnessMachine = new FitnessMachineServiceData(fitnessMachineFeature
                , treadmillData
                , crossTrainerData
                , stepClimberData
                , stairClimberData
                , rowerData
                , indoorBikeData
                , trainingStatus
                , supportedSpeedRange
                , supportedInclinationRange
                , supportedResistanceLevelRange
                , supportedPowerRange
                , supportedHeartRateRange
                , fitnessMachineControlPoint
                , fitnessMachineStatus);

        ServiceData deviceInformation = new ServiceData(DEVICE_INFORMATION_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList());

        FitnessMachineProfileMockData result1 = new FitnessMachineProfileMockData(fitnessMachine, null, deviceInformation);

        List<ServiceData> list = new ArrayList<>();
        list.add(fitnessMachine);
        list.add(deviceInformation);
        assertArrayEquals(list.toArray(), result1.getServiceDataList().toArray());
    }

    @Test
    public void test_getServiceDataList_00003() {
        CharacteristicData fitnessMachineFeature = new CharacteristicData(FITNESS_MACHINE_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData treadmillData = new CharacteristicData(TREADMILL_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData crossTrainerData = new CharacteristicData(CROSS_TRAINER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stepClimberData = new CharacteristicData(STEP_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stairClimberData = new CharacteristicData(STAIR_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData rowerData = new CharacteristicData(ROWER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData indoorBikeData = new CharacteristicData(INDOOR_BIKE_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData trainingStatus = new CharacteristicData(TRAINING_STATUS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedSpeedRange = new CharacteristicData(SUPPORTED_SPEED_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedInclinationRange = new CharacteristicData(SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedResistanceLevelRange = new CharacteristicData(SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedPowerRange = new CharacteristicData(SUPPORTED_POWER_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedHeartRateRange = new CharacteristicData(SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        FitnessMachineControlPointCharacteristicData fitnessMachineControlPoint = new FitnessMachineControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , 9
                , 10
                , 11
                , 12
                , 13
                , 14
                , 15
                , 16
                , 17
                , 18
                , 19
                , 20
                , 21
                , new byte[]{22}
                , 23);
        FitnessMachineStatusCharacteristicData fitnessMachineStatus = new FitnessMachineStatusCharacteristicData(new ArrayList<>()
                , 1);

        FitnessMachineServiceData fitnessMachine = new FitnessMachineServiceData(fitnessMachineFeature
                , treadmillData
                , crossTrainerData
                , stepClimberData
                , stairClimberData
                , rowerData
                , indoorBikeData
                , trainingStatus
                , supportedSpeedRange
                , supportedInclinationRange
                , supportedResistanceLevelRange
                , supportedPowerRange
                , supportedHeartRateRange
                , fitnessMachineControlPoint
                , fitnessMachineStatus);

        UDSCharacteristicData firstName = new UDSCharacteristicData(FIRST_NAME_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData lastName = new UDSCharacteristicData(LAST_NAME_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData emailAddress = new UDSCharacteristicData(EMAIL_ADDRESS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData age = new UDSCharacteristicData(AGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData dateOfBirth = new UDSCharacteristicData(DATE_OF_BIRTH_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData gender = new UDSCharacteristicData(GENDER_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData weight = new UDSCharacteristicData(WEIGHT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData height = new UDSCharacteristicData(HEIGHT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData vo2Max = new UDSCharacteristicData(VO2_MAX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData heartRateMax = new UDSCharacteristicData(HEART_RATE_MAX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData restingHeartRate = new UDSCharacteristicData(RESTING_HEART_RATE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData maximumRecommendedHeartRate = new UDSCharacteristicData(MAXIMUM_RECOMMENDED_HEART_RATE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData aerobicThreshold = new UDSCharacteristicData(AEROBIC_THRESHOLD_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData anaerobicThreshold = new UDSCharacteristicData(ANAEROBIC_THRESHOLD_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData sportTypeForAerobicAndAnaerobicThresholds = new UDSCharacteristicData(SPORT_TYPE_FOR_AEROBIC_AND_ANAEROBIC_THRESHOLDS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData dateOfThresholdAssessment = new UDSCharacteristicData(DATE_OF_THRESHOLD_ASSESSMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData waistCircumference = new UDSCharacteristicData(WAIST_CIRCUMFERENCE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData hipCircumference = new UDSCharacteristicData(HIP_CIRCUMFERENCE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData fatBurnHeartRateLowerLimit = new UDSCharacteristicData(FAT_BURN_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData fatBurnHeartRateUpperLimit = new UDSCharacteristicData(FAT_BURN_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData aerobicHeartRateLowerLimit = new UDSCharacteristicData(AEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData aerobicHeartRateUpperLimit = new UDSCharacteristicData(AEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData anaerobicHeartRateLowerLimit = new UDSCharacteristicData(ANAEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData anaerobicHeartRateUpperLimit = new UDSCharacteristicData(ANAEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData fiveZoneHeartRateLimits = new UDSCharacteristicData(FIVE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData threeZoneHeartRateLimits = new UDSCharacteristicData(THREE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData twoZoneHeartRateLimit = new UDSCharacteristicData(TWO_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData language = new UDSCharacteristicData(LANGUAGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData databaseChangeIncrement = new CharacteristicData(DATABASE_CHANGE_INCREMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData userIndex = new CharacteristicData(USER_INDEX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UserControlPointCharacteristicData userControlPoint = new UserControlPointCharacteristicData(1
                , 2
                , new ArrayList<>()
                , 3
                , 5
                , 6
                , 7
                , 8
                , 9);
        CharacteristicData registeredUser = new CharacteristicData(REGISTERED_USER_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);

        UserDataServiceData userData = new UserDataServiceData(firstName
                , lastName
                , emailAddress
                , age
                , dateOfBirth
                , gender
                , weight
                , height
                , vo2Max
                , heartRateMax
                , restingHeartRate
                , maximumRecommendedHeartRate
                , aerobicThreshold
                , anaerobicThreshold
                , sportTypeForAerobicAndAnaerobicThresholds
                , dateOfThresholdAssessment
                , waistCircumference
                , hipCircumference
                , fatBurnHeartRateLowerLimit
                , fatBurnHeartRateUpperLimit
                , aerobicHeartRateLowerLimit
                , aerobicHeartRateUpperLimit
                , anaerobicHeartRateLowerLimit
                , anaerobicHeartRateUpperLimit
                , fiveZoneHeartRateLimits
                , threeZoneHeartRateLimits
                , twoZoneHeartRateLimit
                , language
                , databaseChangeIncrement
                , userIndex
                , userControlPoint
                , registeredUser);

        FitnessMachineProfileMockData result1 = new FitnessMachineProfileMockData(fitnessMachine, userData, null);

        List<ServiceData> list = new ArrayList<>();
        list.add(fitnessMachine);
        list.add(userData);
        assertArrayEquals(list.toArray(), result1.getServiceDataList().toArray());
    }

    @Test
    public void test_parcelable_00001() {
        CharacteristicData fitnessMachineFeature = new CharacteristicData(FITNESS_MACHINE_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData treadmillData = new CharacteristicData(TREADMILL_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData crossTrainerData = new CharacteristicData(CROSS_TRAINER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stepClimberData = new CharacteristicData(STEP_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stairClimberData = new CharacteristicData(STAIR_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData rowerData = new CharacteristicData(ROWER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData indoorBikeData = new CharacteristicData(INDOOR_BIKE_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData trainingStatus = new CharacteristicData(TRAINING_STATUS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedSpeedRange = new CharacteristicData(SUPPORTED_SPEED_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedInclinationRange = new CharacteristicData(SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedResistanceLevelRange = new CharacteristicData(SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedPowerRange = new CharacteristicData(SUPPORTED_POWER_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedHeartRateRange = new CharacteristicData(SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        FitnessMachineControlPointCharacteristicData fitnessMachineControlPoint = new FitnessMachineControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , 9
                , 10
                , 11
                , 12
                , 13
                , 14
                , 15
                , 16
                , 17
                , 18
                , 19
                , 20
                , 21
                , new byte[]{22}
                , 23);
        FitnessMachineStatusCharacteristicData fitnessMachineStatus = new FitnessMachineStatusCharacteristicData(new ArrayList<>()
                , 1);

        FitnessMachineServiceData fitnessMachine = new FitnessMachineServiceData(fitnessMachineFeature
                , treadmillData
                , crossTrainerData
                , stepClimberData
                , stairClimberData
                , rowerData
                , indoorBikeData
                , trainingStatus
                , supportedSpeedRange
                , supportedInclinationRange
                , supportedResistanceLevelRange
                , supportedPowerRange
                , supportedHeartRateRange
                , fitnessMachineControlPoint
                , fitnessMachineStatus);

        UDSCharacteristicData firstName = new UDSCharacteristicData(FIRST_NAME_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData lastName = new UDSCharacteristicData(LAST_NAME_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData emailAddress = new UDSCharacteristicData(EMAIL_ADDRESS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData age = new UDSCharacteristicData(AGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData dateOfBirth = new UDSCharacteristicData(DATE_OF_BIRTH_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData gender = new UDSCharacteristicData(GENDER_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData weight = new UDSCharacteristicData(WEIGHT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData height = new UDSCharacteristicData(HEIGHT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData vo2Max = new UDSCharacteristicData(VO2_MAX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData heartRateMax = new UDSCharacteristicData(HEART_RATE_MAX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData restingHeartRate = new UDSCharacteristicData(RESTING_HEART_RATE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData maximumRecommendedHeartRate = new UDSCharacteristicData(MAXIMUM_RECOMMENDED_HEART_RATE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData aerobicThreshold = new UDSCharacteristicData(AEROBIC_THRESHOLD_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData anaerobicThreshold = new UDSCharacteristicData(ANAEROBIC_THRESHOLD_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData sportTypeForAerobicAndAnaerobicThresholds = new UDSCharacteristicData(SPORT_TYPE_FOR_AEROBIC_AND_ANAEROBIC_THRESHOLDS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData dateOfThresholdAssessment = new UDSCharacteristicData(DATE_OF_THRESHOLD_ASSESSMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData waistCircumference = new UDSCharacteristicData(WAIST_CIRCUMFERENCE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData hipCircumference = new UDSCharacteristicData(HIP_CIRCUMFERENCE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData fatBurnHeartRateLowerLimit = new UDSCharacteristicData(FAT_BURN_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData fatBurnHeartRateUpperLimit = new UDSCharacteristicData(FAT_BURN_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData aerobicHeartRateLowerLimit = new UDSCharacteristicData(AEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData aerobicHeartRateUpperLimit = new UDSCharacteristicData(AEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData anaerobicHeartRateLowerLimit = new UDSCharacteristicData(ANAEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData anaerobicHeartRateUpperLimit = new UDSCharacteristicData(ANAEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData fiveZoneHeartRateLimits = new UDSCharacteristicData(FIVE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData threeZoneHeartRateLimits = new UDSCharacteristicData(THREE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData twoZoneHeartRateLimit = new UDSCharacteristicData(TWO_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData language = new UDSCharacteristicData(LANGUAGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData databaseChangeIncrement = new CharacteristicData(DATABASE_CHANGE_INCREMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData userIndex = new CharacteristicData(USER_INDEX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UserControlPointCharacteristicData userControlPoint = new UserControlPointCharacteristicData(1
                , 2
                , new ArrayList<>()
                , 3
                , 5
                , 6
                , 7
                , 8
                , 9);
        CharacteristicData registeredUser = new CharacteristicData(REGISTERED_USER_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);

        UserDataServiceData userData = new UserDataServiceData(firstName
                , lastName
                , emailAddress
                , age
                , dateOfBirth
                , gender
                , weight
                , height
                , vo2Max
                , heartRateMax
                , restingHeartRate
                , maximumRecommendedHeartRate
                , aerobicThreshold
                , anaerobicThreshold
                , sportTypeForAerobicAndAnaerobicThresholds
                , dateOfThresholdAssessment
                , waistCircumference
                , hipCircumference
                , fatBurnHeartRateLowerLimit
                , fatBurnHeartRateUpperLimit
                , aerobicHeartRateLowerLimit
                , aerobicHeartRateUpperLimit
                , anaerobicHeartRateLowerLimit
                , anaerobicHeartRateUpperLimit
                , fiveZoneHeartRateLimits
                , threeZoneHeartRateLimits
                , twoZoneHeartRateLimit
                , language
                , databaseChangeIncrement
                , userIndex
                , userControlPoint
                , registeredUser);

        ServiceData deviceInformation = new ServiceData(DEVICE_INFORMATION_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList());

        FitnessMachineProfileMockData result1 = new FitnessMachineProfileMockData(fitnessMachine, userData, deviceInformation);

        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineProfileMockData result2 = FitnessMachineProfileMockData.CREATOR.createFromParcel(parcel);

        assertNotNull(result2.serviceDataList);
        assertEquals(result1.serviceDataList.size(), result2.serviceDataList.size());
        assertArrayEquals(result1.serviceDataList.toArray(), result2.serviceDataList.toArray());
        assertEquals(result1.fitnessMachine, result2.fitnessMachine);
        assertEquals(result1.userData, result2.userData);
        assertEquals(result1.deviceInformation, result2.deviceInformation);
    }

    @Test
    public void test_parcelable_00002() {
        CharacteristicData fitnessMachineFeature = new CharacteristicData(FITNESS_MACHINE_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData treadmillData = new CharacteristicData(TREADMILL_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData crossTrainerData = new CharacteristicData(CROSS_TRAINER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stepClimberData = new CharacteristicData(STEP_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stairClimberData = new CharacteristicData(STAIR_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData rowerData = new CharacteristicData(ROWER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData indoorBikeData = new CharacteristicData(INDOOR_BIKE_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData trainingStatus = new CharacteristicData(TRAINING_STATUS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedSpeedRange = new CharacteristicData(SUPPORTED_SPEED_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedInclinationRange = new CharacteristicData(SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedResistanceLevelRange = new CharacteristicData(SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedPowerRange = new CharacteristicData(SUPPORTED_POWER_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedHeartRateRange = new CharacteristicData(SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        FitnessMachineControlPointCharacteristicData fitnessMachineControlPoint = new FitnessMachineControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , 9
                , 10
                , 11
                , 12
                , 13
                , 14
                , 15
                , 16
                , 17
                , 18
                , 19
                , 20
                , 21
                , new byte[]{22}
                , 23);
        FitnessMachineStatusCharacteristicData fitnessMachineStatus = new FitnessMachineStatusCharacteristicData(new ArrayList<>()
                , 1);

        FitnessMachineServiceData fitnessMachine = new FitnessMachineServiceData(fitnessMachineFeature
                , treadmillData
                , crossTrainerData
                , stepClimberData
                , stairClimberData
                , rowerData
                , indoorBikeData
                , trainingStatus
                , supportedSpeedRange
                , supportedInclinationRange
                , supportedResistanceLevelRange
                , supportedPowerRange
                , supportedHeartRateRange
                , fitnessMachineControlPoint
                , fitnessMachineStatus);

        ServiceData deviceInformation = new ServiceData(DEVICE_INFORMATION_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList());

        FitnessMachineProfileMockData result1 = new FitnessMachineProfileMockData(fitnessMachine, null, deviceInformation);

        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineProfileMockData result2 = FitnessMachineProfileMockData.CREATOR.createFromParcel(parcel);

        assertNotNull(result2.serviceDataList);
        assertEquals(result1.serviceDataList.size(), result2.serviceDataList.size());
        assertArrayEquals(result1.serviceDataList.toArray(), result2.serviceDataList.toArray());
        assertEquals(result1.fitnessMachine, result2.fitnessMachine);
        assertEquals(result1.userData, result2.userData);
        assertEquals(result1.deviceInformation, result2.deviceInformation);
    }

    @Test
    public void test_parcelable_00003() {
        CharacteristicData fitnessMachineFeature = new CharacteristicData(FITNESS_MACHINE_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData treadmillData = new CharacteristicData(TREADMILL_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData crossTrainerData = new CharacteristicData(CROSS_TRAINER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stepClimberData = new CharacteristicData(STEP_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stairClimberData = new CharacteristicData(STAIR_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData rowerData = new CharacteristicData(ROWER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData indoorBikeData = new CharacteristicData(INDOOR_BIKE_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData trainingStatus = new CharacteristicData(TRAINING_STATUS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedSpeedRange = new CharacteristicData(SUPPORTED_SPEED_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedInclinationRange = new CharacteristicData(SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedResistanceLevelRange = new CharacteristicData(SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedPowerRange = new CharacteristicData(SUPPORTED_POWER_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedHeartRateRange = new CharacteristicData(SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        FitnessMachineControlPointCharacteristicData fitnessMachineControlPoint = new FitnessMachineControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , 9
                , 10
                , 11
                , 12
                , 13
                , 14
                , 15
                , 16
                , 17
                , 18
                , 19
                , 20
                , 21
                , new byte[]{22}
                , 23);
        FitnessMachineStatusCharacteristicData fitnessMachineStatus = new FitnessMachineStatusCharacteristicData(new ArrayList<>()
                , 1);

        FitnessMachineServiceData fitnessMachine = new FitnessMachineServiceData(fitnessMachineFeature
                , treadmillData
                , crossTrainerData
                , stepClimberData
                , stairClimberData
                , rowerData
                , indoorBikeData
                , trainingStatus
                , supportedSpeedRange
                , supportedInclinationRange
                , supportedResistanceLevelRange
                , supportedPowerRange
                , supportedHeartRateRange
                , fitnessMachineControlPoint
                , fitnessMachineStatus);

        UDSCharacteristicData firstName = new UDSCharacteristicData(FIRST_NAME_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData lastName = new UDSCharacteristicData(LAST_NAME_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData emailAddress = new UDSCharacteristicData(EMAIL_ADDRESS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData age = new UDSCharacteristicData(AGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData dateOfBirth = new UDSCharacteristicData(DATE_OF_BIRTH_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData gender = new UDSCharacteristicData(GENDER_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData weight = new UDSCharacteristicData(WEIGHT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData height = new UDSCharacteristicData(HEIGHT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData vo2Max = new UDSCharacteristicData(VO2_MAX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData heartRateMax = new UDSCharacteristicData(HEART_RATE_MAX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData restingHeartRate = new UDSCharacteristicData(RESTING_HEART_RATE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData maximumRecommendedHeartRate = new UDSCharacteristicData(MAXIMUM_RECOMMENDED_HEART_RATE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData aerobicThreshold = new UDSCharacteristicData(AEROBIC_THRESHOLD_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData anaerobicThreshold = new UDSCharacteristicData(ANAEROBIC_THRESHOLD_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData sportTypeForAerobicAndAnaerobicThresholds = new UDSCharacteristicData(SPORT_TYPE_FOR_AEROBIC_AND_ANAEROBIC_THRESHOLDS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData dateOfThresholdAssessment = new UDSCharacteristicData(DATE_OF_THRESHOLD_ASSESSMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData waistCircumference = new UDSCharacteristicData(WAIST_CIRCUMFERENCE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData hipCircumference = new UDSCharacteristicData(HIP_CIRCUMFERENCE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData fatBurnHeartRateLowerLimit = new UDSCharacteristicData(FAT_BURN_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData fatBurnHeartRateUpperLimit = new UDSCharacteristicData(FAT_BURN_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData aerobicHeartRateLowerLimit = new UDSCharacteristicData(AEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData aerobicHeartRateUpperLimit = new UDSCharacteristicData(AEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData anaerobicHeartRateLowerLimit = new UDSCharacteristicData(ANAEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData anaerobicHeartRateUpperLimit = new UDSCharacteristicData(ANAEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData fiveZoneHeartRateLimits = new UDSCharacteristicData(FIVE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData threeZoneHeartRateLimits = new UDSCharacteristicData(THREE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData twoZoneHeartRateLimit = new UDSCharacteristicData(TWO_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData language = new UDSCharacteristicData(LANGUAGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData databaseChangeIncrement = new CharacteristicData(DATABASE_CHANGE_INCREMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData userIndex = new CharacteristicData(USER_INDEX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UserControlPointCharacteristicData userControlPoint = new UserControlPointCharacteristicData(1
                , 2
                , new ArrayList<>()
                , 3
                , 5
                , 6
                , 7
                , 8
                , 9);
        CharacteristicData registeredUser = new CharacteristicData(REGISTERED_USER_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);

        UserDataServiceData userData = new UserDataServiceData(firstName
                , lastName
                , emailAddress
                , age
                , dateOfBirth
                , gender
                , weight
                , height
                , vo2Max
                , heartRateMax
                , restingHeartRate
                , maximumRecommendedHeartRate
                , aerobicThreshold
                , anaerobicThreshold
                , sportTypeForAerobicAndAnaerobicThresholds
                , dateOfThresholdAssessment
                , waistCircumference
                , hipCircumference
                , fatBurnHeartRateLowerLimit
                , fatBurnHeartRateUpperLimit
                , aerobicHeartRateLowerLimit
                , aerobicHeartRateUpperLimit
                , anaerobicHeartRateLowerLimit
                , anaerobicHeartRateUpperLimit
                , fiveZoneHeartRateLimits
                , threeZoneHeartRateLimits
                , twoZoneHeartRateLimit
                , language
                , databaseChangeIncrement
                , userIndex
                , userControlPoint
                , registeredUser);

        FitnessMachineProfileMockData result1 = new FitnessMachineProfileMockData(fitnessMachine, userData, null);

        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineProfileMockData result2 = FitnessMachineProfileMockData.CREATOR.createFromParcel(parcel);

        assertNotNull(result2.serviceDataList);
        assertEquals(result1.serviceDataList.size(), result2.serviceDataList.size());
        assertArrayEquals(result1.serviceDataList.toArray(), result2.serviceDataList.toArray());
        assertEquals(result1.fitnessMachine, result2.fitnessMachine);
        assertEquals(result1.userData, result2.userData);
        assertEquals(result1.deviceInformation, result2.deviceInformation);
    }

    @Test
    public void test_hashCode_00001() {
        CharacteristicData fitnessMachineFeature = new CharacteristicData(FITNESS_MACHINE_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData treadmillData = new CharacteristicData(TREADMILL_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData crossTrainerData = new CharacteristicData(CROSS_TRAINER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stepClimberData = new CharacteristicData(STEP_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stairClimberData = new CharacteristicData(STAIR_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData rowerData = new CharacteristicData(ROWER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData indoorBikeData = new CharacteristicData(INDOOR_BIKE_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData trainingStatus = new CharacteristicData(TRAINING_STATUS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedSpeedRange = new CharacteristicData(SUPPORTED_SPEED_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedInclinationRange = new CharacteristicData(SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedResistanceLevelRange = new CharacteristicData(SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedPowerRange = new CharacteristicData(SUPPORTED_POWER_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedHeartRateRange = new CharacteristicData(SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        FitnessMachineControlPointCharacteristicData fitnessMachineControlPoint = new FitnessMachineControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , 9
                , 10
                , 11
                , 12
                , 13
                , 14
                , 15
                , 16
                , 17
                , 18
                , 19
                , 20
                , 21
                , new byte[]{22}
                , 23);
        FitnessMachineStatusCharacteristicData fitnessMachineStatus = new FitnessMachineStatusCharacteristicData(new ArrayList<>()
                , 1);

        FitnessMachineServiceData fitnessMachine = new FitnessMachineServiceData(fitnessMachineFeature
                , treadmillData
                , crossTrainerData
                , stepClimberData
                , stairClimberData
                , rowerData
                , indoorBikeData
                , trainingStatus
                , supportedSpeedRange
                , supportedInclinationRange
                , supportedResistanceLevelRange
                , supportedPowerRange
                , supportedHeartRateRange
                , fitnessMachineControlPoint
                , fitnessMachineStatus);

        UDSCharacteristicData firstName = new UDSCharacteristicData(FIRST_NAME_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData lastName = new UDSCharacteristicData(LAST_NAME_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData emailAddress = new UDSCharacteristicData(EMAIL_ADDRESS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData age = new UDSCharacteristicData(AGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData dateOfBirth = new UDSCharacteristicData(DATE_OF_BIRTH_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData gender = new UDSCharacteristicData(GENDER_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData weight = new UDSCharacteristicData(WEIGHT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData height = new UDSCharacteristicData(HEIGHT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData vo2Max = new UDSCharacteristicData(VO2_MAX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData heartRateMax = new UDSCharacteristicData(HEART_RATE_MAX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData restingHeartRate = new UDSCharacteristicData(RESTING_HEART_RATE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData maximumRecommendedHeartRate = new UDSCharacteristicData(MAXIMUM_RECOMMENDED_HEART_RATE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData aerobicThreshold = new UDSCharacteristicData(AEROBIC_THRESHOLD_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData anaerobicThreshold = new UDSCharacteristicData(ANAEROBIC_THRESHOLD_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData sportTypeForAerobicAndAnaerobicThresholds = new UDSCharacteristicData(SPORT_TYPE_FOR_AEROBIC_AND_ANAEROBIC_THRESHOLDS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData dateOfThresholdAssessment = new UDSCharacteristicData(DATE_OF_THRESHOLD_ASSESSMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData waistCircumference = new UDSCharacteristicData(WAIST_CIRCUMFERENCE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData hipCircumference = new UDSCharacteristicData(HIP_CIRCUMFERENCE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData fatBurnHeartRateLowerLimit = new UDSCharacteristicData(FAT_BURN_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData fatBurnHeartRateUpperLimit = new UDSCharacteristicData(FAT_BURN_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData aerobicHeartRateLowerLimit = new UDSCharacteristicData(AEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData aerobicHeartRateUpperLimit = new UDSCharacteristicData(AEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData anaerobicHeartRateLowerLimit = new UDSCharacteristicData(ANAEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData anaerobicHeartRateUpperLimit = new UDSCharacteristicData(ANAEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData fiveZoneHeartRateLimits = new UDSCharacteristicData(FIVE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData threeZoneHeartRateLimits = new UDSCharacteristicData(THREE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData twoZoneHeartRateLimit = new UDSCharacteristicData(TWO_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData language = new UDSCharacteristicData(LANGUAGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData databaseChangeIncrement = new CharacteristicData(DATABASE_CHANGE_INCREMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData userIndex = new CharacteristicData(USER_INDEX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UserControlPointCharacteristicData userControlPoint = new UserControlPointCharacteristicData(1
                , 2
                , new ArrayList<>()
                , 3
                , 5
                , 6
                , 7
                , 8
                , 9);
        CharacteristicData registeredUser = new CharacteristicData(REGISTERED_USER_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);

        UserDataServiceData userData = new UserDataServiceData(firstName
                , lastName
                , emailAddress
                , age
                , dateOfBirth
                , gender
                , weight
                , height
                , vo2Max
                , heartRateMax
                , restingHeartRate
                , maximumRecommendedHeartRate
                , aerobicThreshold
                , anaerobicThreshold
                , sportTypeForAerobicAndAnaerobicThresholds
                , dateOfThresholdAssessment
                , waistCircumference
                , hipCircumference
                , fatBurnHeartRateLowerLimit
                , fatBurnHeartRateUpperLimit
                , aerobicHeartRateLowerLimit
                , aerobicHeartRateUpperLimit
                , anaerobicHeartRateLowerLimit
                , anaerobicHeartRateUpperLimit
                , fiveZoneHeartRateLimits
                , threeZoneHeartRateLimits
                , twoZoneHeartRateLimit
                , language
                , databaseChangeIncrement
                , userIndex
                , userControlPoint
                , registeredUser);

        ServiceData deviceInformation = new ServiceData(DEVICE_INFORMATION_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList());

        FitnessMachineProfileMockData result1 = new FitnessMachineProfileMockData(fitnessMachine, userData, deviceInformation);

        assertEquals(Objects.hashCode(Collections.emptyList())
                        ^ Objects.hashCode(fitnessMachine)
                        ^ Objects.hashCode(userData)
                        ^ Objects.hashCode(deviceInformation)
                , result1.hashCode());
    }

    @Test
    public void test_hashCode_00002() {
        CharacteristicData fitnessMachineFeature = new CharacteristicData(FITNESS_MACHINE_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData treadmillData = new CharacteristicData(TREADMILL_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData crossTrainerData = new CharacteristicData(CROSS_TRAINER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stepClimberData = new CharacteristicData(STEP_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stairClimberData = new CharacteristicData(STAIR_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData rowerData = new CharacteristicData(ROWER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData indoorBikeData = new CharacteristicData(INDOOR_BIKE_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData trainingStatus = new CharacteristicData(TRAINING_STATUS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedSpeedRange = new CharacteristicData(SUPPORTED_SPEED_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedInclinationRange = new CharacteristicData(SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedResistanceLevelRange = new CharacteristicData(SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedPowerRange = new CharacteristicData(SUPPORTED_POWER_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedHeartRateRange = new CharacteristicData(SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        FitnessMachineControlPointCharacteristicData fitnessMachineControlPoint = new FitnessMachineControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , 9
                , 10
                , 11
                , 12
                , 13
                , 14
                , 15
                , 16
                , 17
                , 18
                , 19
                , 20
                , 21
                , new byte[]{22}
                , 23);
        FitnessMachineStatusCharacteristicData fitnessMachineStatus = new FitnessMachineStatusCharacteristicData(new ArrayList<>()
                , 1);

        FitnessMachineServiceData fitnessMachine = new FitnessMachineServiceData(fitnessMachineFeature
                , treadmillData
                , crossTrainerData
                , stepClimberData
                , stairClimberData
                , rowerData
                , indoorBikeData
                , trainingStatus
                , supportedSpeedRange
                , supportedInclinationRange
                , supportedResistanceLevelRange
                , supportedPowerRange
                , supportedHeartRateRange
                , fitnessMachineControlPoint
                , fitnessMachineStatus);

        ServiceData deviceInformation = new ServiceData(DEVICE_INFORMATION_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList());

        FitnessMachineProfileMockData result1 = new FitnessMachineProfileMockData(fitnessMachine, null, deviceInformation);

        assertEquals(Objects.hashCode(Collections.emptyList())
                        ^ Objects.hashCode(fitnessMachine)
                        ^ Objects.hashCode(null)
                        ^ Objects.hashCode(deviceInformation)
                , result1.hashCode());
    }

    @Test
    public void test_hashCode_00003() {
        CharacteristicData fitnessMachineFeature = new CharacteristicData(FITNESS_MACHINE_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData treadmillData = new CharacteristicData(TREADMILL_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData crossTrainerData = new CharacteristicData(CROSS_TRAINER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stepClimberData = new CharacteristicData(STEP_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stairClimberData = new CharacteristicData(STAIR_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData rowerData = new CharacteristicData(ROWER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData indoorBikeData = new CharacteristicData(INDOOR_BIKE_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData trainingStatus = new CharacteristicData(TRAINING_STATUS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedSpeedRange = new CharacteristicData(SUPPORTED_SPEED_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedInclinationRange = new CharacteristicData(SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedResistanceLevelRange = new CharacteristicData(SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedPowerRange = new CharacteristicData(SUPPORTED_POWER_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedHeartRateRange = new CharacteristicData(SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        FitnessMachineControlPointCharacteristicData fitnessMachineControlPoint = new FitnessMachineControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , 9
                , 10
                , 11
                , 12
                , 13
                , 14
                , 15
                , 16
                , 17
                , 18
                , 19
                , 20
                , 21
                , new byte[]{22}
                , 23);
        FitnessMachineStatusCharacteristicData fitnessMachineStatus = new FitnessMachineStatusCharacteristicData(new ArrayList<>()
                , 1);

        FitnessMachineServiceData fitnessMachine = new FitnessMachineServiceData(fitnessMachineFeature
                , treadmillData
                , crossTrainerData
                , stepClimberData
                , stairClimberData
                , rowerData
                , indoorBikeData
                , trainingStatus
                , supportedSpeedRange
                , supportedInclinationRange
                , supportedResistanceLevelRange
                , supportedPowerRange
                , supportedHeartRateRange
                , fitnessMachineControlPoint
                , fitnessMachineStatus);

        UDSCharacteristicData firstName = new UDSCharacteristicData(FIRST_NAME_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData lastName = new UDSCharacteristicData(LAST_NAME_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData emailAddress = new UDSCharacteristicData(EMAIL_ADDRESS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData age = new UDSCharacteristicData(AGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData dateOfBirth = new UDSCharacteristicData(DATE_OF_BIRTH_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData gender = new UDSCharacteristicData(GENDER_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData weight = new UDSCharacteristicData(WEIGHT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData height = new UDSCharacteristicData(HEIGHT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData vo2Max = new UDSCharacteristicData(VO2_MAX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData heartRateMax = new UDSCharacteristicData(HEART_RATE_MAX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData restingHeartRate = new UDSCharacteristicData(RESTING_HEART_RATE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData maximumRecommendedHeartRate = new UDSCharacteristicData(MAXIMUM_RECOMMENDED_HEART_RATE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData aerobicThreshold = new UDSCharacteristicData(AEROBIC_THRESHOLD_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData anaerobicThreshold = new UDSCharacteristicData(ANAEROBIC_THRESHOLD_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData sportTypeForAerobicAndAnaerobicThresholds = new UDSCharacteristicData(SPORT_TYPE_FOR_AEROBIC_AND_ANAEROBIC_THRESHOLDS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData dateOfThresholdAssessment = new UDSCharacteristicData(DATE_OF_THRESHOLD_ASSESSMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData waistCircumference = new UDSCharacteristicData(WAIST_CIRCUMFERENCE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData hipCircumference = new UDSCharacteristicData(HIP_CIRCUMFERENCE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData fatBurnHeartRateLowerLimit = new UDSCharacteristicData(FAT_BURN_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData fatBurnHeartRateUpperLimit = new UDSCharacteristicData(FAT_BURN_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData aerobicHeartRateLowerLimit = new UDSCharacteristicData(AEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData aerobicHeartRateUpperLimit = new UDSCharacteristicData(AEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData anaerobicHeartRateLowerLimit = new UDSCharacteristicData(ANAEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData anaerobicHeartRateUpperLimit = new UDSCharacteristicData(ANAEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData fiveZoneHeartRateLimits = new UDSCharacteristicData(FIVE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData threeZoneHeartRateLimits = new UDSCharacteristicData(THREE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData twoZoneHeartRateLimit = new UDSCharacteristicData(TWO_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData language = new UDSCharacteristicData(LANGUAGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData databaseChangeIncrement = new CharacteristicData(DATABASE_CHANGE_INCREMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData userIndex = new CharacteristicData(USER_INDEX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UserControlPointCharacteristicData userControlPoint = new UserControlPointCharacteristicData(1
                , 2
                , new ArrayList<>()
                , 3
                , 5
                , 6
                , 7
                , 8
                , 9);
        CharacteristicData registeredUser = new CharacteristicData(REGISTERED_USER_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);

        UserDataServiceData userData = new UserDataServiceData(firstName
                , lastName
                , emailAddress
                , age
                , dateOfBirth
                , gender
                , weight
                , height
                , vo2Max
                , heartRateMax
                , restingHeartRate
                , maximumRecommendedHeartRate
                , aerobicThreshold
                , anaerobicThreshold
                , sportTypeForAerobicAndAnaerobicThresholds
                , dateOfThresholdAssessment
                , waistCircumference
                , hipCircumference
                , fatBurnHeartRateLowerLimit
                , fatBurnHeartRateUpperLimit
                , aerobicHeartRateLowerLimit
                , aerobicHeartRateUpperLimit
                , anaerobicHeartRateLowerLimit
                , anaerobicHeartRateUpperLimit
                , fiveZoneHeartRateLimits
                , threeZoneHeartRateLimits
                , twoZoneHeartRateLimit
                , language
                , databaseChangeIncrement
                , userIndex
                , userControlPoint
                , registeredUser);

        FitnessMachineProfileMockData result1 = new FitnessMachineProfileMockData(fitnessMachine, userData, null);

        assertEquals(Objects.hashCode(Collections.emptyList())
                        ^ Objects.hashCode(fitnessMachine)
                        ^ Objects.hashCode(userData)
                        ^ Objects.hashCode(null)
                , result1.hashCode());
    }


    @Test
    public void test_equals_00001() {
        CharacteristicData fitnessMachineFeature = new CharacteristicData(FITNESS_MACHINE_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData treadmillData = new CharacteristicData(TREADMILL_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData crossTrainerData = new CharacteristicData(CROSS_TRAINER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stepClimberData = new CharacteristicData(STEP_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stairClimberData = new CharacteristicData(STAIR_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData rowerData = new CharacteristicData(ROWER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData indoorBikeData = new CharacteristicData(INDOOR_BIKE_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData trainingStatus = new CharacteristicData(TRAINING_STATUS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedSpeedRange = new CharacteristicData(SUPPORTED_SPEED_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedInclinationRange = new CharacteristicData(SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedResistanceLevelRange = new CharacteristicData(SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedPowerRange = new CharacteristicData(SUPPORTED_POWER_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedHeartRateRange = new CharacteristicData(SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        FitnessMachineControlPointCharacteristicData fitnessMachineControlPoint = new FitnessMachineControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , 9
                , 10
                , 11
                , 12
                , 13
                , 14
                , 15
                , 16
                , 17
                , 18
                , 19
                , 20
                , 21
                , new byte[]{22}
                , 23);
        FitnessMachineStatusCharacteristicData fitnessMachineStatus = new FitnessMachineStatusCharacteristicData(new ArrayList<>()
                , 1);

        FitnessMachineServiceData firstFitnessMachine = new FitnessMachineServiceData(fitnessMachineFeature
                , treadmillData
                , crossTrainerData
                , stepClimberData
                , stairClimberData
                , rowerData
                , indoorBikeData
                , trainingStatus
                , supportedSpeedRange
                , supportedInclinationRange
                , supportedResistanceLevelRange
                , supportedPowerRange
                , supportedHeartRateRange
                , fitnessMachineControlPoint
                , fitnessMachineStatus);

        UDSCharacteristicData firstName = new UDSCharacteristicData(FIRST_NAME_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData lastName = new UDSCharacteristicData(LAST_NAME_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData emailAddress = new UDSCharacteristicData(EMAIL_ADDRESS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData age = new UDSCharacteristicData(AGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData dateOfBirth = new UDSCharacteristicData(DATE_OF_BIRTH_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData gender = new UDSCharacteristicData(GENDER_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData weight = new UDSCharacteristicData(WEIGHT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData height = new UDSCharacteristicData(HEIGHT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData vo2Max = new UDSCharacteristicData(VO2_MAX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData heartRateMax = new UDSCharacteristicData(HEART_RATE_MAX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData restingHeartRate = new UDSCharacteristicData(RESTING_HEART_RATE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData maximumRecommendedHeartRate = new UDSCharacteristicData(MAXIMUM_RECOMMENDED_HEART_RATE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData aerobicThreshold = new UDSCharacteristicData(AEROBIC_THRESHOLD_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData anaerobicThreshold = new UDSCharacteristicData(ANAEROBIC_THRESHOLD_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData sportTypeForAerobicAndAnaerobicThresholds = new UDSCharacteristicData(SPORT_TYPE_FOR_AEROBIC_AND_ANAEROBIC_THRESHOLDS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData dateOfThresholdAssessment = new UDSCharacteristicData(DATE_OF_THRESHOLD_ASSESSMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData waistCircumference = new UDSCharacteristicData(WAIST_CIRCUMFERENCE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData hipCircumference = new UDSCharacteristicData(HIP_CIRCUMFERENCE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData fatBurnHeartRateLowerLimit = new UDSCharacteristicData(FAT_BURN_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData fatBurnHeartRateUpperLimit = new UDSCharacteristicData(FAT_BURN_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData aerobicHeartRateLowerLimit = new UDSCharacteristicData(AEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData aerobicHeartRateUpperLimit = new UDSCharacteristicData(AEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData anaerobicHeartRateLowerLimit = new UDSCharacteristicData(ANAEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData anaerobicHeartRateUpperLimit = new UDSCharacteristicData(ANAEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData fiveZoneHeartRateLimits = new UDSCharacteristicData(FIVE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData threeZoneHeartRateLimits = new UDSCharacteristicData(THREE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData twoZoneHeartRateLimit = new UDSCharacteristicData(TWO_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData language = new UDSCharacteristicData(LANGUAGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData databaseChangeIncrement = new CharacteristicData(DATABASE_CHANGE_INCREMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData userIndex = new CharacteristicData(USER_INDEX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UserControlPointCharacteristicData userControlPoint = new UserControlPointCharacteristicData(1
                , 2
                , new ArrayList<>()
                , 3
                , 5
                , 6
                , 7
                , 8
                , 9);
        CharacteristicData registeredUser = new CharacteristicData(REGISTERED_USER_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);

        UserDataServiceData firstUserData = new UserDataServiceData(firstName
                , lastName
                , emailAddress
                , age
                , dateOfBirth
                , gender
                , weight
                , height
                , vo2Max
                , heartRateMax
                , restingHeartRate
                , maximumRecommendedHeartRate
                , aerobicThreshold
                , anaerobicThreshold
                , sportTypeForAerobicAndAnaerobicThresholds
                , dateOfThresholdAssessment
                , waistCircumference
                , hipCircumference
                , fatBurnHeartRateLowerLimit
                , fatBurnHeartRateUpperLimit
                , aerobicHeartRateLowerLimit
                , aerobicHeartRateUpperLimit
                , anaerobicHeartRateLowerLimit
                , anaerobicHeartRateUpperLimit
                , fiveZoneHeartRateLimits
                , threeZoneHeartRateLimits
                , twoZoneHeartRateLimit
                , language
                , databaseChangeIncrement
                , userIndex
                , userControlPoint
                , registeredUser);

        ServiceData firstDeviceInformation = new ServiceData(DEVICE_INFORMATION_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList());

        FitnessMachineProfileMockData result1 = new FitnessMachineProfileMockData(firstFitnessMachine, firstUserData, firstDeviceInformation);

        FitnessMachineProfileMockData result2 = new FitnessMachineProfileMockData(firstFitnessMachine, firstUserData, firstDeviceInformation);

        assertEquals(result1, result2);
    }

    @Test
    public void test_equals_00002() {
        CharacteristicData fitnessMachineFeature = new CharacteristicData(FITNESS_MACHINE_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData treadmillData = new CharacteristicData(TREADMILL_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData crossTrainerData = new CharacteristicData(CROSS_TRAINER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stepClimberData = new CharacteristicData(STEP_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stairClimberData = new CharacteristicData(STAIR_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData rowerData = new CharacteristicData(ROWER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData indoorBikeData = new CharacteristicData(INDOOR_BIKE_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData trainingStatus = new CharacteristicData(TRAINING_STATUS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedSpeedRange = new CharacteristicData(SUPPORTED_SPEED_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedInclinationRange = new CharacteristicData(SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedResistanceLevelRange = new CharacteristicData(SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedPowerRange = new CharacteristicData(SUPPORTED_POWER_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedHeartRateRange = new CharacteristicData(SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        FitnessMachineControlPointCharacteristicData fitnessMachineControlPoint = new FitnessMachineControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , 9
                , 10
                , 11
                , 12
                , 13
                , 14
                , 15
                , 16
                , 17
                , 18
                , 19
                , 20
                , 21
                , new byte[]{22}
                , 23);
        FitnessMachineStatusCharacteristicData fitnessMachineStatus = new FitnessMachineStatusCharacteristicData(new ArrayList<>()
                , 1);

        FitnessMachineServiceData firstFitnessMachine = new FitnessMachineServiceData(fitnessMachineFeature
                , treadmillData
                , crossTrainerData
                , stepClimberData
                , stairClimberData
                , rowerData
                , indoorBikeData
                , trainingStatus
                , supportedSpeedRange
                , supportedInclinationRange
                , supportedResistanceLevelRange
                , supportedPowerRange
                , supportedHeartRateRange
                , fitnessMachineControlPoint
                , fitnessMachineStatus);

        UDSCharacteristicData firstName = new UDSCharacteristicData(FIRST_NAME_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData lastName = new UDSCharacteristicData(LAST_NAME_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData emailAddress = new UDSCharacteristicData(EMAIL_ADDRESS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData age = new UDSCharacteristicData(AGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData dateOfBirth = new UDSCharacteristicData(DATE_OF_BIRTH_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData gender = new UDSCharacteristicData(GENDER_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData weight = new UDSCharacteristicData(WEIGHT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData height = new UDSCharacteristicData(HEIGHT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData vo2Max = new UDSCharacteristicData(VO2_MAX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData heartRateMax = new UDSCharacteristicData(HEART_RATE_MAX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData restingHeartRate = new UDSCharacteristicData(RESTING_HEART_RATE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData maximumRecommendedHeartRate = new UDSCharacteristicData(MAXIMUM_RECOMMENDED_HEART_RATE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData aerobicThreshold = new UDSCharacteristicData(AEROBIC_THRESHOLD_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData anaerobicThreshold = new UDSCharacteristicData(ANAEROBIC_THRESHOLD_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData sportTypeForAerobicAndAnaerobicThresholds = new UDSCharacteristicData(SPORT_TYPE_FOR_AEROBIC_AND_ANAEROBIC_THRESHOLDS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData dateOfThresholdAssessment = new UDSCharacteristicData(DATE_OF_THRESHOLD_ASSESSMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData waistCircumference = new UDSCharacteristicData(WAIST_CIRCUMFERENCE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData hipCircumference = new UDSCharacteristicData(HIP_CIRCUMFERENCE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData fatBurnHeartRateLowerLimit = new UDSCharacteristicData(FAT_BURN_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData fatBurnHeartRateUpperLimit = new UDSCharacteristicData(FAT_BURN_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData aerobicHeartRateLowerLimit = new UDSCharacteristicData(AEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData aerobicHeartRateUpperLimit = new UDSCharacteristicData(AEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData anaerobicHeartRateLowerLimit = new UDSCharacteristicData(ANAEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData anaerobicHeartRateUpperLimit = new UDSCharacteristicData(ANAEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData fiveZoneHeartRateLimits = new UDSCharacteristicData(FIVE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData threeZoneHeartRateLimits = new UDSCharacteristicData(THREE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData twoZoneHeartRateLimit = new UDSCharacteristicData(TWO_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData language = new UDSCharacteristicData(LANGUAGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData databaseChangeIncrement = new CharacteristicData(DATABASE_CHANGE_INCREMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData userIndex = new CharacteristicData(USER_INDEX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UserControlPointCharacteristicData userControlPoint = new UserControlPointCharacteristicData(1
                , 2
                , new ArrayList<>()
                , 3
                , 5
                , 6
                , 7
                , 8
                , 9);
        CharacteristicData registeredUser = new CharacteristicData(REGISTERED_USER_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);

        UserDataServiceData firstUserData = new UserDataServiceData(firstName
                , lastName
                , emailAddress
                , age
                , dateOfBirth
                , gender
                , weight
                , height
                , vo2Max
                , heartRateMax
                , restingHeartRate
                , maximumRecommendedHeartRate
                , aerobicThreshold
                , anaerobicThreshold
                , sportTypeForAerobicAndAnaerobicThresholds
                , dateOfThresholdAssessment
                , waistCircumference
                , hipCircumference
                , fatBurnHeartRateLowerLimit
                , fatBurnHeartRateUpperLimit
                , aerobicHeartRateLowerLimit
                , aerobicHeartRateUpperLimit
                , anaerobicHeartRateLowerLimit
                , anaerobicHeartRateUpperLimit
                , fiveZoneHeartRateLimits
                , threeZoneHeartRateLimits
                , twoZoneHeartRateLimit
                , language
                , databaseChangeIncrement
                , userIndex
                , userControlPoint
                , registeredUser);

        ServiceData firstDeviceInformation = new ServiceData(DEVICE_INFORMATION_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList());

        UserDataServiceData secondUserData = new UserDataServiceData();

        FitnessMachineProfileMockData result1 = new FitnessMachineProfileMockData(firstFitnessMachine, firstUserData, firstDeviceInformation);

        FitnessMachineProfileMockData result2 = new FitnessMachineProfileMockData(firstFitnessMachine, secondUserData, firstDeviceInformation);

        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00003() {
        CharacteristicData fitnessMachineFeature = new CharacteristicData(FITNESS_MACHINE_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData treadmillData = new CharacteristicData(TREADMILL_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData crossTrainerData = new CharacteristicData(CROSS_TRAINER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stepClimberData = new CharacteristicData(STEP_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stairClimberData = new CharacteristicData(STAIR_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData rowerData = new CharacteristicData(ROWER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData indoorBikeData = new CharacteristicData(INDOOR_BIKE_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData trainingStatus = new CharacteristicData(TRAINING_STATUS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedSpeedRange = new CharacteristicData(SUPPORTED_SPEED_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedInclinationRange = new CharacteristicData(SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedResistanceLevelRange = new CharacteristicData(SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedPowerRange = new CharacteristicData(SUPPORTED_POWER_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedHeartRateRange = new CharacteristicData(SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        FitnessMachineControlPointCharacteristicData fitnessMachineControlPoint = new FitnessMachineControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , 9
                , 10
                , 11
                , 12
                , 13
                , 14
                , 15
                , 16
                , 17
                , 18
                , 19
                , 20
                , 21
                , new byte[]{22}
                , 23);
        FitnessMachineStatusCharacteristicData fitnessMachineStatus = new FitnessMachineStatusCharacteristicData(new ArrayList<>()
                , 1);

        FitnessMachineServiceData firstFitnessMachine = new FitnessMachineServiceData(fitnessMachineFeature
                , treadmillData
                , crossTrainerData
                , stepClimberData
                , stairClimberData
                , rowerData
                , indoorBikeData
                , trainingStatus
                , supportedSpeedRange
                , supportedInclinationRange
                , supportedResistanceLevelRange
                , supportedPowerRange
                , supportedHeartRateRange
                , fitnessMachineControlPoint
                , fitnessMachineStatus);

        UDSCharacteristicData firstName = new UDSCharacteristicData(FIRST_NAME_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData lastName = new UDSCharacteristicData(LAST_NAME_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData emailAddress = new UDSCharacteristicData(EMAIL_ADDRESS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData age = new UDSCharacteristicData(AGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData dateOfBirth = new UDSCharacteristicData(DATE_OF_BIRTH_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData gender = new UDSCharacteristicData(GENDER_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData weight = new UDSCharacteristicData(WEIGHT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData height = new UDSCharacteristicData(HEIGHT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData vo2Max = new UDSCharacteristicData(VO2_MAX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData heartRateMax = new UDSCharacteristicData(HEART_RATE_MAX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData restingHeartRate = new UDSCharacteristicData(RESTING_HEART_RATE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData maximumRecommendedHeartRate = new UDSCharacteristicData(MAXIMUM_RECOMMENDED_HEART_RATE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData aerobicThreshold = new UDSCharacteristicData(AEROBIC_THRESHOLD_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData anaerobicThreshold = new UDSCharacteristicData(ANAEROBIC_THRESHOLD_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData sportTypeForAerobicAndAnaerobicThresholds = new UDSCharacteristicData(SPORT_TYPE_FOR_AEROBIC_AND_ANAEROBIC_THRESHOLDS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData dateOfThresholdAssessment = new UDSCharacteristicData(DATE_OF_THRESHOLD_ASSESSMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData waistCircumference = new UDSCharacteristicData(WAIST_CIRCUMFERENCE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData hipCircumference = new UDSCharacteristicData(HIP_CIRCUMFERENCE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData fatBurnHeartRateLowerLimit = new UDSCharacteristicData(FAT_BURN_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData fatBurnHeartRateUpperLimit = new UDSCharacteristicData(FAT_BURN_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData aerobicHeartRateLowerLimit = new UDSCharacteristicData(AEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData aerobicHeartRateUpperLimit = new UDSCharacteristicData(AEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData anaerobicHeartRateLowerLimit = new UDSCharacteristicData(ANAEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData anaerobicHeartRateUpperLimit = new UDSCharacteristicData(ANAEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData fiveZoneHeartRateLimits = new UDSCharacteristicData(FIVE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData threeZoneHeartRateLimits = new UDSCharacteristicData(THREE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData twoZoneHeartRateLimit = new UDSCharacteristicData(TWO_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData language = new UDSCharacteristicData(LANGUAGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData databaseChangeIncrement = new CharacteristicData(DATABASE_CHANGE_INCREMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData userIndex = new CharacteristicData(USER_INDEX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UserControlPointCharacteristicData userControlPoint = new UserControlPointCharacteristicData(1
                , 2
                , new ArrayList<>()
                , 3
                , 5
                , 6
                , 7
                , 8
                , 9);
        CharacteristicData registeredUser = new CharacteristicData(REGISTERED_USER_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);

        UserDataServiceData firstUserData = new UserDataServiceData(firstName
                , lastName
                , emailAddress
                , age
                , dateOfBirth
                , gender
                , weight
                , height
                , vo2Max
                , heartRateMax
                , restingHeartRate
                , maximumRecommendedHeartRate
                , aerobicThreshold
                , anaerobicThreshold
                , sportTypeForAerobicAndAnaerobicThresholds
                , dateOfThresholdAssessment
                , waistCircumference
                , hipCircumference
                , fatBurnHeartRateLowerLimit
                , fatBurnHeartRateUpperLimit
                , aerobicHeartRateLowerLimit
                , aerobicHeartRateUpperLimit
                , anaerobicHeartRateLowerLimit
                , anaerobicHeartRateUpperLimit
                , fiveZoneHeartRateLimits
                , threeZoneHeartRateLimits
                , twoZoneHeartRateLimit
                , language
                , databaseChangeIncrement
                , userIndex
                , userControlPoint
                , registeredUser);

        ServiceData firstDeviceInformation = new ServiceData(DEVICE_INFORMATION_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList());

        ServiceData secondDeviceInformation = new ServiceData(DEVICE_INFORMATION_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.singletonList(new CharacteristicData()));

        FitnessMachineProfileMockData result1 = new FitnessMachineProfileMockData(firstFitnessMachine, firstUserData, firstDeviceInformation);

        FitnessMachineProfileMockData result2 = new FitnessMachineProfileMockData(firstFitnessMachine, firstUserData, secondDeviceInformation);

        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00101() {
        CharacteristicData fitnessMachineFeature = new CharacteristicData(FITNESS_MACHINE_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData treadmillData = new CharacteristicData(TREADMILL_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData crossTrainerData = new CharacteristicData(CROSS_TRAINER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stepClimberData = new CharacteristicData(STEP_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stairClimberData = new CharacteristicData(STAIR_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData rowerData = new CharacteristicData(ROWER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData indoorBikeData = new CharacteristicData(INDOOR_BIKE_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData trainingStatus = new CharacteristicData(TRAINING_STATUS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedSpeedRange = new CharacteristicData(SUPPORTED_SPEED_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedInclinationRange = new CharacteristicData(SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedResistanceLevelRange = new CharacteristicData(SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedPowerRange = new CharacteristicData(SUPPORTED_POWER_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedHeartRateRange = new CharacteristicData(SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        FitnessMachineControlPointCharacteristicData fitnessMachineControlPoint = new FitnessMachineControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , 9
                , 10
                , 11
                , 12
                , 13
                , 14
                , 15
                , 16
                , 17
                , 18
                , 19
                , 20
                , 21
                , new byte[]{22}
                , 23);
        FitnessMachineStatusCharacteristicData fitnessMachineStatus = new FitnessMachineStatusCharacteristicData(new ArrayList<>()
                , 1);

        FitnessMachineServiceData firstFitnessMachine = new FitnessMachineServiceData(fitnessMachineFeature
                , treadmillData
                , crossTrainerData
                , stepClimberData
                , stairClimberData
                , rowerData
                , indoorBikeData
                , trainingStatus
                , supportedSpeedRange
                , supportedInclinationRange
                , supportedResistanceLevelRange
                , supportedPowerRange
                , supportedHeartRateRange
                , fitnessMachineControlPoint
                , fitnessMachineStatus);

        ServiceData firstDeviceInformation = new ServiceData(DEVICE_INFORMATION_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList());

        FitnessMachineProfileMockData result1 = new FitnessMachineProfileMockData(firstFitnessMachine, null, firstDeviceInformation);

        FitnessMachineProfileMockData result2 = new FitnessMachineProfileMockData(firstFitnessMachine, null, firstDeviceInformation);

        assertEquals(result1, result2);
    }

    @Test
    public void test_equals_00102() {
        CharacteristicData fitnessMachineFeature = new CharacteristicData(FITNESS_MACHINE_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData treadmillData = new CharacteristicData(TREADMILL_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData crossTrainerData = new CharacteristicData(CROSS_TRAINER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stepClimberData = new CharacteristicData(STEP_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stairClimberData = new CharacteristicData(STAIR_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData rowerData = new CharacteristicData(ROWER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData indoorBikeData = new CharacteristicData(INDOOR_BIKE_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData trainingStatus = new CharacteristicData(TRAINING_STATUS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedSpeedRange = new CharacteristicData(SUPPORTED_SPEED_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedInclinationRange = new CharacteristicData(SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedResistanceLevelRange = new CharacteristicData(SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedPowerRange = new CharacteristicData(SUPPORTED_POWER_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedHeartRateRange = new CharacteristicData(SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        FitnessMachineControlPointCharacteristicData fitnessMachineControlPoint = new FitnessMachineControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , 9
                , 10
                , 11
                , 12
                , 13
                , 14
                , 15
                , 16
                , 17
                , 18
                , 19
                , 20
                , 21
                , new byte[]{22}
                , 23);
        FitnessMachineStatusCharacteristicData fitnessMachineStatus = new FitnessMachineStatusCharacteristicData(new ArrayList<>()
                , 1);

        FitnessMachineServiceData firstFitnessMachine = new FitnessMachineServiceData(fitnessMachineFeature
                , treadmillData
                , crossTrainerData
                , stepClimberData
                , stairClimberData
                , rowerData
                , indoorBikeData
                , trainingStatus
                , supportedSpeedRange
                , supportedInclinationRange
                , supportedResistanceLevelRange
                , supportedPowerRange
                , supportedHeartRateRange
                , fitnessMachineControlPoint
                , fitnessMachineStatus);

        UDSCharacteristicData firstName = new UDSCharacteristicData(FIRST_NAME_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData lastName = new UDSCharacteristicData(LAST_NAME_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData emailAddress = new UDSCharacteristicData(EMAIL_ADDRESS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData age = new UDSCharacteristicData(AGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData dateOfBirth = new UDSCharacteristicData(DATE_OF_BIRTH_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData gender = new UDSCharacteristicData(GENDER_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData weight = new UDSCharacteristicData(WEIGHT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData height = new UDSCharacteristicData(HEIGHT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData vo2Max = new UDSCharacteristicData(VO2_MAX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData heartRateMax = new UDSCharacteristicData(HEART_RATE_MAX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData restingHeartRate = new UDSCharacteristicData(RESTING_HEART_RATE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData maximumRecommendedHeartRate = new UDSCharacteristicData(MAXIMUM_RECOMMENDED_HEART_RATE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData aerobicThreshold = new UDSCharacteristicData(AEROBIC_THRESHOLD_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData anaerobicThreshold = new UDSCharacteristicData(ANAEROBIC_THRESHOLD_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData sportTypeForAerobicAndAnaerobicThresholds = new UDSCharacteristicData(SPORT_TYPE_FOR_AEROBIC_AND_ANAEROBIC_THRESHOLDS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData dateOfThresholdAssessment = new UDSCharacteristicData(DATE_OF_THRESHOLD_ASSESSMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData waistCircumference = new UDSCharacteristicData(WAIST_CIRCUMFERENCE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData hipCircumference = new UDSCharacteristicData(HIP_CIRCUMFERENCE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData fatBurnHeartRateLowerLimit = new UDSCharacteristicData(FAT_BURN_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData fatBurnHeartRateUpperLimit = new UDSCharacteristicData(FAT_BURN_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData aerobicHeartRateLowerLimit = new UDSCharacteristicData(AEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData aerobicHeartRateUpperLimit = new UDSCharacteristicData(AEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData anaerobicHeartRateLowerLimit = new UDSCharacteristicData(ANAEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData anaerobicHeartRateUpperLimit = new UDSCharacteristicData(ANAEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData fiveZoneHeartRateLimits = new UDSCharacteristicData(FIVE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData threeZoneHeartRateLimits = new UDSCharacteristicData(THREE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData twoZoneHeartRateLimit = new UDSCharacteristicData(TWO_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData language = new UDSCharacteristicData(LANGUAGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData databaseChangeIncrement = new CharacteristicData(DATABASE_CHANGE_INCREMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData userIndex = new CharacteristicData(USER_INDEX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UserControlPointCharacteristicData userControlPoint = new UserControlPointCharacteristicData(1
                , 2
                , new ArrayList<>()
                , 3
                , 5
                , 6
                , 7
                , 8
                , 9);
        CharacteristicData registeredUser = new CharacteristicData(REGISTERED_USER_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);

        UserDataServiceData firstUserData = new UserDataServiceData(firstName
                , lastName
                , emailAddress
                , age
                , dateOfBirth
                , gender
                , weight
                , height
                , vo2Max
                , heartRateMax
                , restingHeartRate
                , maximumRecommendedHeartRate
                , aerobicThreshold
                , anaerobicThreshold
                , sportTypeForAerobicAndAnaerobicThresholds
                , dateOfThresholdAssessment
                , waistCircumference
                , hipCircumference
                , fatBurnHeartRateLowerLimit
                , fatBurnHeartRateUpperLimit
                , aerobicHeartRateLowerLimit
                , aerobicHeartRateUpperLimit
                , anaerobicHeartRateLowerLimit
                , anaerobicHeartRateUpperLimit
                , fiveZoneHeartRateLimits
                , threeZoneHeartRateLimits
                , twoZoneHeartRateLimit
                , language
                , databaseChangeIncrement
                , userIndex
                , userControlPoint
                , registeredUser);

        FitnessMachineProfileMockData result1 = new FitnessMachineProfileMockData(firstFitnessMachine, firstUserData, null);

        FitnessMachineProfileMockData result2 = new FitnessMachineProfileMockData(firstFitnessMachine, firstUserData, null);

        assertEquals(result1, result2);
    }

}
