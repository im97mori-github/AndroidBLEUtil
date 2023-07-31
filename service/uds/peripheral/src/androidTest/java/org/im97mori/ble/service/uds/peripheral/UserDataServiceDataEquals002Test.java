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
import static org.junit.Assert.assertEquals;

import org.im97mori.ble.CharacteristicData;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

public class UserDataServiceDataEquals002Test {

    @Test
    public void test_equals_00101() {
        UDSCharacteristicData firstLastName = new UDSCharacteristicData(LAST_NAME_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstEmailAddress = new UDSCharacteristicData(EMAIL_ADDRESS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAge = new UDSCharacteristicData(AGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstDateOfBirth = new UDSCharacteristicData(DATE_OF_BIRTH_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstGender = new UDSCharacteristicData(GENDER_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstWeight = new UDSCharacteristicData(WEIGHT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstHeight = new UDSCharacteristicData(HEIGHT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstVo2Max = new UDSCharacteristicData(VO2_MAX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstHeartRateMax = new UDSCharacteristicData(HEART_RATE_MAX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstRestingHeartRate = new UDSCharacteristicData(RESTING_HEART_RATE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstMaximumRecommendedHeartRate = new UDSCharacteristicData(MAXIMUM_RECOMMENDED_HEART_RATE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAerobicThreshold = new UDSCharacteristicData(AEROBIC_THRESHOLD_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAnaerobicThreshold = new UDSCharacteristicData(ANAEROBIC_THRESHOLD_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstSportTypeForAerobicAndAnaerobicThresholds = new UDSCharacteristicData(SPORT_TYPE_FOR_AEROBIC_AND_ANAEROBIC_THRESHOLDS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstDateOfThresholdAssessment = new UDSCharacteristicData(DATE_OF_THRESHOLD_ASSESSMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstWaistCircumference = new UDSCharacteristicData(WAIST_CIRCUMFERENCE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstHipCircumference = new UDSCharacteristicData(HIP_CIRCUMFERENCE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstFatBurnHeartRateLowerLimit = new UDSCharacteristicData(FAT_BURN_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstFatBurnHeartRateUpperLimit = new UDSCharacteristicData(FAT_BURN_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAerobicHeartRateLowerLimit = new UDSCharacteristicData(AEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAerobicHeartRateUpperLimit = new UDSCharacteristicData(AEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAnaerobicHeartRateLowerLimit = new UDSCharacteristicData(ANAEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAnaerobicHeartRateUpperLimit = new UDSCharacteristicData(ANAEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstFiveZoneHeartRateLimits = new UDSCharacteristicData(FIVE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstThreeZoneHeartRateLimits = new UDSCharacteristicData(THREE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstTwoZoneHeartRateLimit = new UDSCharacteristicData(TWO_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstLanguage = new UDSCharacteristicData(LANGUAGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstDatabaseChangeIncrement = new CharacteristicData(DATABASE_CHANGE_INCREMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstUserIndex = new CharacteristicData(USER_INDEX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UserControlPointCharacteristicData firstUserControlPoint = new UserControlPointCharacteristicData(1
                , 2
                , new ArrayList<>()
                , 3
                , 5
                , 6
                , 7
                , 8
                , 9);
        CharacteristicData firstRegisteredUser = new CharacteristicData(REGISTERED_USER_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);

        UserDataServiceData result1 = new UserDataServiceData(null
                , firstLastName
                , firstEmailAddress
                , firstAge
                , firstDateOfBirth
                , firstGender
                , firstWeight
                , firstHeight
                , firstVo2Max
                , firstHeartRateMax
                , firstRestingHeartRate
                , firstMaximumRecommendedHeartRate
                , firstAerobicThreshold
                , firstAnaerobicThreshold
                , firstSportTypeForAerobicAndAnaerobicThresholds
                , firstDateOfThresholdAssessment
                , firstWaistCircumference
                , firstHipCircumference
                , firstFatBurnHeartRateLowerLimit
                , firstFatBurnHeartRateUpperLimit
                , firstAerobicHeartRateLowerLimit
                , firstAerobicHeartRateUpperLimit
                , firstAnaerobicHeartRateLowerLimit
                , firstAnaerobicHeartRateUpperLimit
                , firstFiveZoneHeartRateLimits
                , firstThreeZoneHeartRateLimits
                , firstTwoZoneHeartRateLimit
                , firstLanguage
                , firstDatabaseChangeIncrement
                , firstUserIndex
                , firstUserControlPoint
                , firstRegisteredUser);

        UserDataServiceData result2 = new UserDataServiceData(null
                , firstLastName
                , firstEmailAddress
                , firstAge
                , firstDateOfBirth
                , firstGender
                , firstWeight
                , firstHeight
                , firstVo2Max
                , firstHeartRateMax
                , firstRestingHeartRate
                , firstMaximumRecommendedHeartRate
                , firstAerobicThreshold
                , firstAnaerobicThreshold
                , firstSportTypeForAerobicAndAnaerobicThresholds
                , firstDateOfThresholdAssessment
                , firstWaistCircumference
                , firstHipCircumference
                , firstFatBurnHeartRateLowerLimit
                , firstFatBurnHeartRateUpperLimit
                , firstAerobicHeartRateLowerLimit
                , firstAerobicHeartRateUpperLimit
                , firstAnaerobicHeartRateLowerLimit
                , firstAnaerobicHeartRateUpperLimit
                , firstFiveZoneHeartRateLimits
                , firstThreeZoneHeartRateLimits
                , firstTwoZoneHeartRateLimit
                , firstLanguage
                , firstDatabaseChangeIncrement
                , firstUserIndex
                , firstUserControlPoint
                , firstRegisteredUser);
        assertEquals(result1, result2);
    }

    @Test
    public void test_equals_00102() {
        UDSCharacteristicData firstFirstName = new UDSCharacteristicData(FIRST_NAME_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstLastName = new UDSCharacteristicData(LAST_NAME_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstEmailAddress = new UDSCharacteristicData(EMAIL_ADDRESS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAge = new UDSCharacteristicData(AGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstDateOfBirth = new UDSCharacteristicData(DATE_OF_BIRTH_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstGender = new UDSCharacteristicData(GENDER_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstWeight = new UDSCharacteristicData(WEIGHT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstHeight = new UDSCharacteristicData(HEIGHT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstVo2Max = new UDSCharacteristicData(VO2_MAX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstHeartRateMax = new UDSCharacteristicData(HEART_RATE_MAX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstRestingHeartRate = new UDSCharacteristicData(RESTING_HEART_RATE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstMaximumRecommendedHeartRate = new UDSCharacteristicData(MAXIMUM_RECOMMENDED_HEART_RATE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAerobicThreshold = new UDSCharacteristicData(AEROBIC_THRESHOLD_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAnaerobicThreshold = new UDSCharacteristicData(ANAEROBIC_THRESHOLD_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstSportTypeForAerobicAndAnaerobicThresholds = new UDSCharacteristicData(SPORT_TYPE_FOR_AEROBIC_AND_ANAEROBIC_THRESHOLDS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstDateOfThresholdAssessment = new UDSCharacteristicData(DATE_OF_THRESHOLD_ASSESSMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstWaistCircumference = new UDSCharacteristicData(WAIST_CIRCUMFERENCE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstHipCircumference = new UDSCharacteristicData(HIP_CIRCUMFERENCE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstFatBurnHeartRateLowerLimit = new UDSCharacteristicData(FAT_BURN_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstFatBurnHeartRateUpperLimit = new UDSCharacteristicData(FAT_BURN_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAerobicHeartRateLowerLimit = new UDSCharacteristicData(AEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAerobicHeartRateUpperLimit = new UDSCharacteristicData(AEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAnaerobicHeartRateLowerLimit = new UDSCharacteristicData(ANAEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAnaerobicHeartRateUpperLimit = new UDSCharacteristicData(ANAEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstFiveZoneHeartRateLimits = new UDSCharacteristicData(FIVE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstThreeZoneHeartRateLimits = new UDSCharacteristicData(THREE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstTwoZoneHeartRateLimit = new UDSCharacteristicData(TWO_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstLanguage = new UDSCharacteristicData(LANGUAGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstDatabaseChangeIncrement = new CharacteristicData(DATABASE_CHANGE_INCREMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstUserIndex = new CharacteristicData(USER_INDEX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UserControlPointCharacteristicData firstUserControlPoint = new UserControlPointCharacteristicData(1
                , 2
                , new ArrayList<>()
                , 3
                , 5
                , 6
                , 7
                , 8
                , 9);
        CharacteristicData firstRegisteredUser = new CharacteristicData(REGISTERED_USER_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);

        UserDataServiceData result1 = new UserDataServiceData(firstFirstName
                , firstLastName
                , firstEmailAddress
                , firstAge
                , firstDateOfBirth
                , firstGender
                , firstWeight
                , firstHeight
                , firstVo2Max
                , firstHeartRateMax
                , firstRestingHeartRate
                , firstMaximumRecommendedHeartRate
                , firstAerobicThreshold
                , firstAnaerobicThreshold
                , firstSportTypeForAerobicAndAnaerobicThresholds
                , firstDateOfThresholdAssessment
                , firstWaistCircumference
                , firstHipCircumference
                , firstFatBurnHeartRateLowerLimit
                , firstFatBurnHeartRateUpperLimit
                , firstAerobicHeartRateLowerLimit
                , firstAerobicHeartRateUpperLimit
                , firstAnaerobicHeartRateLowerLimit
                , firstAnaerobicHeartRateUpperLimit
                , firstFiveZoneHeartRateLimits
                , firstThreeZoneHeartRateLimits
                , firstTwoZoneHeartRateLimit
                , firstLanguage
                , firstDatabaseChangeIncrement
                , firstUserIndex
                , firstUserControlPoint
                , firstRegisteredUser);

        UserDataServiceData result2 = new UserDataServiceData(firstFirstName
                , firstLastName
                , firstEmailAddress
                , firstAge
                , firstDateOfBirth
                , firstGender
                , firstWeight
                , firstHeight
                , firstVo2Max
                , firstHeartRateMax
                , firstRestingHeartRate
                , firstMaximumRecommendedHeartRate
                , firstAerobicThreshold
                , firstAnaerobicThreshold
                , firstSportTypeForAerobicAndAnaerobicThresholds
                , firstDateOfThresholdAssessment
                , firstWaistCircumference
                , firstHipCircumference
                , firstFatBurnHeartRateLowerLimit
                , firstFatBurnHeartRateUpperLimit
                , firstAerobicHeartRateLowerLimit
                , firstAerobicHeartRateUpperLimit
                , firstAnaerobicHeartRateLowerLimit
                , firstAnaerobicHeartRateUpperLimit
                , firstFiveZoneHeartRateLimits
                , firstThreeZoneHeartRateLimits
                , firstTwoZoneHeartRateLimit
                , firstLanguage
                , firstDatabaseChangeIncrement
                , firstUserIndex
                , firstUserControlPoint
                , firstRegisteredUser);
        assertEquals(result1, result2);
    }

    @Test
    public void test_equals_00103() {
        UDSCharacteristicData firstFirstName = new UDSCharacteristicData(FIRST_NAME_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstEmailAddress = new UDSCharacteristicData(EMAIL_ADDRESS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAge = new UDSCharacteristicData(AGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstDateOfBirth = new UDSCharacteristicData(DATE_OF_BIRTH_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstGender = new UDSCharacteristicData(GENDER_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstWeight = new UDSCharacteristicData(WEIGHT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstHeight = new UDSCharacteristicData(HEIGHT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstVo2Max = new UDSCharacteristicData(VO2_MAX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstHeartRateMax = new UDSCharacteristicData(HEART_RATE_MAX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstRestingHeartRate = new UDSCharacteristicData(RESTING_HEART_RATE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstMaximumRecommendedHeartRate = new UDSCharacteristicData(MAXIMUM_RECOMMENDED_HEART_RATE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAerobicThreshold = new UDSCharacteristicData(AEROBIC_THRESHOLD_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAnaerobicThreshold = new UDSCharacteristicData(ANAEROBIC_THRESHOLD_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstSportTypeForAerobicAndAnaerobicThresholds = new UDSCharacteristicData(SPORT_TYPE_FOR_AEROBIC_AND_ANAEROBIC_THRESHOLDS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstDateOfThresholdAssessment = new UDSCharacteristicData(DATE_OF_THRESHOLD_ASSESSMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstWaistCircumference = new UDSCharacteristicData(WAIST_CIRCUMFERENCE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstHipCircumference = new UDSCharacteristicData(HIP_CIRCUMFERENCE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstFatBurnHeartRateLowerLimit = new UDSCharacteristicData(FAT_BURN_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstFatBurnHeartRateUpperLimit = new UDSCharacteristicData(FAT_BURN_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAerobicHeartRateLowerLimit = new UDSCharacteristicData(AEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAerobicHeartRateUpperLimit = new UDSCharacteristicData(AEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAnaerobicHeartRateLowerLimit = new UDSCharacteristicData(ANAEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAnaerobicHeartRateUpperLimit = new UDSCharacteristicData(ANAEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstFiveZoneHeartRateLimits = new UDSCharacteristicData(FIVE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstThreeZoneHeartRateLimits = new UDSCharacteristicData(THREE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstTwoZoneHeartRateLimit = new UDSCharacteristicData(TWO_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstLanguage = new UDSCharacteristicData(LANGUAGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstDatabaseChangeIncrement = new CharacteristicData(DATABASE_CHANGE_INCREMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstUserIndex = new CharacteristicData(USER_INDEX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UserControlPointCharacteristicData firstUserControlPoint = new UserControlPointCharacteristicData(1
                , 2
                , new ArrayList<>()
                , 3
                , 5
                , 6
                , 7
                , 8
                , 9);
        CharacteristicData firstRegisteredUser = new CharacteristicData(REGISTERED_USER_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);

        UserDataServiceData result1 = new UserDataServiceData(firstFirstName
                , null
                , firstEmailAddress
                , firstAge
                , firstDateOfBirth
                , firstGender
                , firstWeight
                , firstHeight
                , firstVo2Max
                , firstHeartRateMax
                , firstRestingHeartRate
                , firstMaximumRecommendedHeartRate
                , firstAerobicThreshold
                , firstAnaerobicThreshold
                , firstSportTypeForAerobicAndAnaerobicThresholds
                , firstDateOfThresholdAssessment
                , firstWaistCircumference
                , firstHipCircumference
                , firstFatBurnHeartRateLowerLimit
                , firstFatBurnHeartRateUpperLimit
                , firstAerobicHeartRateLowerLimit
                , firstAerobicHeartRateUpperLimit
                , firstAnaerobicHeartRateLowerLimit
                , firstAnaerobicHeartRateUpperLimit
                , firstFiveZoneHeartRateLimits
                , firstThreeZoneHeartRateLimits
                , firstTwoZoneHeartRateLimit
                , firstLanguage
                , firstDatabaseChangeIncrement
                , firstUserIndex
                , firstUserControlPoint
                , firstRegisteredUser);

        UserDataServiceData result2 = new UserDataServiceData(firstFirstName
                , null
                , firstEmailAddress
                , firstAge
                , firstDateOfBirth
                , firstGender
                , firstWeight
                , firstHeight
                , firstVo2Max
                , firstHeartRateMax
                , firstRestingHeartRate
                , firstMaximumRecommendedHeartRate
                , firstAerobicThreshold
                , firstAnaerobicThreshold
                , firstSportTypeForAerobicAndAnaerobicThresholds
                , firstDateOfThresholdAssessment
                , firstWaistCircumference
                , firstHipCircumference
                , firstFatBurnHeartRateLowerLimit
                , firstFatBurnHeartRateUpperLimit
                , firstAerobicHeartRateLowerLimit
                , firstAerobicHeartRateUpperLimit
                , firstAnaerobicHeartRateLowerLimit
                , firstAnaerobicHeartRateUpperLimit
                , firstFiveZoneHeartRateLimits
                , firstThreeZoneHeartRateLimits
                , firstTwoZoneHeartRateLimit
                , firstLanguage
                , firstDatabaseChangeIncrement
                , firstUserIndex
                , firstUserControlPoint
                , firstRegisteredUser);
        assertEquals(result1, result2);
    }

    @Test
    public void test_equals_00104() {
        UDSCharacteristicData firstFirstName = new UDSCharacteristicData(FIRST_NAME_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstLastName = new UDSCharacteristicData(LAST_NAME_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAge = new UDSCharacteristicData(AGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstDateOfBirth = new UDSCharacteristicData(DATE_OF_BIRTH_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstGender = new UDSCharacteristicData(GENDER_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstWeight = new UDSCharacteristicData(WEIGHT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstHeight = new UDSCharacteristicData(HEIGHT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstVo2Max = new UDSCharacteristicData(VO2_MAX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstHeartRateMax = new UDSCharacteristicData(HEART_RATE_MAX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstRestingHeartRate = new UDSCharacteristicData(RESTING_HEART_RATE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstMaximumRecommendedHeartRate = new UDSCharacteristicData(MAXIMUM_RECOMMENDED_HEART_RATE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAerobicThreshold = new UDSCharacteristicData(AEROBIC_THRESHOLD_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAnaerobicThreshold = new UDSCharacteristicData(ANAEROBIC_THRESHOLD_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstSportTypeForAerobicAndAnaerobicThresholds = new UDSCharacteristicData(SPORT_TYPE_FOR_AEROBIC_AND_ANAEROBIC_THRESHOLDS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstDateOfThresholdAssessment = new UDSCharacteristicData(DATE_OF_THRESHOLD_ASSESSMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstWaistCircumference = new UDSCharacteristicData(WAIST_CIRCUMFERENCE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstHipCircumference = new UDSCharacteristicData(HIP_CIRCUMFERENCE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstFatBurnHeartRateLowerLimit = new UDSCharacteristicData(FAT_BURN_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstFatBurnHeartRateUpperLimit = new UDSCharacteristicData(FAT_BURN_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAerobicHeartRateLowerLimit = new UDSCharacteristicData(AEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAerobicHeartRateUpperLimit = new UDSCharacteristicData(AEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAnaerobicHeartRateLowerLimit = new UDSCharacteristicData(ANAEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAnaerobicHeartRateUpperLimit = new UDSCharacteristicData(ANAEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstFiveZoneHeartRateLimits = new UDSCharacteristicData(FIVE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstThreeZoneHeartRateLimits = new UDSCharacteristicData(THREE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstTwoZoneHeartRateLimit = new UDSCharacteristicData(TWO_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstLanguage = new UDSCharacteristicData(LANGUAGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstDatabaseChangeIncrement = new CharacteristicData(DATABASE_CHANGE_INCREMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstUserIndex = new CharacteristicData(USER_INDEX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UserControlPointCharacteristicData firstUserControlPoint = new UserControlPointCharacteristicData(1
                , 2
                , new ArrayList<>()
                , 3
                , 5
                , 6
                , 7
                , 8
                , 9);
        CharacteristicData firstRegisteredUser = new CharacteristicData(REGISTERED_USER_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);

        UserDataServiceData result1 = new UserDataServiceData(firstFirstName
                , firstLastName
                , null
                , firstAge
                , firstDateOfBirth
                , firstGender
                , firstWeight
                , firstHeight
                , firstVo2Max
                , firstHeartRateMax
                , firstRestingHeartRate
                , firstMaximumRecommendedHeartRate
                , firstAerobicThreshold
                , firstAnaerobicThreshold
                , firstSportTypeForAerobicAndAnaerobicThresholds
                , firstDateOfThresholdAssessment
                , firstWaistCircumference
                , firstHipCircumference
                , firstFatBurnHeartRateLowerLimit
                , firstFatBurnHeartRateUpperLimit
                , firstAerobicHeartRateLowerLimit
                , firstAerobicHeartRateUpperLimit
                , firstAnaerobicHeartRateLowerLimit
                , firstAnaerobicHeartRateUpperLimit
                , firstFiveZoneHeartRateLimits
                , firstThreeZoneHeartRateLimits
                , firstTwoZoneHeartRateLimit
                , firstLanguage
                , firstDatabaseChangeIncrement
                , firstUserIndex
                , firstUserControlPoint
                , firstRegisteredUser);

        UserDataServiceData result2 = new UserDataServiceData(firstFirstName
                , firstLastName
                , null
                , firstAge
                , firstDateOfBirth
                , firstGender
                , firstWeight
                , firstHeight
                , firstVo2Max
                , firstHeartRateMax
                , firstRestingHeartRate
                , firstMaximumRecommendedHeartRate
                , firstAerobicThreshold
                , firstAnaerobicThreshold
                , firstSportTypeForAerobicAndAnaerobicThresholds
                , firstDateOfThresholdAssessment
                , firstWaistCircumference
                , firstHipCircumference
                , firstFatBurnHeartRateLowerLimit
                , firstFatBurnHeartRateUpperLimit
                , firstAerobicHeartRateLowerLimit
                , firstAerobicHeartRateUpperLimit
                , firstAnaerobicHeartRateLowerLimit
                , firstAnaerobicHeartRateUpperLimit
                , firstFiveZoneHeartRateLimits
                , firstThreeZoneHeartRateLimits
                , firstTwoZoneHeartRateLimit
                , firstLanguage
                , firstDatabaseChangeIncrement
                , firstUserIndex
                , firstUserControlPoint
                , firstRegisteredUser);
        assertEquals(result1, result2);
    }

    @Test
    public void test_equals_00105() {
        UDSCharacteristicData firstFirstName = new UDSCharacteristicData(FIRST_NAME_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstLastName = new UDSCharacteristicData(LAST_NAME_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstEmailAddress = new UDSCharacteristicData(EMAIL_ADDRESS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstDateOfBirth = new UDSCharacteristicData(DATE_OF_BIRTH_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstGender = new UDSCharacteristicData(GENDER_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstWeight = new UDSCharacteristicData(WEIGHT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstHeight = new UDSCharacteristicData(HEIGHT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstVo2Max = new UDSCharacteristicData(VO2_MAX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstHeartRateMax = new UDSCharacteristicData(HEART_RATE_MAX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstRestingHeartRate = new UDSCharacteristicData(RESTING_HEART_RATE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstMaximumRecommendedHeartRate = new UDSCharacteristicData(MAXIMUM_RECOMMENDED_HEART_RATE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAerobicThreshold = new UDSCharacteristicData(AEROBIC_THRESHOLD_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAnaerobicThreshold = new UDSCharacteristicData(ANAEROBIC_THRESHOLD_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstSportTypeForAerobicAndAnaerobicThresholds = new UDSCharacteristicData(SPORT_TYPE_FOR_AEROBIC_AND_ANAEROBIC_THRESHOLDS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstDateOfThresholdAssessment = new UDSCharacteristicData(DATE_OF_THRESHOLD_ASSESSMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstWaistCircumference = new UDSCharacteristicData(WAIST_CIRCUMFERENCE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstHipCircumference = new UDSCharacteristicData(HIP_CIRCUMFERENCE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstFatBurnHeartRateLowerLimit = new UDSCharacteristicData(FAT_BURN_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstFatBurnHeartRateUpperLimit = new UDSCharacteristicData(FAT_BURN_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAerobicHeartRateLowerLimit = new UDSCharacteristicData(AEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAerobicHeartRateUpperLimit = new UDSCharacteristicData(AEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAnaerobicHeartRateLowerLimit = new UDSCharacteristicData(ANAEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAnaerobicHeartRateUpperLimit = new UDSCharacteristicData(ANAEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstFiveZoneHeartRateLimits = new UDSCharacteristicData(FIVE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstThreeZoneHeartRateLimits = new UDSCharacteristicData(THREE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstTwoZoneHeartRateLimit = new UDSCharacteristicData(TWO_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstLanguage = new UDSCharacteristicData(LANGUAGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstDatabaseChangeIncrement = new CharacteristicData(DATABASE_CHANGE_INCREMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstUserIndex = new CharacteristicData(USER_INDEX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UserControlPointCharacteristicData firstUserControlPoint = new UserControlPointCharacteristicData(1
                , 2
                , new ArrayList<>()
                , 3
                , 5
                , 6
                , 7
                , 8
                , 9);
        CharacteristicData firstRegisteredUser = new CharacteristicData(REGISTERED_USER_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);

        UserDataServiceData result1 = new UserDataServiceData(firstFirstName
                , firstLastName
                , firstEmailAddress
                , null
                , firstDateOfBirth
                , firstGender
                , firstWeight
                , firstHeight
                , firstVo2Max
                , firstHeartRateMax
                , firstRestingHeartRate
                , firstMaximumRecommendedHeartRate
                , firstAerobicThreshold
                , firstAnaerobicThreshold
                , firstSportTypeForAerobicAndAnaerobicThresholds
                , firstDateOfThresholdAssessment
                , firstWaistCircumference
                , firstHipCircumference
                , firstFatBurnHeartRateLowerLimit
                , firstFatBurnHeartRateUpperLimit
                , firstAerobicHeartRateLowerLimit
                , firstAerobicHeartRateUpperLimit
                , firstAnaerobicHeartRateLowerLimit
                , firstAnaerobicHeartRateUpperLimit
                , firstFiveZoneHeartRateLimits
                , firstThreeZoneHeartRateLimits
                , firstTwoZoneHeartRateLimit
                , firstLanguage
                , firstDatabaseChangeIncrement
                , firstUserIndex
                , firstUserControlPoint
                , firstRegisteredUser);

        UserDataServiceData result2 = new UserDataServiceData(firstFirstName
                , firstLastName
                , firstEmailAddress
                , null
                , firstDateOfBirth
                , firstGender
                , firstWeight
                , firstHeight
                , firstVo2Max
                , firstHeartRateMax
                , firstRestingHeartRate
                , firstMaximumRecommendedHeartRate
                , firstAerobicThreshold
                , firstAnaerobicThreshold
                , firstSportTypeForAerobicAndAnaerobicThresholds
                , firstDateOfThresholdAssessment
                , firstWaistCircumference
                , firstHipCircumference
                , firstFatBurnHeartRateLowerLimit
                , firstFatBurnHeartRateUpperLimit
                , firstAerobicHeartRateLowerLimit
                , firstAerobicHeartRateUpperLimit
                , firstAnaerobicHeartRateLowerLimit
                , firstAnaerobicHeartRateUpperLimit
                , firstFiveZoneHeartRateLimits
                , firstThreeZoneHeartRateLimits
                , firstTwoZoneHeartRateLimit
                , firstLanguage
                , firstDatabaseChangeIncrement
                , firstUserIndex
                , firstUserControlPoint
                , firstRegisteredUser);
        assertEquals(result1, result2);
    }

    @Test
    public void test_equals_00106() {
        UDSCharacteristicData firstFirstName = new UDSCharacteristicData(FIRST_NAME_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstLastName = new UDSCharacteristicData(LAST_NAME_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstEmailAddress = new UDSCharacteristicData(EMAIL_ADDRESS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAge = new UDSCharacteristicData(AGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstGender = new UDSCharacteristicData(GENDER_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstWeight = new UDSCharacteristicData(WEIGHT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstHeight = new UDSCharacteristicData(HEIGHT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstVo2Max = new UDSCharacteristicData(VO2_MAX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstHeartRateMax = new UDSCharacteristicData(HEART_RATE_MAX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstRestingHeartRate = new UDSCharacteristicData(RESTING_HEART_RATE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstMaximumRecommendedHeartRate = new UDSCharacteristicData(MAXIMUM_RECOMMENDED_HEART_RATE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAerobicThreshold = new UDSCharacteristicData(AEROBIC_THRESHOLD_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAnaerobicThreshold = new UDSCharacteristicData(ANAEROBIC_THRESHOLD_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstSportTypeForAerobicAndAnaerobicThresholds = new UDSCharacteristicData(SPORT_TYPE_FOR_AEROBIC_AND_ANAEROBIC_THRESHOLDS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstDateOfThresholdAssessment = new UDSCharacteristicData(DATE_OF_THRESHOLD_ASSESSMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstWaistCircumference = new UDSCharacteristicData(WAIST_CIRCUMFERENCE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstHipCircumference = new UDSCharacteristicData(HIP_CIRCUMFERENCE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstFatBurnHeartRateLowerLimit = new UDSCharacteristicData(FAT_BURN_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstFatBurnHeartRateUpperLimit = new UDSCharacteristicData(FAT_BURN_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAerobicHeartRateLowerLimit = new UDSCharacteristicData(AEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAerobicHeartRateUpperLimit = new UDSCharacteristicData(AEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAnaerobicHeartRateLowerLimit = new UDSCharacteristicData(ANAEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAnaerobicHeartRateUpperLimit = new UDSCharacteristicData(ANAEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstFiveZoneHeartRateLimits = new UDSCharacteristicData(FIVE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstThreeZoneHeartRateLimits = new UDSCharacteristicData(THREE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstTwoZoneHeartRateLimit = new UDSCharacteristicData(TWO_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstLanguage = new UDSCharacteristicData(LANGUAGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstDatabaseChangeIncrement = new CharacteristicData(DATABASE_CHANGE_INCREMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstUserIndex = new CharacteristicData(USER_INDEX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UserControlPointCharacteristicData firstUserControlPoint = new UserControlPointCharacteristicData(1
                , 2
                , new ArrayList<>()
                , 3
                , 5
                , 6
                , 7
                , 8
                , 9);
        CharacteristicData firstRegisteredUser = new CharacteristicData(REGISTERED_USER_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);

        UserDataServiceData result1 = new UserDataServiceData(firstFirstName
                , firstLastName
                , firstEmailAddress
                , firstAge
                , null
                , firstGender
                , firstWeight
                , firstHeight
                , firstVo2Max
                , firstHeartRateMax
                , firstRestingHeartRate
                , firstMaximumRecommendedHeartRate
                , firstAerobicThreshold
                , firstAnaerobicThreshold
                , firstSportTypeForAerobicAndAnaerobicThresholds
                , firstDateOfThresholdAssessment
                , firstWaistCircumference
                , firstHipCircumference
                , firstFatBurnHeartRateLowerLimit
                , firstFatBurnHeartRateUpperLimit
                , firstAerobicHeartRateLowerLimit
                , firstAerobicHeartRateUpperLimit
                , firstAnaerobicHeartRateLowerLimit
                , firstAnaerobicHeartRateUpperLimit
                , firstFiveZoneHeartRateLimits
                , firstThreeZoneHeartRateLimits
                , firstTwoZoneHeartRateLimit
                , firstLanguage
                , firstDatabaseChangeIncrement
                , firstUserIndex
                , firstUserControlPoint
                , firstRegisteredUser);

        UserDataServiceData result2 = new UserDataServiceData(firstFirstName
                , firstLastName
                , firstEmailAddress
                , firstAge
                , null
                , firstGender
                , firstWeight
                , firstHeight
                , firstVo2Max
                , firstHeartRateMax
                , firstRestingHeartRate
                , firstMaximumRecommendedHeartRate
                , firstAerobicThreshold
                , firstAnaerobicThreshold
                , firstSportTypeForAerobicAndAnaerobicThresholds
                , firstDateOfThresholdAssessment
                , firstWaistCircumference
                , firstHipCircumference
                , firstFatBurnHeartRateLowerLimit
                , firstFatBurnHeartRateUpperLimit
                , firstAerobicHeartRateLowerLimit
                , firstAerobicHeartRateUpperLimit
                , firstAnaerobicHeartRateLowerLimit
                , firstAnaerobicHeartRateUpperLimit
                , firstFiveZoneHeartRateLimits
                , firstThreeZoneHeartRateLimits
                , firstTwoZoneHeartRateLimit
                , firstLanguage
                , firstDatabaseChangeIncrement
                , firstUserIndex
                , firstUserControlPoint
                , firstRegisteredUser);
        assertEquals(result1, result2);
    }

    @Test
    public void test_equals_00107() {
        UDSCharacteristicData firstFirstName = new UDSCharacteristicData(FIRST_NAME_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstLastName = new UDSCharacteristicData(LAST_NAME_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstEmailAddress = new UDSCharacteristicData(EMAIL_ADDRESS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAge = new UDSCharacteristicData(AGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstDateOfBirth = new UDSCharacteristicData(DATE_OF_BIRTH_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstWeight = new UDSCharacteristicData(WEIGHT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstHeight = new UDSCharacteristicData(HEIGHT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstVo2Max = new UDSCharacteristicData(VO2_MAX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstHeartRateMax = new UDSCharacteristicData(HEART_RATE_MAX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstRestingHeartRate = new UDSCharacteristicData(RESTING_HEART_RATE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstMaximumRecommendedHeartRate = new UDSCharacteristicData(MAXIMUM_RECOMMENDED_HEART_RATE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAerobicThreshold = new UDSCharacteristicData(AEROBIC_THRESHOLD_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAnaerobicThreshold = new UDSCharacteristicData(ANAEROBIC_THRESHOLD_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstSportTypeForAerobicAndAnaerobicThresholds = new UDSCharacteristicData(SPORT_TYPE_FOR_AEROBIC_AND_ANAEROBIC_THRESHOLDS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstDateOfThresholdAssessment = new UDSCharacteristicData(DATE_OF_THRESHOLD_ASSESSMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstWaistCircumference = new UDSCharacteristicData(WAIST_CIRCUMFERENCE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstHipCircumference = new UDSCharacteristicData(HIP_CIRCUMFERENCE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstFatBurnHeartRateLowerLimit = new UDSCharacteristicData(FAT_BURN_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstFatBurnHeartRateUpperLimit = new UDSCharacteristicData(FAT_BURN_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAerobicHeartRateLowerLimit = new UDSCharacteristicData(AEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAerobicHeartRateUpperLimit = new UDSCharacteristicData(AEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAnaerobicHeartRateLowerLimit = new UDSCharacteristicData(ANAEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAnaerobicHeartRateUpperLimit = new UDSCharacteristicData(ANAEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstFiveZoneHeartRateLimits = new UDSCharacteristicData(FIVE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstThreeZoneHeartRateLimits = new UDSCharacteristicData(THREE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstTwoZoneHeartRateLimit = new UDSCharacteristicData(TWO_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstLanguage = new UDSCharacteristicData(LANGUAGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstDatabaseChangeIncrement = new CharacteristicData(DATABASE_CHANGE_INCREMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstUserIndex = new CharacteristicData(USER_INDEX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UserControlPointCharacteristicData firstUserControlPoint = new UserControlPointCharacteristicData(1
                , 2
                , new ArrayList<>()
                , 3
                , 5
                , 6
                , 7
                , 8
                , 9);
        CharacteristicData firstRegisteredUser = new CharacteristicData(REGISTERED_USER_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);

        UserDataServiceData result1 = new UserDataServiceData(firstFirstName
                , firstLastName
                , firstEmailAddress
                , firstAge
                , firstDateOfBirth
                , null
                , firstWeight
                , firstHeight
                , firstVo2Max
                , firstHeartRateMax
                , firstRestingHeartRate
                , firstMaximumRecommendedHeartRate
                , firstAerobicThreshold
                , firstAnaerobicThreshold
                , firstSportTypeForAerobicAndAnaerobicThresholds
                , firstDateOfThresholdAssessment
                , firstWaistCircumference
                , firstHipCircumference
                , firstFatBurnHeartRateLowerLimit
                , firstFatBurnHeartRateUpperLimit
                , firstAerobicHeartRateLowerLimit
                , firstAerobicHeartRateUpperLimit
                , firstAnaerobicHeartRateLowerLimit
                , firstAnaerobicHeartRateUpperLimit
                , firstFiveZoneHeartRateLimits
                , firstThreeZoneHeartRateLimits
                , firstTwoZoneHeartRateLimit
                , firstLanguage
                , firstDatabaseChangeIncrement
                , firstUserIndex
                , firstUserControlPoint
                , firstRegisteredUser);

        UserDataServiceData result2 = new UserDataServiceData(firstFirstName
                , firstLastName
                , firstEmailAddress
                , firstAge
                , firstDateOfBirth
                , null
                , firstWeight
                , firstHeight
                , firstVo2Max
                , firstHeartRateMax
                , firstRestingHeartRate
                , firstMaximumRecommendedHeartRate
                , firstAerobicThreshold
                , firstAnaerobicThreshold
                , firstSportTypeForAerobicAndAnaerobicThresholds
                , firstDateOfThresholdAssessment
                , firstWaistCircumference
                , firstHipCircumference
                , firstFatBurnHeartRateLowerLimit
                , firstFatBurnHeartRateUpperLimit
                , firstAerobicHeartRateLowerLimit
                , firstAerobicHeartRateUpperLimit
                , firstAnaerobicHeartRateLowerLimit
                , firstAnaerobicHeartRateUpperLimit
                , firstFiveZoneHeartRateLimits
                , firstThreeZoneHeartRateLimits
                , firstTwoZoneHeartRateLimit
                , firstLanguage
                , firstDatabaseChangeIncrement
                , firstUserIndex
                , firstUserControlPoint
                , firstRegisteredUser);
        assertEquals(result1, result2);
    }

    @Test
    public void test_equals_00108() {
        UDSCharacteristicData firstFirstName = new UDSCharacteristicData(FIRST_NAME_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstLastName = new UDSCharacteristicData(LAST_NAME_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstEmailAddress = new UDSCharacteristicData(EMAIL_ADDRESS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAge = new UDSCharacteristicData(AGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstDateOfBirth = new UDSCharacteristicData(DATE_OF_BIRTH_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstGender = new UDSCharacteristicData(GENDER_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstHeight = new UDSCharacteristicData(HEIGHT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstVo2Max = new UDSCharacteristicData(VO2_MAX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstHeartRateMax = new UDSCharacteristicData(HEART_RATE_MAX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstRestingHeartRate = new UDSCharacteristicData(RESTING_HEART_RATE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstMaximumRecommendedHeartRate = new UDSCharacteristicData(MAXIMUM_RECOMMENDED_HEART_RATE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAerobicThreshold = new UDSCharacteristicData(AEROBIC_THRESHOLD_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAnaerobicThreshold = new UDSCharacteristicData(ANAEROBIC_THRESHOLD_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstSportTypeForAerobicAndAnaerobicThresholds = new UDSCharacteristicData(SPORT_TYPE_FOR_AEROBIC_AND_ANAEROBIC_THRESHOLDS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstDateOfThresholdAssessment = new UDSCharacteristicData(DATE_OF_THRESHOLD_ASSESSMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstWaistCircumference = new UDSCharacteristicData(WAIST_CIRCUMFERENCE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstHipCircumference = new UDSCharacteristicData(HIP_CIRCUMFERENCE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstFatBurnHeartRateLowerLimit = new UDSCharacteristicData(FAT_BURN_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstFatBurnHeartRateUpperLimit = new UDSCharacteristicData(FAT_BURN_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAerobicHeartRateLowerLimit = new UDSCharacteristicData(AEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAerobicHeartRateUpperLimit = new UDSCharacteristicData(AEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAnaerobicHeartRateLowerLimit = new UDSCharacteristicData(ANAEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAnaerobicHeartRateUpperLimit = new UDSCharacteristicData(ANAEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstFiveZoneHeartRateLimits = new UDSCharacteristicData(FIVE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstThreeZoneHeartRateLimits = new UDSCharacteristicData(THREE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstTwoZoneHeartRateLimit = new UDSCharacteristicData(TWO_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstLanguage = new UDSCharacteristicData(LANGUAGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstDatabaseChangeIncrement = new CharacteristicData(DATABASE_CHANGE_INCREMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstUserIndex = new CharacteristicData(USER_INDEX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UserControlPointCharacteristicData firstUserControlPoint = new UserControlPointCharacteristicData(1
                , 2
                , new ArrayList<>()
                , 3
                , 5
                , 6
                , 7
                , 8
                , 9);
        CharacteristicData firstRegisteredUser = new CharacteristicData(REGISTERED_USER_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);

        UserDataServiceData result1 = new UserDataServiceData(firstFirstName
                , firstLastName
                , firstEmailAddress
                , firstAge
                , firstDateOfBirth
                , firstGender
                , null
                , firstHeight
                , firstVo2Max
                , firstHeartRateMax
                , firstRestingHeartRate
                , firstMaximumRecommendedHeartRate
                , firstAerobicThreshold
                , firstAnaerobicThreshold
                , firstSportTypeForAerobicAndAnaerobicThresholds
                , firstDateOfThresholdAssessment
                , firstWaistCircumference
                , firstHipCircumference
                , firstFatBurnHeartRateLowerLimit
                , firstFatBurnHeartRateUpperLimit
                , firstAerobicHeartRateLowerLimit
                , firstAerobicHeartRateUpperLimit
                , firstAnaerobicHeartRateLowerLimit
                , firstAnaerobicHeartRateUpperLimit
                , firstFiveZoneHeartRateLimits
                , firstThreeZoneHeartRateLimits
                , firstTwoZoneHeartRateLimit
                , firstLanguage
                , firstDatabaseChangeIncrement
                , firstUserIndex
                , firstUserControlPoint
                , firstRegisteredUser);

        UserDataServiceData result2 = new UserDataServiceData(firstFirstName
                , firstLastName
                , firstEmailAddress
                , firstAge
                , firstDateOfBirth
                , firstGender
                , null
                , firstHeight
                , firstVo2Max
                , firstHeartRateMax
                , firstRestingHeartRate
                , firstMaximumRecommendedHeartRate
                , firstAerobicThreshold
                , firstAnaerobicThreshold
                , firstSportTypeForAerobicAndAnaerobicThresholds
                , firstDateOfThresholdAssessment
                , firstWaistCircumference
                , firstHipCircumference
                , firstFatBurnHeartRateLowerLimit
                , firstFatBurnHeartRateUpperLimit
                , firstAerobicHeartRateLowerLimit
                , firstAerobicHeartRateUpperLimit
                , firstAnaerobicHeartRateLowerLimit
                , firstAnaerobicHeartRateUpperLimit
                , firstFiveZoneHeartRateLimits
                , firstThreeZoneHeartRateLimits
                , firstTwoZoneHeartRateLimit
                , firstLanguage
                , firstDatabaseChangeIncrement
                , firstUserIndex
                , firstUserControlPoint
                , firstRegisteredUser);
        assertEquals(result1, result2);
    }

    @Test
    public void test_equals_00109() {
        UDSCharacteristicData firstFirstName = new UDSCharacteristicData(FIRST_NAME_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstLastName = new UDSCharacteristicData(LAST_NAME_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstEmailAddress = new UDSCharacteristicData(EMAIL_ADDRESS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAge = new UDSCharacteristicData(AGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstDateOfBirth = new UDSCharacteristicData(DATE_OF_BIRTH_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstGender = new UDSCharacteristicData(GENDER_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstWeight = new UDSCharacteristicData(WEIGHT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstVo2Max = new UDSCharacteristicData(VO2_MAX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstHeartRateMax = new UDSCharacteristicData(HEART_RATE_MAX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstRestingHeartRate = new UDSCharacteristicData(RESTING_HEART_RATE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstMaximumRecommendedHeartRate = new UDSCharacteristicData(MAXIMUM_RECOMMENDED_HEART_RATE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAerobicThreshold = new UDSCharacteristicData(AEROBIC_THRESHOLD_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAnaerobicThreshold = new UDSCharacteristicData(ANAEROBIC_THRESHOLD_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstSportTypeForAerobicAndAnaerobicThresholds = new UDSCharacteristicData(SPORT_TYPE_FOR_AEROBIC_AND_ANAEROBIC_THRESHOLDS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstDateOfThresholdAssessment = new UDSCharacteristicData(DATE_OF_THRESHOLD_ASSESSMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstWaistCircumference = new UDSCharacteristicData(WAIST_CIRCUMFERENCE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstHipCircumference = new UDSCharacteristicData(HIP_CIRCUMFERENCE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstFatBurnHeartRateLowerLimit = new UDSCharacteristicData(FAT_BURN_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstFatBurnHeartRateUpperLimit = new UDSCharacteristicData(FAT_BURN_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAerobicHeartRateLowerLimit = new UDSCharacteristicData(AEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAerobicHeartRateUpperLimit = new UDSCharacteristicData(AEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAnaerobicHeartRateLowerLimit = new UDSCharacteristicData(ANAEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAnaerobicHeartRateUpperLimit = new UDSCharacteristicData(ANAEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstFiveZoneHeartRateLimits = new UDSCharacteristicData(FIVE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstThreeZoneHeartRateLimits = new UDSCharacteristicData(THREE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstTwoZoneHeartRateLimit = new UDSCharacteristicData(TWO_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstLanguage = new UDSCharacteristicData(LANGUAGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstDatabaseChangeIncrement = new CharacteristicData(DATABASE_CHANGE_INCREMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstUserIndex = new CharacteristicData(USER_INDEX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UserControlPointCharacteristicData firstUserControlPoint = new UserControlPointCharacteristicData(1
                , 2
                , new ArrayList<>()
                , 3
                , 5
                , 6
                , 7
                , 8
                , 9);
        CharacteristicData firstRegisteredUser = new CharacteristicData(REGISTERED_USER_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);

        UserDataServiceData result1 = new UserDataServiceData(firstFirstName
                , firstLastName
                , firstEmailAddress
                , firstAge
                , firstDateOfBirth
                , firstGender
                , firstWeight
                , null
                , firstVo2Max
                , firstHeartRateMax
                , firstRestingHeartRate
                , firstMaximumRecommendedHeartRate
                , firstAerobicThreshold
                , firstAnaerobicThreshold
                , firstSportTypeForAerobicAndAnaerobicThresholds
                , firstDateOfThresholdAssessment
                , firstWaistCircumference
                , firstHipCircumference
                , firstFatBurnHeartRateLowerLimit
                , firstFatBurnHeartRateUpperLimit
                , firstAerobicHeartRateLowerLimit
                , firstAerobicHeartRateUpperLimit
                , firstAnaerobicHeartRateLowerLimit
                , firstAnaerobicHeartRateUpperLimit
                , firstFiveZoneHeartRateLimits
                , firstThreeZoneHeartRateLimits
                , firstTwoZoneHeartRateLimit
                , firstLanguage
                , firstDatabaseChangeIncrement
                , firstUserIndex
                , firstUserControlPoint
                , firstRegisteredUser);

        UserDataServiceData result2 = new UserDataServiceData(firstFirstName
                , firstLastName
                , firstEmailAddress
                , firstAge
                , firstDateOfBirth
                , firstGender
                , firstWeight
                , null
                , firstVo2Max
                , firstHeartRateMax
                , firstRestingHeartRate
                , firstMaximumRecommendedHeartRate
                , firstAerobicThreshold
                , firstAnaerobicThreshold
                , firstSportTypeForAerobicAndAnaerobicThresholds
                , firstDateOfThresholdAssessment
                , firstWaistCircumference
                , firstHipCircumference
                , firstFatBurnHeartRateLowerLimit
                , firstFatBurnHeartRateUpperLimit
                , firstAerobicHeartRateLowerLimit
                , firstAerobicHeartRateUpperLimit
                , firstAnaerobicHeartRateLowerLimit
                , firstAnaerobicHeartRateUpperLimit
                , firstFiveZoneHeartRateLimits
                , firstThreeZoneHeartRateLimits
                , firstTwoZoneHeartRateLimit
                , firstLanguage
                , firstDatabaseChangeIncrement
                , firstUserIndex
                , firstUserControlPoint
                , firstRegisteredUser);
        assertEquals(result1, result2);
    }

    @Test
    public void test_equals_00110() {
        UDSCharacteristicData firstFirstName = new UDSCharacteristicData(FIRST_NAME_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstLastName = new UDSCharacteristicData(LAST_NAME_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstEmailAddress = new UDSCharacteristicData(EMAIL_ADDRESS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAge = new UDSCharacteristicData(AGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstDateOfBirth = new UDSCharacteristicData(DATE_OF_BIRTH_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstGender = new UDSCharacteristicData(GENDER_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstWeight = new UDSCharacteristicData(WEIGHT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstHeight = new UDSCharacteristicData(HEIGHT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstHeartRateMax = new UDSCharacteristicData(HEART_RATE_MAX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstRestingHeartRate = new UDSCharacteristicData(RESTING_HEART_RATE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstMaximumRecommendedHeartRate = new UDSCharacteristicData(MAXIMUM_RECOMMENDED_HEART_RATE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAerobicThreshold = new UDSCharacteristicData(AEROBIC_THRESHOLD_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAnaerobicThreshold = new UDSCharacteristicData(ANAEROBIC_THRESHOLD_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstSportTypeForAerobicAndAnaerobicThresholds = new UDSCharacteristicData(SPORT_TYPE_FOR_AEROBIC_AND_ANAEROBIC_THRESHOLDS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstDateOfThresholdAssessment = new UDSCharacteristicData(DATE_OF_THRESHOLD_ASSESSMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstWaistCircumference = new UDSCharacteristicData(WAIST_CIRCUMFERENCE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstHipCircumference = new UDSCharacteristicData(HIP_CIRCUMFERENCE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstFatBurnHeartRateLowerLimit = new UDSCharacteristicData(FAT_BURN_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstFatBurnHeartRateUpperLimit = new UDSCharacteristicData(FAT_BURN_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAerobicHeartRateLowerLimit = new UDSCharacteristicData(AEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAerobicHeartRateUpperLimit = new UDSCharacteristicData(AEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAnaerobicHeartRateLowerLimit = new UDSCharacteristicData(ANAEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAnaerobicHeartRateUpperLimit = new UDSCharacteristicData(ANAEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstFiveZoneHeartRateLimits = new UDSCharacteristicData(FIVE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstThreeZoneHeartRateLimits = new UDSCharacteristicData(THREE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstTwoZoneHeartRateLimit = new UDSCharacteristicData(TWO_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstLanguage = new UDSCharacteristicData(LANGUAGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstDatabaseChangeIncrement = new CharacteristicData(DATABASE_CHANGE_INCREMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstUserIndex = new CharacteristicData(USER_INDEX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UserControlPointCharacteristicData firstUserControlPoint = new UserControlPointCharacteristicData(1
                , 2
                , new ArrayList<>()
                , 3
                , 5
                , 6
                , 7
                , 8
                , 9);
        CharacteristicData firstRegisteredUser = new CharacteristicData(REGISTERED_USER_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);

        UserDataServiceData result1 = new UserDataServiceData(firstFirstName
                , firstLastName
                , firstEmailAddress
                , firstAge
                , firstDateOfBirth
                , firstGender
                , firstWeight
                , firstHeight
                , null
                , firstHeartRateMax
                , firstRestingHeartRate
                , firstMaximumRecommendedHeartRate
                , firstAerobicThreshold
                , firstAnaerobicThreshold
                , firstSportTypeForAerobicAndAnaerobicThresholds
                , firstDateOfThresholdAssessment
                , firstWaistCircumference
                , firstHipCircumference
                , firstFatBurnHeartRateLowerLimit
                , firstFatBurnHeartRateUpperLimit
                , firstAerobicHeartRateLowerLimit
                , firstAerobicHeartRateUpperLimit
                , firstAnaerobicHeartRateLowerLimit
                , firstAnaerobicHeartRateUpperLimit
                , firstFiveZoneHeartRateLimits
                , firstThreeZoneHeartRateLimits
                , firstTwoZoneHeartRateLimit
                , firstLanguage
                , firstDatabaseChangeIncrement
                , firstUserIndex
                , firstUserControlPoint
                , firstRegisteredUser);

        UserDataServiceData result2 = new UserDataServiceData(firstFirstName
                , firstLastName
                , firstEmailAddress
                , firstAge
                , firstDateOfBirth
                , firstGender
                , firstWeight
                , firstHeight
                , null
                , firstHeartRateMax
                , firstRestingHeartRate
                , firstMaximumRecommendedHeartRate
                , firstAerobicThreshold
                , firstAnaerobicThreshold
                , firstSportTypeForAerobicAndAnaerobicThresholds
                , firstDateOfThresholdAssessment
                , firstWaistCircumference
                , firstHipCircumference
                , firstFatBurnHeartRateLowerLimit
                , firstFatBurnHeartRateUpperLimit
                , firstAerobicHeartRateLowerLimit
                , firstAerobicHeartRateUpperLimit
                , firstAnaerobicHeartRateLowerLimit
                , firstAnaerobicHeartRateUpperLimit
                , firstFiveZoneHeartRateLimits
                , firstThreeZoneHeartRateLimits
                , firstTwoZoneHeartRateLimit
                , firstLanguage
                , firstDatabaseChangeIncrement
                , firstUserIndex
                , firstUserControlPoint
                , firstRegisteredUser);
        assertEquals(result1, result2);
    }

    @Test
    public void test_equals_00111() {
        UDSCharacteristicData firstFirstName = new UDSCharacteristicData(FIRST_NAME_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstLastName = new UDSCharacteristicData(LAST_NAME_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstEmailAddress = new UDSCharacteristicData(EMAIL_ADDRESS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAge = new UDSCharacteristicData(AGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstDateOfBirth = new UDSCharacteristicData(DATE_OF_BIRTH_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstGender = new UDSCharacteristicData(GENDER_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstWeight = new UDSCharacteristicData(WEIGHT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstHeight = new UDSCharacteristicData(HEIGHT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstVo2Max = new UDSCharacteristicData(VO2_MAX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstRestingHeartRate = new UDSCharacteristicData(RESTING_HEART_RATE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstMaximumRecommendedHeartRate = new UDSCharacteristicData(MAXIMUM_RECOMMENDED_HEART_RATE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAerobicThreshold = new UDSCharacteristicData(AEROBIC_THRESHOLD_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAnaerobicThreshold = new UDSCharacteristicData(ANAEROBIC_THRESHOLD_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstSportTypeForAerobicAndAnaerobicThresholds = new UDSCharacteristicData(SPORT_TYPE_FOR_AEROBIC_AND_ANAEROBIC_THRESHOLDS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstDateOfThresholdAssessment = new UDSCharacteristicData(DATE_OF_THRESHOLD_ASSESSMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstWaistCircumference = new UDSCharacteristicData(WAIST_CIRCUMFERENCE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstHipCircumference = new UDSCharacteristicData(HIP_CIRCUMFERENCE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstFatBurnHeartRateLowerLimit = new UDSCharacteristicData(FAT_BURN_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstFatBurnHeartRateUpperLimit = new UDSCharacteristicData(FAT_BURN_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAerobicHeartRateLowerLimit = new UDSCharacteristicData(AEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAerobicHeartRateUpperLimit = new UDSCharacteristicData(AEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAnaerobicHeartRateLowerLimit = new UDSCharacteristicData(ANAEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAnaerobicHeartRateUpperLimit = new UDSCharacteristicData(ANAEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstFiveZoneHeartRateLimits = new UDSCharacteristicData(FIVE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstThreeZoneHeartRateLimits = new UDSCharacteristicData(THREE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstTwoZoneHeartRateLimit = new UDSCharacteristicData(TWO_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstLanguage = new UDSCharacteristicData(LANGUAGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstDatabaseChangeIncrement = new CharacteristicData(DATABASE_CHANGE_INCREMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstUserIndex = new CharacteristicData(USER_INDEX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UserControlPointCharacteristicData firstUserControlPoint = new UserControlPointCharacteristicData(1
                , 2
                , new ArrayList<>()
                , 3
                , 5
                , 6
                , 7
                , 8
                , 9);
        CharacteristicData firstRegisteredUser = new CharacteristicData(REGISTERED_USER_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);

        UserDataServiceData result1 = new UserDataServiceData(firstFirstName
                , firstLastName
                , firstEmailAddress
                , firstAge
                , firstDateOfBirth
                , firstGender
                , firstWeight
                , firstHeight
                , firstVo2Max
                , null
                , firstRestingHeartRate
                , firstMaximumRecommendedHeartRate
                , firstAerobicThreshold
                , firstAnaerobicThreshold
                , firstSportTypeForAerobicAndAnaerobicThresholds
                , firstDateOfThresholdAssessment
                , firstWaistCircumference
                , firstHipCircumference
                , firstFatBurnHeartRateLowerLimit
                , firstFatBurnHeartRateUpperLimit
                , firstAerobicHeartRateLowerLimit
                , firstAerobicHeartRateUpperLimit
                , firstAnaerobicHeartRateLowerLimit
                , firstAnaerobicHeartRateUpperLimit
                , firstFiveZoneHeartRateLimits
                , firstThreeZoneHeartRateLimits
                , firstTwoZoneHeartRateLimit
                , firstLanguage
                , firstDatabaseChangeIncrement
                , firstUserIndex
                , firstUserControlPoint
                , firstRegisteredUser);

        UserDataServiceData result2 = new UserDataServiceData(firstFirstName
                , firstLastName
                , firstEmailAddress
                , firstAge
                , firstDateOfBirth
                , firstGender
                , firstWeight
                , firstHeight
                , firstVo2Max
                , null
                , firstRestingHeartRate
                , firstMaximumRecommendedHeartRate
                , firstAerobicThreshold
                , firstAnaerobicThreshold
                , firstSportTypeForAerobicAndAnaerobicThresholds
                , firstDateOfThresholdAssessment
                , firstWaistCircumference
                , firstHipCircumference
                , firstFatBurnHeartRateLowerLimit
                , firstFatBurnHeartRateUpperLimit
                , firstAerobicHeartRateLowerLimit
                , firstAerobicHeartRateUpperLimit
                , firstAnaerobicHeartRateLowerLimit
                , firstAnaerobicHeartRateUpperLimit
                , firstFiveZoneHeartRateLimits
                , firstThreeZoneHeartRateLimits
                , firstTwoZoneHeartRateLimit
                , firstLanguage
                , firstDatabaseChangeIncrement
                , firstUserIndex
                , firstUserControlPoint
                , firstRegisteredUser);
        assertEquals(result1, result2);
    }

    @Test
    public void test_equals_00112() {
        UDSCharacteristicData firstFirstName = new UDSCharacteristicData(FIRST_NAME_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstLastName = new UDSCharacteristicData(LAST_NAME_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstEmailAddress = new UDSCharacteristicData(EMAIL_ADDRESS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAge = new UDSCharacteristicData(AGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstDateOfBirth = new UDSCharacteristicData(DATE_OF_BIRTH_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstGender = new UDSCharacteristicData(GENDER_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstWeight = new UDSCharacteristicData(WEIGHT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstHeight = new UDSCharacteristicData(HEIGHT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstVo2Max = new UDSCharacteristicData(VO2_MAX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstHeartRateMax = new UDSCharacteristicData(HEART_RATE_MAX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstMaximumRecommendedHeartRate = new UDSCharacteristicData(MAXIMUM_RECOMMENDED_HEART_RATE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAerobicThreshold = new UDSCharacteristicData(AEROBIC_THRESHOLD_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAnaerobicThreshold = new UDSCharacteristicData(ANAEROBIC_THRESHOLD_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstSportTypeForAerobicAndAnaerobicThresholds = new UDSCharacteristicData(SPORT_TYPE_FOR_AEROBIC_AND_ANAEROBIC_THRESHOLDS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstDateOfThresholdAssessment = new UDSCharacteristicData(DATE_OF_THRESHOLD_ASSESSMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstWaistCircumference = new UDSCharacteristicData(WAIST_CIRCUMFERENCE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstHipCircumference = new UDSCharacteristicData(HIP_CIRCUMFERENCE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstFatBurnHeartRateLowerLimit = new UDSCharacteristicData(FAT_BURN_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstFatBurnHeartRateUpperLimit = new UDSCharacteristicData(FAT_BURN_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAerobicHeartRateLowerLimit = new UDSCharacteristicData(AEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAerobicHeartRateUpperLimit = new UDSCharacteristicData(AEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAnaerobicHeartRateLowerLimit = new UDSCharacteristicData(ANAEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAnaerobicHeartRateUpperLimit = new UDSCharacteristicData(ANAEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstFiveZoneHeartRateLimits = new UDSCharacteristicData(FIVE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstThreeZoneHeartRateLimits = new UDSCharacteristicData(THREE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstTwoZoneHeartRateLimit = new UDSCharacteristicData(TWO_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstLanguage = new UDSCharacteristicData(LANGUAGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstDatabaseChangeIncrement = new CharacteristicData(DATABASE_CHANGE_INCREMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstUserIndex = new CharacteristicData(USER_INDEX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UserControlPointCharacteristicData firstUserControlPoint = new UserControlPointCharacteristicData(1
                , 2
                , new ArrayList<>()
                , 3
                , 5
                , 6
                , 7
                , 8
                , 9);
        CharacteristicData firstRegisteredUser = new CharacteristicData(REGISTERED_USER_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);

        UserDataServiceData result1 = new UserDataServiceData(firstFirstName
                , firstLastName
                , firstEmailAddress
                , firstAge
                , firstDateOfBirth
                , firstGender
                , firstWeight
                , firstHeight
                , firstVo2Max
                , firstHeartRateMax
                , null
                , firstMaximumRecommendedHeartRate
                , firstAerobicThreshold
                , firstAnaerobicThreshold
                , firstSportTypeForAerobicAndAnaerobicThresholds
                , firstDateOfThresholdAssessment
                , firstWaistCircumference
                , firstHipCircumference
                , firstFatBurnHeartRateLowerLimit
                , firstFatBurnHeartRateUpperLimit
                , firstAerobicHeartRateLowerLimit
                , firstAerobicHeartRateUpperLimit
                , firstAnaerobicHeartRateLowerLimit
                , firstAnaerobicHeartRateUpperLimit
                , firstFiveZoneHeartRateLimits
                , firstThreeZoneHeartRateLimits
                , firstTwoZoneHeartRateLimit
                , firstLanguage
                , firstDatabaseChangeIncrement
                , firstUserIndex
                , firstUserControlPoint
                , firstRegisteredUser);

        UserDataServiceData result2 = new UserDataServiceData(firstFirstName
                , firstLastName
                , firstEmailAddress
                , firstAge
                , firstDateOfBirth
                , firstGender
                , firstWeight
                , firstHeight
                , firstVo2Max
                , firstHeartRateMax
                , null
                , firstMaximumRecommendedHeartRate
                , firstAerobicThreshold
                , firstAnaerobicThreshold
                , firstSportTypeForAerobicAndAnaerobicThresholds
                , firstDateOfThresholdAssessment
                , firstWaistCircumference
                , firstHipCircumference
                , firstFatBurnHeartRateLowerLimit
                , firstFatBurnHeartRateUpperLimit
                , firstAerobicHeartRateLowerLimit
                , firstAerobicHeartRateUpperLimit
                , firstAnaerobicHeartRateLowerLimit
                , firstAnaerobicHeartRateUpperLimit
                , firstFiveZoneHeartRateLimits
                , firstThreeZoneHeartRateLimits
                , firstTwoZoneHeartRateLimit
                , firstLanguage
                , firstDatabaseChangeIncrement
                , firstUserIndex
                , firstUserControlPoint
                , firstRegisteredUser);
        assertEquals(result1, result2);
    }

    @Test
    public void test_equals_00113() {
        UDSCharacteristicData firstFirstName = new UDSCharacteristicData(FIRST_NAME_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstLastName = new UDSCharacteristicData(LAST_NAME_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstEmailAddress = new UDSCharacteristicData(EMAIL_ADDRESS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAge = new UDSCharacteristicData(AGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstDateOfBirth = new UDSCharacteristicData(DATE_OF_BIRTH_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstGender = new UDSCharacteristicData(GENDER_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstWeight = new UDSCharacteristicData(WEIGHT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstHeight = new UDSCharacteristicData(HEIGHT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstVo2Max = new UDSCharacteristicData(VO2_MAX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstHeartRateMax = new UDSCharacteristicData(HEART_RATE_MAX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstRestingHeartRate = new UDSCharacteristicData(RESTING_HEART_RATE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAerobicThreshold = new UDSCharacteristicData(AEROBIC_THRESHOLD_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAnaerobicThreshold = new UDSCharacteristicData(ANAEROBIC_THRESHOLD_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstSportTypeForAerobicAndAnaerobicThresholds = new UDSCharacteristicData(SPORT_TYPE_FOR_AEROBIC_AND_ANAEROBIC_THRESHOLDS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstDateOfThresholdAssessment = new UDSCharacteristicData(DATE_OF_THRESHOLD_ASSESSMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstWaistCircumference = new UDSCharacteristicData(WAIST_CIRCUMFERENCE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstHipCircumference = new UDSCharacteristicData(HIP_CIRCUMFERENCE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstFatBurnHeartRateLowerLimit = new UDSCharacteristicData(FAT_BURN_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstFatBurnHeartRateUpperLimit = new UDSCharacteristicData(FAT_BURN_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAerobicHeartRateLowerLimit = new UDSCharacteristicData(AEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAerobicHeartRateUpperLimit = new UDSCharacteristicData(AEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAnaerobicHeartRateLowerLimit = new UDSCharacteristicData(ANAEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAnaerobicHeartRateUpperLimit = new UDSCharacteristicData(ANAEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstFiveZoneHeartRateLimits = new UDSCharacteristicData(FIVE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstThreeZoneHeartRateLimits = new UDSCharacteristicData(THREE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstTwoZoneHeartRateLimit = new UDSCharacteristicData(TWO_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstLanguage = new UDSCharacteristicData(LANGUAGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstDatabaseChangeIncrement = new CharacteristicData(DATABASE_CHANGE_INCREMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstUserIndex = new CharacteristicData(USER_INDEX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UserControlPointCharacteristicData firstUserControlPoint = new UserControlPointCharacteristicData(1
                , 2
                , new ArrayList<>()
                , 3
                , 5
                , 6
                , 7
                , 8
                , 9);
        CharacteristicData firstRegisteredUser = new CharacteristicData(REGISTERED_USER_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);

        UserDataServiceData result1 = new UserDataServiceData(firstFirstName
                , firstLastName
                , firstEmailAddress
                , firstAge
                , firstDateOfBirth
                , firstGender
                , firstWeight
                , firstHeight
                , firstVo2Max
                , firstHeartRateMax
                , firstRestingHeartRate
                , null
                , firstAerobicThreshold
                , firstAnaerobicThreshold
                , firstSportTypeForAerobicAndAnaerobicThresholds
                , firstDateOfThresholdAssessment
                , firstWaistCircumference
                , firstHipCircumference
                , firstFatBurnHeartRateLowerLimit
                , firstFatBurnHeartRateUpperLimit
                , firstAerobicHeartRateLowerLimit
                , firstAerobicHeartRateUpperLimit
                , firstAnaerobicHeartRateLowerLimit
                , firstAnaerobicHeartRateUpperLimit
                , firstFiveZoneHeartRateLimits
                , firstThreeZoneHeartRateLimits
                , firstTwoZoneHeartRateLimit
                , firstLanguage
                , firstDatabaseChangeIncrement
                , firstUserIndex
                , firstUserControlPoint
                , firstRegisteredUser);

        UserDataServiceData result2 = new UserDataServiceData(firstFirstName
                , firstLastName
                , firstEmailAddress
                , firstAge
                , firstDateOfBirth
                , firstGender
                , firstWeight
                , firstHeight
                , firstVo2Max
                , firstHeartRateMax
                , firstRestingHeartRate
                , null
                , firstAerobicThreshold
                , firstAnaerobicThreshold
                , firstSportTypeForAerobicAndAnaerobicThresholds
                , firstDateOfThresholdAssessment
                , firstWaistCircumference
                , firstHipCircumference
                , firstFatBurnHeartRateLowerLimit
                , firstFatBurnHeartRateUpperLimit
                , firstAerobicHeartRateLowerLimit
                , firstAerobicHeartRateUpperLimit
                , firstAnaerobicHeartRateLowerLimit
                , firstAnaerobicHeartRateUpperLimit
                , firstFiveZoneHeartRateLimits
                , firstThreeZoneHeartRateLimits
                , firstTwoZoneHeartRateLimit
                , firstLanguage
                , firstDatabaseChangeIncrement
                , firstUserIndex
                , firstUserControlPoint
                , firstRegisteredUser);
        assertEquals(result1, result2);
    }

    @Test
    public void test_equals_00114() {
        UDSCharacteristicData firstFirstName = new UDSCharacteristicData(FIRST_NAME_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstLastName = new UDSCharacteristicData(LAST_NAME_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstEmailAddress = new UDSCharacteristicData(EMAIL_ADDRESS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAge = new UDSCharacteristicData(AGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstDateOfBirth = new UDSCharacteristicData(DATE_OF_BIRTH_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstGender = new UDSCharacteristicData(GENDER_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstWeight = new UDSCharacteristicData(WEIGHT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstHeight = new UDSCharacteristicData(HEIGHT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstVo2Max = new UDSCharacteristicData(VO2_MAX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstHeartRateMax = new UDSCharacteristicData(HEART_RATE_MAX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstRestingHeartRate = new UDSCharacteristicData(RESTING_HEART_RATE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstMaximumRecommendedHeartRate = new UDSCharacteristicData(MAXIMUM_RECOMMENDED_HEART_RATE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAnaerobicThreshold = new UDSCharacteristicData(ANAEROBIC_THRESHOLD_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstSportTypeForAerobicAndAnaerobicThresholds = new UDSCharacteristicData(SPORT_TYPE_FOR_AEROBIC_AND_ANAEROBIC_THRESHOLDS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstDateOfThresholdAssessment = new UDSCharacteristicData(DATE_OF_THRESHOLD_ASSESSMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstWaistCircumference = new UDSCharacteristicData(WAIST_CIRCUMFERENCE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstHipCircumference = new UDSCharacteristicData(HIP_CIRCUMFERENCE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstFatBurnHeartRateLowerLimit = new UDSCharacteristicData(FAT_BURN_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstFatBurnHeartRateUpperLimit = new UDSCharacteristicData(FAT_BURN_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAerobicHeartRateLowerLimit = new UDSCharacteristicData(AEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAerobicHeartRateUpperLimit = new UDSCharacteristicData(AEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAnaerobicHeartRateLowerLimit = new UDSCharacteristicData(ANAEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAnaerobicHeartRateUpperLimit = new UDSCharacteristicData(ANAEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstFiveZoneHeartRateLimits = new UDSCharacteristicData(FIVE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstThreeZoneHeartRateLimits = new UDSCharacteristicData(THREE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstTwoZoneHeartRateLimit = new UDSCharacteristicData(TWO_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstLanguage = new UDSCharacteristicData(LANGUAGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstDatabaseChangeIncrement = new CharacteristicData(DATABASE_CHANGE_INCREMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstUserIndex = new CharacteristicData(USER_INDEX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UserControlPointCharacteristicData firstUserControlPoint = new UserControlPointCharacteristicData(1
                , 2
                , new ArrayList<>()
                , 3
                , 5
                , 6
                , 7
                , 8
                , 9);
        CharacteristicData firstRegisteredUser = new CharacteristicData(REGISTERED_USER_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);

        UserDataServiceData result1 = new UserDataServiceData(firstFirstName
                , firstLastName
                , firstEmailAddress
                , firstAge
                , firstDateOfBirth
                , firstGender
                , firstWeight
                , firstHeight
                , firstVo2Max
                , firstHeartRateMax
                , firstRestingHeartRate
                , firstMaximumRecommendedHeartRate
                , null
                , firstAnaerobicThreshold
                , firstSportTypeForAerobicAndAnaerobicThresholds
                , firstDateOfThresholdAssessment
                , firstWaistCircumference
                , firstHipCircumference
                , firstFatBurnHeartRateLowerLimit
                , firstFatBurnHeartRateUpperLimit
                , firstAerobicHeartRateLowerLimit
                , firstAerobicHeartRateUpperLimit
                , firstAnaerobicHeartRateLowerLimit
                , firstAnaerobicHeartRateUpperLimit
                , firstFiveZoneHeartRateLimits
                , firstThreeZoneHeartRateLimits
                , firstTwoZoneHeartRateLimit
                , firstLanguage
                , firstDatabaseChangeIncrement
                , firstUserIndex
                , firstUserControlPoint
                , firstRegisteredUser);

        UserDataServiceData result2 = new UserDataServiceData(firstFirstName
                , firstLastName
                , firstEmailAddress
                , firstAge
                , firstDateOfBirth
                , firstGender
                , firstWeight
                , firstHeight
                , firstVo2Max
                , firstHeartRateMax
                , firstRestingHeartRate
                , firstMaximumRecommendedHeartRate
                , null
                , firstAnaerobicThreshold
                , firstSportTypeForAerobicAndAnaerobicThresholds
                , firstDateOfThresholdAssessment
                , firstWaistCircumference
                , firstHipCircumference
                , firstFatBurnHeartRateLowerLimit
                , firstFatBurnHeartRateUpperLimit
                , firstAerobicHeartRateLowerLimit
                , firstAerobicHeartRateUpperLimit
                , firstAnaerobicHeartRateLowerLimit
                , firstAnaerobicHeartRateUpperLimit
                , firstFiveZoneHeartRateLimits
                , firstThreeZoneHeartRateLimits
                , firstTwoZoneHeartRateLimit
                , firstLanguage
                , firstDatabaseChangeIncrement
                , firstUserIndex
                , firstUserControlPoint
                , firstRegisteredUser);
        assertEquals(result1, result2);
    }

    @Test
    public void test_equals_00115() {
        UDSCharacteristicData firstFirstName = new UDSCharacteristicData(FIRST_NAME_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstLastName = new UDSCharacteristicData(LAST_NAME_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstEmailAddress = new UDSCharacteristicData(EMAIL_ADDRESS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAge = new UDSCharacteristicData(AGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstDateOfBirth = new UDSCharacteristicData(DATE_OF_BIRTH_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstGender = new UDSCharacteristicData(GENDER_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstWeight = new UDSCharacteristicData(WEIGHT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstHeight = new UDSCharacteristicData(HEIGHT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstVo2Max = new UDSCharacteristicData(VO2_MAX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstHeartRateMax = new UDSCharacteristicData(HEART_RATE_MAX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstRestingHeartRate = new UDSCharacteristicData(RESTING_HEART_RATE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstMaximumRecommendedHeartRate = new UDSCharacteristicData(MAXIMUM_RECOMMENDED_HEART_RATE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAerobicThreshold = new UDSCharacteristicData(AEROBIC_THRESHOLD_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstSportTypeForAerobicAndAnaerobicThresholds = new UDSCharacteristicData(SPORT_TYPE_FOR_AEROBIC_AND_ANAEROBIC_THRESHOLDS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstDateOfThresholdAssessment = new UDSCharacteristicData(DATE_OF_THRESHOLD_ASSESSMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstWaistCircumference = new UDSCharacteristicData(WAIST_CIRCUMFERENCE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstHipCircumference = new UDSCharacteristicData(HIP_CIRCUMFERENCE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstFatBurnHeartRateLowerLimit = new UDSCharacteristicData(FAT_BURN_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstFatBurnHeartRateUpperLimit = new UDSCharacteristicData(FAT_BURN_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAerobicHeartRateLowerLimit = new UDSCharacteristicData(AEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAerobicHeartRateUpperLimit = new UDSCharacteristicData(AEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAnaerobicHeartRateLowerLimit = new UDSCharacteristicData(ANAEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAnaerobicHeartRateUpperLimit = new UDSCharacteristicData(ANAEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstFiveZoneHeartRateLimits = new UDSCharacteristicData(FIVE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstThreeZoneHeartRateLimits = new UDSCharacteristicData(THREE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstTwoZoneHeartRateLimit = new UDSCharacteristicData(TWO_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstLanguage = new UDSCharacteristicData(LANGUAGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstDatabaseChangeIncrement = new CharacteristicData(DATABASE_CHANGE_INCREMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstUserIndex = new CharacteristicData(USER_INDEX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UserControlPointCharacteristicData firstUserControlPoint = new UserControlPointCharacteristicData(1
                , 2
                , new ArrayList<>()
                , 3
                , 5
                , 6
                , 7
                , 8
                , 9);
        CharacteristicData firstRegisteredUser = new CharacteristicData(REGISTERED_USER_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);

        UserDataServiceData result1 = new UserDataServiceData(firstFirstName
                , firstLastName
                , firstEmailAddress
                , firstAge
                , firstDateOfBirth
                , firstGender
                , firstWeight
                , firstHeight
                , firstVo2Max
                , firstHeartRateMax
                , firstRestingHeartRate
                , firstMaximumRecommendedHeartRate
                , firstAerobicThreshold
                , null
                , firstSportTypeForAerobicAndAnaerobicThresholds
                , firstDateOfThresholdAssessment
                , firstWaistCircumference
                , firstHipCircumference
                , firstFatBurnHeartRateLowerLimit
                , firstFatBurnHeartRateUpperLimit
                , firstAerobicHeartRateLowerLimit
                , firstAerobicHeartRateUpperLimit
                , firstAnaerobicHeartRateLowerLimit
                , firstAnaerobicHeartRateUpperLimit
                , firstFiveZoneHeartRateLimits
                , firstThreeZoneHeartRateLimits
                , firstTwoZoneHeartRateLimit
                , firstLanguage
                , firstDatabaseChangeIncrement
                , firstUserIndex
                , firstUserControlPoint
                , firstRegisteredUser);

        UserDataServiceData result2 = new UserDataServiceData(firstFirstName
                , firstLastName
                , firstEmailAddress
                , firstAge
                , firstDateOfBirth
                , firstGender
                , firstWeight
                , firstHeight
                , firstVo2Max
                , firstHeartRateMax
                , firstRestingHeartRate
                , firstMaximumRecommendedHeartRate
                , firstAerobicThreshold
                , null
                , firstSportTypeForAerobicAndAnaerobicThresholds
                , firstDateOfThresholdAssessment
                , firstWaistCircumference
                , firstHipCircumference
                , firstFatBurnHeartRateLowerLimit
                , firstFatBurnHeartRateUpperLimit
                , firstAerobicHeartRateLowerLimit
                , firstAerobicHeartRateUpperLimit
                , firstAnaerobicHeartRateLowerLimit
                , firstAnaerobicHeartRateUpperLimit
                , firstFiveZoneHeartRateLimits
                , firstThreeZoneHeartRateLimits
                , firstTwoZoneHeartRateLimit
                , firstLanguage
                , firstDatabaseChangeIncrement
                , firstUserIndex
                , firstUserControlPoint
                , firstRegisteredUser);
        assertEquals(result1, result2);
    }

    @Test
    public void test_equals_00116() {
        UDSCharacteristicData firstFirstName = new UDSCharacteristicData(FIRST_NAME_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstLastName = new UDSCharacteristicData(LAST_NAME_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstEmailAddress = new UDSCharacteristicData(EMAIL_ADDRESS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAge = new UDSCharacteristicData(AGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstDateOfBirth = new UDSCharacteristicData(DATE_OF_BIRTH_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstGender = new UDSCharacteristicData(GENDER_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstWeight = new UDSCharacteristicData(WEIGHT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstHeight = new UDSCharacteristicData(HEIGHT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstVo2Max = new UDSCharacteristicData(VO2_MAX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstHeartRateMax = new UDSCharacteristicData(HEART_RATE_MAX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstRestingHeartRate = new UDSCharacteristicData(RESTING_HEART_RATE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstMaximumRecommendedHeartRate = new UDSCharacteristicData(MAXIMUM_RECOMMENDED_HEART_RATE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAerobicThreshold = new UDSCharacteristicData(AEROBIC_THRESHOLD_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAnaerobicThreshold = new UDSCharacteristicData(ANAEROBIC_THRESHOLD_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstDateOfThresholdAssessment = new UDSCharacteristicData(DATE_OF_THRESHOLD_ASSESSMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstWaistCircumference = new UDSCharacteristicData(WAIST_CIRCUMFERENCE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstHipCircumference = new UDSCharacteristicData(HIP_CIRCUMFERENCE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstFatBurnHeartRateLowerLimit = new UDSCharacteristicData(FAT_BURN_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstFatBurnHeartRateUpperLimit = new UDSCharacteristicData(FAT_BURN_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAerobicHeartRateLowerLimit = new UDSCharacteristicData(AEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAerobicHeartRateUpperLimit = new UDSCharacteristicData(AEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAnaerobicHeartRateLowerLimit = new UDSCharacteristicData(ANAEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAnaerobicHeartRateUpperLimit = new UDSCharacteristicData(ANAEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstFiveZoneHeartRateLimits = new UDSCharacteristicData(FIVE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstThreeZoneHeartRateLimits = new UDSCharacteristicData(THREE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstTwoZoneHeartRateLimit = new UDSCharacteristicData(TWO_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstLanguage = new UDSCharacteristicData(LANGUAGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstDatabaseChangeIncrement = new CharacteristicData(DATABASE_CHANGE_INCREMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstUserIndex = new CharacteristicData(USER_INDEX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UserControlPointCharacteristicData firstUserControlPoint = new UserControlPointCharacteristicData(1
                , 2
                , new ArrayList<>()
                , 3
                , 5
                , 6
                , 7
                , 8
                , 9);
        CharacteristicData firstRegisteredUser = new CharacteristicData(REGISTERED_USER_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);

        UserDataServiceData result1 = new UserDataServiceData(firstFirstName
                , firstLastName
                , firstEmailAddress
                , firstAge
                , firstDateOfBirth
                , firstGender
                , firstWeight
                , firstHeight
                , firstVo2Max
                , firstHeartRateMax
                , firstRestingHeartRate
                , firstMaximumRecommendedHeartRate
                , firstAerobicThreshold
                , firstAnaerobicThreshold
                , null
                , firstDateOfThresholdAssessment
                , firstWaistCircumference
                , firstHipCircumference
                , firstFatBurnHeartRateLowerLimit
                , firstFatBurnHeartRateUpperLimit
                , firstAerobicHeartRateLowerLimit
                , firstAerobicHeartRateUpperLimit
                , firstAnaerobicHeartRateLowerLimit
                , firstAnaerobicHeartRateUpperLimit
                , firstFiveZoneHeartRateLimits
                , firstThreeZoneHeartRateLimits
                , firstTwoZoneHeartRateLimit
                , firstLanguage
                , firstDatabaseChangeIncrement
                , firstUserIndex
                , firstUserControlPoint
                , firstRegisteredUser);

        UserDataServiceData result2 = new UserDataServiceData(firstFirstName
                , firstLastName
                , firstEmailAddress
                , firstAge
                , firstDateOfBirth
                , firstGender
                , firstWeight
                , firstHeight
                , firstVo2Max
                , firstHeartRateMax
                , firstRestingHeartRate
                , firstMaximumRecommendedHeartRate
                , firstAerobicThreshold
                , firstAnaerobicThreshold
                , null
                , firstDateOfThresholdAssessment
                , firstWaistCircumference
                , firstHipCircumference
                , firstFatBurnHeartRateLowerLimit
                , firstFatBurnHeartRateUpperLimit
                , firstAerobicHeartRateLowerLimit
                , firstAerobicHeartRateUpperLimit
                , firstAnaerobicHeartRateLowerLimit
                , firstAnaerobicHeartRateUpperLimit
                , firstFiveZoneHeartRateLimits
                , firstThreeZoneHeartRateLimits
                , firstTwoZoneHeartRateLimit
                , firstLanguage
                , firstDatabaseChangeIncrement
                , firstUserIndex
                , firstUserControlPoint
                , firstRegisteredUser);
        assertEquals(result1, result2);
    }

    @Test
    public void test_equals_00117() {
        UDSCharacteristicData firstFirstName = new UDSCharacteristicData(FIRST_NAME_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstLastName = new UDSCharacteristicData(LAST_NAME_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstEmailAddress = new UDSCharacteristicData(EMAIL_ADDRESS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAge = new UDSCharacteristicData(AGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstDateOfBirth = new UDSCharacteristicData(DATE_OF_BIRTH_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstGender = new UDSCharacteristicData(GENDER_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstWeight = new UDSCharacteristicData(WEIGHT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstHeight = new UDSCharacteristicData(HEIGHT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstVo2Max = new UDSCharacteristicData(VO2_MAX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstHeartRateMax = new UDSCharacteristicData(HEART_RATE_MAX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstRestingHeartRate = new UDSCharacteristicData(RESTING_HEART_RATE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstMaximumRecommendedHeartRate = new UDSCharacteristicData(MAXIMUM_RECOMMENDED_HEART_RATE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAerobicThreshold = new UDSCharacteristicData(AEROBIC_THRESHOLD_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAnaerobicThreshold = new UDSCharacteristicData(ANAEROBIC_THRESHOLD_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstSportTypeForAerobicAndAnaerobicThresholds = new UDSCharacteristicData(SPORT_TYPE_FOR_AEROBIC_AND_ANAEROBIC_THRESHOLDS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstWaistCircumference = new UDSCharacteristicData(WAIST_CIRCUMFERENCE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstHipCircumference = new UDSCharacteristicData(HIP_CIRCUMFERENCE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstFatBurnHeartRateLowerLimit = new UDSCharacteristicData(FAT_BURN_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstFatBurnHeartRateUpperLimit = new UDSCharacteristicData(FAT_BURN_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAerobicHeartRateLowerLimit = new UDSCharacteristicData(AEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAerobicHeartRateUpperLimit = new UDSCharacteristicData(AEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAnaerobicHeartRateLowerLimit = new UDSCharacteristicData(ANAEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAnaerobicHeartRateUpperLimit = new UDSCharacteristicData(ANAEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstFiveZoneHeartRateLimits = new UDSCharacteristicData(FIVE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstThreeZoneHeartRateLimits = new UDSCharacteristicData(THREE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstTwoZoneHeartRateLimit = new UDSCharacteristicData(TWO_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstLanguage = new UDSCharacteristicData(LANGUAGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstDatabaseChangeIncrement = new CharacteristicData(DATABASE_CHANGE_INCREMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstUserIndex = new CharacteristicData(USER_INDEX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UserControlPointCharacteristicData firstUserControlPoint = new UserControlPointCharacteristicData(1
                , 2
                , new ArrayList<>()
                , 3
                , 5
                , 6
                , 7
                , 8
                , 9);
        CharacteristicData firstRegisteredUser = new CharacteristicData(REGISTERED_USER_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);

        UserDataServiceData result1 = new UserDataServiceData(firstFirstName
                , firstLastName
                , firstEmailAddress
                , firstAge
                , firstDateOfBirth
                , firstGender
                , firstWeight
                , firstHeight
                , firstVo2Max
                , firstHeartRateMax
                , firstRestingHeartRate
                , firstMaximumRecommendedHeartRate
                , firstAerobicThreshold
                , firstAnaerobicThreshold
                , firstSportTypeForAerobicAndAnaerobicThresholds
                , null
                , firstWaistCircumference
                , firstHipCircumference
                , firstFatBurnHeartRateLowerLimit
                , firstFatBurnHeartRateUpperLimit
                , firstAerobicHeartRateLowerLimit
                , firstAerobicHeartRateUpperLimit
                , firstAnaerobicHeartRateLowerLimit
                , firstAnaerobicHeartRateUpperLimit
                , firstFiveZoneHeartRateLimits
                , firstThreeZoneHeartRateLimits
                , firstTwoZoneHeartRateLimit
                , firstLanguage
                , firstDatabaseChangeIncrement
                , firstUserIndex
                , firstUserControlPoint
                , firstRegisteredUser);

        UserDataServiceData result2 = new UserDataServiceData(firstFirstName
                , firstLastName
                , firstEmailAddress
                , firstAge
                , firstDateOfBirth
                , firstGender
                , firstWeight
                , firstHeight
                , firstVo2Max
                , firstHeartRateMax
                , firstRestingHeartRate
                , firstMaximumRecommendedHeartRate
                , firstAerobicThreshold
                , firstAnaerobicThreshold
                , firstSportTypeForAerobicAndAnaerobicThresholds
                , null
                , firstWaistCircumference
                , firstHipCircumference
                , firstFatBurnHeartRateLowerLimit
                , firstFatBurnHeartRateUpperLimit
                , firstAerobicHeartRateLowerLimit
                , firstAerobicHeartRateUpperLimit
                , firstAnaerobicHeartRateLowerLimit
                , firstAnaerobicHeartRateUpperLimit
                , firstFiveZoneHeartRateLimits
                , firstThreeZoneHeartRateLimits
                , firstTwoZoneHeartRateLimit
                , firstLanguage
                , firstDatabaseChangeIncrement
                , firstUserIndex
                , firstUserControlPoint
                , firstRegisteredUser);
        assertEquals(result1, result2);
    }

    @Test
    public void test_equals_00118() {
        UDSCharacteristicData firstFirstName = new UDSCharacteristicData(FIRST_NAME_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstLastName = new UDSCharacteristicData(LAST_NAME_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstEmailAddress = new UDSCharacteristicData(EMAIL_ADDRESS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAge = new UDSCharacteristicData(AGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstDateOfBirth = new UDSCharacteristicData(DATE_OF_BIRTH_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstGender = new UDSCharacteristicData(GENDER_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstWeight = new UDSCharacteristicData(WEIGHT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstHeight = new UDSCharacteristicData(HEIGHT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstVo2Max = new UDSCharacteristicData(VO2_MAX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstHeartRateMax = new UDSCharacteristicData(HEART_RATE_MAX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstRestingHeartRate = new UDSCharacteristicData(RESTING_HEART_RATE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstMaximumRecommendedHeartRate = new UDSCharacteristicData(MAXIMUM_RECOMMENDED_HEART_RATE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAerobicThreshold = new UDSCharacteristicData(AEROBIC_THRESHOLD_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAnaerobicThreshold = new UDSCharacteristicData(ANAEROBIC_THRESHOLD_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstSportTypeForAerobicAndAnaerobicThresholds = new UDSCharacteristicData(SPORT_TYPE_FOR_AEROBIC_AND_ANAEROBIC_THRESHOLDS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstDateOfThresholdAssessment = new UDSCharacteristicData(DATE_OF_THRESHOLD_ASSESSMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstHipCircumference = new UDSCharacteristicData(HIP_CIRCUMFERENCE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstFatBurnHeartRateLowerLimit = new UDSCharacteristicData(FAT_BURN_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstFatBurnHeartRateUpperLimit = new UDSCharacteristicData(FAT_BURN_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAerobicHeartRateLowerLimit = new UDSCharacteristicData(AEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAerobicHeartRateUpperLimit = new UDSCharacteristicData(AEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAnaerobicHeartRateLowerLimit = new UDSCharacteristicData(ANAEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAnaerobicHeartRateUpperLimit = new UDSCharacteristicData(ANAEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstFiveZoneHeartRateLimits = new UDSCharacteristicData(FIVE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstThreeZoneHeartRateLimits = new UDSCharacteristicData(THREE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstTwoZoneHeartRateLimit = new UDSCharacteristicData(TWO_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstLanguage = new UDSCharacteristicData(LANGUAGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstDatabaseChangeIncrement = new CharacteristicData(DATABASE_CHANGE_INCREMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstUserIndex = new CharacteristicData(USER_INDEX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UserControlPointCharacteristicData firstUserControlPoint = new UserControlPointCharacteristicData(1
                , 2
                , new ArrayList<>()
                , 3
                , 5
                , 6
                , 7
                , 8
                , 9);
        CharacteristicData firstRegisteredUser = new CharacteristicData(REGISTERED_USER_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);

        UserDataServiceData result1 = new UserDataServiceData(firstFirstName
                , firstLastName
                , firstEmailAddress
                , firstAge
                , firstDateOfBirth
                , firstGender
                , firstWeight
                , firstHeight
                , firstVo2Max
                , firstHeartRateMax
                , firstRestingHeartRate
                , firstMaximumRecommendedHeartRate
                , firstAerobicThreshold
                , firstAnaerobicThreshold
                , firstSportTypeForAerobicAndAnaerobicThresholds
                , firstDateOfThresholdAssessment
                , null
                , firstHipCircumference
                , firstFatBurnHeartRateLowerLimit
                , firstFatBurnHeartRateUpperLimit
                , firstAerobicHeartRateLowerLimit
                , firstAerobicHeartRateUpperLimit
                , firstAnaerobicHeartRateLowerLimit
                , firstAnaerobicHeartRateUpperLimit
                , firstFiveZoneHeartRateLimits
                , firstThreeZoneHeartRateLimits
                , firstTwoZoneHeartRateLimit
                , firstLanguage
                , firstDatabaseChangeIncrement
                , firstUserIndex
                , firstUserControlPoint
                , firstRegisteredUser);

        UserDataServiceData result2 = new UserDataServiceData(firstFirstName
                , firstLastName
                , firstEmailAddress
                , firstAge
                , firstDateOfBirth
                , firstGender
                , firstWeight
                , firstHeight
                , firstVo2Max
                , firstHeartRateMax
                , firstRestingHeartRate
                , firstMaximumRecommendedHeartRate
                , firstAerobicThreshold
                , firstAnaerobicThreshold
                , firstSportTypeForAerobicAndAnaerobicThresholds
                , firstDateOfThresholdAssessment
                , null
                , firstHipCircumference
                , firstFatBurnHeartRateLowerLimit
                , firstFatBurnHeartRateUpperLimit
                , firstAerobicHeartRateLowerLimit
                , firstAerobicHeartRateUpperLimit
                , firstAnaerobicHeartRateLowerLimit
                , firstAnaerobicHeartRateUpperLimit
                , firstFiveZoneHeartRateLimits
                , firstThreeZoneHeartRateLimits
                , firstTwoZoneHeartRateLimit
                , firstLanguage
                , firstDatabaseChangeIncrement
                , firstUserIndex
                , firstUserControlPoint
                , firstRegisteredUser);
        assertEquals(result1, result2);
    }

    @Test
    public void test_equals_00119() {
        UDSCharacteristicData firstFirstName = new UDSCharacteristicData(FIRST_NAME_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstLastName = new UDSCharacteristicData(LAST_NAME_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstEmailAddress = new UDSCharacteristicData(EMAIL_ADDRESS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAge = new UDSCharacteristicData(AGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstDateOfBirth = new UDSCharacteristicData(DATE_OF_BIRTH_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstGender = new UDSCharacteristicData(GENDER_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstWeight = new UDSCharacteristicData(WEIGHT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstHeight = new UDSCharacteristicData(HEIGHT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstVo2Max = new UDSCharacteristicData(VO2_MAX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstHeartRateMax = new UDSCharacteristicData(HEART_RATE_MAX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstRestingHeartRate = new UDSCharacteristicData(RESTING_HEART_RATE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstMaximumRecommendedHeartRate = new UDSCharacteristicData(MAXIMUM_RECOMMENDED_HEART_RATE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAerobicThreshold = new UDSCharacteristicData(AEROBIC_THRESHOLD_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAnaerobicThreshold = new UDSCharacteristicData(ANAEROBIC_THRESHOLD_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstSportTypeForAerobicAndAnaerobicThresholds = new UDSCharacteristicData(SPORT_TYPE_FOR_AEROBIC_AND_ANAEROBIC_THRESHOLDS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstDateOfThresholdAssessment = new UDSCharacteristicData(DATE_OF_THRESHOLD_ASSESSMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstWaistCircumference = new UDSCharacteristicData(WAIST_CIRCUMFERENCE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstFatBurnHeartRateLowerLimit = new UDSCharacteristicData(FAT_BURN_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstFatBurnHeartRateUpperLimit = new UDSCharacteristicData(FAT_BURN_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAerobicHeartRateLowerLimit = new UDSCharacteristicData(AEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAerobicHeartRateUpperLimit = new UDSCharacteristicData(AEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAnaerobicHeartRateLowerLimit = new UDSCharacteristicData(ANAEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAnaerobicHeartRateUpperLimit = new UDSCharacteristicData(ANAEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstFiveZoneHeartRateLimits = new UDSCharacteristicData(FIVE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstThreeZoneHeartRateLimits = new UDSCharacteristicData(THREE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstTwoZoneHeartRateLimit = new UDSCharacteristicData(TWO_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstLanguage = new UDSCharacteristicData(LANGUAGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstDatabaseChangeIncrement = new CharacteristicData(DATABASE_CHANGE_INCREMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstUserIndex = new CharacteristicData(USER_INDEX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UserControlPointCharacteristicData firstUserControlPoint = new UserControlPointCharacteristicData(1
                , 2
                , new ArrayList<>()
                , 3
                , 5
                , 6
                , 7
                , 8
                , 9);
        CharacteristicData firstRegisteredUser = new CharacteristicData(REGISTERED_USER_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);

        UserDataServiceData result1 = new UserDataServiceData(firstFirstName
                , firstLastName
                , firstEmailAddress
                , firstAge
                , firstDateOfBirth
                , firstGender
                , firstWeight
                , firstHeight
                , firstVo2Max
                , firstHeartRateMax
                , firstRestingHeartRate
                , firstMaximumRecommendedHeartRate
                , firstAerobicThreshold
                , firstAnaerobicThreshold
                , firstSportTypeForAerobicAndAnaerobicThresholds
                , firstDateOfThresholdAssessment
                , firstWaistCircumference
                , null
                , firstFatBurnHeartRateLowerLimit
                , firstFatBurnHeartRateUpperLimit
                , firstAerobicHeartRateLowerLimit
                , firstAerobicHeartRateUpperLimit
                , firstAnaerobicHeartRateLowerLimit
                , firstAnaerobicHeartRateUpperLimit
                , firstFiveZoneHeartRateLimits
                , firstThreeZoneHeartRateLimits
                , firstTwoZoneHeartRateLimit
                , firstLanguage
                , firstDatabaseChangeIncrement
                , firstUserIndex
                , firstUserControlPoint
                , firstRegisteredUser);

        UserDataServiceData result2 = new UserDataServiceData(firstFirstName
                , firstLastName
                , firstEmailAddress
                , firstAge
                , firstDateOfBirth
                , firstGender
                , firstWeight
                , firstHeight
                , firstVo2Max
                , firstHeartRateMax
                , firstRestingHeartRate
                , firstMaximumRecommendedHeartRate
                , firstAerobicThreshold
                , firstAnaerobicThreshold
                , firstSportTypeForAerobicAndAnaerobicThresholds
                , firstDateOfThresholdAssessment
                , firstWaistCircumference
                , null
                , firstFatBurnHeartRateLowerLimit
                , firstFatBurnHeartRateUpperLimit
                , firstAerobicHeartRateLowerLimit
                , firstAerobicHeartRateUpperLimit
                , firstAnaerobicHeartRateLowerLimit
                , firstAnaerobicHeartRateUpperLimit
                , firstFiveZoneHeartRateLimits
                , firstThreeZoneHeartRateLimits
                , firstTwoZoneHeartRateLimit
                , firstLanguage
                , firstDatabaseChangeIncrement
                , firstUserIndex
                , firstUserControlPoint
                , firstRegisteredUser);
        assertEquals(result1, result2);
    }

    @Test
    public void test_equals_00120() {
        UDSCharacteristicData firstFirstName = new UDSCharacteristicData(FIRST_NAME_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstLastName = new UDSCharacteristicData(LAST_NAME_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstEmailAddress = new UDSCharacteristicData(EMAIL_ADDRESS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAge = new UDSCharacteristicData(AGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstDateOfBirth = new UDSCharacteristicData(DATE_OF_BIRTH_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstGender = new UDSCharacteristicData(GENDER_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstWeight = new UDSCharacteristicData(WEIGHT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstHeight = new UDSCharacteristicData(HEIGHT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstVo2Max = new UDSCharacteristicData(VO2_MAX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstHeartRateMax = new UDSCharacteristicData(HEART_RATE_MAX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstRestingHeartRate = new UDSCharacteristicData(RESTING_HEART_RATE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstMaximumRecommendedHeartRate = new UDSCharacteristicData(MAXIMUM_RECOMMENDED_HEART_RATE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAerobicThreshold = new UDSCharacteristicData(AEROBIC_THRESHOLD_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAnaerobicThreshold = new UDSCharacteristicData(ANAEROBIC_THRESHOLD_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstSportTypeForAerobicAndAnaerobicThresholds = new UDSCharacteristicData(SPORT_TYPE_FOR_AEROBIC_AND_ANAEROBIC_THRESHOLDS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstDateOfThresholdAssessment = new UDSCharacteristicData(DATE_OF_THRESHOLD_ASSESSMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstWaistCircumference = new UDSCharacteristicData(WAIST_CIRCUMFERENCE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstHipCircumference = new UDSCharacteristicData(HIP_CIRCUMFERENCE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstFatBurnHeartRateUpperLimit = new UDSCharacteristicData(FAT_BURN_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAerobicHeartRateLowerLimit = new UDSCharacteristicData(AEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAerobicHeartRateUpperLimit = new UDSCharacteristicData(AEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAnaerobicHeartRateLowerLimit = new UDSCharacteristicData(ANAEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAnaerobicHeartRateUpperLimit = new UDSCharacteristicData(ANAEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstFiveZoneHeartRateLimits = new UDSCharacteristicData(FIVE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstThreeZoneHeartRateLimits = new UDSCharacteristicData(THREE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstTwoZoneHeartRateLimit = new UDSCharacteristicData(TWO_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstLanguage = new UDSCharacteristicData(LANGUAGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstDatabaseChangeIncrement = new CharacteristicData(DATABASE_CHANGE_INCREMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstUserIndex = new CharacteristicData(USER_INDEX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UserControlPointCharacteristicData firstUserControlPoint = new UserControlPointCharacteristicData(1
                , 2
                , new ArrayList<>()
                , 3
                , 5
                , 6
                , 7
                , 8
                , 9);
        CharacteristicData firstRegisteredUser = new CharacteristicData(REGISTERED_USER_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);

        UserDataServiceData result1 = new UserDataServiceData(firstFirstName
                , firstLastName
                , firstEmailAddress
                , firstAge
                , firstDateOfBirth
                , firstGender
                , firstWeight
                , firstHeight
                , firstVo2Max
                , firstHeartRateMax
                , firstRestingHeartRate
                , firstMaximumRecommendedHeartRate
                , firstAerobicThreshold
                , firstAnaerobicThreshold
                , firstSportTypeForAerobicAndAnaerobicThresholds
                , firstDateOfThresholdAssessment
                , firstWaistCircumference
                , firstHipCircumference
                , null
                , firstFatBurnHeartRateUpperLimit
                , firstAerobicHeartRateLowerLimit
                , firstAerobicHeartRateUpperLimit
                , firstAnaerobicHeartRateLowerLimit
                , firstAnaerobicHeartRateUpperLimit
                , firstFiveZoneHeartRateLimits
                , firstThreeZoneHeartRateLimits
                , firstTwoZoneHeartRateLimit
                , firstLanguage
                , firstDatabaseChangeIncrement
                , firstUserIndex
                , firstUserControlPoint
                , firstRegisteredUser);

        UserDataServiceData result2 = new UserDataServiceData(firstFirstName
                , firstLastName
                , firstEmailAddress
                , firstAge
                , firstDateOfBirth
                , firstGender
                , firstWeight
                , firstHeight
                , firstVo2Max
                , firstHeartRateMax
                , firstRestingHeartRate
                , firstMaximumRecommendedHeartRate
                , firstAerobicThreshold
                , firstAnaerobicThreshold
                , firstSportTypeForAerobicAndAnaerobicThresholds
                , firstDateOfThresholdAssessment
                , firstWaistCircumference
                , firstHipCircumference
                , null
                , firstFatBurnHeartRateUpperLimit
                , firstAerobicHeartRateLowerLimit
                , firstAerobicHeartRateUpperLimit
                , firstAnaerobicHeartRateLowerLimit
                , firstAnaerobicHeartRateUpperLimit
                , firstFiveZoneHeartRateLimits
                , firstThreeZoneHeartRateLimits
                , firstTwoZoneHeartRateLimit
                , firstLanguage
                , firstDatabaseChangeIncrement
                , firstUserIndex
                , firstUserControlPoint
                , firstRegisteredUser);
        assertEquals(result1, result2);
    }

    @Test
    public void test_equals_00121() {
        UDSCharacteristicData firstFirstName = new UDSCharacteristicData(FIRST_NAME_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstLastName = new UDSCharacteristicData(LAST_NAME_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstEmailAddress = new UDSCharacteristicData(EMAIL_ADDRESS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAge = new UDSCharacteristicData(AGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstDateOfBirth = new UDSCharacteristicData(DATE_OF_BIRTH_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstGender = new UDSCharacteristicData(GENDER_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstWeight = new UDSCharacteristicData(WEIGHT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstHeight = new UDSCharacteristicData(HEIGHT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstVo2Max = new UDSCharacteristicData(VO2_MAX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstHeartRateMax = new UDSCharacteristicData(HEART_RATE_MAX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstRestingHeartRate = new UDSCharacteristicData(RESTING_HEART_RATE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstMaximumRecommendedHeartRate = new UDSCharacteristicData(MAXIMUM_RECOMMENDED_HEART_RATE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAerobicThreshold = new UDSCharacteristicData(AEROBIC_THRESHOLD_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAnaerobicThreshold = new UDSCharacteristicData(ANAEROBIC_THRESHOLD_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstSportTypeForAerobicAndAnaerobicThresholds = new UDSCharacteristicData(SPORT_TYPE_FOR_AEROBIC_AND_ANAEROBIC_THRESHOLDS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstDateOfThresholdAssessment = new UDSCharacteristicData(DATE_OF_THRESHOLD_ASSESSMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstWaistCircumference = new UDSCharacteristicData(WAIST_CIRCUMFERENCE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstHipCircumference = new UDSCharacteristicData(HIP_CIRCUMFERENCE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstFatBurnHeartRateLowerLimit = new UDSCharacteristicData(FAT_BURN_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAerobicHeartRateLowerLimit = new UDSCharacteristicData(AEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAerobicHeartRateUpperLimit = new UDSCharacteristicData(AEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAnaerobicHeartRateLowerLimit = new UDSCharacteristicData(ANAEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAnaerobicHeartRateUpperLimit = new UDSCharacteristicData(ANAEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstFiveZoneHeartRateLimits = new UDSCharacteristicData(FIVE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstThreeZoneHeartRateLimits = new UDSCharacteristicData(THREE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstTwoZoneHeartRateLimit = new UDSCharacteristicData(TWO_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstLanguage = new UDSCharacteristicData(LANGUAGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstDatabaseChangeIncrement = new CharacteristicData(DATABASE_CHANGE_INCREMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstUserIndex = new CharacteristicData(USER_INDEX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UserControlPointCharacteristicData firstUserControlPoint = new UserControlPointCharacteristicData(1
                , 2
                , new ArrayList<>()
                , 3
                , 5
                , 6
                , 7
                , 8
                , 9);
        CharacteristicData firstRegisteredUser = new CharacteristicData(REGISTERED_USER_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);

        UserDataServiceData result1 = new UserDataServiceData(firstFirstName
                , firstLastName
                , firstEmailAddress
                , firstAge
                , firstDateOfBirth
                , firstGender
                , firstWeight
                , firstHeight
                , firstVo2Max
                , firstHeartRateMax
                , firstRestingHeartRate
                , firstMaximumRecommendedHeartRate
                , firstAerobicThreshold
                , firstAnaerobicThreshold
                , firstSportTypeForAerobicAndAnaerobicThresholds
                , firstDateOfThresholdAssessment
                , firstWaistCircumference
                , firstHipCircumference
                , firstFatBurnHeartRateLowerLimit
                , null
                , firstAerobicHeartRateLowerLimit
                , firstAerobicHeartRateUpperLimit
                , firstAnaerobicHeartRateLowerLimit
                , firstAnaerobicHeartRateUpperLimit
                , firstFiveZoneHeartRateLimits
                , firstThreeZoneHeartRateLimits
                , firstTwoZoneHeartRateLimit
                , firstLanguage
                , firstDatabaseChangeIncrement
                , firstUserIndex
                , firstUserControlPoint
                , firstRegisteredUser);

        UserDataServiceData result2 = new UserDataServiceData(firstFirstName
                , firstLastName
                , firstEmailAddress
                , firstAge
                , firstDateOfBirth
                , firstGender
                , firstWeight
                , firstHeight
                , firstVo2Max
                , firstHeartRateMax
                , firstRestingHeartRate
                , firstMaximumRecommendedHeartRate
                , firstAerobicThreshold
                , firstAnaerobicThreshold
                , firstSportTypeForAerobicAndAnaerobicThresholds
                , firstDateOfThresholdAssessment
                , firstWaistCircumference
                , firstHipCircumference
                , firstFatBurnHeartRateLowerLimit
                , null
                , firstAerobicHeartRateLowerLimit
                , firstAerobicHeartRateUpperLimit
                , firstAnaerobicHeartRateLowerLimit
                , firstAnaerobicHeartRateUpperLimit
                , firstFiveZoneHeartRateLimits
                , firstThreeZoneHeartRateLimits
                , firstTwoZoneHeartRateLimit
                , firstLanguage
                , firstDatabaseChangeIncrement
                , firstUserIndex
                , firstUserControlPoint
                , firstRegisteredUser);
        assertEquals(result1, result2);
    }

    @Test
    public void test_equals_00122() {
        UDSCharacteristicData firstFirstName = new UDSCharacteristicData(FIRST_NAME_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstLastName = new UDSCharacteristicData(LAST_NAME_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstEmailAddress = new UDSCharacteristicData(EMAIL_ADDRESS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAge = new UDSCharacteristicData(AGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstDateOfBirth = new UDSCharacteristicData(DATE_OF_BIRTH_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstGender = new UDSCharacteristicData(GENDER_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstWeight = new UDSCharacteristicData(WEIGHT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstHeight = new UDSCharacteristicData(HEIGHT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstVo2Max = new UDSCharacteristicData(VO2_MAX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstHeartRateMax = new UDSCharacteristicData(HEART_RATE_MAX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstRestingHeartRate = new UDSCharacteristicData(RESTING_HEART_RATE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstMaximumRecommendedHeartRate = new UDSCharacteristicData(MAXIMUM_RECOMMENDED_HEART_RATE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAerobicThreshold = new UDSCharacteristicData(AEROBIC_THRESHOLD_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAnaerobicThreshold = new UDSCharacteristicData(ANAEROBIC_THRESHOLD_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstSportTypeForAerobicAndAnaerobicThresholds = new UDSCharacteristicData(SPORT_TYPE_FOR_AEROBIC_AND_ANAEROBIC_THRESHOLDS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstDateOfThresholdAssessment = new UDSCharacteristicData(DATE_OF_THRESHOLD_ASSESSMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstWaistCircumference = new UDSCharacteristicData(WAIST_CIRCUMFERENCE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstHipCircumference = new UDSCharacteristicData(HIP_CIRCUMFERENCE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstFatBurnHeartRateLowerLimit = new UDSCharacteristicData(FAT_BURN_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstFatBurnHeartRateUpperLimit = new UDSCharacteristicData(FAT_BURN_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAerobicHeartRateUpperLimit = new UDSCharacteristicData(AEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAnaerobicHeartRateLowerLimit = new UDSCharacteristicData(ANAEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAnaerobicHeartRateUpperLimit = new UDSCharacteristicData(ANAEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstFiveZoneHeartRateLimits = new UDSCharacteristicData(FIVE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstThreeZoneHeartRateLimits = new UDSCharacteristicData(THREE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstTwoZoneHeartRateLimit = new UDSCharacteristicData(TWO_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstLanguage = new UDSCharacteristicData(LANGUAGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstDatabaseChangeIncrement = new CharacteristicData(DATABASE_CHANGE_INCREMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstUserIndex = new CharacteristicData(USER_INDEX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UserControlPointCharacteristicData firstUserControlPoint = new UserControlPointCharacteristicData(1
                , 2
                , new ArrayList<>()
                , 3
                , 5
                , 6
                , 7
                , 8
                , 9);
        CharacteristicData firstRegisteredUser = new CharacteristicData(REGISTERED_USER_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);

        UserDataServiceData result1 = new UserDataServiceData(firstFirstName
                , firstLastName
                , firstEmailAddress
                , firstAge
                , firstDateOfBirth
                , firstGender
                , firstWeight
                , firstHeight
                , firstVo2Max
                , firstHeartRateMax
                , firstRestingHeartRate
                , firstMaximumRecommendedHeartRate
                , firstAerobicThreshold
                , firstAnaerobicThreshold
                , firstSportTypeForAerobicAndAnaerobicThresholds
                , firstDateOfThresholdAssessment
                , firstWaistCircumference
                , firstHipCircumference
                , firstFatBurnHeartRateLowerLimit
                , firstFatBurnHeartRateUpperLimit
                , null
                , firstAerobicHeartRateUpperLimit
                , firstAnaerobicHeartRateLowerLimit
                , firstAnaerobicHeartRateUpperLimit
                , firstFiveZoneHeartRateLimits
                , firstThreeZoneHeartRateLimits
                , firstTwoZoneHeartRateLimit
                , firstLanguage
                , firstDatabaseChangeIncrement
                , firstUserIndex
                , firstUserControlPoint
                , firstRegisteredUser);

        UserDataServiceData result2 = new UserDataServiceData(firstFirstName
                , firstLastName
                , firstEmailAddress
                , firstAge
                , firstDateOfBirth
                , firstGender
                , firstWeight
                , firstHeight
                , firstVo2Max
                , firstHeartRateMax
                , firstRestingHeartRate
                , firstMaximumRecommendedHeartRate
                , firstAerobicThreshold
                , firstAnaerobicThreshold
                , firstSportTypeForAerobicAndAnaerobicThresholds
                , firstDateOfThresholdAssessment
                , firstWaistCircumference
                , firstHipCircumference
                , firstFatBurnHeartRateLowerLimit
                , firstFatBurnHeartRateUpperLimit
                , null
                , firstAerobicHeartRateUpperLimit
                , firstAnaerobicHeartRateLowerLimit
                , firstAnaerobicHeartRateUpperLimit
                , firstFiveZoneHeartRateLimits
                , firstThreeZoneHeartRateLimits
                , firstTwoZoneHeartRateLimit
                , firstLanguage
                , firstDatabaseChangeIncrement
                , firstUserIndex
                , firstUserControlPoint
                , firstRegisteredUser);
        assertEquals(result1, result2);
    }

    @Test
    public void test_equals_00123() {
        UDSCharacteristicData firstFirstName = new UDSCharacteristicData(FIRST_NAME_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstLastName = new UDSCharacteristicData(LAST_NAME_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstEmailAddress = new UDSCharacteristicData(EMAIL_ADDRESS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAge = new UDSCharacteristicData(AGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstDateOfBirth = new UDSCharacteristicData(DATE_OF_BIRTH_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstGender = new UDSCharacteristicData(GENDER_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstWeight = new UDSCharacteristicData(WEIGHT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstHeight = new UDSCharacteristicData(HEIGHT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstVo2Max = new UDSCharacteristicData(VO2_MAX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstHeartRateMax = new UDSCharacteristicData(HEART_RATE_MAX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstRestingHeartRate = new UDSCharacteristicData(RESTING_HEART_RATE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstMaximumRecommendedHeartRate = new UDSCharacteristicData(MAXIMUM_RECOMMENDED_HEART_RATE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAerobicThreshold = new UDSCharacteristicData(AEROBIC_THRESHOLD_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAnaerobicThreshold = new UDSCharacteristicData(ANAEROBIC_THRESHOLD_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstSportTypeForAerobicAndAnaerobicThresholds = new UDSCharacteristicData(SPORT_TYPE_FOR_AEROBIC_AND_ANAEROBIC_THRESHOLDS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstDateOfThresholdAssessment = new UDSCharacteristicData(DATE_OF_THRESHOLD_ASSESSMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstWaistCircumference = new UDSCharacteristicData(WAIST_CIRCUMFERENCE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstHipCircumference = new UDSCharacteristicData(HIP_CIRCUMFERENCE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstFatBurnHeartRateLowerLimit = new UDSCharacteristicData(FAT_BURN_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstFatBurnHeartRateUpperLimit = new UDSCharacteristicData(FAT_BURN_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAerobicHeartRateLowerLimit = new UDSCharacteristicData(AEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAnaerobicHeartRateLowerLimit = new UDSCharacteristicData(ANAEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAnaerobicHeartRateUpperLimit = new UDSCharacteristicData(ANAEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstFiveZoneHeartRateLimits = new UDSCharacteristicData(FIVE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstThreeZoneHeartRateLimits = new UDSCharacteristicData(THREE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstTwoZoneHeartRateLimit = new UDSCharacteristicData(TWO_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstLanguage = new UDSCharacteristicData(LANGUAGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstDatabaseChangeIncrement = new CharacteristicData(DATABASE_CHANGE_INCREMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstUserIndex = new CharacteristicData(USER_INDEX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UserControlPointCharacteristicData firstUserControlPoint = new UserControlPointCharacteristicData(1
                , 2
                , new ArrayList<>()
                , 3
                , 5
                , 6
                , 7
                , 8
                , 9);
        CharacteristicData firstRegisteredUser = new CharacteristicData(REGISTERED_USER_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);

        UserDataServiceData result1 = new UserDataServiceData(firstFirstName
                , firstLastName
                , firstEmailAddress
                , firstAge
                , firstDateOfBirth
                , firstGender
                , firstWeight
                , firstHeight
                , firstVo2Max
                , firstHeartRateMax
                , firstRestingHeartRate
                , firstMaximumRecommendedHeartRate
                , firstAerobicThreshold
                , firstAnaerobicThreshold
                , firstSportTypeForAerobicAndAnaerobicThresholds
                , firstDateOfThresholdAssessment
                , firstWaistCircumference
                , firstHipCircumference
                , firstFatBurnHeartRateLowerLimit
                , firstFatBurnHeartRateUpperLimit
                , firstAerobicHeartRateLowerLimit
                , null
                , firstAnaerobicHeartRateLowerLimit
                , firstAnaerobicHeartRateUpperLimit
                , firstFiveZoneHeartRateLimits
                , firstThreeZoneHeartRateLimits
                , firstTwoZoneHeartRateLimit
                , firstLanguage
                , firstDatabaseChangeIncrement
                , firstUserIndex
                , firstUserControlPoint
                , firstRegisteredUser);

        UserDataServiceData result2 = new UserDataServiceData(firstFirstName
                , firstLastName
                , firstEmailAddress
                , firstAge
                , firstDateOfBirth
                , firstGender
                , firstWeight
                , firstHeight
                , firstVo2Max
                , firstHeartRateMax
                , firstRestingHeartRate
                , firstMaximumRecommendedHeartRate
                , firstAerobicThreshold
                , firstAnaerobicThreshold
                , firstSportTypeForAerobicAndAnaerobicThresholds
                , firstDateOfThresholdAssessment
                , firstWaistCircumference
                , firstHipCircumference
                , firstFatBurnHeartRateLowerLimit
                , firstFatBurnHeartRateUpperLimit
                , firstAerobicHeartRateLowerLimit
                , null
                , firstAnaerobicHeartRateLowerLimit
                , firstAnaerobicHeartRateUpperLimit
                , firstFiveZoneHeartRateLimits
                , firstThreeZoneHeartRateLimits
                , firstTwoZoneHeartRateLimit
                , firstLanguage
                , firstDatabaseChangeIncrement
                , firstUserIndex
                , firstUserControlPoint
                , firstRegisteredUser);
        assertEquals(result1, result2);
    }

    @Test
    public void test_equals_00124() {
        UDSCharacteristicData firstFirstName = new UDSCharacteristicData(FIRST_NAME_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstLastName = new UDSCharacteristicData(LAST_NAME_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstEmailAddress = new UDSCharacteristicData(EMAIL_ADDRESS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAge = new UDSCharacteristicData(AGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstDateOfBirth = new UDSCharacteristicData(DATE_OF_BIRTH_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstGender = new UDSCharacteristicData(GENDER_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstWeight = new UDSCharacteristicData(WEIGHT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstHeight = new UDSCharacteristicData(HEIGHT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstVo2Max = new UDSCharacteristicData(VO2_MAX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstHeartRateMax = new UDSCharacteristicData(HEART_RATE_MAX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstRestingHeartRate = new UDSCharacteristicData(RESTING_HEART_RATE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstMaximumRecommendedHeartRate = new UDSCharacteristicData(MAXIMUM_RECOMMENDED_HEART_RATE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAerobicThreshold = new UDSCharacteristicData(AEROBIC_THRESHOLD_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAnaerobicThreshold = new UDSCharacteristicData(ANAEROBIC_THRESHOLD_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstSportTypeForAerobicAndAnaerobicThresholds = new UDSCharacteristicData(SPORT_TYPE_FOR_AEROBIC_AND_ANAEROBIC_THRESHOLDS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstDateOfThresholdAssessment = new UDSCharacteristicData(DATE_OF_THRESHOLD_ASSESSMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstWaistCircumference = new UDSCharacteristicData(WAIST_CIRCUMFERENCE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstHipCircumference = new UDSCharacteristicData(HIP_CIRCUMFERENCE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstFatBurnHeartRateLowerLimit = new UDSCharacteristicData(FAT_BURN_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstFatBurnHeartRateUpperLimit = new UDSCharacteristicData(FAT_BURN_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAerobicHeartRateLowerLimit = new UDSCharacteristicData(AEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAerobicHeartRateUpperLimit = new UDSCharacteristicData(AEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAnaerobicHeartRateUpperLimit = new UDSCharacteristicData(ANAEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstFiveZoneHeartRateLimits = new UDSCharacteristicData(FIVE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstThreeZoneHeartRateLimits = new UDSCharacteristicData(THREE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstTwoZoneHeartRateLimit = new UDSCharacteristicData(TWO_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstLanguage = new UDSCharacteristicData(LANGUAGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstDatabaseChangeIncrement = new CharacteristicData(DATABASE_CHANGE_INCREMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstUserIndex = new CharacteristicData(USER_INDEX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UserControlPointCharacteristicData firstUserControlPoint = new UserControlPointCharacteristicData(1
                , 2
                , new ArrayList<>()
                , 3
                , 5
                , 6
                , 7
                , 8
                , 9);
        CharacteristicData firstRegisteredUser = new CharacteristicData(REGISTERED_USER_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);

        UserDataServiceData result1 = new UserDataServiceData(firstFirstName
                , firstLastName
                , firstEmailAddress
                , firstAge
                , firstDateOfBirth
                , firstGender
                , firstWeight
                , firstHeight
                , firstVo2Max
                , firstHeartRateMax
                , firstRestingHeartRate
                , firstMaximumRecommendedHeartRate
                , firstAerobicThreshold
                , firstAnaerobicThreshold
                , firstSportTypeForAerobicAndAnaerobicThresholds
                , firstDateOfThresholdAssessment
                , firstWaistCircumference
                , firstHipCircumference
                , firstFatBurnHeartRateLowerLimit
                , firstFatBurnHeartRateUpperLimit
                , firstAerobicHeartRateLowerLimit
                , firstAerobicHeartRateUpperLimit
                , null
                , firstAnaerobicHeartRateUpperLimit
                , firstFiveZoneHeartRateLimits
                , firstThreeZoneHeartRateLimits
                , firstTwoZoneHeartRateLimit
                , firstLanguage
                , firstDatabaseChangeIncrement
                , firstUserIndex
                , firstUserControlPoint
                , firstRegisteredUser);

        UserDataServiceData result2 = new UserDataServiceData(firstFirstName
                , firstLastName
                , firstEmailAddress
                , firstAge
                , firstDateOfBirth
                , firstGender
                , firstWeight
                , firstHeight
                , firstVo2Max
                , firstHeartRateMax
                , firstRestingHeartRate
                , firstMaximumRecommendedHeartRate
                , firstAerobicThreshold
                , firstAnaerobicThreshold
                , firstSportTypeForAerobicAndAnaerobicThresholds
                , firstDateOfThresholdAssessment
                , firstWaistCircumference
                , firstHipCircumference
                , firstFatBurnHeartRateLowerLimit
                , firstFatBurnHeartRateUpperLimit
                , firstAerobicHeartRateLowerLimit
                , firstAerobicHeartRateUpperLimit
                , null
                , firstAnaerobicHeartRateUpperLimit
                , firstFiveZoneHeartRateLimits
                , firstThreeZoneHeartRateLimits
                , firstTwoZoneHeartRateLimit
                , firstLanguage
                , firstDatabaseChangeIncrement
                , firstUserIndex
                , firstUserControlPoint
                , firstRegisteredUser);
        assertEquals(result1, result2);
    }

    @Test
    public void test_equals_00125() {
        UDSCharacteristicData firstFirstName = new UDSCharacteristicData(FIRST_NAME_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstLastName = new UDSCharacteristicData(LAST_NAME_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstEmailAddress = new UDSCharacteristicData(EMAIL_ADDRESS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAge = new UDSCharacteristicData(AGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstDateOfBirth = new UDSCharacteristicData(DATE_OF_BIRTH_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstGender = new UDSCharacteristicData(GENDER_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstWeight = new UDSCharacteristicData(WEIGHT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstHeight = new UDSCharacteristicData(HEIGHT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstVo2Max = new UDSCharacteristicData(VO2_MAX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstHeartRateMax = new UDSCharacteristicData(HEART_RATE_MAX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstRestingHeartRate = new UDSCharacteristicData(RESTING_HEART_RATE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstMaximumRecommendedHeartRate = new UDSCharacteristicData(MAXIMUM_RECOMMENDED_HEART_RATE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAerobicThreshold = new UDSCharacteristicData(AEROBIC_THRESHOLD_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAnaerobicThreshold = new UDSCharacteristicData(ANAEROBIC_THRESHOLD_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstSportTypeForAerobicAndAnaerobicThresholds = new UDSCharacteristicData(SPORT_TYPE_FOR_AEROBIC_AND_ANAEROBIC_THRESHOLDS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstDateOfThresholdAssessment = new UDSCharacteristicData(DATE_OF_THRESHOLD_ASSESSMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstWaistCircumference = new UDSCharacteristicData(WAIST_CIRCUMFERENCE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstHipCircumference = new UDSCharacteristicData(HIP_CIRCUMFERENCE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstFatBurnHeartRateLowerLimit = new UDSCharacteristicData(FAT_BURN_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstFatBurnHeartRateUpperLimit = new UDSCharacteristicData(FAT_BURN_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAerobicHeartRateLowerLimit = new UDSCharacteristicData(AEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAerobicHeartRateUpperLimit = new UDSCharacteristicData(AEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAnaerobicHeartRateLowerLimit = new UDSCharacteristicData(ANAEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstFiveZoneHeartRateLimits = new UDSCharacteristicData(FIVE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstThreeZoneHeartRateLimits = new UDSCharacteristicData(THREE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstTwoZoneHeartRateLimit = new UDSCharacteristicData(TWO_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstLanguage = new UDSCharacteristicData(LANGUAGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstDatabaseChangeIncrement = new CharacteristicData(DATABASE_CHANGE_INCREMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstUserIndex = new CharacteristicData(USER_INDEX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UserControlPointCharacteristicData firstUserControlPoint = new UserControlPointCharacteristicData(1
                , 2
                , new ArrayList<>()
                , 3
                , 5
                , 6
                , 7
                , 8
                , 9);
        CharacteristicData firstRegisteredUser = new CharacteristicData(REGISTERED_USER_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);

        UserDataServiceData result1 = new UserDataServiceData(firstFirstName
                , firstLastName
                , firstEmailAddress
                , firstAge
                , firstDateOfBirth
                , firstGender
                , firstWeight
                , firstHeight
                , firstVo2Max
                , firstHeartRateMax
                , firstRestingHeartRate
                , firstMaximumRecommendedHeartRate
                , firstAerobicThreshold
                , firstAnaerobicThreshold
                , firstSportTypeForAerobicAndAnaerobicThresholds
                , firstDateOfThresholdAssessment
                , firstWaistCircumference
                , firstHipCircumference
                , firstFatBurnHeartRateLowerLimit
                , firstFatBurnHeartRateUpperLimit
                , firstAerobicHeartRateLowerLimit
                , firstAerobicHeartRateUpperLimit
                , firstAnaerobicHeartRateLowerLimit
                , null
                , firstFiveZoneHeartRateLimits
                , firstThreeZoneHeartRateLimits
                , firstTwoZoneHeartRateLimit
                , firstLanguage
                , firstDatabaseChangeIncrement
                , firstUserIndex
                , firstUserControlPoint
                , firstRegisteredUser);

        UserDataServiceData result2 = new UserDataServiceData(firstFirstName
                , firstLastName
                , firstEmailAddress
                , firstAge
                , firstDateOfBirth
                , firstGender
                , firstWeight
                , firstHeight
                , firstVo2Max
                , firstHeartRateMax
                , firstRestingHeartRate
                , firstMaximumRecommendedHeartRate
                , firstAerobicThreshold
                , firstAnaerobicThreshold
                , firstSportTypeForAerobicAndAnaerobicThresholds
                , firstDateOfThresholdAssessment
                , firstWaistCircumference
                , firstHipCircumference
                , firstFatBurnHeartRateLowerLimit
                , firstFatBurnHeartRateUpperLimit
                , firstAerobicHeartRateLowerLimit
                , firstAerobicHeartRateUpperLimit
                , firstAnaerobicHeartRateLowerLimit
                , null
                , firstFiveZoneHeartRateLimits
                , firstThreeZoneHeartRateLimits
                , firstTwoZoneHeartRateLimit
                , firstLanguage
                , firstDatabaseChangeIncrement
                , firstUserIndex
                , firstUserControlPoint
                , firstRegisteredUser);
        assertEquals(result1, result2);
    }

    @Test
    public void test_equals_00126() {
        UDSCharacteristicData firstFirstName = new UDSCharacteristicData(FIRST_NAME_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstLastName = new UDSCharacteristicData(LAST_NAME_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstEmailAddress = new UDSCharacteristicData(EMAIL_ADDRESS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAge = new UDSCharacteristicData(AGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstDateOfBirth = new UDSCharacteristicData(DATE_OF_BIRTH_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstGender = new UDSCharacteristicData(GENDER_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstWeight = new UDSCharacteristicData(WEIGHT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstHeight = new UDSCharacteristicData(HEIGHT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstVo2Max = new UDSCharacteristicData(VO2_MAX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstHeartRateMax = new UDSCharacteristicData(HEART_RATE_MAX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstRestingHeartRate = new UDSCharacteristicData(RESTING_HEART_RATE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstMaximumRecommendedHeartRate = new UDSCharacteristicData(MAXIMUM_RECOMMENDED_HEART_RATE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAerobicThreshold = new UDSCharacteristicData(AEROBIC_THRESHOLD_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAnaerobicThreshold = new UDSCharacteristicData(ANAEROBIC_THRESHOLD_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstSportTypeForAerobicAndAnaerobicThresholds = new UDSCharacteristicData(SPORT_TYPE_FOR_AEROBIC_AND_ANAEROBIC_THRESHOLDS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstDateOfThresholdAssessment = new UDSCharacteristicData(DATE_OF_THRESHOLD_ASSESSMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstWaistCircumference = new UDSCharacteristicData(WAIST_CIRCUMFERENCE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstHipCircumference = new UDSCharacteristicData(HIP_CIRCUMFERENCE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstFatBurnHeartRateLowerLimit = new UDSCharacteristicData(FAT_BURN_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstFatBurnHeartRateUpperLimit = new UDSCharacteristicData(FAT_BURN_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAerobicHeartRateLowerLimit = new UDSCharacteristicData(AEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAerobicHeartRateUpperLimit = new UDSCharacteristicData(AEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAnaerobicHeartRateLowerLimit = new UDSCharacteristicData(ANAEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAnaerobicHeartRateUpperLimit = new UDSCharacteristicData(ANAEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstThreeZoneHeartRateLimits = new UDSCharacteristicData(THREE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstTwoZoneHeartRateLimit = new UDSCharacteristicData(TWO_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstLanguage = new UDSCharacteristicData(LANGUAGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstDatabaseChangeIncrement = new CharacteristicData(DATABASE_CHANGE_INCREMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstUserIndex = new CharacteristicData(USER_INDEX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UserControlPointCharacteristicData firstUserControlPoint = new UserControlPointCharacteristicData(1
                , 2
                , new ArrayList<>()
                , 3
                , 5
                , 6
                , 7
                , 8
                , 9);
        CharacteristicData firstRegisteredUser = new CharacteristicData(REGISTERED_USER_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);

        UserDataServiceData result1 = new UserDataServiceData(firstFirstName
                , firstLastName
                , firstEmailAddress
                , firstAge
                , firstDateOfBirth
                , firstGender
                , firstWeight
                , firstHeight
                , firstVo2Max
                , firstHeartRateMax
                , firstRestingHeartRate
                , firstMaximumRecommendedHeartRate
                , firstAerobicThreshold
                , firstAnaerobicThreshold
                , firstSportTypeForAerobicAndAnaerobicThresholds
                , firstDateOfThresholdAssessment
                , firstWaistCircumference
                , firstHipCircumference
                , firstFatBurnHeartRateLowerLimit
                , firstFatBurnHeartRateUpperLimit
                , firstAerobicHeartRateLowerLimit
                , firstAerobicHeartRateUpperLimit
                , firstAnaerobicHeartRateLowerLimit
                , firstAnaerobicHeartRateUpperLimit
                , null
                , firstThreeZoneHeartRateLimits
                , firstTwoZoneHeartRateLimit
                , firstLanguage
                , firstDatabaseChangeIncrement
                , firstUserIndex
                , firstUserControlPoint
                , firstRegisteredUser);

        UserDataServiceData result2 = new UserDataServiceData(firstFirstName
                , firstLastName
                , firstEmailAddress
                , firstAge
                , firstDateOfBirth
                , firstGender
                , firstWeight
                , firstHeight
                , firstVo2Max
                , firstHeartRateMax
                , firstRestingHeartRate
                , firstMaximumRecommendedHeartRate
                , firstAerobicThreshold
                , firstAnaerobicThreshold
                , firstSportTypeForAerobicAndAnaerobicThresholds
                , firstDateOfThresholdAssessment
                , firstWaistCircumference
                , firstHipCircumference
                , firstFatBurnHeartRateLowerLimit
                , firstFatBurnHeartRateUpperLimit
                , firstAerobicHeartRateLowerLimit
                , firstAerobicHeartRateUpperLimit
                , firstAnaerobicHeartRateLowerLimit
                , firstAnaerobicHeartRateUpperLimit
                , null
                , firstThreeZoneHeartRateLimits
                , firstTwoZoneHeartRateLimit
                , firstLanguage
                , firstDatabaseChangeIncrement
                , firstUserIndex
                , firstUserControlPoint
                , firstRegisteredUser);
        assertEquals(result1, result2);
    }

    @Test
    public void test_equals_00127() {
        UDSCharacteristicData firstFirstName = new UDSCharacteristicData(FIRST_NAME_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstLastName = new UDSCharacteristicData(LAST_NAME_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstEmailAddress = new UDSCharacteristicData(EMAIL_ADDRESS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAge = new UDSCharacteristicData(AGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstDateOfBirth = new UDSCharacteristicData(DATE_OF_BIRTH_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstGender = new UDSCharacteristicData(GENDER_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstWeight = new UDSCharacteristicData(WEIGHT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstHeight = new UDSCharacteristicData(HEIGHT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstVo2Max = new UDSCharacteristicData(VO2_MAX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstHeartRateMax = new UDSCharacteristicData(HEART_RATE_MAX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstRestingHeartRate = new UDSCharacteristicData(RESTING_HEART_RATE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstMaximumRecommendedHeartRate = new UDSCharacteristicData(MAXIMUM_RECOMMENDED_HEART_RATE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAerobicThreshold = new UDSCharacteristicData(AEROBIC_THRESHOLD_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAnaerobicThreshold = new UDSCharacteristicData(ANAEROBIC_THRESHOLD_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstSportTypeForAerobicAndAnaerobicThresholds = new UDSCharacteristicData(SPORT_TYPE_FOR_AEROBIC_AND_ANAEROBIC_THRESHOLDS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstDateOfThresholdAssessment = new UDSCharacteristicData(DATE_OF_THRESHOLD_ASSESSMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstWaistCircumference = new UDSCharacteristicData(WAIST_CIRCUMFERENCE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstHipCircumference = new UDSCharacteristicData(HIP_CIRCUMFERENCE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstFatBurnHeartRateLowerLimit = new UDSCharacteristicData(FAT_BURN_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstFatBurnHeartRateUpperLimit = new UDSCharacteristicData(FAT_BURN_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAerobicHeartRateLowerLimit = new UDSCharacteristicData(AEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAerobicHeartRateUpperLimit = new UDSCharacteristicData(AEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAnaerobicHeartRateLowerLimit = new UDSCharacteristicData(ANAEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAnaerobicHeartRateUpperLimit = new UDSCharacteristicData(ANAEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstFiveZoneHeartRateLimits = new UDSCharacteristicData(FIVE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstTwoZoneHeartRateLimit = new UDSCharacteristicData(TWO_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstLanguage = new UDSCharacteristicData(LANGUAGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstDatabaseChangeIncrement = new CharacteristicData(DATABASE_CHANGE_INCREMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstUserIndex = new CharacteristicData(USER_INDEX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UserControlPointCharacteristicData firstUserControlPoint = new UserControlPointCharacteristicData(1
                , 2
                , new ArrayList<>()
                , 3
                , 5
                , 6
                , 7
                , 8
                , 9);
        CharacteristicData firstRegisteredUser = new CharacteristicData(REGISTERED_USER_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);

        UserDataServiceData result1 = new UserDataServiceData(firstFirstName
                , firstLastName
                , firstEmailAddress
                , firstAge
                , firstDateOfBirth
                , firstGender
                , firstWeight
                , firstHeight
                , firstVo2Max
                , firstHeartRateMax
                , firstRestingHeartRate
                , firstMaximumRecommendedHeartRate
                , firstAerobicThreshold
                , firstAnaerobicThreshold
                , firstSportTypeForAerobicAndAnaerobicThresholds
                , firstDateOfThresholdAssessment
                , firstWaistCircumference
                , firstHipCircumference
                , firstFatBurnHeartRateLowerLimit
                , firstFatBurnHeartRateUpperLimit
                , firstAerobicHeartRateLowerLimit
                , firstAerobicHeartRateUpperLimit
                , firstAnaerobicHeartRateLowerLimit
                , firstAnaerobicHeartRateUpperLimit
                , firstFiveZoneHeartRateLimits
                , null
                , firstTwoZoneHeartRateLimit
                , firstLanguage
                , firstDatabaseChangeIncrement
                , firstUserIndex
                , firstUserControlPoint
                , firstRegisteredUser);

        UserDataServiceData result2 = new UserDataServiceData(firstFirstName
                , firstLastName
                , firstEmailAddress
                , firstAge
                , firstDateOfBirth
                , firstGender
                , firstWeight
                , firstHeight
                , firstVo2Max
                , firstHeartRateMax
                , firstRestingHeartRate
                , firstMaximumRecommendedHeartRate
                , firstAerobicThreshold
                , firstAnaerobicThreshold
                , firstSportTypeForAerobicAndAnaerobicThresholds
                , firstDateOfThresholdAssessment
                , firstWaistCircumference
                , firstHipCircumference
                , firstFatBurnHeartRateLowerLimit
                , firstFatBurnHeartRateUpperLimit
                , firstAerobicHeartRateLowerLimit
                , firstAerobicHeartRateUpperLimit
                , firstAnaerobicHeartRateLowerLimit
                , firstAnaerobicHeartRateUpperLimit
                , firstFiveZoneHeartRateLimits
                , null
                , firstTwoZoneHeartRateLimit
                , firstLanguage
                , firstDatabaseChangeIncrement
                , firstUserIndex
                , firstUserControlPoint
                , firstRegisteredUser);
        assertEquals(result1, result2);
    }

    @Test
    public void test_equals_00128() {
        UDSCharacteristicData firstFirstName = new UDSCharacteristicData(FIRST_NAME_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstLastName = new UDSCharacteristicData(LAST_NAME_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstEmailAddress = new UDSCharacteristicData(EMAIL_ADDRESS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAge = new UDSCharacteristicData(AGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstDateOfBirth = new UDSCharacteristicData(DATE_OF_BIRTH_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstGender = new UDSCharacteristicData(GENDER_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstWeight = new UDSCharacteristicData(WEIGHT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstHeight = new UDSCharacteristicData(HEIGHT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstVo2Max = new UDSCharacteristicData(VO2_MAX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstHeartRateMax = new UDSCharacteristicData(HEART_RATE_MAX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstRestingHeartRate = new UDSCharacteristicData(RESTING_HEART_RATE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstMaximumRecommendedHeartRate = new UDSCharacteristicData(MAXIMUM_RECOMMENDED_HEART_RATE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAerobicThreshold = new UDSCharacteristicData(AEROBIC_THRESHOLD_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAnaerobicThreshold = new UDSCharacteristicData(ANAEROBIC_THRESHOLD_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstSportTypeForAerobicAndAnaerobicThresholds = new UDSCharacteristicData(SPORT_TYPE_FOR_AEROBIC_AND_ANAEROBIC_THRESHOLDS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstDateOfThresholdAssessment = new UDSCharacteristicData(DATE_OF_THRESHOLD_ASSESSMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstWaistCircumference = new UDSCharacteristicData(WAIST_CIRCUMFERENCE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstHipCircumference = new UDSCharacteristicData(HIP_CIRCUMFERENCE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstFatBurnHeartRateLowerLimit = new UDSCharacteristicData(FAT_BURN_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstFatBurnHeartRateUpperLimit = new UDSCharacteristicData(FAT_BURN_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAerobicHeartRateLowerLimit = new UDSCharacteristicData(AEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAerobicHeartRateUpperLimit = new UDSCharacteristicData(AEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAnaerobicHeartRateLowerLimit = new UDSCharacteristicData(ANAEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAnaerobicHeartRateUpperLimit = new UDSCharacteristicData(ANAEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstFiveZoneHeartRateLimits = new UDSCharacteristicData(FIVE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstThreeZoneHeartRateLimits = new UDSCharacteristicData(THREE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstLanguage = new UDSCharacteristicData(LANGUAGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstDatabaseChangeIncrement = new CharacteristicData(DATABASE_CHANGE_INCREMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstUserIndex = new CharacteristicData(USER_INDEX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UserControlPointCharacteristicData firstUserControlPoint = new UserControlPointCharacteristicData(1
                , 2
                , new ArrayList<>()
                , 3
                , 5
                , 6
                , 7
                , 8
                , 9);
        CharacteristicData firstRegisteredUser = new CharacteristicData(REGISTERED_USER_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);

        UserDataServiceData result1 = new UserDataServiceData(firstFirstName
                , firstLastName
                , firstEmailAddress
                , firstAge
                , firstDateOfBirth
                , firstGender
                , firstWeight
                , firstHeight
                , firstVo2Max
                , firstHeartRateMax
                , firstRestingHeartRate
                , firstMaximumRecommendedHeartRate
                , firstAerobicThreshold
                , firstAnaerobicThreshold
                , firstSportTypeForAerobicAndAnaerobicThresholds
                , firstDateOfThresholdAssessment
                , firstWaistCircumference
                , firstHipCircumference
                , firstFatBurnHeartRateLowerLimit
                , firstFatBurnHeartRateUpperLimit
                , firstAerobicHeartRateLowerLimit
                , firstAerobicHeartRateUpperLimit
                , firstAnaerobicHeartRateLowerLimit
                , firstAnaerobicHeartRateUpperLimit
                , firstFiveZoneHeartRateLimits
                , firstThreeZoneHeartRateLimits
                , null
                , firstLanguage
                , firstDatabaseChangeIncrement
                , firstUserIndex
                , firstUserControlPoint
                , firstRegisteredUser);

        UserDataServiceData result2 = new UserDataServiceData(firstFirstName
                , firstLastName
                , firstEmailAddress
                , firstAge
                , firstDateOfBirth
                , firstGender
                , firstWeight
                , firstHeight
                , firstVo2Max
                , firstHeartRateMax
                , firstRestingHeartRate
                , firstMaximumRecommendedHeartRate
                , firstAerobicThreshold
                , firstAnaerobicThreshold
                , firstSportTypeForAerobicAndAnaerobicThresholds
                , firstDateOfThresholdAssessment
                , firstWaistCircumference
                , firstHipCircumference
                , firstFatBurnHeartRateLowerLimit
                , firstFatBurnHeartRateUpperLimit
                , firstAerobicHeartRateLowerLimit
                , firstAerobicHeartRateUpperLimit
                , firstAnaerobicHeartRateLowerLimit
                , firstAnaerobicHeartRateUpperLimit
                , firstFiveZoneHeartRateLimits
                , firstThreeZoneHeartRateLimits
                , null
                , firstLanguage
                , firstDatabaseChangeIncrement
                , firstUserIndex
                , firstUserControlPoint
                , firstRegisteredUser);
        assertEquals(result1, result2);
    }

    @Test
    public void test_equals_00129() {
        UDSCharacteristicData firstFirstName = new UDSCharacteristicData(FIRST_NAME_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstLastName = new UDSCharacteristicData(LAST_NAME_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstEmailAddress = new UDSCharacteristicData(EMAIL_ADDRESS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAge = new UDSCharacteristicData(AGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstDateOfBirth = new UDSCharacteristicData(DATE_OF_BIRTH_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstGender = new UDSCharacteristicData(GENDER_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstWeight = new UDSCharacteristicData(WEIGHT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstHeight = new UDSCharacteristicData(HEIGHT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstVo2Max = new UDSCharacteristicData(VO2_MAX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstHeartRateMax = new UDSCharacteristicData(HEART_RATE_MAX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstRestingHeartRate = new UDSCharacteristicData(RESTING_HEART_RATE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstMaximumRecommendedHeartRate = new UDSCharacteristicData(MAXIMUM_RECOMMENDED_HEART_RATE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAerobicThreshold = new UDSCharacteristicData(AEROBIC_THRESHOLD_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAnaerobicThreshold = new UDSCharacteristicData(ANAEROBIC_THRESHOLD_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstSportTypeForAerobicAndAnaerobicThresholds = new UDSCharacteristicData(SPORT_TYPE_FOR_AEROBIC_AND_ANAEROBIC_THRESHOLDS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstDateOfThresholdAssessment = new UDSCharacteristicData(DATE_OF_THRESHOLD_ASSESSMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstWaistCircumference = new UDSCharacteristicData(WAIST_CIRCUMFERENCE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstHipCircumference = new UDSCharacteristicData(HIP_CIRCUMFERENCE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstFatBurnHeartRateLowerLimit = new UDSCharacteristicData(FAT_BURN_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstFatBurnHeartRateUpperLimit = new UDSCharacteristicData(FAT_BURN_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAerobicHeartRateLowerLimit = new UDSCharacteristicData(AEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAerobicHeartRateUpperLimit = new UDSCharacteristicData(AEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAnaerobicHeartRateLowerLimit = new UDSCharacteristicData(ANAEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAnaerobicHeartRateUpperLimit = new UDSCharacteristicData(ANAEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstFiveZoneHeartRateLimits = new UDSCharacteristicData(FIVE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstThreeZoneHeartRateLimits = new UDSCharacteristicData(THREE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstTwoZoneHeartRateLimit = new UDSCharacteristicData(TWO_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstDatabaseChangeIncrement = new CharacteristicData(DATABASE_CHANGE_INCREMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstUserIndex = new CharacteristicData(USER_INDEX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UserControlPointCharacteristicData firstUserControlPoint = new UserControlPointCharacteristicData(1
                , 2
                , new ArrayList<>()
                , 3
                , 5
                , 6
                , 7
                , 8
                , 9);
        CharacteristicData firstRegisteredUser = new CharacteristicData(REGISTERED_USER_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);

        UserDataServiceData result1 = new UserDataServiceData(firstFirstName
                , firstLastName
                , firstEmailAddress
                , firstAge
                , firstDateOfBirth
                , firstGender
                , firstWeight
                , firstHeight
                , firstVo2Max
                , firstHeartRateMax
                , firstRestingHeartRate
                , firstMaximumRecommendedHeartRate
                , firstAerobicThreshold
                , firstAnaerobicThreshold
                , firstSportTypeForAerobicAndAnaerobicThresholds
                , firstDateOfThresholdAssessment
                , firstWaistCircumference
                , firstHipCircumference
                , firstFatBurnHeartRateLowerLimit
                , firstFatBurnHeartRateUpperLimit
                , firstAerobicHeartRateLowerLimit
                , firstAerobicHeartRateUpperLimit
                , firstAnaerobicHeartRateLowerLimit
                , firstAnaerobicHeartRateUpperLimit
                , firstFiveZoneHeartRateLimits
                , firstThreeZoneHeartRateLimits
                , firstTwoZoneHeartRateLimit
                , null
                , firstDatabaseChangeIncrement
                , firstUserIndex
                , firstUserControlPoint
                , firstRegisteredUser);

        UserDataServiceData result2 = new UserDataServiceData(firstFirstName
                , firstLastName
                , firstEmailAddress
                , firstAge
                , firstDateOfBirth
                , firstGender
                , firstWeight
                , firstHeight
                , firstVo2Max
                , firstHeartRateMax
                , firstRestingHeartRate
                , firstMaximumRecommendedHeartRate
                , firstAerobicThreshold
                , firstAnaerobicThreshold
                , firstSportTypeForAerobicAndAnaerobicThresholds
                , firstDateOfThresholdAssessment
                , firstWaistCircumference
                , firstHipCircumference
                , firstFatBurnHeartRateLowerLimit
                , firstFatBurnHeartRateUpperLimit
                , firstAerobicHeartRateLowerLimit
                , firstAerobicHeartRateUpperLimit
                , firstAnaerobicHeartRateLowerLimit
                , firstAnaerobicHeartRateUpperLimit
                , firstFiveZoneHeartRateLimits
                , firstThreeZoneHeartRateLimits
                , firstTwoZoneHeartRateLimit
                , null
                , firstDatabaseChangeIncrement
                , firstUserIndex
                , firstUserControlPoint
                , firstRegisteredUser);
        assertEquals(result1, result2);
    }

    @Test
    public void test_equals_00130() {
        UDSCharacteristicData firstFirstName = new UDSCharacteristicData(FIRST_NAME_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstLastName = new UDSCharacteristicData(LAST_NAME_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstEmailAddress = new UDSCharacteristicData(EMAIL_ADDRESS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAge = new UDSCharacteristicData(AGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstDateOfBirth = new UDSCharacteristicData(DATE_OF_BIRTH_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstGender = new UDSCharacteristicData(GENDER_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstWeight = new UDSCharacteristicData(WEIGHT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstHeight = new UDSCharacteristicData(HEIGHT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstVo2Max = new UDSCharacteristicData(VO2_MAX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstHeartRateMax = new UDSCharacteristicData(HEART_RATE_MAX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstRestingHeartRate = new UDSCharacteristicData(RESTING_HEART_RATE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstMaximumRecommendedHeartRate = new UDSCharacteristicData(MAXIMUM_RECOMMENDED_HEART_RATE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAerobicThreshold = new UDSCharacteristicData(AEROBIC_THRESHOLD_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAnaerobicThreshold = new UDSCharacteristicData(ANAEROBIC_THRESHOLD_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstSportTypeForAerobicAndAnaerobicThresholds = new UDSCharacteristicData(SPORT_TYPE_FOR_AEROBIC_AND_ANAEROBIC_THRESHOLDS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstDateOfThresholdAssessment = new UDSCharacteristicData(DATE_OF_THRESHOLD_ASSESSMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstWaistCircumference = new UDSCharacteristicData(WAIST_CIRCUMFERENCE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstHipCircumference = new UDSCharacteristicData(HIP_CIRCUMFERENCE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstFatBurnHeartRateLowerLimit = new UDSCharacteristicData(FAT_BURN_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstFatBurnHeartRateUpperLimit = new UDSCharacteristicData(FAT_BURN_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAerobicHeartRateLowerLimit = new UDSCharacteristicData(AEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAerobicHeartRateUpperLimit = new UDSCharacteristicData(AEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAnaerobicHeartRateLowerLimit = new UDSCharacteristicData(ANAEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstAnaerobicHeartRateUpperLimit = new UDSCharacteristicData(ANAEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstFiveZoneHeartRateLimits = new UDSCharacteristicData(FIVE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstThreeZoneHeartRateLimits = new UDSCharacteristicData(THREE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstTwoZoneHeartRateLimit = new UDSCharacteristicData(TWO_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UDSCharacteristicData firstLanguage = new UDSCharacteristicData(LANGUAGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstDatabaseChangeIncrement = new CharacteristicData(DATABASE_CHANGE_INCREMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstUserIndex = new CharacteristicData(USER_INDEX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UserControlPointCharacteristicData firstUserControlPoint = new UserControlPointCharacteristicData(1
                , 2
                , new ArrayList<>()
                , 3
                , 5
                , 6
                , 7
                , 8
                , 9);

        UserDataServiceData result1 = new UserDataServiceData(firstFirstName
                , firstLastName
                , firstEmailAddress
                , firstAge
                , firstDateOfBirth
                , firstGender
                , firstWeight
                , firstHeight
                , firstVo2Max
                , firstHeartRateMax
                , firstRestingHeartRate
                , firstMaximumRecommendedHeartRate
                , firstAerobicThreshold
                , firstAnaerobicThreshold
                , firstSportTypeForAerobicAndAnaerobicThresholds
                , firstDateOfThresholdAssessment
                , firstWaistCircumference
                , firstHipCircumference
                , firstFatBurnHeartRateLowerLimit
                , firstFatBurnHeartRateUpperLimit
                , firstAerobicHeartRateLowerLimit
                , firstAerobicHeartRateUpperLimit
                , firstAnaerobicHeartRateLowerLimit
                , firstAnaerobicHeartRateUpperLimit
                , firstFiveZoneHeartRateLimits
                , firstThreeZoneHeartRateLimits
                , firstTwoZoneHeartRateLimit
                , firstLanguage
                , firstDatabaseChangeIncrement
                , firstUserIndex
                , firstUserControlPoint
                , null);

        UserDataServiceData result2 = new UserDataServiceData(firstFirstName
                , firstLastName
                , firstEmailAddress
                , firstAge
                , firstDateOfBirth
                , firstGender
                , firstWeight
                , firstHeight
                , firstVo2Max
                , firstHeartRateMax
                , firstRestingHeartRate
                , firstMaximumRecommendedHeartRate
                , firstAerobicThreshold
                , firstAnaerobicThreshold
                , firstSportTypeForAerobicAndAnaerobicThresholds
                , firstDateOfThresholdAssessment
                , firstWaistCircumference
                , firstHipCircumference
                , firstFatBurnHeartRateLowerLimit
                , firstFatBurnHeartRateUpperLimit
                , firstAerobicHeartRateLowerLimit
                , firstAerobicHeartRateUpperLimit
                , firstAnaerobicHeartRateLowerLimit
                , firstAnaerobicHeartRateUpperLimit
                , firstFiveZoneHeartRateLimits
                , firstThreeZoneHeartRateLimits
                , firstTwoZoneHeartRateLimit
                , firstLanguage
                , firstDatabaseChangeIncrement
                , firstUserIndex
                , firstUserControlPoint
                , null);
        assertEquals(result1, result2);
    }

}
