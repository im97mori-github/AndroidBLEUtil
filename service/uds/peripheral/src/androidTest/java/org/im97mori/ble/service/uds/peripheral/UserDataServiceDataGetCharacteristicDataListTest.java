package org.im97mori.ble.service.uds.peripheral;

import static org.im97mori.ble.constants.CharacteristicUUID.AEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.AEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.AEROBIC_THRESHOLD_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.AGE_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.ANAEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.ANAEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.ANAEROBIC_THRESHOLD_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.DATABASE_CHANGE_INCREMENT_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.DATE_OF_BIRTH_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.DATE_OF_THRESHOLD_ASSESSMENT_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.EMAIL_ADDRESS_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.FAT_BURN_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.FAT_BURN_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.FIRST_NAME_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.FIVE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.GENDER_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.HEART_RATE_MAX_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.HEIGHT_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.HIP_CIRCUMFERENCE_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.LANGUAGE_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.LAST_NAME_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.MAXIMUM_RECOMMENDED_HEART_RATE_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.REGISTERED_USER_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.RESTING_HEART_RATE_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.SPORT_TYPE_FOR_AEROBIC_AND_ANAEROBIC_THRESHOLDS_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.THREE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.TWO_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.USER_INDEX_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.VO2_MAX_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.WAIST_CIRCUMFERENCE_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.WEIGHT_CHARACTERISTIC;
import static org.junit.Assert.assertArrayEquals;

