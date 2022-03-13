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
import static org.junit.Assert.assertNotEquals;

import org.im97mori.ble.CharacteristicData;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

public class UserDataServiceDataTest_equals_1 {

    @Test
    public void test_equals_00001() {
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
    public void test_equals_00002() {
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

        UDSCharacteristicData secondFirstName = new UDSCharacteristicData(FIRST_NAME_CHARACTERISTIC
                , 11
                , 22
                , Collections.emptyList()
                , 33
                , 44
                , new byte[]{55}
                , 66);

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

        UserDataServiceData result2 = new UserDataServiceData(secondFirstName
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
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00003() {
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

        UDSCharacteristicData secondLastName = new UDSCharacteristicData(LAST_NAME_CHARACTERISTIC
                , 11
                , 22
                , Collections.emptyList()
                , 33
                , 44
                , new byte[]{55}
                , 66);

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
                , secondLastName
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
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00004() {
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

        UDSCharacteristicData secondEmailAddress = new UDSCharacteristicData(EMAIL_ADDRESS_CHARACTERISTIC
                , 11
                , 22
                , Collections.emptyList()
                , 33
                , 44
                , new byte[]{55}
                , 66);

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
                , secondEmailAddress
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
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00005() {
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

        UDSCharacteristicData secondAge = new UDSCharacteristicData(AGE_CHARACTERISTIC
                , 11
                , 22
                , Collections.emptyList()
                , 33
                , 44
                , new byte[]{55}
                , 66);

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
                , secondAge
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
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00006() {
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

        UDSCharacteristicData secondDateOfBirth = new UDSCharacteristicData(DATE_OF_BIRTH_CHARACTERISTIC
                , 11
                , 22
                , Collections.emptyList()
                , 33
                , 44
                , new byte[]{55}
                , 66);

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
                , secondDateOfBirth
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
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00007() {
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

        UDSCharacteristicData secondGender = new UDSCharacteristicData(GENDER_CHARACTERISTIC
                , 11
                , 22
                , Collections.emptyList()
                , 33
                , 44
                , new byte[]{55}
                , 66);

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
                , secondGender
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
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00008() {
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

        UDSCharacteristicData secondWeight = new UDSCharacteristicData(WEIGHT_CHARACTERISTIC
                , 11
                , 22
                , Collections.emptyList()
                , 33
                , 44
                , new byte[]{55}
                , 66);

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
                , secondWeight
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
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00009() {
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

        UDSCharacteristicData secondHeight = new UDSCharacteristicData(HEIGHT_CHARACTERISTIC
                , 11
                , 22
                , Collections.emptyList()
                , 33
                , 44
                , new byte[]{55}
                , 66);

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
                , secondHeight
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
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00010() {
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

        UDSCharacteristicData secondVo2Max = new UDSCharacteristicData(VO2_MAX_CHARACTERISTIC
                , 11
                , 22
                , Collections.emptyList()
                , 33
                , 44
                , new byte[]{55}
                , 66);

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
                , secondVo2Max
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
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00011() {
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

        UDSCharacteristicData secondHeartRateMax = new UDSCharacteristicData(HEART_RATE_MAX_CHARACTERISTIC
                , 11
                , 22
                , Collections.emptyList()
                , 33
                , 44
                , new byte[]{55}
                , 66);

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
                , secondHeartRateMax
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
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00012() {
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

        UDSCharacteristicData secondRestingHeartRate = new UDSCharacteristicData(RESTING_HEART_RATE_CHARACTERISTIC
                , 11
                , 22
                , Collections.emptyList()
                , 33
                , 44
                , new byte[]{55}
                , 66);

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
                , secondRestingHeartRate
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
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00013() {
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

        UDSCharacteristicData secondMaximumRecommendedHeartRate = new UDSCharacteristicData(MAXIMUM_RECOMMENDED_HEART_RATE_CHARACTERISTIC
                , 11
                , 22
                , Collections.emptyList()
                , 33
                , 44
                , new byte[]{55}
                , 66);

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
                , secondMaximumRecommendedHeartRate
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
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00014() {
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

        UDSCharacteristicData secondAerobicThreshold = new UDSCharacteristicData(AEROBIC_THRESHOLD_CHARACTERISTIC
                , 11
                , 22
                , Collections.emptyList()
                , 33
                , 44
                , new byte[]{55}
                , 66);

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
                , secondAerobicThreshold
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
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00015() {
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

        UDSCharacteristicData secondAnaerobicThreshold = new UDSCharacteristicData(ANAEROBIC_THRESHOLD_CHARACTERISTIC
                , 11
                , 22
                , Collections.emptyList()
                , 33
                , 44
                , new byte[]{55}
                , 66);

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
                , secondAnaerobicThreshold
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
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00016() {
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

        UDSCharacteristicData secondSportTypeForAerobicAndAnaerobicThresholds = new UDSCharacteristicData(SPORT_TYPE_FOR_AEROBIC_AND_ANAEROBIC_THRESHOLDS_CHARACTERISTIC
                , 11
                , 22
                , Collections.emptyList()
                , 33
                , 44
                , new byte[]{55}
                , 66);

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
                , secondSportTypeForAerobicAndAnaerobicThresholds
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
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00017() {
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

        UDSCharacteristicData secondDateOfThresholdAssessment = new UDSCharacteristicData(DATE_OF_THRESHOLD_ASSESSMENT_CHARACTERISTIC
                , 11
                , 22
                , Collections.emptyList()
                , 33
                , 44
                , new byte[]{55}
                , 66);

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
                , secondDateOfThresholdAssessment
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
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00018() {
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

        UDSCharacteristicData secondWaistCircumference = new UDSCharacteristicData(WAIST_CIRCUMFERENCE_CHARACTERISTIC
                , 11
                , 22
                , Collections.emptyList()
                , 33
                , 44
                , new byte[]{55}
                , 66);

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
                , secondWaistCircumference
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
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00019() {
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

        UDSCharacteristicData secondHipCircumference = new UDSCharacteristicData(HIP_CIRCUMFERENCE_CHARACTERISTIC
                , 11
                , 22
                , Collections.emptyList()
                , 33
                , 44
                , new byte[]{55}
                , 66);

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
                , secondHipCircumference
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
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00020() {
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

        UDSCharacteristicData secondFatBurnHeartRateLowerLimit = new UDSCharacteristicData(FAT_BURN_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC
                , 11
                , 22
                , Collections.emptyList()
                , 33
                , 44
                , new byte[]{55}
                , 66);

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
                , secondFatBurnHeartRateLowerLimit
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
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00021() {
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

        UDSCharacteristicData secondFatBurnHeartRateUpperLimit = new UDSCharacteristicData(FAT_BURN_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC
                , 11
                , 22
                , Collections.emptyList()
                , 33
                , 44
                , new byte[]{55}
                , 66);

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
                , secondFatBurnHeartRateUpperLimit
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
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00022() {
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

        UDSCharacteristicData secondAerobicHeartRateLowerLimit = new UDSCharacteristicData(AEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC
                , 11
                , 22
                , Collections.emptyList()
                , 33
                , 44
                , new byte[]{55}
                , 66);

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
                , secondAerobicHeartRateLowerLimit
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
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00023() {
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

        UDSCharacteristicData secondAerobicHeartRateUpperLimit = new UDSCharacteristicData(AEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC
                , 11
                , 22
                , Collections.emptyList()
                , 33
                , 44
                , new byte[]{55}
                , 66);

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
                , secondAerobicHeartRateUpperLimit
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
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00024() {
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

        UDSCharacteristicData secondnaerobicHeartRateLowerLimit = new UDSCharacteristicData(ANAEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC
                , 11
                , 22
                , Collections.emptyList()
                , 33
                , 44
                , new byte[]{55}
                , 66);

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
                , secondnaerobicHeartRateLowerLimit
                , firstAnaerobicHeartRateUpperLimit
                , firstFiveZoneHeartRateLimits
                , firstThreeZoneHeartRateLimits
                , firstTwoZoneHeartRateLimit
                , firstLanguage
                , firstDatabaseChangeIncrement
                , firstUserIndex
                , firstUserControlPoint
                , firstRegisteredUser);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00025() {
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

        UDSCharacteristicData secondAnaerobicHeartRateUpperLimit = new UDSCharacteristicData(ANAEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC
                , 11
                , 22
                , Collections.emptyList()
                , 33
                , 44
                , new byte[]{55}
                , 66);

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
                , secondAnaerobicHeartRateUpperLimit
                , firstFiveZoneHeartRateLimits
                , firstThreeZoneHeartRateLimits
                , firstTwoZoneHeartRateLimit
                , firstLanguage
                , firstDatabaseChangeIncrement
                , firstUserIndex
                , firstUserControlPoint
                , firstRegisteredUser);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00026() {
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

        UDSCharacteristicData secondFiveZoneHeartRateLimits = new UDSCharacteristicData(FIVE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC
                , 11
                , 22
                , Collections.emptyList()
                , 33
                , 44
                , new byte[]{55}
                , 66);

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
                , secondFiveZoneHeartRateLimits
                , firstThreeZoneHeartRateLimits
                , firstTwoZoneHeartRateLimit
                , firstLanguage
                , firstDatabaseChangeIncrement
                , firstUserIndex
                , firstUserControlPoint
                , firstRegisteredUser);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00027() {
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

        UDSCharacteristicData secondThreeZoneHeartRateLimits = new UDSCharacteristicData(THREE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC
                , 11
                , 22
                , Collections.emptyList()
                , 33
                , 44
                , new byte[]{55}
                , 66);

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
                , secondThreeZoneHeartRateLimits
                , firstTwoZoneHeartRateLimit
                , firstLanguage
                , firstDatabaseChangeIncrement
                , firstUserIndex
                , firstUserControlPoint
                , firstRegisteredUser);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00028() {
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

        UDSCharacteristicData secondTwoZoneHeartRateLimit = new UDSCharacteristicData(TWO_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC
                , 11
                , 22
                , Collections.emptyList()
                , 33
                , 44
                , new byte[]{55}
                , 66);

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
                , secondTwoZoneHeartRateLimit
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
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00029() {
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

        UDSCharacteristicData secondLanguage = new UDSCharacteristicData(LANGUAGE_CHARACTERISTIC
                , 11
                , 22
                , Collections.emptyList()
                , 33
                , 44
                , new byte[]{55}
                , 66);

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
                , secondLanguage
                , firstDatabaseChangeIncrement
                , firstUserIndex
                , firstUserControlPoint
                , firstRegisteredUser);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00030() {
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

        CharacteristicData secondDatabaseChangeIncrement = new CharacteristicData(DATABASE_CHANGE_INCREMENT_CHARACTERISTIC
                , 11
                , 22
                , Collections.emptyList()
                , 33
                , 44
                , new byte[]{55}
                , 66);

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
                , secondDatabaseChangeIncrement
                , firstUserIndex
                , firstUserControlPoint
                , firstRegisteredUser);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00031() {
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

        CharacteristicData secondUserIndex = new CharacteristicData(USER_INDEX_CHARACTERISTIC
                , 11
                , 22
                , Collections.emptyList()
                , 33
                , 44
                , new byte[]{55}
                , 66);

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
                , secondUserIndex
                , firstUserControlPoint
                , firstRegisteredUser);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00032() {
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


        UserControlPointCharacteristicData secondUserControlPoint = new UserControlPointCharacteristicData(11
                , 22
                , new ArrayList<>()
                , 33
                , 55
                , 66
                , 77
                , 88
                , 99);

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
                , secondUserControlPoint
                , firstRegisteredUser);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00033() {
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

        CharacteristicData secondRegisteredUser = new CharacteristicData(REGISTERED_USER_CHARACTERISTIC
                , 11
                , 22
                , Collections.emptyList()
                , 33
                , 44
                , new byte[]{55}
                , 66);

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
                , secondRegisteredUser);
        assertNotEquals(result1, result2);
    }

}
