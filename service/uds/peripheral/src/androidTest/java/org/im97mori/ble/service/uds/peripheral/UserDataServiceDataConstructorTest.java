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
import static org.im97mori.ble.constants.ServiceUUID.USER_DATA_SERVICE;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import android.bluetooth.BluetoothGattService;

import com.google.gson.Gson;

import org.im97mori.ble.CharacteristicData;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

public class UserDataServiceDataConstructorTest {

    @Test
    public void test_constructor_00001() {
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

        Gson gson = new Gson();
        UserDataServiceData result2 = gson.fromJson(gson.toJson(result1), UserDataServiceData.class);

        assertEquals(USER_DATA_SERVICE, result2.uuid);
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, result2.type);
        assertNotNull(result2.characteristicDataList);
        assertTrue(result2.characteristicDataList.isEmpty());
        assertEquals(result1.characteristicDataList.size(), result2.characteristicDataList.size());
        assertArrayEquals(result1.characteristicDataList.toArray(), result2.characteristicDataList.toArray());
        assertEquals(result1.firstName, result2.firstName);
        assertEquals(result1.lastName, result2.lastName);
        assertEquals(result1.emailAddress, result2.emailAddress);
        assertEquals(result1.age, result2.age);
        assertEquals(result1.dateOfBirth, result2.dateOfBirth);
        assertEquals(result1.gender, result2.gender);
        assertEquals(result1.weight, result2.weight);
        assertEquals(result1.height, result2.height);
        assertEquals(result1.vo2Max, result2.vo2Max);
        assertEquals(result1.heartRateMax, result2.heartRateMax);
        assertEquals(result1.restingHeartRate, result2.restingHeartRate);
        assertEquals(result1.maximumRecommendedHeartRate, result2.maximumRecommendedHeartRate);
        assertEquals(result1.aerobicThreshold, result2.aerobicThreshold);
        assertEquals(result1.anaerobicThreshold, result2.anaerobicThreshold);
        assertEquals(result1.sportTypeForAerobicAndAnaerobicThresholds, result2.sportTypeForAerobicAndAnaerobicThresholds);
        assertEquals(result1.dateOfThresholdAssessment, result2.dateOfThresholdAssessment);
        assertEquals(result1.waistCircumference, result2.waistCircumference);
        assertEquals(result1.hipCircumference, result2.hipCircumference);
        assertEquals(result1.fatBurnHeartRateLowerLimit, result2.fatBurnHeartRateLowerLimit);
        assertEquals(result1.fatBurnHeartRateUpperLimit, result2.fatBurnHeartRateUpperLimit);
        assertEquals(result1.aerobicHeartRateLowerLimit, result2.aerobicHeartRateLowerLimit);
        assertEquals(result1.aerobicHeartRateUpperLimit, result2.aerobicHeartRateUpperLimit);
        assertEquals(result1.anaerobicHeartRateLowerLimit, result2.anaerobicHeartRateLowerLimit);
        assertEquals(result1.anaerobicHeartRateUpperLimit, result2.anaerobicHeartRateUpperLimit);
        assertEquals(result1.fiveZoneHeartRateLimits, result2.fiveZoneHeartRateLimits);
        assertEquals(result1.threeZoneHeartRateLimits, result2.threeZoneHeartRateLimits);
        assertEquals(result1.twoZoneHeartRateLimit, result2.twoZoneHeartRateLimit);
        assertEquals(result1.language, result2.language);
        assertEquals(result1.databaseChangeIncrement, result2.databaseChangeIncrement);
        assertEquals(result1.userIndex, result2.userIndex);
        assertEquals(result1.userControlPoint, result2.userControlPoint);
        assertEquals(result1.registeredUser, result2.registeredUser);
    }

    @Test
    public void test_constructor_00002() {
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

        Gson gson = new Gson();
        UserDataServiceData result2 = gson.fromJson(gson.toJson(result1), UserDataServiceData.class);

        assertEquals(USER_DATA_SERVICE, result2.uuid);
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, result2.type);
        assertNotNull(result2.characteristicDataList);
        assertTrue(result2.characteristicDataList.isEmpty());
        assertEquals(result1.characteristicDataList.size(), result2.characteristicDataList.size());
        assertArrayEquals(result1.characteristicDataList.toArray(), result2.characteristicDataList.toArray());
        assertEquals(result1.firstName, result2.firstName);
        assertEquals(result1.lastName, result2.lastName);
        assertEquals(result1.emailAddress, result2.emailAddress);
        assertEquals(result1.age, result2.age);
        assertEquals(result1.dateOfBirth, result2.dateOfBirth);
        assertEquals(result1.gender, result2.gender);
        assertEquals(result1.weight, result2.weight);
        assertEquals(result1.height, result2.height);
        assertEquals(result1.vo2Max, result2.vo2Max);
        assertEquals(result1.heartRateMax, result2.heartRateMax);
        assertEquals(result1.restingHeartRate, result2.restingHeartRate);
        assertEquals(result1.maximumRecommendedHeartRate, result2.maximumRecommendedHeartRate);
        assertEquals(result1.aerobicThreshold, result2.aerobicThreshold);
        assertEquals(result1.anaerobicThreshold, result2.anaerobicThreshold);
        assertEquals(result1.sportTypeForAerobicAndAnaerobicThresholds, result2.sportTypeForAerobicAndAnaerobicThresholds);
        assertEquals(result1.dateOfThresholdAssessment, result2.dateOfThresholdAssessment);
        assertEquals(result1.waistCircumference, result2.waistCircumference);
        assertEquals(result1.hipCircumference, result2.hipCircumference);
        assertEquals(result1.fatBurnHeartRateLowerLimit, result2.fatBurnHeartRateLowerLimit);
        assertEquals(result1.fatBurnHeartRateUpperLimit, result2.fatBurnHeartRateUpperLimit);
        assertEquals(result1.aerobicHeartRateLowerLimit, result2.aerobicHeartRateLowerLimit);
        assertEquals(result1.aerobicHeartRateUpperLimit, result2.aerobicHeartRateUpperLimit);
        assertEquals(result1.anaerobicHeartRateLowerLimit, result2.anaerobicHeartRateLowerLimit);
        assertEquals(result1.anaerobicHeartRateUpperLimit, result2.anaerobicHeartRateUpperLimit);
        assertEquals(result1.fiveZoneHeartRateLimits, result2.fiveZoneHeartRateLimits);
        assertEquals(result1.threeZoneHeartRateLimits, result2.threeZoneHeartRateLimits);
        assertEquals(result1.twoZoneHeartRateLimit, result2.twoZoneHeartRateLimit);
        assertEquals(result1.language, result2.language);
        assertEquals(result1.databaseChangeIncrement, result2.databaseChangeIncrement);
        assertEquals(result1.userIndex, result2.userIndex);
        assertEquals(result1.userControlPoint, result2.userControlPoint);
        assertEquals(result1.registeredUser, result2.registeredUser);
    }

    @Test
    public void test_constructor_00003() {
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

        Gson gson = new Gson();
        UserDataServiceData result2 = gson.fromJson(gson.toJson(result1), UserDataServiceData.class);

        assertEquals(USER_DATA_SERVICE, result2.uuid);
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, result2.type);
        assertNotNull(result2.characteristicDataList);
        assertTrue(result2.characteristicDataList.isEmpty());
        assertEquals(result1.characteristicDataList.size(), result2.characteristicDataList.size());
        assertArrayEquals(result1.characteristicDataList.toArray(), result2.characteristicDataList.toArray());
        assertEquals(result1.firstName, result2.firstName);
        assertEquals(result1.lastName, result2.lastName);
        assertEquals(result1.emailAddress, result2.emailAddress);
        assertEquals(result1.age, result2.age);
        assertEquals(result1.dateOfBirth, result2.dateOfBirth);
        assertEquals(result1.gender, result2.gender);
        assertEquals(result1.weight, result2.weight);
        assertEquals(result1.height, result2.height);
        assertEquals(result1.vo2Max, result2.vo2Max);
        assertEquals(result1.heartRateMax, result2.heartRateMax);
        assertEquals(result1.restingHeartRate, result2.restingHeartRate);
        assertEquals(result1.maximumRecommendedHeartRate, result2.maximumRecommendedHeartRate);
        assertEquals(result1.aerobicThreshold, result2.aerobicThreshold);
        assertEquals(result1.anaerobicThreshold, result2.anaerobicThreshold);
        assertEquals(result1.sportTypeForAerobicAndAnaerobicThresholds, result2.sportTypeForAerobicAndAnaerobicThresholds);
        assertEquals(result1.dateOfThresholdAssessment, result2.dateOfThresholdAssessment);
        assertEquals(result1.waistCircumference, result2.waistCircumference);
        assertEquals(result1.hipCircumference, result2.hipCircumference);
        assertEquals(result1.fatBurnHeartRateLowerLimit, result2.fatBurnHeartRateLowerLimit);
        assertEquals(result1.fatBurnHeartRateUpperLimit, result2.fatBurnHeartRateUpperLimit);
        assertEquals(result1.aerobicHeartRateLowerLimit, result2.aerobicHeartRateLowerLimit);
        assertEquals(result1.aerobicHeartRateUpperLimit, result2.aerobicHeartRateUpperLimit);
        assertEquals(result1.anaerobicHeartRateLowerLimit, result2.anaerobicHeartRateLowerLimit);
        assertEquals(result1.anaerobicHeartRateUpperLimit, result2.anaerobicHeartRateUpperLimit);
        assertEquals(result1.fiveZoneHeartRateLimits, result2.fiveZoneHeartRateLimits);
        assertEquals(result1.threeZoneHeartRateLimits, result2.threeZoneHeartRateLimits);
        assertEquals(result1.twoZoneHeartRateLimit, result2.twoZoneHeartRateLimit);
        assertEquals(result1.language, result2.language);
        assertEquals(result1.databaseChangeIncrement, result2.databaseChangeIncrement);
        assertEquals(result1.userIndex, result2.userIndex);
        assertEquals(result1.userControlPoint, result2.userControlPoint);
        assertEquals(result1.registeredUser, result2.registeredUser);
    }

    @Test
    public void test_constructor_00004() {
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

        Gson gson = new Gson();
        UserDataServiceData result2 = gson.fromJson(gson.toJson(result1), UserDataServiceData.class);

        assertEquals(USER_DATA_SERVICE, result2.uuid);
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, result2.type);
        assertNotNull(result2.characteristicDataList);
        assertTrue(result2.characteristicDataList.isEmpty());
        assertEquals(result1.characteristicDataList.size(), result2.characteristicDataList.size());
        assertArrayEquals(result1.characteristicDataList.toArray(), result2.characteristicDataList.toArray());
        assertEquals(result1.firstName, result2.firstName);
        assertEquals(result1.lastName, result2.lastName);
        assertEquals(result1.emailAddress, result2.emailAddress);
        assertEquals(result1.age, result2.age);
        assertEquals(result1.dateOfBirth, result2.dateOfBirth);
        assertEquals(result1.gender, result2.gender);
        assertEquals(result1.weight, result2.weight);
        assertEquals(result1.height, result2.height);
        assertEquals(result1.vo2Max, result2.vo2Max);
        assertEquals(result1.heartRateMax, result2.heartRateMax);
        assertEquals(result1.restingHeartRate, result2.restingHeartRate);
        assertEquals(result1.maximumRecommendedHeartRate, result2.maximumRecommendedHeartRate);
        assertEquals(result1.aerobicThreshold, result2.aerobicThreshold);
        assertEquals(result1.anaerobicThreshold, result2.anaerobicThreshold);
        assertEquals(result1.sportTypeForAerobicAndAnaerobicThresholds, result2.sportTypeForAerobicAndAnaerobicThresholds);
        assertEquals(result1.dateOfThresholdAssessment, result2.dateOfThresholdAssessment);
        assertEquals(result1.waistCircumference, result2.waistCircumference);
        assertEquals(result1.hipCircumference, result2.hipCircumference);
        assertEquals(result1.fatBurnHeartRateLowerLimit, result2.fatBurnHeartRateLowerLimit);
        assertEquals(result1.fatBurnHeartRateUpperLimit, result2.fatBurnHeartRateUpperLimit);
        assertEquals(result1.aerobicHeartRateLowerLimit, result2.aerobicHeartRateLowerLimit);
        assertEquals(result1.aerobicHeartRateUpperLimit, result2.aerobicHeartRateUpperLimit);
        assertEquals(result1.anaerobicHeartRateLowerLimit, result2.anaerobicHeartRateLowerLimit);
        assertEquals(result1.anaerobicHeartRateUpperLimit, result2.anaerobicHeartRateUpperLimit);
        assertEquals(result1.fiveZoneHeartRateLimits, result2.fiveZoneHeartRateLimits);
        assertEquals(result1.threeZoneHeartRateLimits, result2.threeZoneHeartRateLimits);
        assertEquals(result1.twoZoneHeartRateLimit, result2.twoZoneHeartRateLimit);
        assertEquals(result1.language, result2.language);
        assertEquals(result1.databaseChangeIncrement, result2.databaseChangeIncrement);
        assertEquals(result1.userIndex, result2.userIndex);
        assertEquals(result1.userControlPoint, result2.userControlPoint);
        assertEquals(result1.registeredUser, result2.registeredUser);
    }

    @Test
    public void test_constructor_00005() {
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

        Gson gson = new Gson();
        UserDataServiceData result2 = gson.fromJson(gson.toJson(result1), UserDataServiceData.class);

        assertEquals(USER_DATA_SERVICE, result2.uuid);
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, result2.type);
        assertNotNull(result2.characteristicDataList);
        assertTrue(result2.characteristicDataList.isEmpty());
        assertEquals(result1.characteristicDataList.size(), result2.characteristicDataList.size());
        assertArrayEquals(result1.characteristicDataList.toArray(), result2.characteristicDataList.toArray());
        assertEquals(result1.firstName, result2.firstName);
        assertEquals(result1.lastName, result2.lastName);
        assertEquals(result1.emailAddress, result2.emailAddress);
        assertEquals(result1.age, result2.age);
        assertEquals(result1.dateOfBirth, result2.dateOfBirth);
        assertEquals(result1.gender, result2.gender);
        assertEquals(result1.weight, result2.weight);
        assertEquals(result1.height, result2.height);
        assertEquals(result1.vo2Max, result2.vo2Max);
        assertEquals(result1.heartRateMax, result2.heartRateMax);
        assertEquals(result1.restingHeartRate, result2.restingHeartRate);
        assertEquals(result1.maximumRecommendedHeartRate, result2.maximumRecommendedHeartRate);
        assertEquals(result1.aerobicThreshold, result2.aerobicThreshold);
        assertEquals(result1.anaerobicThreshold, result2.anaerobicThreshold);
        assertEquals(result1.sportTypeForAerobicAndAnaerobicThresholds, result2.sportTypeForAerobicAndAnaerobicThresholds);
        assertEquals(result1.dateOfThresholdAssessment, result2.dateOfThresholdAssessment);
        assertEquals(result1.waistCircumference, result2.waistCircumference);
        assertEquals(result1.hipCircumference, result2.hipCircumference);
        assertEquals(result1.fatBurnHeartRateLowerLimit, result2.fatBurnHeartRateLowerLimit);
        assertEquals(result1.fatBurnHeartRateUpperLimit, result2.fatBurnHeartRateUpperLimit);
        assertEquals(result1.aerobicHeartRateLowerLimit, result2.aerobicHeartRateLowerLimit);
        assertEquals(result1.aerobicHeartRateUpperLimit, result2.aerobicHeartRateUpperLimit);
        assertEquals(result1.anaerobicHeartRateLowerLimit, result2.anaerobicHeartRateLowerLimit);
        assertEquals(result1.anaerobicHeartRateUpperLimit, result2.anaerobicHeartRateUpperLimit);
        assertEquals(result1.fiveZoneHeartRateLimits, result2.fiveZoneHeartRateLimits);
        assertEquals(result1.threeZoneHeartRateLimits, result2.threeZoneHeartRateLimits);
        assertEquals(result1.twoZoneHeartRateLimit, result2.twoZoneHeartRateLimit);
        assertEquals(result1.language, result2.language);
        assertEquals(result1.databaseChangeIncrement, result2.databaseChangeIncrement);
        assertEquals(result1.userIndex, result2.userIndex);
        assertEquals(result1.userControlPoint, result2.userControlPoint);
        assertEquals(result1.registeredUser, result2.registeredUser);
    }

    @Test
    public void test_constructor_00006() {
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

        Gson gson = new Gson();
        UserDataServiceData result2 = gson.fromJson(gson.toJson(result1), UserDataServiceData.class);

        assertEquals(USER_DATA_SERVICE, result2.uuid);
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, result2.type);
        assertNotNull(result2.characteristicDataList);
        assertTrue(result2.characteristicDataList.isEmpty());
        assertEquals(result1.characteristicDataList.size(), result2.characteristicDataList.size());
        assertArrayEquals(result1.characteristicDataList.toArray(), result2.characteristicDataList.toArray());
        assertEquals(result1.firstName, result2.firstName);
        assertEquals(result1.lastName, result2.lastName);
        assertEquals(result1.emailAddress, result2.emailAddress);
        assertEquals(result1.age, result2.age);
        assertEquals(result1.dateOfBirth, result2.dateOfBirth);
        assertEquals(result1.gender, result2.gender);
        assertEquals(result1.weight, result2.weight);
        assertEquals(result1.height, result2.height);
        assertEquals(result1.vo2Max, result2.vo2Max);
        assertEquals(result1.heartRateMax, result2.heartRateMax);
        assertEquals(result1.restingHeartRate, result2.restingHeartRate);
        assertEquals(result1.maximumRecommendedHeartRate, result2.maximumRecommendedHeartRate);
        assertEquals(result1.aerobicThreshold, result2.aerobicThreshold);
        assertEquals(result1.anaerobicThreshold, result2.anaerobicThreshold);
        assertEquals(result1.sportTypeForAerobicAndAnaerobicThresholds, result2.sportTypeForAerobicAndAnaerobicThresholds);
        assertEquals(result1.dateOfThresholdAssessment, result2.dateOfThresholdAssessment);
        assertEquals(result1.waistCircumference, result2.waistCircumference);
        assertEquals(result1.hipCircumference, result2.hipCircumference);
        assertEquals(result1.fatBurnHeartRateLowerLimit, result2.fatBurnHeartRateLowerLimit);
        assertEquals(result1.fatBurnHeartRateUpperLimit, result2.fatBurnHeartRateUpperLimit);
        assertEquals(result1.aerobicHeartRateLowerLimit, result2.aerobicHeartRateLowerLimit);
        assertEquals(result1.aerobicHeartRateUpperLimit, result2.aerobicHeartRateUpperLimit);
        assertEquals(result1.anaerobicHeartRateLowerLimit, result2.anaerobicHeartRateLowerLimit);
        assertEquals(result1.anaerobicHeartRateUpperLimit, result2.anaerobicHeartRateUpperLimit);
        assertEquals(result1.fiveZoneHeartRateLimits, result2.fiveZoneHeartRateLimits);
        assertEquals(result1.threeZoneHeartRateLimits, result2.threeZoneHeartRateLimits);
        assertEquals(result1.twoZoneHeartRateLimit, result2.twoZoneHeartRateLimit);
        assertEquals(result1.language, result2.language);
        assertEquals(result1.databaseChangeIncrement, result2.databaseChangeIncrement);
        assertEquals(result1.userIndex, result2.userIndex);
        assertEquals(result1.userControlPoint, result2.userControlPoint);
        assertEquals(result1.registeredUser, result2.registeredUser);
    }

    @Test
    public void test_constructor_00007() {
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

        Gson gson = new Gson();
        UserDataServiceData result2 = gson.fromJson(gson.toJson(result1), UserDataServiceData.class);

        assertEquals(USER_DATA_SERVICE, result2.uuid);
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, result2.type);
        assertNotNull(result2.characteristicDataList);
        assertTrue(result2.characteristicDataList.isEmpty());
        assertEquals(result1.characteristicDataList.size(), result2.characteristicDataList.size());
        assertArrayEquals(result1.characteristicDataList.toArray(), result2.characteristicDataList.toArray());
        assertEquals(result1.firstName, result2.firstName);
        assertEquals(result1.lastName, result2.lastName);
        assertEquals(result1.emailAddress, result2.emailAddress);
        assertEquals(result1.age, result2.age);
        assertEquals(result1.dateOfBirth, result2.dateOfBirth);
        assertEquals(result1.gender, result2.gender);
        assertEquals(result1.weight, result2.weight);
        assertEquals(result1.height, result2.height);
        assertEquals(result1.vo2Max, result2.vo2Max);
        assertEquals(result1.heartRateMax, result2.heartRateMax);
        assertEquals(result1.restingHeartRate, result2.restingHeartRate);
        assertEquals(result1.maximumRecommendedHeartRate, result2.maximumRecommendedHeartRate);
        assertEquals(result1.aerobicThreshold, result2.aerobicThreshold);
        assertEquals(result1.anaerobicThreshold, result2.anaerobicThreshold);
        assertEquals(result1.sportTypeForAerobicAndAnaerobicThresholds, result2.sportTypeForAerobicAndAnaerobicThresholds);
        assertEquals(result1.dateOfThresholdAssessment, result2.dateOfThresholdAssessment);
        assertEquals(result1.waistCircumference, result2.waistCircumference);
        assertEquals(result1.hipCircumference, result2.hipCircumference);
        assertEquals(result1.fatBurnHeartRateLowerLimit, result2.fatBurnHeartRateLowerLimit);
        assertEquals(result1.fatBurnHeartRateUpperLimit, result2.fatBurnHeartRateUpperLimit);
        assertEquals(result1.aerobicHeartRateLowerLimit, result2.aerobicHeartRateLowerLimit);
        assertEquals(result1.aerobicHeartRateUpperLimit, result2.aerobicHeartRateUpperLimit);
        assertEquals(result1.anaerobicHeartRateLowerLimit, result2.anaerobicHeartRateLowerLimit);
        assertEquals(result1.anaerobicHeartRateUpperLimit, result2.anaerobicHeartRateUpperLimit);
        assertEquals(result1.fiveZoneHeartRateLimits, result2.fiveZoneHeartRateLimits);
        assertEquals(result1.threeZoneHeartRateLimits, result2.threeZoneHeartRateLimits);
        assertEquals(result1.twoZoneHeartRateLimit, result2.twoZoneHeartRateLimit);
        assertEquals(result1.language, result2.language);
        assertEquals(result1.databaseChangeIncrement, result2.databaseChangeIncrement);
        assertEquals(result1.userIndex, result2.userIndex);
        assertEquals(result1.userControlPoint, result2.userControlPoint);
        assertEquals(result1.registeredUser, result2.registeredUser);
    }

    @Test
    public void test_constructor_00008() {
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

        Gson gson = new Gson();
        UserDataServiceData result2 = gson.fromJson(gson.toJson(result1), UserDataServiceData.class);

        assertEquals(USER_DATA_SERVICE, result2.uuid);
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, result2.type);
        assertNotNull(result2.characteristicDataList);
        assertTrue(result2.characteristicDataList.isEmpty());
        assertEquals(result1.characteristicDataList.size(), result2.characteristicDataList.size());
        assertArrayEquals(result1.characteristicDataList.toArray(), result2.characteristicDataList.toArray());
        assertEquals(result1.firstName, result2.firstName);
        assertEquals(result1.lastName, result2.lastName);
        assertEquals(result1.emailAddress, result2.emailAddress);
        assertEquals(result1.age, result2.age);
        assertEquals(result1.dateOfBirth, result2.dateOfBirth);
        assertEquals(result1.gender, result2.gender);
        assertEquals(result1.weight, result2.weight);
        assertEquals(result1.height, result2.height);
        assertEquals(result1.vo2Max, result2.vo2Max);
        assertEquals(result1.heartRateMax, result2.heartRateMax);
        assertEquals(result1.restingHeartRate, result2.restingHeartRate);
        assertEquals(result1.maximumRecommendedHeartRate, result2.maximumRecommendedHeartRate);
        assertEquals(result1.aerobicThreshold, result2.aerobicThreshold);
        assertEquals(result1.anaerobicThreshold, result2.anaerobicThreshold);
        assertEquals(result1.sportTypeForAerobicAndAnaerobicThresholds, result2.sportTypeForAerobicAndAnaerobicThresholds);
        assertEquals(result1.dateOfThresholdAssessment, result2.dateOfThresholdAssessment);
        assertEquals(result1.waistCircumference, result2.waistCircumference);
        assertEquals(result1.hipCircumference, result2.hipCircumference);
        assertEquals(result1.fatBurnHeartRateLowerLimit, result2.fatBurnHeartRateLowerLimit);
        assertEquals(result1.fatBurnHeartRateUpperLimit, result2.fatBurnHeartRateUpperLimit);
        assertEquals(result1.aerobicHeartRateLowerLimit, result2.aerobicHeartRateLowerLimit);
        assertEquals(result1.aerobicHeartRateUpperLimit, result2.aerobicHeartRateUpperLimit);
        assertEquals(result1.anaerobicHeartRateLowerLimit, result2.anaerobicHeartRateLowerLimit);
        assertEquals(result1.anaerobicHeartRateUpperLimit, result2.anaerobicHeartRateUpperLimit);
        assertEquals(result1.fiveZoneHeartRateLimits, result2.fiveZoneHeartRateLimits);
        assertEquals(result1.threeZoneHeartRateLimits, result2.threeZoneHeartRateLimits);
        assertEquals(result1.twoZoneHeartRateLimit, result2.twoZoneHeartRateLimit);
        assertEquals(result1.language, result2.language);
        assertEquals(result1.databaseChangeIncrement, result2.databaseChangeIncrement);
        assertEquals(result1.userIndex, result2.userIndex);
        assertEquals(result1.userControlPoint, result2.userControlPoint);
        assertEquals(result1.registeredUser, result2.registeredUser);
    }

    @Test
    public void test_constructor_00009() {
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

        Gson gson = new Gson();
        UserDataServiceData result2 = gson.fromJson(gson.toJson(result1), UserDataServiceData.class);

        assertEquals(USER_DATA_SERVICE, result2.uuid);
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, result2.type);
        assertNotNull(result2.characteristicDataList);
        assertTrue(result2.characteristicDataList.isEmpty());
        assertEquals(result1.characteristicDataList.size(), result2.characteristicDataList.size());
        assertArrayEquals(result1.characteristicDataList.toArray(), result2.characteristicDataList.toArray());
        assertEquals(result1.firstName, result2.firstName);
        assertEquals(result1.lastName, result2.lastName);
        assertEquals(result1.emailAddress, result2.emailAddress);
        assertEquals(result1.age, result2.age);
        assertEquals(result1.dateOfBirth, result2.dateOfBirth);
        assertEquals(result1.gender, result2.gender);
        assertEquals(result1.weight, result2.weight);
        assertEquals(result1.height, result2.height);
        assertEquals(result1.vo2Max, result2.vo2Max);
        assertEquals(result1.heartRateMax, result2.heartRateMax);
        assertEquals(result1.restingHeartRate, result2.restingHeartRate);
        assertEquals(result1.maximumRecommendedHeartRate, result2.maximumRecommendedHeartRate);
        assertEquals(result1.aerobicThreshold, result2.aerobicThreshold);
        assertEquals(result1.anaerobicThreshold, result2.anaerobicThreshold);
        assertEquals(result1.sportTypeForAerobicAndAnaerobicThresholds, result2.sportTypeForAerobicAndAnaerobicThresholds);
        assertEquals(result1.dateOfThresholdAssessment, result2.dateOfThresholdAssessment);
        assertEquals(result1.waistCircumference, result2.waistCircumference);
        assertEquals(result1.hipCircumference, result2.hipCircumference);
        assertEquals(result1.fatBurnHeartRateLowerLimit, result2.fatBurnHeartRateLowerLimit);
        assertEquals(result1.fatBurnHeartRateUpperLimit, result2.fatBurnHeartRateUpperLimit);
        assertEquals(result1.aerobicHeartRateLowerLimit, result2.aerobicHeartRateLowerLimit);
        assertEquals(result1.aerobicHeartRateUpperLimit, result2.aerobicHeartRateUpperLimit);
        assertEquals(result1.anaerobicHeartRateLowerLimit, result2.anaerobicHeartRateLowerLimit);
        assertEquals(result1.anaerobicHeartRateUpperLimit, result2.anaerobicHeartRateUpperLimit);
        assertEquals(result1.fiveZoneHeartRateLimits, result2.fiveZoneHeartRateLimits);
        assertEquals(result1.threeZoneHeartRateLimits, result2.threeZoneHeartRateLimits);
        assertEquals(result1.twoZoneHeartRateLimit, result2.twoZoneHeartRateLimit);
        assertEquals(result1.language, result2.language);
        assertEquals(result1.databaseChangeIncrement, result2.databaseChangeIncrement);
        assertEquals(result1.userIndex, result2.userIndex);
        assertEquals(result1.userControlPoint, result2.userControlPoint);
        assertEquals(result1.registeredUser, result2.registeredUser);
    }

    @Test
    public void test_constructor_00010() {
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

        Gson gson = new Gson();
        UserDataServiceData result2 = gson.fromJson(gson.toJson(result1), UserDataServiceData.class);

        assertEquals(USER_DATA_SERVICE, result2.uuid);
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, result2.type);
        assertNotNull(result2.characteristicDataList);
        assertTrue(result2.characteristicDataList.isEmpty());
        assertEquals(result1.characteristicDataList.size(), result2.characteristicDataList.size());
        assertArrayEquals(result1.characteristicDataList.toArray(), result2.characteristicDataList.toArray());
        assertEquals(result1.firstName, result2.firstName);
        assertEquals(result1.lastName, result2.lastName);
        assertEquals(result1.emailAddress, result2.emailAddress);
        assertEquals(result1.age, result2.age);
        assertEquals(result1.dateOfBirth, result2.dateOfBirth);
        assertEquals(result1.gender, result2.gender);
        assertEquals(result1.weight, result2.weight);
        assertEquals(result1.height, result2.height);
        assertEquals(result1.vo2Max, result2.vo2Max);
        assertEquals(result1.heartRateMax, result2.heartRateMax);
        assertEquals(result1.restingHeartRate, result2.restingHeartRate);
        assertEquals(result1.maximumRecommendedHeartRate, result2.maximumRecommendedHeartRate);
        assertEquals(result1.aerobicThreshold, result2.aerobicThreshold);
        assertEquals(result1.anaerobicThreshold, result2.anaerobicThreshold);
        assertEquals(result1.sportTypeForAerobicAndAnaerobicThresholds, result2.sportTypeForAerobicAndAnaerobicThresholds);
        assertEquals(result1.dateOfThresholdAssessment, result2.dateOfThresholdAssessment);
        assertEquals(result1.waistCircumference, result2.waistCircumference);
        assertEquals(result1.hipCircumference, result2.hipCircumference);
        assertEquals(result1.fatBurnHeartRateLowerLimit, result2.fatBurnHeartRateLowerLimit);
        assertEquals(result1.fatBurnHeartRateUpperLimit, result2.fatBurnHeartRateUpperLimit);
        assertEquals(result1.aerobicHeartRateLowerLimit, result2.aerobicHeartRateLowerLimit);
        assertEquals(result1.aerobicHeartRateUpperLimit, result2.aerobicHeartRateUpperLimit);
        assertEquals(result1.anaerobicHeartRateLowerLimit, result2.anaerobicHeartRateLowerLimit);
        assertEquals(result1.anaerobicHeartRateUpperLimit, result2.anaerobicHeartRateUpperLimit);
        assertEquals(result1.fiveZoneHeartRateLimits, result2.fiveZoneHeartRateLimits);
        assertEquals(result1.threeZoneHeartRateLimits, result2.threeZoneHeartRateLimits);
        assertEquals(result1.twoZoneHeartRateLimit, result2.twoZoneHeartRateLimit);
        assertEquals(result1.language, result2.language);
        assertEquals(result1.databaseChangeIncrement, result2.databaseChangeIncrement);
        assertEquals(result1.userIndex, result2.userIndex);
        assertEquals(result1.userControlPoint, result2.userControlPoint);
        assertEquals(result1.registeredUser, result2.registeredUser);
    }

    @Test
    public void test_constructor_00011() {
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

        Gson gson = new Gson();
        UserDataServiceData result2 = gson.fromJson(gson.toJson(result1), UserDataServiceData.class);

        assertEquals(USER_DATA_SERVICE, result2.uuid);
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, result2.type);
        assertNotNull(result2.characteristicDataList);
        assertTrue(result2.characteristicDataList.isEmpty());
        assertEquals(result1.characteristicDataList.size(), result2.characteristicDataList.size());
        assertArrayEquals(result1.characteristicDataList.toArray(), result2.characteristicDataList.toArray());
        assertEquals(result1.firstName, result2.firstName);
        assertEquals(result1.lastName, result2.lastName);
        assertEquals(result1.emailAddress, result2.emailAddress);
        assertEquals(result1.age, result2.age);
        assertEquals(result1.dateOfBirth, result2.dateOfBirth);
        assertEquals(result1.gender, result2.gender);
        assertEquals(result1.weight, result2.weight);
        assertEquals(result1.height, result2.height);
        assertEquals(result1.vo2Max, result2.vo2Max);
        assertEquals(result1.heartRateMax, result2.heartRateMax);
        assertEquals(result1.restingHeartRate, result2.restingHeartRate);
        assertEquals(result1.maximumRecommendedHeartRate, result2.maximumRecommendedHeartRate);
        assertEquals(result1.aerobicThreshold, result2.aerobicThreshold);
        assertEquals(result1.anaerobicThreshold, result2.anaerobicThreshold);
        assertEquals(result1.sportTypeForAerobicAndAnaerobicThresholds, result2.sportTypeForAerobicAndAnaerobicThresholds);
        assertEquals(result1.dateOfThresholdAssessment, result2.dateOfThresholdAssessment);
        assertEquals(result1.waistCircumference, result2.waistCircumference);
        assertEquals(result1.hipCircumference, result2.hipCircumference);
        assertEquals(result1.fatBurnHeartRateLowerLimit, result2.fatBurnHeartRateLowerLimit);
        assertEquals(result1.fatBurnHeartRateUpperLimit, result2.fatBurnHeartRateUpperLimit);
        assertEquals(result1.aerobicHeartRateLowerLimit, result2.aerobicHeartRateLowerLimit);
        assertEquals(result1.aerobicHeartRateUpperLimit, result2.aerobicHeartRateUpperLimit);
        assertEquals(result1.anaerobicHeartRateLowerLimit, result2.anaerobicHeartRateLowerLimit);
        assertEquals(result1.anaerobicHeartRateUpperLimit, result2.anaerobicHeartRateUpperLimit);
        assertEquals(result1.fiveZoneHeartRateLimits, result2.fiveZoneHeartRateLimits);
        assertEquals(result1.threeZoneHeartRateLimits, result2.threeZoneHeartRateLimits);
        assertEquals(result1.twoZoneHeartRateLimit, result2.twoZoneHeartRateLimit);
        assertEquals(result1.language, result2.language);
        assertEquals(result1.databaseChangeIncrement, result2.databaseChangeIncrement);
        assertEquals(result1.userIndex, result2.userIndex);
        assertEquals(result1.userControlPoint, result2.userControlPoint);
        assertEquals(result1.registeredUser, result2.registeredUser);
    }

    @Test
    public void test_constructor_00012() {
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

        Gson gson = new Gson();
        UserDataServiceData result2 = gson.fromJson(gson.toJson(result1), UserDataServiceData.class);

        assertEquals(USER_DATA_SERVICE, result2.uuid);
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, result2.type);
        assertNotNull(result2.characteristicDataList);
        assertTrue(result2.characteristicDataList.isEmpty());
        assertEquals(result1.characteristicDataList.size(), result2.characteristicDataList.size());
        assertArrayEquals(result1.characteristicDataList.toArray(), result2.characteristicDataList.toArray());
        assertEquals(result1.firstName, result2.firstName);
        assertEquals(result1.lastName, result2.lastName);
        assertEquals(result1.emailAddress, result2.emailAddress);
        assertEquals(result1.age, result2.age);
        assertEquals(result1.dateOfBirth, result2.dateOfBirth);
        assertEquals(result1.gender, result2.gender);
        assertEquals(result1.weight, result2.weight);
        assertEquals(result1.height, result2.height);
        assertEquals(result1.vo2Max, result2.vo2Max);
        assertEquals(result1.heartRateMax, result2.heartRateMax);
        assertEquals(result1.restingHeartRate, result2.restingHeartRate);
        assertEquals(result1.maximumRecommendedHeartRate, result2.maximumRecommendedHeartRate);
        assertEquals(result1.aerobicThreshold, result2.aerobicThreshold);
        assertEquals(result1.anaerobicThreshold, result2.anaerobicThreshold);
        assertEquals(result1.sportTypeForAerobicAndAnaerobicThresholds, result2.sportTypeForAerobicAndAnaerobicThresholds);
        assertEquals(result1.dateOfThresholdAssessment, result2.dateOfThresholdAssessment);
        assertEquals(result1.waistCircumference, result2.waistCircumference);
        assertEquals(result1.hipCircumference, result2.hipCircumference);
        assertEquals(result1.fatBurnHeartRateLowerLimit, result2.fatBurnHeartRateLowerLimit);
        assertEquals(result1.fatBurnHeartRateUpperLimit, result2.fatBurnHeartRateUpperLimit);
        assertEquals(result1.aerobicHeartRateLowerLimit, result2.aerobicHeartRateLowerLimit);
        assertEquals(result1.aerobicHeartRateUpperLimit, result2.aerobicHeartRateUpperLimit);
        assertEquals(result1.anaerobicHeartRateLowerLimit, result2.anaerobicHeartRateLowerLimit);
        assertEquals(result1.anaerobicHeartRateUpperLimit, result2.anaerobicHeartRateUpperLimit);
        assertEquals(result1.fiveZoneHeartRateLimits, result2.fiveZoneHeartRateLimits);
        assertEquals(result1.threeZoneHeartRateLimits, result2.threeZoneHeartRateLimits);
        assertEquals(result1.twoZoneHeartRateLimit, result2.twoZoneHeartRateLimit);
        assertEquals(result1.language, result2.language);
        assertEquals(result1.databaseChangeIncrement, result2.databaseChangeIncrement);
        assertEquals(result1.userIndex, result2.userIndex);
        assertEquals(result1.userControlPoint, result2.userControlPoint);
        assertEquals(result1.registeredUser, result2.registeredUser);
    }

    @Test
    public void test_constructor_00013() {
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

        Gson gson = new Gson();
        UserDataServiceData result2 = gson.fromJson(gson.toJson(result1), UserDataServiceData.class);

        assertEquals(USER_DATA_SERVICE, result2.uuid);
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, result2.type);
        assertNotNull(result2.characteristicDataList);
        assertTrue(result2.characteristicDataList.isEmpty());
        assertEquals(result1.characteristicDataList.size(), result2.characteristicDataList.size());
        assertArrayEquals(result1.characteristicDataList.toArray(), result2.characteristicDataList.toArray());
        assertEquals(result1.firstName, result2.firstName);
        assertEquals(result1.lastName, result2.lastName);
        assertEquals(result1.emailAddress, result2.emailAddress);
        assertEquals(result1.age, result2.age);
        assertEquals(result1.dateOfBirth, result2.dateOfBirth);
        assertEquals(result1.gender, result2.gender);
        assertEquals(result1.weight, result2.weight);
        assertEquals(result1.height, result2.height);
        assertEquals(result1.vo2Max, result2.vo2Max);
        assertEquals(result1.heartRateMax, result2.heartRateMax);
        assertEquals(result1.restingHeartRate, result2.restingHeartRate);
        assertEquals(result1.maximumRecommendedHeartRate, result2.maximumRecommendedHeartRate);
        assertEquals(result1.aerobicThreshold, result2.aerobicThreshold);
        assertEquals(result1.anaerobicThreshold, result2.anaerobicThreshold);
        assertEquals(result1.sportTypeForAerobicAndAnaerobicThresholds, result2.sportTypeForAerobicAndAnaerobicThresholds);
        assertEquals(result1.dateOfThresholdAssessment, result2.dateOfThresholdAssessment);
        assertEquals(result1.waistCircumference, result2.waistCircumference);
        assertEquals(result1.hipCircumference, result2.hipCircumference);
        assertEquals(result1.fatBurnHeartRateLowerLimit, result2.fatBurnHeartRateLowerLimit);
        assertEquals(result1.fatBurnHeartRateUpperLimit, result2.fatBurnHeartRateUpperLimit);
        assertEquals(result1.aerobicHeartRateLowerLimit, result2.aerobicHeartRateLowerLimit);
        assertEquals(result1.aerobicHeartRateUpperLimit, result2.aerobicHeartRateUpperLimit);
        assertEquals(result1.anaerobicHeartRateLowerLimit, result2.anaerobicHeartRateLowerLimit);
        assertEquals(result1.anaerobicHeartRateUpperLimit, result2.anaerobicHeartRateUpperLimit);
        assertEquals(result1.fiveZoneHeartRateLimits, result2.fiveZoneHeartRateLimits);
        assertEquals(result1.threeZoneHeartRateLimits, result2.threeZoneHeartRateLimits);
        assertEquals(result1.twoZoneHeartRateLimit, result2.twoZoneHeartRateLimit);
        assertEquals(result1.language, result2.language);
        assertEquals(result1.databaseChangeIncrement, result2.databaseChangeIncrement);
        assertEquals(result1.userIndex, result2.userIndex);
        assertEquals(result1.userControlPoint, result2.userControlPoint);
        assertEquals(result1.registeredUser, result2.registeredUser);
    }

    @Test
    public void test_constructor_00014() {
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

        Gson gson = new Gson();
        UserDataServiceData result2 = gson.fromJson(gson.toJson(result1), UserDataServiceData.class);

        assertEquals(USER_DATA_SERVICE, result2.uuid);
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, result2.type);
        assertNotNull(result2.characteristicDataList);
        assertTrue(result2.characteristicDataList.isEmpty());
        assertEquals(result1.characteristicDataList.size(), result2.characteristicDataList.size());
        assertArrayEquals(result1.characteristicDataList.toArray(), result2.characteristicDataList.toArray());
        assertEquals(result1.firstName, result2.firstName);
        assertEquals(result1.lastName, result2.lastName);
        assertEquals(result1.emailAddress, result2.emailAddress);
        assertEquals(result1.age, result2.age);
        assertEquals(result1.dateOfBirth, result2.dateOfBirth);
        assertEquals(result1.gender, result2.gender);
        assertEquals(result1.weight, result2.weight);
        assertEquals(result1.height, result2.height);
        assertEquals(result1.vo2Max, result2.vo2Max);
        assertEquals(result1.heartRateMax, result2.heartRateMax);
        assertEquals(result1.restingHeartRate, result2.restingHeartRate);
        assertEquals(result1.maximumRecommendedHeartRate, result2.maximumRecommendedHeartRate);
        assertEquals(result1.aerobicThreshold, result2.aerobicThreshold);
        assertEquals(result1.anaerobicThreshold, result2.anaerobicThreshold);
        assertEquals(result1.sportTypeForAerobicAndAnaerobicThresholds, result2.sportTypeForAerobicAndAnaerobicThresholds);
        assertEquals(result1.dateOfThresholdAssessment, result2.dateOfThresholdAssessment);
        assertEquals(result1.waistCircumference, result2.waistCircumference);
        assertEquals(result1.hipCircumference, result2.hipCircumference);
        assertEquals(result1.fatBurnHeartRateLowerLimit, result2.fatBurnHeartRateLowerLimit);
        assertEquals(result1.fatBurnHeartRateUpperLimit, result2.fatBurnHeartRateUpperLimit);
        assertEquals(result1.aerobicHeartRateLowerLimit, result2.aerobicHeartRateLowerLimit);
        assertEquals(result1.aerobicHeartRateUpperLimit, result2.aerobicHeartRateUpperLimit);
        assertEquals(result1.anaerobicHeartRateLowerLimit, result2.anaerobicHeartRateLowerLimit);
        assertEquals(result1.anaerobicHeartRateUpperLimit, result2.anaerobicHeartRateUpperLimit);
        assertEquals(result1.fiveZoneHeartRateLimits, result2.fiveZoneHeartRateLimits);
        assertEquals(result1.threeZoneHeartRateLimits, result2.threeZoneHeartRateLimits);
        assertEquals(result1.twoZoneHeartRateLimit, result2.twoZoneHeartRateLimit);
        assertEquals(result1.language, result2.language);
        assertEquals(result1.databaseChangeIncrement, result2.databaseChangeIncrement);
        assertEquals(result1.userIndex, result2.userIndex);
        assertEquals(result1.userControlPoint, result2.userControlPoint);
        assertEquals(result1.registeredUser, result2.registeredUser);
    }

    @Test
    public void test_constructor_00015() {
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

        Gson gson = new Gson();
        UserDataServiceData result2 = gson.fromJson(gson.toJson(result1), UserDataServiceData.class);

        assertEquals(USER_DATA_SERVICE, result2.uuid);
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, result2.type);
        assertNotNull(result2.characteristicDataList);
        assertTrue(result2.characteristicDataList.isEmpty());
        assertEquals(result1.characteristicDataList.size(), result2.characteristicDataList.size());
        assertArrayEquals(result1.characteristicDataList.toArray(), result2.characteristicDataList.toArray());
        assertEquals(result1.firstName, result2.firstName);
        assertEquals(result1.lastName, result2.lastName);
        assertEquals(result1.emailAddress, result2.emailAddress);
        assertEquals(result1.age, result2.age);
        assertEquals(result1.dateOfBirth, result2.dateOfBirth);
        assertEquals(result1.gender, result2.gender);
        assertEquals(result1.weight, result2.weight);
        assertEquals(result1.height, result2.height);
        assertEquals(result1.vo2Max, result2.vo2Max);
        assertEquals(result1.heartRateMax, result2.heartRateMax);
        assertEquals(result1.restingHeartRate, result2.restingHeartRate);
        assertEquals(result1.maximumRecommendedHeartRate, result2.maximumRecommendedHeartRate);
        assertEquals(result1.aerobicThreshold, result2.aerobicThreshold);
        assertEquals(result1.anaerobicThreshold, result2.anaerobicThreshold);
        assertEquals(result1.sportTypeForAerobicAndAnaerobicThresholds, result2.sportTypeForAerobicAndAnaerobicThresholds);
        assertEquals(result1.dateOfThresholdAssessment, result2.dateOfThresholdAssessment);
        assertEquals(result1.waistCircumference, result2.waistCircumference);
        assertEquals(result1.hipCircumference, result2.hipCircumference);
        assertEquals(result1.fatBurnHeartRateLowerLimit, result2.fatBurnHeartRateLowerLimit);
        assertEquals(result1.fatBurnHeartRateUpperLimit, result2.fatBurnHeartRateUpperLimit);
        assertEquals(result1.aerobicHeartRateLowerLimit, result2.aerobicHeartRateLowerLimit);
        assertEquals(result1.aerobicHeartRateUpperLimit, result2.aerobicHeartRateUpperLimit);
        assertEquals(result1.anaerobicHeartRateLowerLimit, result2.anaerobicHeartRateLowerLimit);
        assertEquals(result1.anaerobicHeartRateUpperLimit, result2.anaerobicHeartRateUpperLimit);
        assertEquals(result1.fiveZoneHeartRateLimits, result2.fiveZoneHeartRateLimits);
        assertEquals(result1.threeZoneHeartRateLimits, result2.threeZoneHeartRateLimits);
        assertEquals(result1.twoZoneHeartRateLimit, result2.twoZoneHeartRateLimit);
        assertEquals(result1.language, result2.language);
        assertEquals(result1.databaseChangeIncrement, result2.databaseChangeIncrement);
        assertEquals(result1.userIndex, result2.userIndex);
        assertEquals(result1.userControlPoint, result2.userControlPoint);
        assertEquals(result1.registeredUser, result2.registeredUser);
    }

    @Test
    public void test_constructor_00016() {
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

        Gson gson = new Gson();
        UserDataServiceData result2 = gson.fromJson(gson.toJson(result1), UserDataServiceData.class);

        assertEquals(USER_DATA_SERVICE, result2.uuid);
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, result2.type);
        assertNotNull(result2.characteristicDataList);
        assertTrue(result2.characteristicDataList.isEmpty());
        assertEquals(result1.characteristicDataList.size(), result2.characteristicDataList.size());
        assertArrayEquals(result1.characteristicDataList.toArray(), result2.characteristicDataList.toArray());
        assertEquals(result1.firstName, result2.firstName);
        assertEquals(result1.lastName, result2.lastName);
        assertEquals(result1.emailAddress, result2.emailAddress);
        assertEquals(result1.age, result2.age);
        assertEquals(result1.dateOfBirth, result2.dateOfBirth);
        assertEquals(result1.gender, result2.gender);
        assertEquals(result1.weight, result2.weight);
        assertEquals(result1.height, result2.height);
        assertEquals(result1.vo2Max, result2.vo2Max);
        assertEquals(result1.heartRateMax, result2.heartRateMax);
        assertEquals(result1.restingHeartRate, result2.restingHeartRate);
        assertEquals(result1.maximumRecommendedHeartRate, result2.maximumRecommendedHeartRate);
        assertEquals(result1.aerobicThreshold, result2.aerobicThreshold);
        assertEquals(result1.anaerobicThreshold, result2.anaerobicThreshold);
        assertEquals(result1.sportTypeForAerobicAndAnaerobicThresholds, result2.sportTypeForAerobicAndAnaerobicThresholds);
        assertEquals(result1.dateOfThresholdAssessment, result2.dateOfThresholdAssessment);
        assertEquals(result1.waistCircumference, result2.waistCircumference);
        assertEquals(result1.hipCircumference, result2.hipCircumference);
        assertEquals(result1.fatBurnHeartRateLowerLimit, result2.fatBurnHeartRateLowerLimit);
        assertEquals(result1.fatBurnHeartRateUpperLimit, result2.fatBurnHeartRateUpperLimit);
        assertEquals(result1.aerobicHeartRateLowerLimit, result2.aerobicHeartRateLowerLimit);
        assertEquals(result1.aerobicHeartRateUpperLimit, result2.aerobicHeartRateUpperLimit);
        assertEquals(result1.anaerobicHeartRateLowerLimit, result2.anaerobicHeartRateLowerLimit);
        assertEquals(result1.anaerobicHeartRateUpperLimit, result2.anaerobicHeartRateUpperLimit);
        assertEquals(result1.fiveZoneHeartRateLimits, result2.fiveZoneHeartRateLimits);
        assertEquals(result1.threeZoneHeartRateLimits, result2.threeZoneHeartRateLimits);
        assertEquals(result1.twoZoneHeartRateLimit, result2.twoZoneHeartRateLimit);
        assertEquals(result1.language, result2.language);
        assertEquals(result1.databaseChangeIncrement, result2.databaseChangeIncrement);
        assertEquals(result1.userIndex, result2.userIndex);
        assertEquals(result1.userControlPoint, result2.userControlPoint);
        assertEquals(result1.registeredUser, result2.registeredUser);
    }

    @Test
    public void test_constructor_00017() {
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

        Gson gson = new Gson();
        UserDataServiceData result2 = gson.fromJson(gson.toJson(result1), UserDataServiceData.class);

        assertEquals(USER_DATA_SERVICE, result2.uuid);
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, result2.type);
        assertNotNull(result2.characteristicDataList);
        assertTrue(result2.characteristicDataList.isEmpty());
        assertEquals(result1.characteristicDataList.size(), result2.characteristicDataList.size());
        assertArrayEquals(result1.characteristicDataList.toArray(), result2.characteristicDataList.toArray());
        assertEquals(result1.firstName, result2.firstName);
        assertEquals(result1.lastName, result2.lastName);
        assertEquals(result1.emailAddress, result2.emailAddress);
        assertEquals(result1.age, result2.age);
        assertEquals(result1.dateOfBirth, result2.dateOfBirth);
        assertEquals(result1.gender, result2.gender);
        assertEquals(result1.weight, result2.weight);
        assertEquals(result1.height, result2.height);
        assertEquals(result1.vo2Max, result2.vo2Max);
        assertEquals(result1.heartRateMax, result2.heartRateMax);
        assertEquals(result1.restingHeartRate, result2.restingHeartRate);
        assertEquals(result1.maximumRecommendedHeartRate, result2.maximumRecommendedHeartRate);
        assertEquals(result1.aerobicThreshold, result2.aerobicThreshold);
        assertEquals(result1.anaerobicThreshold, result2.anaerobicThreshold);
        assertEquals(result1.sportTypeForAerobicAndAnaerobicThresholds, result2.sportTypeForAerobicAndAnaerobicThresholds);
        assertEquals(result1.dateOfThresholdAssessment, result2.dateOfThresholdAssessment);
        assertEquals(result1.waistCircumference, result2.waistCircumference);
        assertEquals(result1.hipCircumference, result2.hipCircumference);
        assertEquals(result1.fatBurnHeartRateLowerLimit, result2.fatBurnHeartRateLowerLimit);
        assertEquals(result1.fatBurnHeartRateUpperLimit, result2.fatBurnHeartRateUpperLimit);
        assertEquals(result1.aerobicHeartRateLowerLimit, result2.aerobicHeartRateLowerLimit);
        assertEquals(result1.aerobicHeartRateUpperLimit, result2.aerobicHeartRateUpperLimit);
        assertEquals(result1.anaerobicHeartRateLowerLimit, result2.anaerobicHeartRateLowerLimit);
        assertEquals(result1.anaerobicHeartRateUpperLimit, result2.anaerobicHeartRateUpperLimit);
        assertEquals(result1.fiveZoneHeartRateLimits, result2.fiveZoneHeartRateLimits);
        assertEquals(result1.threeZoneHeartRateLimits, result2.threeZoneHeartRateLimits);
        assertEquals(result1.twoZoneHeartRateLimit, result2.twoZoneHeartRateLimit);
        assertEquals(result1.language, result2.language);
        assertEquals(result1.databaseChangeIncrement, result2.databaseChangeIncrement);
        assertEquals(result1.userIndex, result2.userIndex);
        assertEquals(result1.userControlPoint, result2.userControlPoint);
        assertEquals(result1.registeredUser, result2.registeredUser);
    }

    @Test
    public void test_constructor_00018() {
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

        Gson gson = new Gson();
        UserDataServiceData result2 = gson.fromJson(gson.toJson(result1), UserDataServiceData.class);

        assertEquals(USER_DATA_SERVICE, result2.uuid);
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, result2.type);
        assertNotNull(result2.characteristicDataList);
        assertTrue(result2.characteristicDataList.isEmpty());
        assertEquals(result1.characteristicDataList.size(), result2.characteristicDataList.size());
        assertArrayEquals(result1.characteristicDataList.toArray(), result2.characteristicDataList.toArray());
        assertEquals(result1.firstName, result2.firstName);
        assertEquals(result1.lastName, result2.lastName);
        assertEquals(result1.emailAddress, result2.emailAddress);
        assertEquals(result1.age, result2.age);
        assertEquals(result1.dateOfBirth, result2.dateOfBirth);
        assertEquals(result1.gender, result2.gender);
        assertEquals(result1.weight, result2.weight);
        assertEquals(result1.height, result2.height);
        assertEquals(result1.vo2Max, result2.vo2Max);
        assertEquals(result1.heartRateMax, result2.heartRateMax);
        assertEquals(result1.restingHeartRate, result2.restingHeartRate);
        assertEquals(result1.maximumRecommendedHeartRate, result2.maximumRecommendedHeartRate);
        assertEquals(result1.aerobicThreshold, result2.aerobicThreshold);
        assertEquals(result1.anaerobicThreshold, result2.anaerobicThreshold);
        assertEquals(result1.sportTypeForAerobicAndAnaerobicThresholds, result2.sportTypeForAerobicAndAnaerobicThresholds);
        assertEquals(result1.dateOfThresholdAssessment, result2.dateOfThresholdAssessment);
        assertEquals(result1.waistCircumference, result2.waistCircumference);
        assertEquals(result1.hipCircumference, result2.hipCircumference);
        assertEquals(result1.fatBurnHeartRateLowerLimit, result2.fatBurnHeartRateLowerLimit);
        assertEquals(result1.fatBurnHeartRateUpperLimit, result2.fatBurnHeartRateUpperLimit);
        assertEquals(result1.aerobicHeartRateLowerLimit, result2.aerobicHeartRateLowerLimit);
        assertEquals(result1.aerobicHeartRateUpperLimit, result2.aerobicHeartRateUpperLimit);
        assertEquals(result1.anaerobicHeartRateLowerLimit, result2.anaerobicHeartRateLowerLimit);
        assertEquals(result1.anaerobicHeartRateUpperLimit, result2.anaerobicHeartRateUpperLimit);
        assertEquals(result1.fiveZoneHeartRateLimits, result2.fiveZoneHeartRateLimits);
        assertEquals(result1.threeZoneHeartRateLimits, result2.threeZoneHeartRateLimits);
        assertEquals(result1.twoZoneHeartRateLimit, result2.twoZoneHeartRateLimit);
        assertEquals(result1.language, result2.language);
        assertEquals(result1.databaseChangeIncrement, result2.databaseChangeIncrement);
        assertEquals(result1.userIndex, result2.userIndex);
        assertEquals(result1.userControlPoint, result2.userControlPoint);
        assertEquals(result1.registeredUser, result2.registeredUser);
    }

    @Test
    public void test_constructor_00019() {
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

        Gson gson = new Gson();
        UserDataServiceData result2 = gson.fromJson(gson.toJson(result1), UserDataServiceData.class);

        assertEquals(USER_DATA_SERVICE, result2.uuid);
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, result2.type);
        assertNotNull(result2.characteristicDataList);
        assertTrue(result2.characteristicDataList.isEmpty());
        assertEquals(result1.characteristicDataList.size(), result2.characteristicDataList.size());
        assertArrayEquals(result1.characteristicDataList.toArray(), result2.characteristicDataList.toArray());
        assertEquals(result1.firstName, result2.firstName);
        assertEquals(result1.lastName, result2.lastName);
        assertEquals(result1.emailAddress, result2.emailAddress);
        assertEquals(result1.age, result2.age);
        assertEquals(result1.dateOfBirth, result2.dateOfBirth);
        assertEquals(result1.gender, result2.gender);
        assertEquals(result1.weight, result2.weight);
        assertEquals(result1.height, result2.height);
        assertEquals(result1.vo2Max, result2.vo2Max);
        assertEquals(result1.heartRateMax, result2.heartRateMax);
        assertEquals(result1.restingHeartRate, result2.restingHeartRate);
        assertEquals(result1.maximumRecommendedHeartRate, result2.maximumRecommendedHeartRate);
        assertEquals(result1.aerobicThreshold, result2.aerobicThreshold);
        assertEquals(result1.anaerobicThreshold, result2.anaerobicThreshold);
        assertEquals(result1.sportTypeForAerobicAndAnaerobicThresholds, result2.sportTypeForAerobicAndAnaerobicThresholds);
        assertEquals(result1.dateOfThresholdAssessment, result2.dateOfThresholdAssessment);
        assertEquals(result1.waistCircumference, result2.waistCircumference);
        assertEquals(result1.hipCircumference, result2.hipCircumference);
        assertEquals(result1.fatBurnHeartRateLowerLimit, result2.fatBurnHeartRateLowerLimit);
        assertEquals(result1.fatBurnHeartRateUpperLimit, result2.fatBurnHeartRateUpperLimit);
        assertEquals(result1.aerobicHeartRateLowerLimit, result2.aerobicHeartRateLowerLimit);
        assertEquals(result1.aerobicHeartRateUpperLimit, result2.aerobicHeartRateUpperLimit);
        assertEquals(result1.anaerobicHeartRateLowerLimit, result2.anaerobicHeartRateLowerLimit);
        assertEquals(result1.anaerobicHeartRateUpperLimit, result2.anaerobicHeartRateUpperLimit);
        assertEquals(result1.fiveZoneHeartRateLimits, result2.fiveZoneHeartRateLimits);
        assertEquals(result1.threeZoneHeartRateLimits, result2.threeZoneHeartRateLimits);
        assertEquals(result1.twoZoneHeartRateLimit, result2.twoZoneHeartRateLimit);
        assertEquals(result1.language, result2.language);
        assertEquals(result1.databaseChangeIncrement, result2.databaseChangeIncrement);
        assertEquals(result1.userIndex, result2.userIndex);
        assertEquals(result1.userControlPoint, result2.userControlPoint);
        assertEquals(result1.registeredUser, result2.registeredUser);
    }

    @Test
    public void test_constructor_00020() {
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

        Gson gson = new Gson();
        UserDataServiceData result2 = gson.fromJson(gson.toJson(result1), UserDataServiceData.class);

        assertEquals(USER_DATA_SERVICE, result2.uuid);
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, result2.type);
        assertNotNull(result2.characteristicDataList);
        assertTrue(result2.characteristicDataList.isEmpty());
        assertEquals(result1.characteristicDataList.size(), result2.characteristicDataList.size());
        assertArrayEquals(result1.characteristicDataList.toArray(), result2.characteristicDataList.toArray());
        assertEquals(result1.firstName, result2.firstName);
        assertEquals(result1.lastName, result2.lastName);
        assertEquals(result1.emailAddress, result2.emailAddress);
        assertEquals(result1.age, result2.age);
        assertEquals(result1.dateOfBirth, result2.dateOfBirth);
        assertEquals(result1.gender, result2.gender);
        assertEquals(result1.weight, result2.weight);
        assertEquals(result1.height, result2.height);
        assertEquals(result1.vo2Max, result2.vo2Max);
        assertEquals(result1.heartRateMax, result2.heartRateMax);
        assertEquals(result1.restingHeartRate, result2.restingHeartRate);
        assertEquals(result1.maximumRecommendedHeartRate, result2.maximumRecommendedHeartRate);
        assertEquals(result1.aerobicThreshold, result2.aerobicThreshold);
        assertEquals(result1.anaerobicThreshold, result2.anaerobicThreshold);
        assertEquals(result1.sportTypeForAerobicAndAnaerobicThresholds, result2.sportTypeForAerobicAndAnaerobicThresholds);
        assertEquals(result1.dateOfThresholdAssessment, result2.dateOfThresholdAssessment);
        assertEquals(result1.waistCircumference, result2.waistCircumference);
        assertEquals(result1.hipCircumference, result2.hipCircumference);
        assertEquals(result1.fatBurnHeartRateLowerLimit, result2.fatBurnHeartRateLowerLimit);
        assertEquals(result1.fatBurnHeartRateUpperLimit, result2.fatBurnHeartRateUpperLimit);
        assertEquals(result1.aerobicHeartRateLowerLimit, result2.aerobicHeartRateLowerLimit);
        assertEquals(result1.aerobicHeartRateUpperLimit, result2.aerobicHeartRateUpperLimit);
        assertEquals(result1.anaerobicHeartRateLowerLimit, result2.anaerobicHeartRateLowerLimit);
        assertEquals(result1.anaerobicHeartRateUpperLimit, result2.anaerobicHeartRateUpperLimit);
        assertEquals(result1.fiveZoneHeartRateLimits, result2.fiveZoneHeartRateLimits);
        assertEquals(result1.threeZoneHeartRateLimits, result2.threeZoneHeartRateLimits);
        assertEquals(result1.twoZoneHeartRateLimit, result2.twoZoneHeartRateLimit);
        assertEquals(result1.language, result2.language);
        assertEquals(result1.databaseChangeIncrement, result2.databaseChangeIncrement);
        assertEquals(result1.userIndex, result2.userIndex);
        assertEquals(result1.userControlPoint, result2.userControlPoint);
        assertEquals(result1.registeredUser, result2.registeredUser);
    }

    @Test
    public void test_constructor_00021() {
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

        Gson gson = new Gson();
        UserDataServiceData result2 = gson.fromJson(gson.toJson(result1), UserDataServiceData.class);

        assertEquals(USER_DATA_SERVICE, result2.uuid);
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, result2.type);
        assertNotNull(result2.characteristicDataList);
        assertTrue(result2.characteristicDataList.isEmpty());
        assertEquals(result1.characteristicDataList.size(), result2.characteristicDataList.size());
        assertArrayEquals(result1.characteristicDataList.toArray(), result2.characteristicDataList.toArray());
        assertEquals(result1.firstName, result2.firstName);
        assertEquals(result1.lastName, result2.lastName);
        assertEquals(result1.emailAddress, result2.emailAddress);
        assertEquals(result1.age, result2.age);
        assertEquals(result1.dateOfBirth, result2.dateOfBirth);
        assertEquals(result1.gender, result2.gender);
        assertEquals(result1.weight, result2.weight);
        assertEquals(result1.height, result2.height);
        assertEquals(result1.vo2Max, result2.vo2Max);
        assertEquals(result1.heartRateMax, result2.heartRateMax);
        assertEquals(result1.restingHeartRate, result2.restingHeartRate);
        assertEquals(result1.maximumRecommendedHeartRate, result2.maximumRecommendedHeartRate);
        assertEquals(result1.aerobicThreshold, result2.aerobicThreshold);
        assertEquals(result1.anaerobicThreshold, result2.anaerobicThreshold);
        assertEquals(result1.sportTypeForAerobicAndAnaerobicThresholds, result2.sportTypeForAerobicAndAnaerobicThresholds);
        assertEquals(result1.dateOfThresholdAssessment, result2.dateOfThresholdAssessment);
        assertEquals(result1.waistCircumference, result2.waistCircumference);
        assertEquals(result1.hipCircumference, result2.hipCircumference);
        assertEquals(result1.fatBurnHeartRateLowerLimit, result2.fatBurnHeartRateLowerLimit);
        assertEquals(result1.fatBurnHeartRateUpperLimit, result2.fatBurnHeartRateUpperLimit);
        assertEquals(result1.aerobicHeartRateLowerLimit, result2.aerobicHeartRateLowerLimit);
        assertEquals(result1.aerobicHeartRateUpperLimit, result2.aerobicHeartRateUpperLimit);
        assertEquals(result1.anaerobicHeartRateLowerLimit, result2.anaerobicHeartRateLowerLimit);
        assertEquals(result1.anaerobicHeartRateUpperLimit, result2.anaerobicHeartRateUpperLimit);
        assertEquals(result1.fiveZoneHeartRateLimits, result2.fiveZoneHeartRateLimits);
        assertEquals(result1.threeZoneHeartRateLimits, result2.threeZoneHeartRateLimits);
        assertEquals(result1.twoZoneHeartRateLimit, result2.twoZoneHeartRateLimit);
        assertEquals(result1.language, result2.language);
        assertEquals(result1.databaseChangeIncrement, result2.databaseChangeIncrement);
        assertEquals(result1.userIndex, result2.userIndex);
        assertEquals(result1.userControlPoint, result2.userControlPoint);
        assertEquals(result1.registeredUser, result2.registeredUser);
    }

    @Test
    public void test_constructor_00022() {
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

        Gson gson = new Gson();
        UserDataServiceData result2 = gson.fromJson(gson.toJson(result1), UserDataServiceData.class);

        assertEquals(USER_DATA_SERVICE, result2.uuid);
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, result2.type);
        assertNotNull(result2.characteristicDataList);
        assertTrue(result2.characteristicDataList.isEmpty());
        assertEquals(result1.characteristicDataList.size(), result2.characteristicDataList.size());
        assertArrayEquals(result1.characteristicDataList.toArray(), result2.characteristicDataList.toArray());
        assertEquals(result1.firstName, result2.firstName);
        assertEquals(result1.lastName, result2.lastName);
        assertEquals(result1.emailAddress, result2.emailAddress);
        assertEquals(result1.age, result2.age);
        assertEquals(result1.dateOfBirth, result2.dateOfBirth);
        assertEquals(result1.gender, result2.gender);
        assertEquals(result1.weight, result2.weight);
        assertEquals(result1.height, result2.height);
        assertEquals(result1.vo2Max, result2.vo2Max);
        assertEquals(result1.heartRateMax, result2.heartRateMax);
        assertEquals(result1.restingHeartRate, result2.restingHeartRate);
        assertEquals(result1.maximumRecommendedHeartRate, result2.maximumRecommendedHeartRate);
        assertEquals(result1.aerobicThreshold, result2.aerobicThreshold);
        assertEquals(result1.anaerobicThreshold, result2.anaerobicThreshold);
        assertEquals(result1.sportTypeForAerobicAndAnaerobicThresholds, result2.sportTypeForAerobicAndAnaerobicThresholds);
        assertEquals(result1.dateOfThresholdAssessment, result2.dateOfThresholdAssessment);
        assertEquals(result1.waistCircumference, result2.waistCircumference);
        assertEquals(result1.hipCircumference, result2.hipCircumference);
        assertEquals(result1.fatBurnHeartRateLowerLimit, result2.fatBurnHeartRateLowerLimit);
        assertEquals(result1.fatBurnHeartRateUpperLimit, result2.fatBurnHeartRateUpperLimit);
        assertEquals(result1.aerobicHeartRateLowerLimit, result2.aerobicHeartRateLowerLimit);
        assertEquals(result1.aerobicHeartRateUpperLimit, result2.aerobicHeartRateUpperLimit);
        assertEquals(result1.anaerobicHeartRateLowerLimit, result2.anaerobicHeartRateLowerLimit);
        assertEquals(result1.anaerobicHeartRateUpperLimit, result2.anaerobicHeartRateUpperLimit);
        assertEquals(result1.fiveZoneHeartRateLimits, result2.fiveZoneHeartRateLimits);
        assertEquals(result1.threeZoneHeartRateLimits, result2.threeZoneHeartRateLimits);
        assertEquals(result1.twoZoneHeartRateLimit, result2.twoZoneHeartRateLimit);
        assertEquals(result1.language, result2.language);
        assertEquals(result1.databaseChangeIncrement, result2.databaseChangeIncrement);
        assertEquals(result1.userIndex, result2.userIndex);
        assertEquals(result1.userControlPoint, result2.userControlPoint);
        assertEquals(result1.registeredUser, result2.registeredUser);
    }

    @Test
    public void test_constructor_00023() {
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

        Gson gson = new Gson();
        UserDataServiceData result2 = gson.fromJson(gson.toJson(result1), UserDataServiceData.class);

        assertEquals(USER_DATA_SERVICE, result2.uuid);
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, result2.type);
        assertNotNull(result2.characteristicDataList);
        assertTrue(result2.characteristicDataList.isEmpty());
        assertEquals(result1.characteristicDataList.size(), result2.characteristicDataList.size());
        assertArrayEquals(result1.characteristicDataList.toArray(), result2.characteristicDataList.toArray());
        assertEquals(result1.firstName, result2.firstName);
        assertEquals(result1.lastName, result2.lastName);
        assertEquals(result1.emailAddress, result2.emailAddress);
        assertEquals(result1.age, result2.age);
        assertEquals(result1.dateOfBirth, result2.dateOfBirth);
        assertEquals(result1.gender, result2.gender);
        assertEquals(result1.weight, result2.weight);
        assertEquals(result1.height, result2.height);
        assertEquals(result1.vo2Max, result2.vo2Max);
        assertEquals(result1.heartRateMax, result2.heartRateMax);
        assertEquals(result1.restingHeartRate, result2.restingHeartRate);
        assertEquals(result1.maximumRecommendedHeartRate, result2.maximumRecommendedHeartRate);
        assertEquals(result1.aerobicThreshold, result2.aerobicThreshold);
        assertEquals(result1.anaerobicThreshold, result2.anaerobicThreshold);
        assertEquals(result1.sportTypeForAerobicAndAnaerobicThresholds, result2.sportTypeForAerobicAndAnaerobicThresholds);
        assertEquals(result1.dateOfThresholdAssessment, result2.dateOfThresholdAssessment);
        assertEquals(result1.waistCircumference, result2.waistCircumference);
        assertEquals(result1.hipCircumference, result2.hipCircumference);
        assertEquals(result1.fatBurnHeartRateLowerLimit, result2.fatBurnHeartRateLowerLimit);
        assertEquals(result1.fatBurnHeartRateUpperLimit, result2.fatBurnHeartRateUpperLimit);
        assertEquals(result1.aerobicHeartRateLowerLimit, result2.aerobicHeartRateLowerLimit);
        assertEquals(result1.aerobicHeartRateUpperLimit, result2.aerobicHeartRateUpperLimit);
        assertEquals(result1.anaerobicHeartRateLowerLimit, result2.anaerobicHeartRateLowerLimit);
        assertEquals(result1.anaerobicHeartRateUpperLimit, result2.anaerobicHeartRateUpperLimit);
        assertEquals(result1.fiveZoneHeartRateLimits, result2.fiveZoneHeartRateLimits);
        assertEquals(result1.threeZoneHeartRateLimits, result2.threeZoneHeartRateLimits);
        assertEquals(result1.twoZoneHeartRateLimit, result2.twoZoneHeartRateLimit);
        assertEquals(result1.language, result2.language);
        assertEquals(result1.databaseChangeIncrement, result2.databaseChangeIncrement);
        assertEquals(result1.userIndex, result2.userIndex);
        assertEquals(result1.userControlPoint, result2.userControlPoint);
        assertEquals(result1.registeredUser, result2.registeredUser);
    }

    @Test
    public void test_constructor_00024() {
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

        Gson gson = new Gson();
        UserDataServiceData result2 = gson.fromJson(gson.toJson(result1), UserDataServiceData.class);

        assertEquals(USER_DATA_SERVICE, result2.uuid);
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, result2.type);
        assertNotNull(result2.characteristicDataList);
        assertTrue(result2.characteristicDataList.isEmpty());
        assertEquals(result1.characteristicDataList.size(), result2.characteristicDataList.size());
        assertArrayEquals(result1.characteristicDataList.toArray(), result2.characteristicDataList.toArray());
        assertEquals(result1.firstName, result2.firstName);
        assertEquals(result1.lastName, result2.lastName);
        assertEquals(result1.emailAddress, result2.emailAddress);
        assertEquals(result1.age, result2.age);
        assertEquals(result1.dateOfBirth, result2.dateOfBirth);
        assertEquals(result1.gender, result2.gender);
        assertEquals(result1.weight, result2.weight);
        assertEquals(result1.height, result2.height);
        assertEquals(result1.vo2Max, result2.vo2Max);
        assertEquals(result1.heartRateMax, result2.heartRateMax);
        assertEquals(result1.restingHeartRate, result2.restingHeartRate);
        assertEquals(result1.maximumRecommendedHeartRate, result2.maximumRecommendedHeartRate);
        assertEquals(result1.aerobicThreshold, result2.aerobicThreshold);
        assertEquals(result1.anaerobicThreshold, result2.anaerobicThreshold);
        assertEquals(result1.sportTypeForAerobicAndAnaerobicThresholds, result2.sportTypeForAerobicAndAnaerobicThresholds);
        assertEquals(result1.dateOfThresholdAssessment, result2.dateOfThresholdAssessment);
        assertEquals(result1.waistCircumference, result2.waistCircumference);
        assertEquals(result1.hipCircumference, result2.hipCircumference);
        assertEquals(result1.fatBurnHeartRateLowerLimit, result2.fatBurnHeartRateLowerLimit);
        assertEquals(result1.fatBurnHeartRateUpperLimit, result2.fatBurnHeartRateUpperLimit);
        assertEquals(result1.aerobicHeartRateLowerLimit, result2.aerobicHeartRateLowerLimit);
        assertEquals(result1.aerobicHeartRateUpperLimit, result2.aerobicHeartRateUpperLimit);
        assertEquals(result1.anaerobicHeartRateLowerLimit, result2.anaerobicHeartRateLowerLimit);
        assertEquals(result1.anaerobicHeartRateUpperLimit, result2.anaerobicHeartRateUpperLimit);
        assertEquals(result1.fiveZoneHeartRateLimits, result2.fiveZoneHeartRateLimits);
        assertEquals(result1.threeZoneHeartRateLimits, result2.threeZoneHeartRateLimits);
        assertEquals(result1.twoZoneHeartRateLimit, result2.twoZoneHeartRateLimit);
        assertEquals(result1.language, result2.language);
        assertEquals(result1.databaseChangeIncrement, result2.databaseChangeIncrement);
        assertEquals(result1.userIndex, result2.userIndex);
        assertEquals(result1.userControlPoint, result2.userControlPoint);
        assertEquals(result1.registeredUser, result2.registeredUser);
    }

    @Test
    public void test_constructor_00025() {
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

        Gson gson = new Gson();
        UserDataServiceData result2 = gson.fromJson(gson.toJson(result1), UserDataServiceData.class);

        assertEquals(USER_DATA_SERVICE, result2.uuid);
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, result2.type);
        assertNotNull(result2.characteristicDataList);
        assertTrue(result2.characteristicDataList.isEmpty());
        assertEquals(result1.characteristicDataList.size(), result2.characteristicDataList.size());
        assertArrayEquals(result1.characteristicDataList.toArray(), result2.characteristicDataList.toArray());
        assertEquals(result1.firstName, result2.firstName);
        assertEquals(result1.lastName, result2.lastName);
        assertEquals(result1.emailAddress, result2.emailAddress);
        assertEquals(result1.age, result2.age);
        assertEquals(result1.dateOfBirth, result2.dateOfBirth);
        assertEquals(result1.gender, result2.gender);
        assertEquals(result1.weight, result2.weight);
        assertEquals(result1.height, result2.height);
        assertEquals(result1.vo2Max, result2.vo2Max);
        assertEquals(result1.heartRateMax, result2.heartRateMax);
        assertEquals(result1.restingHeartRate, result2.restingHeartRate);
        assertEquals(result1.maximumRecommendedHeartRate, result2.maximumRecommendedHeartRate);
        assertEquals(result1.aerobicThreshold, result2.aerobicThreshold);
        assertEquals(result1.anaerobicThreshold, result2.anaerobicThreshold);
        assertEquals(result1.sportTypeForAerobicAndAnaerobicThresholds, result2.sportTypeForAerobicAndAnaerobicThresholds);
        assertEquals(result1.dateOfThresholdAssessment, result2.dateOfThresholdAssessment);
        assertEquals(result1.waistCircumference, result2.waistCircumference);
        assertEquals(result1.hipCircumference, result2.hipCircumference);
        assertEquals(result1.fatBurnHeartRateLowerLimit, result2.fatBurnHeartRateLowerLimit);
        assertEquals(result1.fatBurnHeartRateUpperLimit, result2.fatBurnHeartRateUpperLimit);
        assertEquals(result1.aerobicHeartRateLowerLimit, result2.aerobicHeartRateLowerLimit);
        assertEquals(result1.aerobicHeartRateUpperLimit, result2.aerobicHeartRateUpperLimit);
        assertEquals(result1.anaerobicHeartRateLowerLimit, result2.anaerobicHeartRateLowerLimit);
        assertEquals(result1.anaerobicHeartRateUpperLimit, result2.anaerobicHeartRateUpperLimit);
        assertEquals(result1.fiveZoneHeartRateLimits, result2.fiveZoneHeartRateLimits);
        assertEquals(result1.threeZoneHeartRateLimits, result2.threeZoneHeartRateLimits);
        assertEquals(result1.twoZoneHeartRateLimit, result2.twoZoneHeartRateLimit);
        assertEquals(result1.language, result2.language);
        assertEquals(result1.databaseChangeIncrement, result2.databaseChangeIncrement);
        assertEquals(result1.userIndex, result2.userIndex);
        assertEquals(result1.userControlPoint, result2.userControlPoint);
        assertEquals(result1.registeredUser, result2.registeredUser);
    }

    @Test
    public void test_constructor_00026() {
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

        Gson gson = new Gson();
        UserDataServiceData result2 = gson.fromJson(gson.toJson(result1), UserDataServiceData.class);

        assertEquals(USER_DATA_SERVICE, result2.uuid);
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, result2.type);
        assertNotNull(result2.characteristicDataList);
        assertTrue(result2.characteristicDataList.isEmpty());
        assertEquals(result1.characteristicDataList.size(), result2.characteristicDataList.size());
        assertArrayEquals(result1.characteristicDataList.toArray(), result2.characteristicDataList.toArray());
        assertEquals(result1.firstName, result2.firstName);
        assertEquals(result1.lastName, result2.lastName);
        assertEquals(result1.emailAddress, result2.emailAddress);
        assertEquals(result1.age, result2.age);
        assertEquals(result1.dateOfBirth, result2.dateOfBirth);
        assertEquals(result1.gender, result2.gender);
        assertEquals(result1.weight, result2.weight);
        assertEquals(result1.height, result2.height);
        assertEquals(result1.vo2Max, result2.vo2Max);
        assertEquals(result1.heartRateMax, result2.heartRateMax);
        assertEquals(result1.restingHeartRate, result2.restingHeartRate);
        assertEquals(result1.maximumRecommendedHeartRate, result2.maximumRecommendedHeartRate);
        assertEquals(result1.aerobicThreshold, result2.aerobicThreshold);
        assertEquals(result1.anaerobicThreshold, result2.anaerobicThreshold);
        assertEquals(result1.sportTypeForAerobicAndAnaerobicThresholds, result2.sportTypeForAerobicAndAnaerobicThresholds);
        assertEquals(result1.dateOfThresholdAssessment, result2.dateOfThresholdAssessment);
        assertEquals(result1.waistCircumference, result2.waistCircumference);
        assertEquals(result1.hipCircumference, result2.hipCircumference);
        assertEquals(result1.fatBurnHeartRateLowerLimit, result2.fatBurnHeartRateLowerLimit);
        assertEquals(result1.fatBurnHeartRateUpperLimit, result2.fatBurnHeartRateUpperLimit);
        assertEquals(result1.aerobicHeartRateLowerLimit, result2.aerobicHeartRateLowerLimit);
        assertEquals(result1.aerobicHeartRateUpperLimit, result2.aerobicHeartRateUpperLimit);
        assertEquals(result1.anaerobicHeartRateLowerLimit, result2.anaerobicHeartRateLowerLimit);
        assertEquals(result1.anaerobicHeartRateUpperLimit, result2.anaerobicHeartRateUpperLimit);
        assertEquals(result1.fiveZoneHeartRateLimits, result2.fiveZoneHeartRateLimits);
        assertEquals(result1.threeZoneHeartRateLimits, result2.threeZoneHeartRateLimits);
        assertEquals(result1.twoZoneHeartRateLimit, result2.twoZoneHeartRateLimit);
        assertEquals(result1.language, result2.language);
        assertEquals(result1.databaseChangeIncrement, result2.databaseChangeIncrement);
        assertEquals(result1.userIndex, result2.userIndex);
        assertEquals(result1.userControlPoint, result2.userControlPoint);
        assertEquals(result1.registeredUser, result2.registeredUser);
    }

    @Test
    public void test_constructor_00027() {
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

        Gson gson = new Gson();
        UserDataServiceData result2 = gson.fromJson(gson.toJson(result1), UserDataServiceData.class);

        assertEquals(USER_DATA_SERVICE, result2.uuid);
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, result2.type);
        assertNotNull(result2.characteristicDataList);
        assertTrue(result2.characteristicDataList.isEmpty());
        assertEquals(result1.characteristicDataList.size(), result2.characteristicDataList.size());
        assertArrayEquals(result1.characteristicDataList.toArray(), result2.characteristicDataList.toArray());
        assertEquals(result1.firstName, result2.firstName);
        assertEquals(result1.lastName, result2.lastName);
        assertEquals(result1.emailAddress, result2.emailAddress);
        assertEquals(result1.age, result2.age);
        assertEquals(result1.dateOfBirth, result2.dateOfBirth);
        assertEquals(result1.gender, result2.gender);
        assertEquals(result1.weight, result2.weight);
        assertEquals(result1.height, result2.height);
        assertEquals(result1.vo2Max, result2.vo2Max);
        assertEquals(result1.heartRateMax, result2.heartRateMax);
        assertEquals(result1.restingHeartRate, result2.restingHeartRate);
        assertEquals(result1.maximumRecommendedHeartRate, result2.maximumRecommendedHeartRate);
        assertEquals(result1.aerobicThreshold, result2.aerobicThreshold);
        assertEquals(result1.anaerobicThreshold, result2.anaerobicThreshold);
        assertEquals(result1.sportTypeForAerobicAndAnaerobicThresholds, result2.sportTypeForAerobicAndAnaerobicThresholds);
        assertEquals(result1.dateOfThresholdAssessment, result2.dateOfThresholdAssessment);
        assertEquals(result1.waistCircumference, result2.waistCircumference);
        assertEquals(result1.hipCircumference, result2.hipCircumference);
        assertEquals(result1.fatBurnHeartRateLowerLimit, result2.fatBurnHeartRateLowerLimit);
        assertEquals(result1.fatBurnHeartRateUpperLimit, result2.fatBurnHeartRateUpperLimit);
        assertEquals(result1.aerobicHeartRateLowerLimit, result2.aerobicHeartRateLowerLimit);
        assertEquals(result1.aerobicHeartRateUpperLimit, result2.aerobicHeartRateUpperLimit);
        assertEquals(result1.anaerobicHeartRateLowerLimit, result2.anaerobicHeartRateLowerLimit);
        assertEquals(result1.anaerobicHeartRateUpperLimit, result2.anaerobicHeartRateUpperLimit);
        assertEquals(result1.fiveZoneHeartRateLimits, result2.fiveZoneHeartRateLimits);
        assertEquals(result1.threeZoneHeartRateLimits, result2.threeZoneHeartRateLimits);
        assertEquals(result1.twoZoneHeartRateLimit, result2.twoZoneHeartRateLimit);
        assertEquals(result1.language, result2.language);
        assertEquals(result1.databaseChangeIncrement, result2.databaseChangeIncrement);
        assertEquals(result1.userIndex, result2.userIndex);
        assertEquals(result1.userControlPoint, result2.userControlPoint);
        assertEquals(result1.registeredUser, result2.registeredUser);
    }

    @Test
    public void test_constructor_00028() {
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

        Gson gson = new Gson();
        UserDataServiceData result2 = gson.fromJson(gson.toJson(result1), UserDataServiceData.class);

        assertEquals(USER_DATA_SERVICE, result2.uuid);
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, result2.type);
        assertNotNull(result2.characteristicDataList);
        assertTrue(result2.characteristicDataList.isEmpty());
        assertEquals(result1.characteristicDataList.size(), result2.characteristicDataList.size());
        assertArrayEquals(result1.characteristicDataList.toArray(), result2.characteristicDataList.toArray());
        assertEquals(result1.firstName, result2.firstName);
        assertEquals(result1.lastName, result2.lastName);
        assertEquals(result1.emailAddress, result2.emailAddress);
        assertEquals(result1.age, result2.age);
        assertEquals(result1.dateOfBirth, result2.dateOfBirth);
        assertEquals(result1.gender, result2.gender);
        assertEquals(result1.weight, result2.weight);
        assertEquals(result1.height, result2.height);
        assertEquals(result1.vo2Max, result2.vo2Max);
        assertEquals(result1.heartRateMax, result2.heartRateMax);
        assertEquals(result1.restingHeartRate, result2.restingHeartRate);
        assertEquals(result1.maximumRecommendedHeartRate, result2.maximumRecommendedHeartRate);
        assertEquals(result1.aerobicThreshold, result2.aerobicThreshold);
        assertEquals(result1.anaerobicThreshold, result2.anaerobicThreshold);
        assertEquals(result1.sportTypeForAerobicAndAnaerobicThresholds, result2.sportTypeForAerobicAndAnaerobicThresholds);
        assertEquals(result1.dateOfThresholdAssessment, result2.dateOfThresholdAssessment);
        assertEquals(result1.waistCircumference, result2.waistCircumference);
        assertEquals(result1.hipCircumference, result2.hipCircumference);
        assertEquals(result1.fatBurnHeartRateLowerLimit, result2.fatBurnHeartRateLowerLimit);
        assertEquals(result1.fatBurnHeartRateUpperLimit, result2.fatBurnHeartRateUpperLimit);
        assertEquals(result1.aerobicHeartRateLowerLimit, result2.aerobicHeartRateLowerLimit);
        assertEquals(result1.aerobicHeartRateUpperLimit, result2.aerobicHeartRateUpperLimit);
        assertEquals(result1.anaerobicHeartRateLowerLimit, result2.anaerobicHeartRateLowerLimit);
        assertEquals(result1.anaerobicHeartRateUpperLimit, result2.anaerobicHeartRateUpperLimit);
        assertEquals(result1.fiveZoneHeartRateLimits, result2.fiveZoneHeartRateLimits);
        assertEquals(result1.threeZoneHeartRateLimits, result2.threeZoneHeartRateLimits);
        assertEquals(result1.twoZoneHeartRateLimit, result2.twoZoneHeartRateLimit);
        assertEquals(result1.language, result2.language);
        assertEquals(result1.databaseChangeIncrement, result2.databaseChangeIncrement);
        assertEquals(result1.userIndex, result2.userIndex);
        assertEquals(result1.userControlPoint, result2.userControlPoint);
        assertEquals(result1.registeredUser, result2.registeredUser);
    }

    @Test
    public void test_constructor_00029() {
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

        Gson gson = new Gson();
        UserDataServiceData result2 = gson.fromJson(gson.toJson(result1), UserDataServiceData.class);

        assertEquals(USER_DATA_SERVICE, result2.uuid);
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, result2.type);
        assertNotNull(result2.characteristicDataList);
        assertTrue(result2.characteristicDataList.isEmpty());
        assertEquals(result1.characteristicDataList.size(), result2.characteristicDataList.size());
        assertArrayEquals(result1.characteristicDataList.toArray(), result2.characteristicDataList.toArray());
        assertEquals(result1.firstName, result2.firstName);
        assertEquals(result1.lastName, result2.lastName);
        assertEquals(result1.emailAddress, result2.emailAddress);
        assertEquals(result1.age, result2.age);
        assertEquals(result1.dateOfBirth, result2.dateOfBirth);
        assertEquals(result1.gender, result2.gender);
        assertEquals(result1.weight, result2.weight);
        assertEquals(result1.height, result2.height);
        assertEquals(result1.vo2Max, result2.vo2Max);
        assertEquals(result1.heartRateMax, result2.heartRateMax);
        assertEquals(result1.restingHeartRate, result2.restingHeartRate);
        assertEquals(result1.maximumRecommendedHeartRate, result2.maximumRecommendedHeartRate);
        assertEquals(result1.aerobicThreshold, result2.aerobicThreshold);
        assertEquals(result1.anaerobicThreshold, result2.anaerobicThreshold);
        assertEquals(result1.sportTypeForAerobicAndAnaerobicThresholds, result2.sportTypeForAerobicAndAnaerobicThresholds);
        assertEquals(result1.dateOfThresholdAssessment, result2.dateOfThresholdAssessment);
        assertEquals(result1.waistCircumference, result2.waistCircumference);
        assertEquals(result1.hipCircumference, result2.hipCircumference);
        assertEquals(result1.fatBurnHeartRateLowerLimit, result2.fatBurnHeartRateLowerLimit);
        assertEquals(result1.fatBurnHeartRateUpperLimit, result2.fatBurnHeartRateUpperLimit);
        assertEquals(result1.aerobicHeartRateLowerLimit, result2.aerobicHeartRateLowerLimit);
        assertEquals(result1.aerobicHeartRateUpperLimit, result2.aerobicHeartRateUpperLimit);
        assertEquals(result1.anaerobicHeartRateLowerLimit, result2.anaerobicHeartRateLowerLimit);
        assertEquals(result1.anaerobicHeartRateUpperLimit, result2.anaerobicHeartRateUpperLimit);
        assertEquals(result1.fiveZoneHeartRateLimits, result2.fiveZoneHeartRateLimits);
        assertEquals(result1.threeZoneHeartRateLimits, result2.threeZoneHeartRateLimits);
        assertEquals(result1.twoZoneHeartRateLimit, result2.twoZoneHeartRateLimit);
        assertEquals(result1.language, result2.language);
        assertEquals(result1.databaseChangeIncrement, result2.databaseChangeIncrement);
        assertEquals(result1.userIndex, result2.userIndex);
        assertEquals(result1.userControlPoint, result2.userControlPoint);
        assertEquals(result1.registeredUser, result2.registeredUser);
    }

    @Test
    public void test_constructor_00030() {
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

        Gson gson = new Gson();
        UserDataServiceData result2 = gson.fromJson(gson.toJson(result1), UserDataServiceData.class);

        assertEquals(USER_DATA_SERVICE, result2.uuid);
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, result2.type);
        assertNotNull(result2.characteristicDataList);
        assertTrue(result2.characteristicDataList.isEmpty());
        assertEquals(result1.characteristicDataList.size(), result2.characteristicDataList.size());
        assertArrayEquals(result1.characteristicDataList.toArray(), result2.characteristicDataList.toArray());
        assertEquals(result1.firstName, result2.firstName);
        assertEquals(result1.lastName, result2.lastName);
        assertEquals(result1.emailAddress, result2.emailAddress);
        assertEquals(result1.age, result2.age);
        assertEquals(result1.dateOfBirth, result2.dateOfBirth);
        assertEquals(result1.gender, result2.gender);
        assertEquals(result1.weight, result2.weight);
        assertEquals(result1.height, result2.height);
        assertEquals(result1.vo2Max, result2.vo2Max);
        assertEquals(result1.heartRateMax, result2.heartRateMax);
        assertEquals(result1.restingHeartRate, result2.restingHeartRate);
        assertEquals(result1.maximumRecommendedHeartRate, result2.maximumRecommendedHeartRate);
        assertEquals(result1.aerobicThreshold, result2.aerobicThreshold);
        assertEquals(result1.anaerobicThreshold, result2.anaerobicThreshold);
        assertEquals(result1.sportTypeForAerobicAndAnaerobicThresholds, result2.sportTypeForAerobicAndAnaerobicThresholds);
        assertEquals(result1.dateOfThresholdAssessment, result2.dateOfThresholdAssessment);
        assertEquals(result1.waistCircumference, result2.waistCircumference);
        assertEquals(result1.hipCircumference, result2.hipCircumference);
        assertEquals(result1.fatBurnHeartRateLowerLimit, result2.fatBurnHeartRateLowerLimit);
        assertEquals(result1.fatBurnHeartRateUpperLimit, result2.fatBurnHeartRateUpperLimit);
        assertEquals(result1.aerobicHeartRateLowerLimit, result2.aerobicHeartRateLowerLimit);
        assertEquals(result1.aerobicHeartRateUpperLimit, result2.aerobicHeartRateUpperLimit);
        assertEquals(result1.anaerobicHeartRateLowerLimit, result2.anaerobicHeartRateLowerLimit);
        assertEquals(result1.anaerobicHeartRateUpperLimit, result2.anaerobicHeartRateUpperLimit);
        assertEquals(result1.fiveZoneHeartRateLimits, result2.fiveZoneHeartRateLimits);
        assertEquals(result1.threeZoneHeartRateLimits, result2.threeZoneHeartRateLimits);
        assertEquals(result1.twoZoneHeartRateLimit, result2.twoZoneHeartRateLimit);
        assertEquals(result1.language, result2.language);
        assertEquals(result1.databaseChangeIncrement, result2.databaseChangeIncrement);
        assertEquals(result1.userIndex, result2.userIndex);
        assertEquals(result1.userControlPoint, result2.userControlPoint);
        assertEquals(result1.registeredUser, result2.registeredUser);
    }

    @Test
    public void test_constructor_00031() {
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

        Gson gson = new Gson();
        UserDataServiceData result2 = gson.fromJson(gson.toJson(result1), UserDataServiceData.class);

        assertEquals(USER_DATA_SERVICE, result2.uuid);
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, result2.type);
        assertNotNull(result2.characteristicDataList);
        assertTrue(result2.characteristicDataList.isEmpty());
        assertEquals(result1.characteristicDataList.size(), result2.characteristicDataList.size());
        assertArrayEquals(result1.characteristicDataList.toArray(), result2.characteristicDataList.toArray());
        assertEquals(result1.firstName, result2.firstName);
        assertEquals(result1.lastName, result2.lastName);
        assertEquals(result1.emailAddress, result2.emailAddress);
        assertEquals(result1.age, result2.age);
        assertEquals(result1.dateOfBirth, result2.dateOfBirth);
        assertEquals(result1.gender, result2.gender);
        assertEquals(result1.weight, result2.weight);
        assertEquals(result1.height, result2.height);
        assertEquals(result1.vo2Max, result2.vo2Max);
        assertEquals(result1.heartRateMax, result2.heartRateMax);
        assertEquals(result1.restingHeartRate, result2.restingHeartRate);
        assertEquals(result1.maximumRecommendedHeartRate, result2.maximumRecommendedHeartRate);
        assertEquals(result1.aerobicThreshold, result2.aerobicThreshold);
        assertEquals(result1.anaerobicThreshold, result2.anaerobicThreshold);
        assertEquals(result1.sportTypeForAerobicAndAnaerobicThresholds, result2.sportTypeForAerobicAndAnaerobicThresholds);
        assertEquals(result1.dateOfThresholdAssessment, result2.dateOfThresholdAssessment);
        assertEquals(result1.waistCircumference, result2.waistCircumference);
        assertEquals(result1.hipCircumference, result2.hipCircumference);
        assertEquals(result1.fatBurnHeartRateLowerLimit, result2.fatBurnHeartRateLowerLimit);
        assertEquals(result1.fatBurnHeartRateUpperLimit, result2.fatBurnHeartRateUpperLimit);
        assertEquals(result1.aerobicHeartRateLowerLimit, result2.aerobicHeartRateLowerLimit);
        assertEquals(result1.aerobicHeartRateUpperLimit, result2.aerobicHeartRateUpperLimit);
        assertEquals(result1.anaerobicHeartRateLowerLimit, result2.anaerobicHeartRateLowerLimit);
        assertEquals(result1.anaerobicHeartRateUpperLimit, result2.anaerobicHeartRateUpperLimit);
        assertEquals(result1.fiveZoneHeartRateLimits, result2.fiveZoneHeartRateLimits);
        assertEquals(result1.threeZoneHeartRateLimits, result2.threeZoneHeartRateLimits);
        assertEquals(result1.twoZoneHeartRateLimit, result2.twoZoneHeartRateLimit);
        assertEquals(result1.language, result2.language);
        assertEquals(result1.databaseChangeIncrement, result2.databaseChangeIncrement);
        assertEquals(result1.userIndex, result2.userIndex);
        assertEquals(result1.userControlPoint, result2.userControlPoint);
        assertEquals(result1.registeredUser, result2.registeredUser);
    }

    @Test
    public void test_constructor_00032() {
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

        Gson gson = new Gson();
        UserDataServiceData result2 = gson.fromJson(gson.toJson(result1), UserDataServiceData.class);

        assertEquals(USER_DATA_SERVICE, result2.uuid);
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, result2.type);
        assertNotNull(result2.characteristicDataList);
        assertTrue(result2.characteristicDataList.isEmpty());
        assertEquals(result1.characteristicDataList.size(), result2.characteristicDataList.size());
        assertArrayEquals(result1.characteristicDataList.toArray(), result2.characteristicDataList.toArray());
        assertEquals(result1.firstName, result2.firstName);
        assertEquals(result1.lastName, result2.lastName);
        assertEquals(result1.emailAddress, result2.emailAddress);
        assertEquals(result1.age, result2.age);
        assertEquals(result1.dateOfBirth, result2.dateOfBirth);
        assertEquals(result1.gender, result2.gender);
        assertEquals(result1.weight, result2.weight);
        assertEquals(result1.height, result2.height);
        assertEquals(result1.vo2Max, result2.vo2Max);
        assertEquals(result1.heartRateMax, result2.heartRateMax);
        assertEquals(result1.restingHeartRate, result2.restingHeartRate);
        assertEquals(result1.maximumRecommendedHeartRate, result2.maximumRecommendedHeartRate);
        assertEquals(result1.aerobicThreshold, result2.aerobicThreshold);
        assertEquals(result1.anaerobicThreshold, result2.anaerobicThreshold);
        assertEquals(result1.sportTypeForAerobicAndAnaerobicThresholds, result2.sportTypeForAerobicAndAnaerobicThresholds);
        assertEquals(result1.dateOfThresholdAssessment, result2.dateOfThresholdAssessment);
        assertEquals(result1.waistCircumference, result2.waistCircumference);
        assertEquals(result1.hipCircumference, result2.hipCircumference);
        assertEquals(result1.fatBurnHeartRateLowerLimit, result2.fatBurnHeartRateLowerLimit);
        assertEquals(result1.fatBurnHeartRateUpperLimit, result2.fatBurnHeartRateUpperLimit);
        assertEquals(result1.aerobicHeartRateLowerLimit, result2.aerobicHeartRateLowerLimit);
        assertEquals(result1.aerobicHeartRateUpperLimit, result2.aerobicHeartRateUpperLimit);
        assertEquals(result1.anaerobicHeartRateLowerLimit, result2.anaerobicHeartRateLowerLimit);
        assertEquals(result1.anaerobicHeartRateUpperLimit, result2.anaerobicHeartRateUpperLimit);
        assertEquals(result1.fiveZoneHeartRateLimits, result2.fiveZoneHeartRateLimits);
        assertEquals(result1.threeZoneHeartRateLimits, result2.threeZoneHeartRateLimits);
        assertEquals(result1.twoZoneHeartRateLimit, result2.twoZoneHeartRateLimit);
        assertEquals(result1.language, result2.language);
        assertEquals(result1.databaseChangeIncrement, result2.databaseChangeIncrement);
        assertEquals(result1.userIndex, result2.userIndex);
        assertEquals(result1.userControlPoint, result2.userControlPoint);
        assertEquals(result1.registeredUser, result2.registeredUser);
    }

    @Test
    public void test_constructor_00101() {
        UserDataServiceData result1 = new UserDataServiceData();

        assertNull(result1.firstName);
        assertNull(result1.lastName);
        assertNull(result1.emailAddress);
        assertNull(result1.age);
        assertNull(result1.dateOfBirth);
        assertNull(result1.gender);
        assertNull(result1.weight);
        assertNull(result1.height);
        assertNull(result1.vo2Max);
        assertNull(result1.heartRateMax);
        assertNull(result1.restingHeartRate);
        assertNull(result1.maximumRecommendedHeartRate);
        assertNull(result1.aerobicThreshold);
        assertNull(result1.anaerobicThreshold);
        assertNull(result1.sportTypeForAerobicAndAnaerobicThresholds);
        assertNull(result1.dateOfThresholdAssessment);
        assertNull(result1.waistCircumference);
        assertNull(result1.hipCircumference);
        assertNull(result1.fatBurnHeartRateLowerLimit);
        assertNull(result1.fatBurnHeartRateUpperLimit);
        assertNull(result1.aerobicHeartRateLowerLimit);
        assertNull(result1.aerobicHeartRateUpperLimit);
        assertNull(result1.anaerobicHeartRateLowerLimit);
        assertNull(result1.anaerobicHeartRateUpperLimit);
        assertNull(result1.fiveZoneHeartRateLimits);
        assertNull(result1.threeZoneHeartRateLimits);
        assertNull(result1.twoZoneHeartRateLimit);
        assertNull(result1.language);
        assertNull(result1.databaseChangeIncrement);
        assertNull(result1.userIndex);
        assertNull(result1.userControlPoint);
        assertNull(result1.registeredUser);
    }

}