import org.im97mori.ble.CharacteristicData;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class UserDataServiceDataGetCharacteristicDataListTest {

    @Test
    public void test_getCharacteristicDataList_00001() {
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

        UserDataServiceData result1 = new UserDataServiceData(firstName
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

        assertArrayEquals(Arrays.asList(firstName
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
                , registeredUser).toArray(), result1.getCharacteristicDataList().toArray());
    }

    @Test
    public void test_getCharacteristicDataList_00002() {
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

        UserDataServiceData result1 = new UserDataServiceData(null
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

        assertArrayEquals(Arrays.asList(lastName
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
                , registeredUser).toArray(), result1.getCharacteristicDataList().toArray());
    }

    @Test
    public void test_getCharacteristicDataList_00003() {
        UDSCharacteristicData firstName = new UDSCharacteristicData(FIRST_NAME_CHARACTERISTIC
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

        UserDataServiceData result1 = new UserDataServiceData(firstName
                , null
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

        assertArrayEquals(Arrays.asList(firstName
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
                , registeredUser).toArray(), result1.getCharacteristicDataList().toArray());
    }

    @Test
    public void test_getCharacteristicDataList_00004() {
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

        UserDataServiceData result1 = new UserDataServiceData(firstName
                , lastName
                , null
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

        assertArrayEquals(Arrays.asList(firstName
                , lastName
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
                , registeredUser).toArray(), result1.getCharacteristicDataList().toArray());
    }

    @Test
    public void test_getCharacteristicDataList_00005() {
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

        UserDataServiceData result1 = new UserDataServiceData(firstName
                , lastName
                , emailAddress
                , null
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

        assertArrayEquals(Arrays.asList(firstName
                , lastName
                , emailAddress
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
                , registeredUser).toArray(), result1.getCharacteristicDataList().toArray());
    }

    @Test
    public void test_getCharacteristicDataList_00006() {
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

        UserDataServiceData result1 = new UserDataServiceData(firstName
                , lastName
                , emailAddress
                , age
                , null
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

        assertArrayEquals(Arrays.asList(firstName
                , lastName
                , emailAddress
                , age
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
                , registeredUser).toArray(), result1.getCharacteristicDataList().toArray());
    }

    @Test
    public void test_getCharacteristicDataList_00007() {
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

        UserDataServiceData result1 = new UserDataServiceData(firstName
                , lastName
                , emailAddress
                , age
                , dateOfBirth
                , null
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

        assertArrayEquals(Arrays.asList(firstName
                , lastName
                , emailAddress
                , age
                , dateOfBirth
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
                , registeredUser).toArray(), result1.getCharacteristicDataList().toArray());
    }

    @Test
    public void test_getCharacteristicDataList_00008() {
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

        UserDataServiceData result1 = new UserDataServiceData(firstName
                , lastName
                , emailAddress
                , age
                , dateOfBirth
                , gender
                , null
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

        assertArrayEquals(Arrays.asList(firstName
                , lastName
                , emailAddress
                , age
                , dateOfBirth
                , gender
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
                , registeredUser).toArray(), result1.getCharacteristicDataList().toArray());
    }

    @Test
    public void test_getCharacteristicDataList_00009() {
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

        UserDataServiceData result1 = new UserDataServiceData(firstName
                , lastName
                , emailAddress
                , age
                , dateOfBirth
                , gender
                , weight
                , null
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

        assertArrayEquals(Arrays.asList(firstName
                , lastName
                , emailAddress
                , age
                , dateOfBirth
                , gender
                , weight
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
                , registeredUser).toArray(), result1.getCharacteristicDataList().toArray());
    }

    @Test
    public void test_getCharacteristicDataList_00010() {
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

        UserDataServiceData result1 = new UserDataServiceData(firstName
                , lastName
                , emailAddress
                , age
                , dateOfBirth
                , gender
                , weight
                , height
                , null
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

        assertArrayEquals(Arrays.asList(firstName
                , lastName
                , emailAddress
                , age
                , dateOfBirth
                , gender
                , weight
                , height
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
                , registeredUser).toArray(), result1.getCharacteristicDataList().toArray());
    }

    @Test
    public void test_getCharacteristicDataList_00011() {
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

        UserDataServiceData result1 = new UserDataServiceData(firstName
                , lastName
                , emailAddress
                , age
                , dateOfBirth
                , gender
                , weight
                , height
                , vo2Max
                , null
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

        assertArrayEquals(Arrays.asList(firstName
                , lastName
                , emailAddress
                , age
                , dateOfBirth
                , gender
                , weight
                , height
                , vo2Max
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
                , registeredUser).toArray(), result1.getCharacteristicDataList().toArray());
    }

    @Test
    public void test_getCharacteristicDataList_00012() {
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

        UserDataServiceData result1 = new UserDataServiceData(firstName
                , lastName
                , emailAddress
                , age
                , dateOfBirth
                , gender
                , weight
                , height
                , vo2Max
                , heartRateMax
                , null
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

        assertArrayEquals(Arrays.asList(firstName
                , lastName
                , emailAddress
                , age
                , dateOfBirth
                , gender
                , weight
                , height
                , vo2Max
                , heartRateMax
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
                , registeredUser).toArray(), result1.getCharacteristicDataList().toArray());
    }

    @Test
    public void test_getCharacteristicDataList_00013() {
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

        UserDataServiceData result1 = new UserDataServiceData(firstName
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
                , null
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

        assertArrayEquals(Arrays.asList(firstName
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
                , registeredUser).toArray(), result1.getCharacteristicDataList().toArray());
    }

    @Test
    public void test_getCharacteristicDataList_00014() {
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

        UserDataServiceData result1 = new UserDataServiceData(firstName
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
                , null
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

        assertArrayEquals(Arrays.asList(firstName
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
                , registeredUser).toArray(), result1.getCharacteristicDataList().toArray());
    }

    @Test
    public void test_getCharacteristicDataList_00015() {
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

        UserDataServiceData result1 = new UserDataServiceData(firstName
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
                , null
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

        assertArrayEquals(Arrays.asList(firstName
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
                , registeredUser).toArray(), result1.getCharacteristicDataList().toArray());
    }

    @Test
    public void test_getCharacteristicDataList_00016() {
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

        UserDataServiceData result1 = new UserDataServiceData(firstName
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
                , null
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

        assertArrayEquals(Arrays.asList(firstName
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
                , registeredUser).toArray(), result1.getCharacteristicDataList().toArray());
    }

    @Test
    public void test_getCharacteristicDataList_00017() {
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

        UserDataServiceData result1 = new UserDataServiceData(firstName
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
                , null
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

        assertArrayEquals(Arrays.asList(firstName
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
                , registeredUser).toArray(), result1.getCharacteristicDataList().toArray());
    }

    @Test
    public void test_getCharacteristicDataList_00018() {
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

        UserDataServiceData result1 = new UserDataServiceData(firstName
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
                , null
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

        assertArrayEquals(Arrays.asList(firstName
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
                , registeredUser).toArray(), result1.getCharacteristicDataList().toArray());
    }

    @Test
    public void test_getCharacteristicDataList_00019() {
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

        UserDataServiceData result1 = new UserDataServiceData(firstName
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
                , null
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

        assertArrayEquals(Arrays.asList(firstName
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
                , registeredUser).toArray(), result1.getCharacteristicDataList().toArray());
    }

    @Test
    public void test_getCharacteristicDataList_00020() {
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

        UserDataServiceData result1 = new UserDataServiceData(firstName
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
                , null
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

        assertArrayEquals(Arrays.asList(firstName
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
                , registeredUser).toArray(), result1.getCharacteristicDataList().toArray());
    }

    @Test
    public void test_getCharacteristicDataList_00021() {
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

        UserDataServiceData result1 = new UserDataServiceData(firstName
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
                , null
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

        assertArrayEquals(Arrays.asList(firstName
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
                , registeredUser).toArray(), result1.getCharacteristicDataList().toArray());
    }

    @Test
    public void test_getCharacteristicDataList_00022() {
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

        UserDataServiceData result1 = new UserDataServiceData(firstName
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
                , null
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

        assertArrayEquals(Arrays.asList(firstName
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
                , registeredUser).toArray(), result1.getCharacteristicDataList().toArray());
    }

    @Test
    public void test_getCharacteristicDataList_00023() {
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

        UserDataServiceData result1 = new UserDataServiceData(firstName
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
                , null
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

        assertArrayEquals(Arrays.asList(firstName
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
                , registeredUser).toArray(), result1.getCharacteristicDataList().toArray());
    }

    @Test
    public void test_getCharacteristicDataList_00024() {
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

        UserDataServiceData result1 = new UserDataServiceData(firstName
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
                , null
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

        assertArrayEquals(Arrays.asList(firstName
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
                , registeredUser).toArray(), result1.getCharacteristicDataList().toArray());
    }

    @Test
    public void test_getCharacteristicDataList_00025() {
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

        UserDataServiceData result1 = new UserDataServiceData(firstName
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
                , null
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

        assertArrayEquals(Arrays.asList(firstName
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
                , anaerobicHeartRateLowerLimit
                , anaerobicHeartRateUpperLimit
                , fiveZoneHeartRateLimits
                , threeZoneHeartRateLimits
                , twoZoneHeartRateLimit
                , language
                , databaseChangeIncrement
                , userIndex
                , userControlPoint
                , registeredUser).toArray(), result1.getCharacteristicDataList().toArray());
    }

    @Test
    public void test_getCharacteristicDataList_00026() {
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

        UserDataServiceData result1 = new UserDataServiceData(firstName
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
                , null
                , anaerobicHeartRateUpperLimit
                , fiveZoneHeartRateLimits
                , threeZoneHeartRateLimits
                , twoZoneHeartRateLimit
                , language
                , databaseChangeIncrement
                , userIndex
                , userControlPoint
                , registeredUser);

        assertArrayEquals(Arrays.asList(firstName
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
                , anaerobicHeartRateUpperLimit
                , fiveZoneHeartRateLimits
                , threeZoneHeartRateLimits
                , twoZoneHeartRateLimit
                , language
                , databaseChangeIncrement
                , userIndex
                , userControlPoint
                , registeredUser).toArray(), result1.getCharacteristicDataList().toArray());
    }

    @Test
    public void test_getCharacteristicDataList_00027() {
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

        UserDataServiceData result1 = new UserDataServiceData(firstName
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
                , null
                , fiveZoneHeartRateLimits
                , threeZoneHeartRateLimits
                , twoZoneHeartRateLimit
                , language
                , databaseChangeIncrement
                , userIndex
                , userControlPoint
                , registeredUser);

        assertArrayEquals(Arrays.asList(firstName
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
                , fiveZoneHeartRateLimits
                , threeZoneHeartRateLimits
                , twoZoneHeartRateLimit
                , language
                , databaseChangeIncrement
                , userIndex
                , userControlPoint
                , registeredUser).toArray(), result1.getCharacteristicDataList().toArray());
    }

    @Test
    public void test_getCharacteristicDataList_00028() {
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

        UserDataServiceData result1 = new UserDataServiceData(firstName
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
                , null
                , threeZoneHeartRateLimits
                , twoZoneHeartRateLimit
                , language
                , databaseChangeIncrement
                , userIndex
                , userControlPoint
                , registeredUser);

        assertArrayEquals(Arrays.asList(firstName
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
                , threeZoneHeartRateLimits
                , twoZoneHeartRateLimit
                , language
                , databaseChangeIncrement
                , userIndex
                , userControlPoint
                , registeredUser).toArray(), result1.getCharacteristicDataList().toArray());
    }

    @Test
    public void test_getCharacteristicDataList_00029() {
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

        UserDataServiceData result1 = new UserDataServiceData(firstName
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
                , null
                , twoZoneHeartRateLimit
                , language
                , databaseChangeIncrement
                , userIndex
                , userControlPoint
                , registeredUser);

        assertArrayEquals(Arrays.asList(firstName
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
                , twoZoneHeartRateLimit
                , language
                , databaseChangeIncrement
                , userIndex
                , userControlPoint
                , registeredUser).toArray(), result1.getCharacteristicDataList().toArray());
    }

    @Test
    public void test_getCharacteristicDataList_00030() {
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

        UserDataServiceData result1 = new UserDataServiceData(firstName
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
                , null
                , language
                , databaseChangeIncrement
                , userIndex
                , userControlPoint
                , registeredUser);

        assertArrayEquals(Arrays.asList(firstName
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
                , language
                , databaseChangeIncrement
                , userIndex
                , userControlPoint
                , registeredUser).toArray(), result1.getCharacteristicDataList().toArray());
    }

    @Test
    public void test_getCharacteristicDataList_00031() {
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

        UserDataServiceData result1 = new UserDataServiceData(firstName
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
                , null
                , databaseChangeIncrement
                , userIndex
                , userControlPoint
                , registeredUser);

        assertArrayEquals(Arrays.asList(firstName
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
                , databaseChangeIncrement
                , userIndex
                , userControlPoint
                , registeredUser).toArray(), result1.getCharacteristicDataList().toArray());
    }

    @Test
    public void test_getCharacteristicDataList_00032() {
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

        UserDataServiceData result1 = new UserDataServiceData(firstName
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
                , null);

        assertArrayEquals(Arrays.asList(firstName
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
                , userControlPoint).toArray(), result1.getCharacteristicDataList().toArray());
    }

}
