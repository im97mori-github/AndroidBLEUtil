package org.im97mori.ble.service.uds.central;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.BLECallback;
import org.im97mori.ble.ByteArrayInterface;
import org.im97mori.ble.characteristic.u2a7e.AerobicHeartRateLowerLimit;
import org.im97mori.ble.characteristic.u2a7e.AerobicHeartRateLowerLimitAndroid;
import org.im97mori.ble.characteristic.u2a7f.AerobicThreshold;
import org.im97mori.ble.characteristic.u2a7f.AerobicThresholdAndroid;
import org.im97mori.ble.characteristic.u2a80.Age;
import org.im97mori.ble.characteristic.u2a80.AgeAndroid;
import org.im97mori.ble.characteristic.u2a81.AnaerobicHeartRateLowerLimit;
import org.im97mori.ble.characteristic.u2a81.AnaerobicHeartRateLowerLimitAndroid;
import org.im97mori.ble.characteristic.u2a82.AnaerobicHeartRateUpperLimit;
import org.im97mori.ble.characteristic.u2a82.AnaerobicHeartRateUpperLimitAndroid;
import org.im97mori.ble.characteristic.u2a83.AnaerobicThreshold;
import org.im97mori.ble.characteristic.u2a83.AnaerobicThresholdAndroid;
import org.im97mori.ble.characteristic.u2a84.AerobicHeartRateUpperLimit;
import org.im97mori.ble.characteristic.u2a84.AerobicHeartRateUpperLimitAndroid;
import org.im97mori.ble.characteristic.u2a85.DateOfBirth;
import org.im97mori.ble.characteristic.u2a85.DateOfBirthAndroid;
import org.im97mori.ble.characteristic.u2a86.DateOfThresholdAssessment;
import org.im97mori.ble.characteristic.u2a86.DateOfThresholdAssessmentAndroid;
import org.im97mori.ble.characteristic.u2a87.EmailAddress;
import org.im97mori.ble.characteristic.u2a87.EmailAddressAndroid;
import org.im97mori.ble.characteristic.u2a88.FatBurnHeartRateLowerLimit;
import org.im97mori.ble.characteristic.u2a88.FatBurnHeartRateLowerLimitAndroid;
import org.im97mori.ble.characteristic.u2a89.FatBurnHeartRateUpperLimit;
import org.im97mori.ble.characteristic.u2a89.FatBurnHeartRateUpperLimitAndroid;
import org.im97mori.ble.characteristic.u2a8a.FirstName;
import org.im97mori.ble.characteristic.u2a8a.FirstNameAndroid;
import org.im97mori.ble.characteristic.u2a8b.FiveZoneHeartRateLimits;
import org.im97mori.ble.characteristic.u2a8b.FiveZoneHeartRateLimitsAndroid;
import org.im97mori.ble.characteristic.u2a8c.Gender;
import org.im97mori.ble.characteristic.u2a8c.GenderAndroid;
import org.im97mori.ble.characteristic.u2a8d.HeartRateMax;
import org.im97mori.ble.characteristic.u2a8d.HeartRateMaxAndroid;
import org.im97mori.ble.characteristic.u2a8e.Height;
import org.im97mori.ble.characteristic.u2a8e.HeightAndroid;
import org.im97mori.ble.characteristic.u2a8f.HipCircumference;
import org.im97mori.ble.characteristic.u2a8f.HipCircumferenceAndroid;
import org.im97mori.ble.characteristic.u2a90.LastName;
import org.im97mori.ble.characteristic.u2a90.LastNameAndroid;
import org.im97mori.ble.characteristic.u2a91.MaximumRecommendedHeartRate;
import org.im97mori.ble.characteristic.u2a91.MaximumRecommendedHeartRateAndroid;
import org.im97mori.ble.characteristic.u2a92.RestingHeartRate;
import org.im97mori.ble.characteristic.u2a92.RestingHeartRateAndroid;
import org.im97mori.ble.characteristic.u2a93.SportTypeForAerobicAndAnaerobicThresholds;
import org.im97mori.ble.characteristic.u2a93.SportTypeForAerobicAndAnaerobicThresholdsAndroid;
import org.im97mori.ble.characteristic.u2a94.ThreeZoneHeartRateLimits;
import org.im97mori.ble.characteristic.u2a94.ThreeZoneHeartRateLimitsAndroid;
import org.im97mori.ble.characteristic.u2a95.TwoZoneHeartRateLimit;
import org.im97mori.ble.characteristic.u2a95.TwoZoneHeartRateLimitAndroid;
import org.im97mori.ble.characteristic.u2a96.VO2Max;
import org.im97mori.ble.characteristic.u2a96.VO2MaxAndroid;
import org.im97mori.ble.characteristic.u2a97.WaistCircumference;
import org.im97mori.ble.characteristic.u2a97.WaistCircumferenceAndroid;
import org.im97mori.ble.characteristic.u2a98.Weight;
import org.im97mori.ble.characteristic.u2a98.WeightAndroid;
import org.im97mori.ble.characteristic.u2a99.DatabaseChangeIncrement;
import org.im97mori.ble.characteristic.u2a99.DatabaseChangeIncrementAndroid;
import org.im97mori.ble.characteristic.u2a9a.UserIndexAndroid;
import org.im97mori.ble.characteristic.u2a9f.UserControlPoint;
import org.im97mori.ble.characteristic.u2a9f.UserControlPointAndroid;
import org.im97mori.ble.characteristic.u2aa2.Language;
import org.im97mori.ble.characteristic.u2aa2.LanguageAndroid;
import org.im97mori.ble.characteristic.u2b37.RegisteredUser;
import org.im97mori.ble.characteristic.u2b37.RegisteredUserAndroid;
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfigurationAndroid;
import org.junit.Test;

import java.util.Collections;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.AEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.AEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.AEROBIC_THRESHOLD_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.AGE_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.ANAEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.ANAEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.ANAEROBIC_THRESHOLD_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.DATABASE_CHANGE_INCREMENT_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.DATE_OF_BIRTH_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.DATE_OF_THRESHOLD_ASSESSMENT_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.EMAIL_ADDRESS_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.FAT_BURN_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.FAT_BURN_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.FIRST_NAME_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.FIVE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.GENDER_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.HEART_RATE_MAX_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.HEIGHT_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.HIP_CIRCUMFERENCE_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.LANGUAGE_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.LAST_NAME_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.MAXIMUM_RECOMMENDED_HEART_RATE_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.REGISTERED_USER_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.RESTING_HEART_RATE_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.SPORT_TYPE_FOR_AEROBIC_AND_ANAEROBIC_THRESHOLDS_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.THREE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.TWO_ZONE_HEART_RATE_LIMIT_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.USER_CONTROL_POINT_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.USER_INDEX_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.VO2_MAX_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.WAIST_CIRCUMFERENCE_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.WEIGHT_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.DescriptorUUID.CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
import static org.im97mori.ble.BLEConstants.ServiceUUID.GENERIC_ACCESS_SERVICE;
import static org.im97mori.ble.BLEConstants.ServiceUUID.USER_DATA_SERVICE;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

@SuppressWarnings("UnnecessaryLocalVariable")
public class UserDataServiceTest {

    @Test
    public void test_onBLEDisconnected_00001() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(FIRST_NAME_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        userDataService.onBLEDisconnected(1, MockBLEConnection.MOCK_DEVICE, 0, null);

        assertFalse(userDataService.isFirstNameCharacteristicSupporeted());
    }

    @Test
    public void test_onBLEDisconnected_00101() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(LAST_NAME_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        userDataService.onBLEDisconnected(1, MockBLEConnection.MOCK_DEVICE, 0, null);

        assertFalse(userDataService.isLastNameCharacteristicSupporeted());
    }

    @Test
    public void test_onBLEDisconnected_00201() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(EMAIL_ADDRESS_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        userDataService.onBLEDisconnected(1, MockBLEConnection.MOCK_DEVICE, 0, null);

        assertFalse(userDataService.isEmailAddressCharacteristicSupporeted());
    }

    @Test
    public void test_onBLEDisconnected_00301() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(AGE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        userDataService.onBLEDisconnected(1, MockBLEConnection.MOCK_DEVICE, 0, null);

        assertFalse(userDataService.isAgeCharacteristicSupporeted());
    }

    @Test
    public void test_onBLEDisconnected_00401() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(DATE_OF_BIRTH_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        userDataService.onBLEDisconnected(1, MockBLEConnection.MOCK_DEVICE, 0, null);

        assertFalse(userDataService.isDateOfBirthCharacteristicSupporeted());
    }

    @Test
    public void test_onBLEDisconnected_00501() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(GENDER_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        userDataService.onBLEDisconnected(1, MockBLEConnection.MOCK_DEVICE, 0, null);

        assertFalse(userDataService.isGenderCharacteristicSupporeted());
    }

    @Test
    public void test_onBLEDisconnected_00601() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(WEIGHT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        userDataService.onBLEDisconnected(1, MockBLEConnection.MOCK_DEVICE, 0, null);

        assertFalse(userDataService.isWeightCharacteristicSupporeted());
    }

    @Test
    public void test_onBLEDisconnected_00701() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(HEIGHT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        userDataService.onBLEDisconnected(1, MockBLEConnection.MOCK_DEVICE, 0, null);

        assertFalse(userDataService.isHeightCharacteristicSupporeted());
    }

    @Test
    public void test_onBLEDisconnected_00801() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(VO2_MAX_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        userDataService.onBLEDisconnected(1, MockBLEConnection.MOCK_DEVICE, 0, null);

        assertFalse(userDataService.isVO2MaxCharacteristicSupporeted());
    }

    @Test
    public void test_onBLEDisconnected_00901() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(HEART_RATE_MAX_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        userDataService.onBLEDisconnected(1, MockBLEConnection.MOCK_DEVICE, 0, null);

        assertFalse(userDataService.isHeartRateMaxCharacteristicSupporeted());
    }

    @Test
    public void test_onBLEDisconnected_01001() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(RESTING_HEART_RATE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        userDataService.onBLEDisconnected(1, MockBLEConnection.MOCK_DEVICE, 0, null);

        assertFalse(userDataService.isRestingHeartRateCharacteristicSupporeted());
    }

    @Test
    public void test_onBLEDisconnected_01101() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(MAXIMUM_RECOMMENDED_HEART_RATE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        userDataService.onBLEDisconnected(1, MockBLEConnection.MOCK_DEVICE, 0, null);

        assertFalse(userDataService.isMaximumRecommendedHeartRateCharacteristicSupporeted());
    }

    @Test
    public void test_onBLEDisconnected_01201() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(AEROBIC_THRESHOLD_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        userDataService.onBLEDisconnected(1, MockBLEConnection.MOCK_DEVICE, 0, null);

        assertFalse(userDataService.isAerobicThresholdCharacteristicSupporeted());
    }

    @Test
    public void test_onBLEDisconnected_01301() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(ANAEROBIC_THRESHOLD_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        userDataService.onBLEDisconnected(1, MockBLEConnection.MOCK_DEVICE, 0, null);

        assertFalse(userDataService.isAnaerobicThresholdCharacteristicSupporeted());
    }

    @Test
    public void test_onBLEDisconnected_01401() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(SPORT_TYPE_FOR_AEROBIC_AND_ANAEROBIC_THRESHOLDS_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        userDataService.onBLEDisconnected(1, MockBLEConnection.MOCK_DEVICE, 0, null);

        assertFalse(userDataService.isSportTypeForAerobicAndAnaerobicThresholdsCharacteristicSupporeted());
    }

    @Test
    public void test_onBLEDisconnected_01501() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(DATE_OF_THRESHOLD_ASSESSMENT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        userDataService.onBLEDisconnected(1, MockBLEConnection.MOCK_DEVICE, 0, null);

        assertFalse(userDataService.isDateOfThresholdAssessmentCharacteristicSupporeted());
    }

    @Test
    public void test_onBLEDisconnected_01601() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(WAIST_CIRCUMFERENCE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        userDataService.onBLEDisconnected(1, MockBLEConnection.MOCK_DEVICE, 0, null);

        assertFalse(userDataService.isWaistCircumferenceCharacteristicSupporeted());
    }

    @Test
    public void test_onBLEDisconnected_01701() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(HIP_CIRCUMFERENCE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        userDataService.onBLEDisconnected(1, MockBLEConnection.MOCK_DEVICE, 0, null);

        assertFalse(userDataService.isHipCircumferenceCharacteristicSupporeted());
    }

    @Test
    public void test_onBLEDisconnected_01801() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(FAT_BURN_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        userDataService.onBLEDisconnected(1, MockBLEConnection.MOCK_DEVICE, 0, null);

        assertFalse(userDataService.isFatBurnHeartRateLowerLimitCharacteristicSupporeted());
    }

    @Test
    public void test_onBLEDisconnected_01901() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(FAT_BURN_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        userDataService.onBLEDisconnected(1, MockBLEConnection.MOCK_DEVICE, 0, null);

        assertFalse(userDataService.isFatBurnHeartRateUpperLimitCharacteristicSupporeted());
    }

    @Test
    public void test_onBLEDisconnected_02001() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(AEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        userDataService.onBLEDisconnected(1, MockBLEConnection.MOCK_DEVICE, 0, null);

        assertFalse(userDataService.isAerobicHeartRateLowerLimitCharacteristicSupporeted());
    }

    @Test
    public void test_onBLEDisconnected_02101() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(AEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        userDataService.onBLEDisconnected(1, MockBLEConnection.MOCK_DEVICE, 0, null);

        assertFalse(userDataService.isAerobicHeartRateUpperLimitCharacteristicSupporeted());
    }

    @Test
    public void test_onBLEDisconnected_02201() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(ANAEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        userDataService.onBLEDisconnected(1, MockBLEConnection.MOCK_DEVICE, 0, null);

        assertFalse(userDataService.isAnaerobicHeartRateLowerLimitCharacteristicSupporeted());
    }

    @Test
    public void test_onBLEDisconnected_02301() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(ANAEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        userDataService.onBLEDisconnected(1, MockBLEConnection.MOCK_DEVICE, 0, null);

        assertFalse(userDataService.isAnaerobicHeartRateUpperLimitCharacteristicSupporeted());
    }

    @Test
    public void test_onBLEDisconnected_02401() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(FIVE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        userDataService.onBLEDisconnected(1, MockBLEConnection.MOCK_DEVICE, 0, null);

        assertFalse(userDataService.isFiveZoneHeartRateLimitsCharacteristicSupporeted());
    }

    @Test
    public void test_onBLEDisconnected_02501() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(THREE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        userDataService.onBLEDisconnected(1, MockBLEConnection.MOCK_DEVICE, 0, null);

        assertFalse(userDataService.isThreeZoneHeartRateLimitsCharacteristicSupporeted());
    }

    @Test
    public void test_onBLEDisconnected_02601() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(TWO_ZONE_HEART_RATE_LIMIT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        userDataService.onBLEDisconnected(1, MockBLEConnection.MOCK_DEVICE, 0, null);

        assertFalse(userDataService.isTwoZoneHeartRateLimitCharacteristicSupporeted());
    }

    @Test
    public void test_onBLEDisconnected_02701() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(LANGUAGE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        userDataService.onBLEDisconnected(1, MockBLEConnection.MOCK_DEVICE, 0, null);

        assertFalse(userDataService.isLanguageCharacteristicSupporeted());
    }

    @Test
    public void test_onBLEDisconnected_02801() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(DATABASE_CHANGE_INCREMENT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        userDataService.onBLEDisconnected(1, MockBLEConnection.MOCK_DEVICE, 0, null);

        assertFalse(userDataService.isDatabaseChangeIncrementCharacteristicNotifySupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00001() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.<BluetoothGattService>emptyList(), null);

        assertFalse(userDataService.isFirstNameCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00002() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isFirstNameCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00003() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isFirstNameCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00004() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(FIRST_NAME_CHARACTERISTIC, 0, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isFirstNameCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00005() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(FIRST_NAME_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isFirstNameCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00006() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(FIRST_NAME_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isFirstNameCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00007() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(FIRST_NAME_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertTrue(userDataService.isFirstNameCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00101() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.<BluetoothGattService>emptyList(), null);

        assertFalse(userDataService.isLastNameCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00102() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isLastNameCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00103() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isLastNameCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00104() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(LAST_NAME_CHARACTERISTIC, 0, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isLastNameCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00105() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(LAST_NAME_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isLastNameCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00106() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(LAST_NAME_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isLastNameCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00107() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(LAST_NAME_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertTrue(userDataService.isLastNameCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00201() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.<BluetoothGattService>emptyList(), null);

        assertFalse(userDataService.isEmailAddressCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00202() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isEmailAddressCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00203() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isEmailAddressCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00204() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(EMAIL_ADDRESS_CHARACTERISTIC, 0, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isEmailAddressCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00205() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(EMAIL_ADDRESS_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isEmailAddressCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00206() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(EMAIL_ADDRESS_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isEmailAddressCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00207() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(EMAIL_ADDRESS_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertTrue(userDataService.isEmailAddressCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00301() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.<BluetoothGattService>emptyList(), null);

        assertFalse(userDataService.isAgeCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00302() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isAgeCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00303() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isAgeCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00304() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(AGE_CHARACTERISTIC, 0, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isAgeCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00305() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(AGE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isAgeCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00306() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(AGE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isAgeCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00307() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(AGE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertTrue(userDataService.isAgeCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00401() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.<BluetoothGattService>emptyList(), null);

        assertFalse(userDataService.isDateOfBirthCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00402() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isDateOfBirthCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00403() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isDateOfBirthCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00404() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(DATE_OF_BIRTH_CHARACTERISTIC, 0, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isDateOfBirthCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00405() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(DATE_OF_BIRTH_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isDateOfBirthCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00406() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(DATE_OF_BIRTH_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isDateOfBirthCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00407() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(DATE_OF_BIRTH_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertTrue(userDataService.isDateOfBirthCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00501() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.<BluetoothGattService>emptyList(), null);

        assertFalse(userDataService.isGenderCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00502() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isGenderCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00503() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isGenderCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00504() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(GENDER_CHARACTERISTIC, 0, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isGenderCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00505() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(GENDER_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isGenderCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00506() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(GENDER_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isGenderCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00507() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(GENDER_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertTrue(userDataService.isGenderCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00601() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.<BluetoothGattService>emptyList(), null);

        assertFalse(userDataService.isWeightCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00602() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isWeightCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00603() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isWeightCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00604() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(WEIGHT_CHARACTERISTIC, 0, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isWeightCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00605() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(WEIGHT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isWeightCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00606() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(WEIGHT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isWeightCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00607() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(WEIGHT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertTrue(userDataService.isWeightCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00701() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.<BluetoothGattService>emptyList(), null);

        assertFalse(userDataService.isHeightCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00702() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isHeightCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00703() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isHeightCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00704() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(HEIGHT_CHARACTERISTIC, 0, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isHeightCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00705() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(HEIGHT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isHeightCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00706() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(HEIGHT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isHeightCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00707() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(HEIGHT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertTrue(userDataService.isHeightCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00801() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.<BluetoothGattService>emptyList(), null);

        assertFalse(userDataService.isVO2MaxCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00802() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isVO2MaxCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00803() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isVO2MaxCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00804() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(VO2_MAX_CHARACTERISTIC, 0, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isVO2MaxCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00805() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(VO2_MAX_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isVO2MaxCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00806() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(VO2_MAX_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isVO2MaxCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00807() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(VO2_MAX_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertTrue(userDataService.isVO2MaxCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00901() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.<BluetoothGattService>emptyList(), null);

        assertFalse(userDataService.isHeartRateMaxCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00902() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isHeartRateMaxCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00903() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isHeartRateMaxCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00904() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(HEART_RATE_MAX_CHARACTERISTIC, 0, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isHeartRateMaxCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00905() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(HEART_RATE_MAX_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isHeartRateMaxCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00906() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(HEART_RATE_MAX_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isHeartRateMaxCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00907() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(HEART_RATE_MAX_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertTrue(userDataService.isHeartRateMaxCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01001() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.<BluetoothGattService>emptyList(), null);

        assertFalse(userDataService.isRestingHeartRateCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01002() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isRestingHeartRateCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01003() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isRestingHeartRateCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01004() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(RESTING_HEART_RATE_CHARACTERISTIC, 0, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isRestingHeartRateCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01005() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(RESTING_HEART_RATE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isRestingHeartRateCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01006() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(RESTING_HEART_RATE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isRestingHeartRateCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01007() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(RESTING_HEART_RATE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertTrue(userDataService.isRestingHeartRateCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01101() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.<BluetoothGattService>emptyList(), null);

        assertFalse(userDataService.isMaximumRecommendedHeartRateCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01102() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isMaximumRecommendedHeartRateCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01103() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isMaximumRecommendedHeartRateCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01104() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(MAXIMUM_RECOMMENDED_HEART_RATE_CHARACTERISTIC, 0, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isMaximumRecommendedHeartRateCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01105() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(MAXIMUM_RECOMMENDED_HEART_RATE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isMaximumRecommendedHeartRateCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01106() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(MAXIMUM_RECOMMENDED_HEART_RATE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isMaximumRecommendedHeartRateCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01107() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(MAXIMUM_RECOMMENDED_HEART_RATE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertTrue(userDataService.isMaximumRecommendedHeartRateCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01201() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.<BluetoothGattService>emptyList(), null);

        assertFalse(userDataService.isAerobicThresholdCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01202() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isAerobicThresholdCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01203() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isAerobicThresholdCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01204() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(AEROBIC_THRESHOLD_CHARACTERISTIC, 0, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isAerobicThresholdCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01205() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(AEROBIC_THRESHOLD_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isAerobicThresholdCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01206() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(AEROBIC_THRESHOLD_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isAerobicThresholdCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01207() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(AEROBIC_THRESHOLD_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertTrue(userDataService.isAerobicThresholdCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01301() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.<BluetoothGattService>emptyList(), null);

        assertFalse(userDataService.isAnaerobicThresholdCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01302() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isAnaerobicThresholdCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01303() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isAnaerobicThresholdCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01304() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(ANAEROBIC_THRESHOLD_CHARACTERISTIC, 0, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isAnaerobicThresholdCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01305() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(ANAEROBIC_THRESHOLD_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isAnaerobicThresholdCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01306() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(ANAEROBIC_THRESHOLD_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isAnaerobicThresholdCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01307() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(ANAEROBIC_THRESHOLD_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertTrue(userDataService.isAnaerobicThresholdCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01401() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.<BluetoothGattService>emptyList(), null);

        assertFalse(userDataService.isSportTypeForAerobicAndAnaerobicThresholdsCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01402() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isSportTypeForAerobicAndAnaerobicThresholdsCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01403() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isSportTypeForAerobicAndAnaerobicThresholdsCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01404() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(SPORT_TYPE_FOR_AEROBIC_AND_ANAEROBIC_THRESHOLDS_CHARACTERISTIC, 0, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isSportTypeForAerobicAndAnaerobicThresholdsCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01405() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(SPORT_TYPE_FOR_AEROBIC_AND_ANAEROBIC_THRESHOLDS_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isSportTypeForAerobicAndAnaerobicThresholdsCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01406() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(SPORT_TYPE_FOR_AEROBIC_AND_ANAEROBIC_THRESHOLDS_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isSportTypeForAerobicAndAnaerobicThresholdsCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01407() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(SPORT_TYPE_FOR_AEROBIC_AND_ANAEROBIC_THRESHOLDS_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertTrue(userDataService.isSportTypeForAerobicAndAnaerobicThresholdsCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01501() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.<BluetoothGattService>emptyList(), null);

        assertFalse(userDataService.isDateOfThresholdAssessmentCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01502() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isDateOfThresholdAssessmentCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01503() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isDateOfThresholdAssessmentCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01504() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(DATE_OF_THRESHOLD_ASSESSMENT_CHARACTERISTIC, 0, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isDateOfThresholdAssessmentCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01505() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(DATE_OF_THRESHOLD_ASSESSMENT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isDateOfThresholdAssessmentCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01506() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(DATE_OF_THRESHOLD_ASSESSMENT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isDateOfThresholdAssessmentCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01507() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(DATE_OF_THRESHOLD_ASSESSMENT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertTrue(userDataService.isDateOfThresholdAssessmentCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01601() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.<BluetoothGattService>emptyList(), null);

        assertFalse(userDataService.isWaistCircumferenceCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01602() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isWaistCircumferenceCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01603() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isWaistCircumferenceCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01604() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(WAIST_CIRCUMFERENCE_CHARACTERISTIC, 0, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isWaistCircumferenceCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01605() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(WAIST_CIRCUMFERENCE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isWaistCircumferenceCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01606() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(WAIST_CIRCUMFERENCE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isWaistCircumferenceCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01607() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(WAIST_CIRCUMFERENCE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertTrue(userDataService.isWaistCircumferenceCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01701() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.<BluetoothGattService>emptyList(), null);

        assertFalse(userDataService.isHipCircumferenceCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01702() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isHipCircumferenceCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01703() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isHipCircumferenceCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01704() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(HIP_CIRCUMFERENCE_CHARACTERISTIC, 0, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isHipCircumferenceCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01705() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(HIP_CIRCUMFERENCE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isHipCircumferenceCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01706() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(HIP_CIRCUMFERENCE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isHipCircumferenceCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01707() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(HIP_CIRCUMFERENCE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertTrue(userDataService.isHipCircumferenceCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01801() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.<BluetoothGattService>emptyList(), null);

        assertFalse(userDataService.isFatBurnHeartRateLowerLimitCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01802() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isFatBurnHeartRateLowerLimitCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01803() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isFatBurnHeartRateLowerLimitCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01804() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(FAT_BURN_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC, 0, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isFatBurnHeartRateLowerLimitCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01805() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(FAT_BURN_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isFatBurnHeartRateLowerLimitCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01806() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(FAT_BURN_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isFatBurnHeartRateLowerLimitCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01807() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(FAT_BURN_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertTrue(userDataService.isFatBurnHeartRateLowerLimitCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01901() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.<BluetoothGattService>emptyList(), null);

        assertFalse(userDataService.isFatBurnHeartRateUpperLimitCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01902() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isFatBurnHeartRateUpperLimitCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01903() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isFatBurnHeartRateUpperLimitCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01904() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(FAT_BURN_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC, 0, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isFatBurnHeartRateUpperLimitCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01905() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(FAT_BURN_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isFatBurnHeartRateUpperLimitCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01906() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(FAT_BURN_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isFatBurnHeartRateUpperLimitCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01907() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(FAT_BURN_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertTrue(userDataService.isFatBurnHeartRateUpperLimitCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_02001() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.<BluetoothGattService>emptyList(), null);

        assertFalse(userDataService.isAerobicHeartRateLowerLimitCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_02002() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isAerobicHeartRateLowerLimitCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_02003() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isAerobicHeartRateLowerLimitCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_02004() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(AEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC, 0, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isAerobicHeartRateLowerLimitCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_02005() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(AEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isAerobicHeartRateLowerLimitCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_02006() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(AEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isAerobicHeartRateLowerLimitCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_02007() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(AEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertTrue(userDataService.isAerobicHeartRateLowerLimitCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_02101() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.<BluetoothGattService>emptyList(), null);

        assertFalse(userDataService.isAerobicHeartRateUpperLimitCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_02102() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isAerobicHeartRateUpperLimitCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_02103() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isAerobicHeartRateUpperLimitCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_02104() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(AEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC, 0, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isAerobicHeartRateUpperLimitCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_02105() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(AEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isAerobicHeartRateUpperLimitCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_02106() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(AEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isAerobicHeartRateUpperLimitCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_02107() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(AEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertTrue(userDataService.isAerobicHeartRateUpperLimitCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_02201() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.<BluetoothGattService>emptyList(), null);

        assertFalse(userDataService.isAnaerobicHeartRateLowerLimitCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_02202() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isAnaerobicHeartRateLowerLimitCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_02203() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isAnaerobicHeartRateLowerLimitCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_02204() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(ANAEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC, 0, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isAnaerobicHeartRateLowerLimitCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_02205() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(ANAEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isAnaerobicHeartRateLowerLimitCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_02206() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(ANAEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isAnaerobicHeartRateLowerLimitCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_02207() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(ANAEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertTrue(userDataService.isAnaerobicHeartRateLowerLimitCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_02301() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.<BluetoothGattService>emptyList(), null);

        assertFalse(userDataService.isAnaerobicHeartRateUpperLimitCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_02302() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isAnaerobicHeartRateUpperLimitCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_02303() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isAnaerobicHeartRateUpperLimitCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_02304() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(ANAEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC, 0, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isAnaerobicHeartRateUpperLimitCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_02305() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(ANAEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isAnaerobicHeartRateUpperLimitCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_02306() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(ANAEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isAnaerobicHeartRateUpperLimitCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_02307() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(ANAEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertTrue(userDataService.isAnaerobicHeartRateUpperLimitCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_02401() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.<BluetoothGattService>emptyList(), null);

        assertFalse(userDataService.isFiveZoneHeartRateLimitsCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_02402() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isFiveZoneHeartRateLimitsCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_02403() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isFiveZoneHeartRateLimitsCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_02404() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(FIVE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC, 0, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isFiveZoneHeartRateLimitsCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_02405() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(FIVE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isFiveZoneHeartRateLimitsCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_02406() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(FIVE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isFiveZoneHeartRateLimitsCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_02407() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(FIVE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertTrue(userDataService.isFiveZoneHeartRateLimitsCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_02501() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.<BluetoothGattService>emptyList(), null);

        assertFalse(userDataService.isThreeZoneHeartRateLimitsCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_02502() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isThreeZoneHeartRateLimitsCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_02503() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isThreeZoneHeartRateLimitsCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_02504() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(THREE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC, 0, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isThreeZoneHeartRateLimitsCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_02505() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(THREE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isThreeZoneHeartRateLimitsCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_02506() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(THREE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isThreeZoneHeartRateLimitsCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_02507() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(THREE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertTrue(userDataService.isThreeZoneHeartRateLimitsCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_02601() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.<BluetoothGattService>emptyList(), null);

        assertFalse(userDataService.isTwoZoneHeartRateLimitCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_02602() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isTwoZoneHeartRateLimitCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_02603() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isTwoZoneHeartRateLimitCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_02604() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(TWO_ZONE_HEART_RATE_LIMIT_CHARACTERISTIC, 0, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isTwoZoneHeartRateLimitCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_02605() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(TWO_ZONE_HEART_RATE_LIMIT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isTwoZoneHeartRateLimitCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_02606() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(TWO_ZONE_HEART_RATE_LIMIT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isTwoZoneHeartRateLimitCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_02607() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(TWO_ZONE_HEART_RATE_LIMIT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertTrue(userDataService.isTwoZoneHeartRateLimitCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_02701() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.<BluetoothGattService>emptyList(), null);

        assertFalse(userDataService.isLanguageCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_02702() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isLanguageCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_02703() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isLanguageCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_02704() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(LANGUAGE_CHARACTERISTIC, 0, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isLanguageCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_02705() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(LANGUAGE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isLanguageCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_02706() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(LANGUAGE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isLanguageCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_02707() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(LANGUAGE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertTrue(userDataService.isLanguageCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_02801() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.<BluetoothGattService>emptyList(), null);

        assertFalse(userDataService.isDatabaseChangeIncrementCharacteristicNotifySupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_02802() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isDatabaseChangeIncrementCharacteristicNotifySupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_02803() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isDatabaseChangeIncrementCharacteristicNotifySupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_02804() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(DATABASE_CHANGE_INCREMENT_CHARACTERISTIC, 0, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isDatabaseChangeIncrementCharacteristicNotifySupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_02805() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(DATABASE_CHANGE_INCREMENT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isDatabaseChangeIncrementCharacteristicNotifySupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_02806() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(DATABASE_CHANGE_INCREMENT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertTrue(userDataService.isDatabaseChangeIncrementCharacteristicNotifySupporeted());
    }

    @Test
    public void test_onCharacteristicReadSuccess_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = FIRST_NAME_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{RegisteredUser.SEGMENTATION_HEADER_FIRST_SEGMENT_TRUE | RegisteredUser.SEGMENTATION_HEADER_LAST_SEGMENT_TRUE
                , RegisteredUser.FLAGS_REGISTERED_USER_NAME_PRESENT_TRUE | RegisteredUser.FLAGS_USER_NAME_TRUNCATED_FALSE
                , 0
                , 5};
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onFirstNameReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull FirstNameAndroid firstNameAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, firstNameAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadSuccess_00101() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = LAST_NAME_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{RegisteredUser.SEGMENTATION_HEADER_FIRST_SEGMENT_TRUE | RegisteredUser.SEGMENTATION_HEADER_LAST_SEGMENT_TRUE
                , RegisteredUser.FLAGS_REGISTERED_USER_NAME_PRESENT_TRUE | RegisteredUser.FLAGS_USER_NAME_TRUNCATED_FALSE
                , 0
                , 5};
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onLastNameReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull LastNameAndroid lastNameAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, lastNameAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadSuccess_00201() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = EMAIL_ADDRESS_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{RegisteredUser.SEGMENTATION_HEADER_FIRST_SEGMENT_TRUE | RegisteredUser.SEGMENTATION_HEADER_LAST_SEGMENT_TRUE
                , RegisteredUser.FLAGS_REGISTERED_USER_NAME_PRESENT_TRUE | RegisteredUser.FLAGS_USER_NAME_TRUNCATED_FALSE
                , 0
                , 5};
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onEmailAddressReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull EmailAddressAndroid emailAddressAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, emailAddressAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadSuccess_00301() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = AGE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onAgeReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull AgeAndroid ageAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, ageAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadSuccess_00401() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DATE_OF_BIRTH_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5, 6, 7};
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onDateOfBirthReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull DateOfBirthAndroid dateOfBirthAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, dateOfBirthAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadSuccess_00501() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = GENDER_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onGenderReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull GenderAndroid genderAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, genderAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadSuccess_00601() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = WEIGHT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5};
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onWeightReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull WeightAndroid weightAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, weightAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadSuccess_00701() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HEIGHT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5};
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onHeightReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull HeightAndroid heightAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, heightAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadSuccess_00801() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = VO2_MAX_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onVO2MaxReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull VO2MaxAndroid vo2MaxAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, vo2MaxAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadSuccess_00901() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HEART_RATE_MAX_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onHeartRateMaxReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull HeartRateMaxAndroid heartRateMaxAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, heartRateMaxAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadSuccess_01001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = RESTING_HEART_RATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onRestingHeartRateReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull RestingHeartRateAndroid restingHeartRateAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, restingHeartRateAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadSuccess_01101() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = MAXIMUM_RECOMMENDED_HEART_RATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onMaximumRecommendedHeartRateReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull MaximumRecommendedHeartRateAndroid maximumRecommendedHeartRateAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, maximumRecommendedHeartRateAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadSuccess_01201() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = AEROBIC_THRESHOLD_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onAerobicThresholdReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull AerobicThresholdAndroid aerobicThresholdAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, aerobicThresholdAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadSuccess_01301() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANAEROBIC_THRESHOLD_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onAnaerobicThresholdReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull AnaerobicThresholdAndroid anaerobicThresholdAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, anaerobicThresholdAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadSuccess_01401() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = SPORT_TYPE_FOR_AEROBIC_AND_ANAEROBIC_THRESHOLDS_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onSportTypeForAerobicAndAnaerobicThresholdsReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull SportTypeForAerobicAndAnaerobicThresholdsAndroid sportTypeForAerobicAndAnaerobicThresholdsAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, sportTypeForAerobicAndAnaerobicThresholdsAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadSuccess_01501() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DATE_OF_THRESHOLD_ASSESSMENT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5, 6, 7};
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onDateOfThresholdAssessmentReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull DateOfThresholdAssessmentAndroid dateOfThresholdAssessmentAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, dateOfThresholdAssessmentAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadSuccess_01601() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = WAIST_CIRCUMFERENCE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5};
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onWaistCircumferenceReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull WaistCircumferenceAndroid waistCircumferenceAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, waistCircumferenceAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadSuccess_01701() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HIP_CIRCUMFERENCE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5};
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onHipCircumferenceReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull HipCircumferenceAndroid hipCircumferenceAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, hipCircumferenceAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadSuccess_01801() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = FAT_BURN_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onFatBurnHeartRateLowerLimitReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull FatBurnHeartRateLowerLimitAndroid fatBurnHeartRateLowerLimitAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, fatBurnHeartRateLowerLimitAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadSuccess_01901() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = FAT_BURN_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onFatBurnHeartRateUpperLimitReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull FatBurnHeartRateUpperLimitAndroid fatBurnHeartRateUpperLimitAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, fatBurnHeartRateUpperLimitAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadSuccess_02001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = AEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onAerobicHeartRateLowerLimitReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull AerobicHeartRateLowerLimitAndroid aerobicHeartRateLowerLimitAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, aerobicHeartRateLowerLimitAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadSuccess_02101() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = AEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onAerobicHeartRateUpperLimitReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull AerobicHeartRateUpperLimitAndroid aerobicHeartRateUpperLimitAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, aerobicHeartRateUpperLimitAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadSuccess_02201() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANAEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onAnaerobicHeartRateLowerLimitReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull AnaerobicHeartRateLowerLimitAndroid anaerobicHeartRateLowerLimitAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, anaerobicHeartRateLowerLimitAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadSuccess_02301() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANAEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onAnaerobicHeartRateUpperLimitReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull AnaerobicHeartRateUpperLimitAndroid anaerobicHeartRateUpperLimitAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, anaerobicHeartRateUpperLimitAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadSuccess_02401() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = FIVE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5, 6, 7};
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onFiveZoneHeartRateLimitsReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull FiveZoneHeartRateLimitsAndroid fiveZoneHeartRateLimitsAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, fiveZoneHeartRateLimitsAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadSuccess_02501() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = THREE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5};
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onThreeZoneHeartRateLimitsReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull ThreeZoneHeartRateLimitsAndroid threeZoneHeartRateLimitsAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, threeZoneHeartRateLimitsAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadSuccess_02601() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TWO_ZONE_HEART_RATE_LIMIT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onTwoZoneHeartRateLimitReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull TwoZoneHeartRateLimitAndroid twoZoneHeartRateLimitAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, twoZoneHeartRateLimitAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadSuccess_02701() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = LANGUAGE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onLanguageReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull LanguageAndroid languageAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, languageAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadSuccess_02801() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DATABASE_CHANGE_INCREMENT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5, 6, 7};
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onDatabaseChangeIncrementReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull DatabaseChangeIncrementAndroid databaseChangeIncrementAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, databaseChangeIncrementAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadSuccess_02901() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = USER_INDEX_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onUserIndexReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull UserIndexAndroid userIndexAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, userIndexAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadFailed_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = FIRST_NAME_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onFirstNameReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadFailed_00101() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = LAST_NAME_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onLastNameReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadFailed_00201() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = EMAIL_ADDRESS_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onEmailAddressReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadFailed_00301() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = AGE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onAgeReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadFailed_00401() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DATE_OF_BIRTH_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onDateOfBirthReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadFailed_00501() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = GENDER_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onGenderReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadFailed_00601() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = WEIGHT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onWeightReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadFailed_00701() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HEIGHT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onHeightReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadFailed_00801() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = VO2_MAX_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onVO2MaxReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadFailed_00901() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HEART_RATE_MAX_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onHeartRateMaxReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadFailed_01001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = RESTING_HEART_RATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onRestingHeartRateReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadFailed_01101() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = MAXIMUM_RECOMMENDED_HEART_RATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onMaximumRecommendedHeartRateReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadFailed_01201() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = AEROBIC_THRESHOLD_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onAerobicThresholdReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadFailed_01301() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANAEROBIC_THRESHOLD_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onAnaerobicThresholdReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadFailed_01401() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = SPORT_TYPE_FOR_AEROBIC_AND_ANAEROBIC_THRESHOLDS_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onSportTypeForAerobicAndAnaerobicThresholdsReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadFailed_01501() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DATE_OF_THRESHOLD_ASSESSMENT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onDateOfThresholdAssessmentReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadFailed_01601() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = WAIST_CIRCUMFERENCE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onWaistCircumferenceReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadFailed_01701() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HIP_CIRCUMFERENCE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onHipCircumferenceReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadFailed_01801() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = FAT_BURN_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onFatBurnHeartRateLowerLimitReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadFailed_01901() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = FAT_BURN_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onFatBurnHeartRateUpperLimitReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadFailed_02001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = AEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onAerobicHeartRateLowerLimitReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadFailed_02101() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = AEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onAerobicHeartRateUpperLimitReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadFailed_02201() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANAEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onAnaerobicHeartRateLowerLimitReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadFailed_02301() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANAEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onAnaerobicHeartRateUpperLimitReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadFailed_02401() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = FIVE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onFiveZoneHeartRateLimitsReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadFailed_02501() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = THREE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onThreeZoneHeartRateLimitsReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadFailed_02601() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TWO_ZONE_HEART_RATE_LIMIT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onTwoZoneHeartRateLimitReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadFailed_02701() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = LANGUAGE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onLanguageReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadFailed_02801() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DATABASE_CHANGE_INCREMENT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onDatabaseChangeIncrementReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadFailed_02901() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = USER_INDEX_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onUserIndexReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadTimeout_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = FIRST_NAME_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onFirstNameReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadTimeout_00101() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = LAST_NAME_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onLastNameReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadTimeout_00201() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = EMAIL_ADDRESS_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onEmailAddressReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadTimeout_00301() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = AGE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onAgeReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadTimeout_00401() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DATE_OF_BIRTH_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onDateOfBirthReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadTimeout_00501() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = GENDER_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onGenderReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadTimeout_00601() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = WEIGHT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onWeightReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadTimeout_00701() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HEIGHT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onHeightReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadTimeout_00801() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = VO2_MAX_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onVO2MaxReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadTimeout_00901() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HEART_RATE_MAX_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onHeartRateMaxReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadTimeout_01001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = RESTING_HEART_RATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onRestingHeartRateReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadTimeout_01101() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = MAXIMUM_RECOMMENDED_HEART_RATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onMaximumRecommendedHeartRateReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadTimeout_01201() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = AEROBIC_THRESHOLD_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onAerobicThresholdReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadTimeout_01301() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANAEROBIC_THRESHOLD_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onAnaerobicThresholdReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadTimeout_01401() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = SPORT_TYPE_FOR_AEROBIC_AND_ANAEROBIC_THRESHOLDS_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onSportTypeForAerobicAndAnaerobicThresholdsReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadTimeout_01501() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DATE_OF_THRESHOLD_ASSESSMENT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onDateOfThresholdAssessmentReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadTimeout_01601() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = WAIST_CIRCUMFERENCE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onWaistCircumferenceReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadTimeout_01701() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HIP_CIRCUMFERENCE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onHipCircumferenceReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadTimeout_01801() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = FAT_BURN_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onFatBurnHeartRateLowerLimitReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadTimeout_01901() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = FAT_BURN_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onFatBurnHeartRateUpperLimitReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadTimeout_02001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = AEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onAerobicHeartRateLowerLimitReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadTimeout_02101() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = AEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onAerobicHeartRateUpperLimitReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadTimeout_02201() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANAEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onAnaerobicHeartRateLowerLimitReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadTimeout_02301() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANAEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onAnaerobicHeartRateUpperLimitReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadTimeout_02401() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = FIVE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onFiveZoneHeartRateLimitsReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadTimeout_02501() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = THREE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onThreeZoneHeartRateLimitsReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadTimeout_02601() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TWO_ZONE_HEART_RATE_LIMIT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onTwoZoneHeartRateLimitReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadTimeout_02701() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = LANGUAGE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onLanguageReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadTimeout_02801() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DATABASE_CHANGE_INCREMENT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onDatabaseChangeIncrementReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadTimeout_02901() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = USER_INDEX_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onUserIndexReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteSuccess_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = FIRST_NAME_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{RegisteredUser.SEGMENTATION_HEADER_FIRST_SEGMENT_TRUE | RegisteredUser.SEGMENTATION_HEADER_LAST_SEGMENT_TRUE
                , RegisteredUser.FLAGS_REGISTERED_USER_NAME_PRESENT_TRUE | RegisteredUser.FLAGS_USER_NAME_TRUNCATED_FALSE
                , 0
                , 5};
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onFirstNameWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull FirstNameAndroid firstNameAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, firstNameAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteSuccess_00101() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = LAST_NAME_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{RegisteredUser.SEGMENTATION_HEADER_FIRST_SEGMENT_TRUE | RegisteredUser.SEGMENTATION_HEADER_LAST_SEGMENT_TRUE
                , RegisteredUser.FLAGS_REGISTERED_USER_NAME_PRESENT_TRUE | RegisteredUser.FLAGS_USER_NAME_TRUNCATED_FALSE
                , 0
                , 5};
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onLastNameWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull LastNameAndroid lastNameAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, lastNameAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteSuccess_00201() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = EMAIL_ADDRESS_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{RegisteredUser.SEGMENTATION_HEADER_FIRST_SEGMENT_TRUE | RegisteredUser.SEGMENTATION_HEADER_LAST_SEGMENT_TRUE
                , RegisteredUser.FLAGS_REGISTERED_USER_NAME_PRESENT_TRUE | RegisteredUser.FLAGS_USER_NAME_TRUNCATED_FALSE
                , 0
                , 5};
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onEmailAddressWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull EmailAddressAndroid emailAddressAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, emailAddressAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteSuccess_00301() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = AGE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onAgeWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull AgeAndroid ageAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, ageAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteSuccess_00401() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DATE_OF_BIRTH_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5, 6, 7};
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onDateOfBirthWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull DateOfBirthAndroid dateOfBirthAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, dateOfBirthAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteSuccess_00501() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = GENDER_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onGenderWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull GenderAndroid genderAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, genderAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteSuccess_00601() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = WEIGHT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5};
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onWeightWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull WeightAndroid weightAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, weightAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteSuccess_00701() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HEIGHT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5};
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onHeightWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull HeightAndroid heightAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, heightAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteSuccess_00801() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = VO2_MAX_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onVO2MaxWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull VO2MaxAndroid vo2MaxAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, vo2MaxAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteSuccess_00901() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HEART_RATE_MAX_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onHeartRateMaxWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull HeartRateMaxAndroid heartRateMaxAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, heartRateMaxAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteSuccess_01001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = RESTING_HEART_RATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onRestingHeartRateWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull RestingHeartRateAndroid restingHeartRateAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, restingHeartRateAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteSuccess_01101() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = MAXIMUM_RECOMMENDED_HEART_RATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onMaximumRecommendedHeartRateWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull MaximumRecommendedHeartRateAndroid maximumRecommendedHeartRateAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, maximumRecommendedHeartRateAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteSuccess_01201() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = AEROBIC_THRESHOLD_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onAerobicThresholdWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull AerobicThresholdAndroid aerobicThresholdAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, aerobicThresholdAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteSuccess_01301() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANAEROBIC_THRESHOLD_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onAnaerobicThresholdWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull AnaerobicThresholdAndroid anaerobicThresholdAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, anaerobicThresholdAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteSuccess_01401() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = SPORT_TYPE_FOR_AEROBIC_AND_ANAEROBIC_THRESHOLDS_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onSportTypeForAerobicAndAnaerobicThresholdsWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull SportTypeForAerobicAndAnaerobicThresholdsAndroid sportTypeForAerobicAndAnaerobicThresholdsAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, sportTypeForAerobicAndAnaerobicThresholdsAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteSuccess_01501() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DATE_OF_THRESHOLD_ASSESSMENT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5, 6, 7};
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onDateOfThresholdAssessmentWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull DateOfThresholdAssessmentAndroid dateOfThresholdAssessmentAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, dateOfThresholdAssessmentAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteSuccess_01601() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = WAIST_CIRCUMFERENCE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5};
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onWaistCircumferenceWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull WaistCircumferenceAndroid waistCircumferenceAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, waistCircumferenceAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteSuccess_01701() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HIP_CIRCUMFERENCE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5};
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onHipCircumferenceWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull HipCircumferenceAndroid hipCircumferenceAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, hipCircumferenceAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteSuccess_01801() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = FAT_BURN_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onFatBurnHeartRateLowerLimitWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull FatBurnHeartRateLowerLimitAndroid fatBurnHeartRateLowerLimitAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, fatBurnHeartRateLowerLimitAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteSuccess_01901() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = FAT_BURN_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onFatBurnHeartRateUpperLimitWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull FatBurnHeartRateUpperLimitAndroid fatBurnHeartRateUpperLimitAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, fatBurnHeartRateUpperLimitAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteSuccess_02001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = AEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onAerobicHeartRateLowerLimitWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull AerobicHeartRateLowerLimitAndroid aerobicHeartRateLowerLimitAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, aerobicHeartRateLowerLimitAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteSuccess_02101() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = AEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onAerobicHeartRateUpperLimitWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull AerobicHeartRateUpperLimitAndroid aerobicHeartRateUpperLimitAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, aerobicHeartRateUpperLimitAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteSuccess_02201() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANAEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onAnaerobicHeartRateLowerLimitWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull AnaerobicHeartRateLowerLimitAndroid anaerobicHeartRateLowerLimitAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, anaerobicHeartRateLowerLimitAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteSuccess_02301() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANAEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onAnaerobicHeartRateUpperLimitWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull AnaerobicHeartRateUpperLimitAndroid anaerobicHeartRateUpperLimitAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, anaerobicHeartRateUpperLimitAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteSuccess_02401() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = FIVE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5, 6, 7};
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onFiveZoneHeartRateLimitsWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull FiveZoneHeartRateLimitsAndroid fiveZoneHeartRateLimitsAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, fiveZoneHeartRateLimitsAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteSuccess_02501() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = THREE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5};
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onThreeZoneHeartRateLimitsWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull ThreeZoneHeartRateLimitsAndroid threeZoneHeartRateLimitsAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, threeZoneHeartRateLimitsAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteSuccess_02601() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TWO_ZONE_HEART_RATE_LIMIT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onTwoZoneHeartRateLimitWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull TwoZoneHeartRateLimitAndroid twoZoneHeartRateLimitAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, twoZoneHeartRateLimitAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteSuccess_02701() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = LANGUAGE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onLanguageWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull LanguageAndroid languageAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, languageAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteSuccess_02801() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DATABASE_CHANGE_INCREMENT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5, 6, 7};
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onDatabaseChangeIncrementWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull DatabaseChangeIncrementAndroid databaseChangeIncrementAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, databaseChangeIncrementAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteSuccess_02901() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = USER_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{UserControlPointAndroid.OP_CODE_REGISTER_NEW_USER
                , 4
                , 5};
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onUserControlPointWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull UserControlPointAndroid userControlPointAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, userControlPointAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteFailed_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = FIRST_NAME_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onFirstNameWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteFailed_00101() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = LAST_NAME_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onLastNameWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteFailed_00201() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = EMAIL_ADDRESS_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onEmailAddressWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteFailed_00301() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = AGE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onAgeWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteFailed_00401() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DATE_OF_BIRTH_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onDateOfBirthWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteFailed_00501() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = GENDER_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onGenderWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteFailed_00601() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = WEIGHT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onWeightWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteFailed_00701() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HEIGHT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onHeightWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteFailed_00801() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = VO2_MAX_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onVO2MaxWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteFailed_00901() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HEART_RATE_MAX_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onHeartRateMaxWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteFailed_01001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = RESTING_HEART_RATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onRestingHeartRateWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteFailed_01101() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = MAXIMUM_RECOMMENDED_HEART_RATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onMaximumRecommendedHeartRateWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteFailed_01201() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = AEROBIC_THRESHOLD_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onAerobicThresholdWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteFailed_01301() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANAEROBIC_THRESHOLD_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onAnaerobicThresholdWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteFailed_01401() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = SPORT_TYPE_FOR_AEROBIC_AND_ANAEROBIC_THRESHOLDS_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onSportTypeForAerobicAndAnaerobicThresholdsWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteFailed_01501() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DATE_OF_THRESHOLD_ASSESSMENT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onDateOfThresholdAssessmentWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteFailed_01601() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = WAIST_CIRCUMFERENCE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onWaistCircumferenceWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteFailed_01701() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HIP_CIRCUMFERENCE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onHipCircumferenceWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteFailed_01801() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = FAT_BURN_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onFatBurnHeartRateLowerLimitWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteFailed_01901() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = FAT_BURN_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onFatBurnHeartRateUpperLimitWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteFailed_02001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = AEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onAerobicHeartRateLowerLimitWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteFailed_02101() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = AEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onAerobicHeartRateUpperLimitWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteFailed_02201() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANAEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onAnaerobicHeartRateLowerLimitWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteFailed_02301() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANAEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onAnaerobicHeartRateUpperLimitWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteFailed_02401() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = FIVE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onFiveZoneHeartRateLimitsWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteFailed_02501() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = THREE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onThreeZoneHeartRateLimitsWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteFailed_02601() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TWO_ZONE_HEART_RATE_LIMIT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onTwoZoneHeartRateLimitWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteFailed_02701() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = LANGUAGE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onLanguageWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteFailed_02801() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DATABASE_CHANGE_INCREMENT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onDatabaseChangeIncrementWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteFailed_02901() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = USER_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onUserControlPointWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteTimeout_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = FIRST_NAME_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onFirstNameWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteTimeout_00101() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = LAST_NAME_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onLastNameWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteTimeout_00201() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = EMAIL_ADDRESS_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onEmailAddressWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteTimeout_00301() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = AGE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onAgeWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteTimeout_00401() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DATE_OF_BIRTH_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onDateOfBirthWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteTimeout_00501() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = GENDER_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onGenderWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteTimeout_00601() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = WEIGHT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onWeightWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteTimeout_00701() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HEIGHT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onHeightWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteTimeout_00801() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = VO2_MAX_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onVO2MaxWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteTimeout_00901() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HEART_RATE_MAX_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onHeartRateMaxWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteTimeout_01001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = RESTING_HEART_RATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onRestingHeartRateWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteTimeout_01101() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = MAXIMUM_RECOMMENDED_HEART_RATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onMaximumRecommendedHeartRateWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteTimeout_01201() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = AEROBIC_THRESHOLD_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onAerobicThresholdWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteTimeout_01301() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANAEROBIC_THRESHOLD_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onAnaerobicThresholdWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteTimeout_01401() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = SPORT_TYPE_FOR_AEROBIC_AND_ANAEROBIC_THRESHOLDS_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onSportTypeForAerobicAndAnaerobicThresholdsWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteTimeout_01501() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DATE_OF_THRESHOLD_ASSESSMENT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onDateOfThresholdAssessmentWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteTimeout_01601() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = WAIST_CIRCUMFERENCE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onWaistCircumferenceWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteTimeout_01701() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HIP_CIRCUMFERENCE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onHipCircumferenceWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteTimeout_01801() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = FAT_BURN_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onFatBurnHeartRateLowerLimitWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteTimeout_01901() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = FAT_BURN_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onFatBurnHeartRateUpperLimitWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteTimeout_02001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = AEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onAerobicHeartRateLowerLimitWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteTimeout_02101() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = AEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onAerobicHeartRateUpperLimitWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteTimeout_02201() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANAEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onAnaerobicHeartRateLowerLimitWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteTimeout_02301() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANAEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onAnaerobicHeartRateUpperLimitWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteTimeout_02401() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = FIVE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onFiveZoneHeartRateLimitsWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteTimeout_02501() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = THREE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onThreeZoneHeartRateLimitsWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteTimeout_02601() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TWO_ZONE_HEART_RATE_LIMIT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onTwoZoneHeartRateLimitWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteTimeout_02701() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = LANGUAGE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onLanguageWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteTimeout_02801() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DATABASE_CHANGE_INCREMENT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onDatabaseChangeIncrementWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteTimeout_02901() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = USER_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onUserControlPointWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DATABASE_CHANGE_INCREMENT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final byte[] originalValues = new byte[]{4, 5};
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onDatabaseChangeIncrementClientCharacteristicConfigurationReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull ClientCharacteristicConfigurationAndroid clientCharacteristicConfigurationAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, clientCharacteristicConfigurationAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00101() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = REGISTERED_USER_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final byte[] originalValues = new byte[]{4, 5};
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onRegisteredUserClientCharacteristicConfigurationReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull ClientCharacteristicConfigurationAndroid clientCharacteristicConfigurationAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, clientCharacteristicConfigurationAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00201() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = USER_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final byte[] originalValues = new byte[]{4, 5};
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onUserControlPointClientCharacteristicConfigurationReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull ClientCharacteristicConfigurationAndroid clientCharacteristicConfigurationAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, clientCharacteristicConfigurationAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadFailed_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DATABASE_CHANGE_INCREMENT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onDatabaseChangeIncrementClientCharacteristicConfigurationReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadFailed_00101() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = REGISTERED_USER_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onRegisteredUserClientCharacteristicConfigurationReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadFailed_00201() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = USER_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onUserControlPointClientCharacteristicConfigurationReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadTimeout_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DATABASE_CHANGE_INCREMENT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onDatabaseChangeIncrementClientCharacteristicConfigurationReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onDescriptorReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadTimeout_00101() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = REGISTERED_USER_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onRegisteredUserClientCharacteristicConfigurationReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onDescriptorReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadTimeout_00201() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = USER_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onUserControlPointClientCharacteristicConfigurationReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onDescriptorReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteSuccess_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DATABASE_CHANGE_INCREMENT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final byte[] originalValues = new byte[]{4, 5};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onDatabaseChangeIncrementNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteSuccess_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DATABASE_CHANGE_INCREMENT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final byte[] originalValues = new byte[]{4, 5};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onDatabaseChangeIncrementNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteSuccess_00101() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = REGISTERED_USER_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final byte[] originalValues = new byte[]{4, 5};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onRegisteredUserIndicateStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteSuccess_00102() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = REGISTERED_USER_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final byte[] originalValues = new byte[]{4, 5};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onRegisteredUserIndicateStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteSuccess_00201() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = USER_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final byte[] originalValues = new byte[]{4, 5};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onUserControlPointIndicateStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteSuccess_00202() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = USER_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final byte[] originalValues = new byte[]{4, 5};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onUserControlPointIndicateStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteFailed_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DATABASE_CHANGE_INCREMENT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onDatabaseChangeIncrementNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteFailed_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DATABASE_CHANGE_INCREMENT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onDatabaseChangeIncrementNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteFailed_00101() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = REGISTERED_USER_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onRegisteredUserIndicateStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteFailed_00102() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = REGISTERED_USER_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onRegisteredUserIndicateStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteFailed_00201() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = USER_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onUserControlPointIndicateStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteFailed_00202() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = USER_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onUserControlPointIndicateStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteTimeout_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DATABASE_CHANGE_INCREMENT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onDatabaseChangeIncrementNotifyStartTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteTimeout_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DATABASE_CHANGE_INCREMENT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onDatabaseChangeIncrementNotifyStopTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteTimeout_00101() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = REGISTERED_USER_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onRegisteredUserIndicateStartTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteTimeout_00102() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = REGISTERED_USER_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onRegisteredUserIndicateStopTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteTimeout_00201() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = USER_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onUserControlPointIndicateStartTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteTimeout_00202() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = USER_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onUserControlPointIndicateStopTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicNotified_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DATABASE_CHANGE_INCREMENT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5, 6, 7};

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onDatabaseChangeIncrementNotified(@NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull DatabaseChangeIncrementAndroid databaseChangeIncrementAndroid) {
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, databaseChangeIncrementAndroid.getBytes());
                isCalled.set(true);
            }

        };

        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicNotified(originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicNotified_00101() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = REGISTERED_USER_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5, 6, 7};

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onRegisteredUserIndicated(@NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull RegisteredUserAndroid registeredUserAndroid) {
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, registeredUserAndroid.getBytes());
                isCalled.set(true);
            }

        };

        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicNotified(originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicNotified_00201() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = USER_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{UserControlPointAndroid.OP_CODE_RESPONSE_CODE
                , UserControlPointAndroid.OP_CODE_REGISTER_NEW_USER
                , UserControlPointAndroid.RESPONSE_VALUE_SUCCESS
                , 4};

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockUserDataServiceCallback mockUserDataServiceCallback = new MockUserDataServiceCallback() {

            @Override
            public void onUserControlPointIndicated(@NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull UserControlPointAndroid userControlPointAndroid) {
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, userControlPointAndroid.getBytes());
                isCalled.set(true);
            }

        };

        UserDataService userDataService = new UserDataService(mockBLEConnection, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicNotified(originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_isFirstNameCharacteristicSupporeted_00001() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);

        assertFalse(userDataService.isFirstNameCharacteristicSupporeted());
    }

    @Test
    public void test_isFirstNameCharacteristicSupporeted_00002() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(FIRST_NAME_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertTrue(userDataService.isFirstNameCharacteristicSupporeted());
    }

    @Test
    public void test_isFirstNameCharacteristicSupporeted_00003() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(LAST_NAME_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        userDataService.onBLEDisconnected(1, MockBLEConnection.MOCK_DEVICE, 0, null);

        assertFalse(userDataService.isFirstNameCharacteristicSupporeted());
    }

    @Test
    public void test_isLastNameCharacteristicSupporeted_00001() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);

        assertFalse(userDataService.isLastNameCharacteristicSupporeted());
    }

    @Test
    public void test_isLastNameCharacteristicSupporeted_00002() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(LAST_NAME_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertTrue(userDataService.isLastNameCharacteristicSupporeted());
    }

    @Test
    public void test_isLastNameCharacteristicSupporeted_00003() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(LAST_NAME_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        userDataService.onBLEDisconnected(1, MockBLEConnection.MOCK_DEVICE, 0, null);

        assertFalse(userDataService.isLastNameCharacteristicSupporeted());
    }

    @Test
    public void test_isEmailAddressCharacteristicSupporeted_00001() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);

        assertFalse(userDataService.isEmailAddressCharacteristicSupporeted());
    }

    @Test
    public void test_isEmailAddressCharacteristicSupporeted_00002() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(EMAIL_ADDRESS_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertTrue(userDataService.isEmailAddressCharacteristicSupporeted());
    }

    @Test
    public void test_isEmailAddressCharacteristicSupporeted_00003() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(EMAIL_ADDRESS_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        userDataService.onBLEDisconnected(1, MockBLEConnection.MOCK_DEVICE, 0, null);

        assertFalse(userDataService.isEmailAddressCharacteristicSupporeted());
    }

    @Test
    public void test_isAgeCharacteristicSupporeted_00001() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);

        assertFalse(userDataService.isAgeCharacteristicSupporeted());
    }

    @Test
    public void test_isAgeCharacteristicSupporeted_00002() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(AGE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertTrue(userDataService.isAgeCharacteristicSupporeted());
    }

    @Test
    public void test_isAgeCharacteristicSupporeted_00003() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(AGE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        userDataService.onBLEDisconnected(1, MockBLEConnection.MOCK_DEVICE, 0, null);

        assertFalse(userDataService.isAgeCharacteristicSupporeted());
    }

    @Test
    public void test_isDateOfBirthCharacteristicSupporeted_00001() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);

        assertFalse(userDataService.isDateOfBirthCharacteristicSupporeted());
    }

    @Test
    public void test_isDateOfBirthCharacteristicSupporeted_00002() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(DATE_OF_BIRTH_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertTrue(userDataService.isDateOfBirthCharacteristicSupporeted());
    }

    @Test
    public void test_isDateOfBirthCharacteristicSupporeted_00003() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(DATE_OF_BIRTH_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        userDataService.onBLEDisconnected(1, MockBLEConnection.MOCK_DEVICE, 0, null);

        assertFalse(userDataService.isDateOfBirthCharacteristicSupporeted());
    }

    @Test
    public void test_isGenderCharacteristicSupporeted_00001() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);

        assertFalse(userDataService.isGenderCharacteristicSupporeted());
    }

    @Test
    public void test_isGenderCharacteristicSupporeted_00002() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(GENDER_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertTrue(userDataService.isGenderCharacteristicSupporeted());
    }

    @Test
    public void test_isGenderCharacteristicSupporeted_00003() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(GENDER_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        userDataService.onBLEDisconnected(1, MockBLEConnection.MOCK_DEVICE, 0, null);

        assertFalse(userDataService.isGenderCharacteristicSupporeted());
    }

    @Test
    public void test_isWeightCharacteristicSupporeted_00001() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);

        assertFalse(userDataService.isWeightCharacteristicSupporeted());
    }

    @Test
    public void test_isWeightCharacteristicSupporeted_00002() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(WEIGHT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertTrue(userDataService.isWeightCharacteristicSupporeted());
    }

    @Test
    public void test_isWeightCharacteristicSupporeted_00003() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(WEIGHT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        userDataService.onBLEDisconnected(1, MockBLEConnection.MOCK_DEVICE, 0, null);

        assertFalse(userDataService.isWeightCharacteristicSupporeted());
    }

    @Test
    public void test_isHeightCharacteristicSupporeted_00001() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);

        assertFalse(userDataService.isHeightCharacteristicSupporeted());
    }

    @Test
    public void test_isHeightCharacteristicSupporeted_00002() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(HEIGHT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertTrue(userDataService.isHeightCharacteristicSupporeted());
    }

    @Test
    public void test_isHeightCharacteristicSupporeted_00003() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(HEIGHT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        userDataService.onBLEDisconnected(1, MockBLEConnection.MOCK_DEVICE, 0, null);

        assertFalse(userDataService.isHeightCharacteristicSupporeted());
    }

    @Test
    public void test_isVO2MaxCharacteristicSupporeted_00001() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);

        assertFalse(userDataService.isVO2MaxCharacteristicSupporeted());
    }

    @Test
    public void test_isVO2MaxCharacteristicSupporeted_00002() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(VO2_MAX_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertTrue(userDataService.isVO2MaxCharacteristicSupporeted());
    }

    @Test
    public void test_isVO2MaxCharacteristicSupporeted_00003() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(VO2_MAX_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        userDataService.onBLEDisconnected(1, MockBLEConnection.MOCK_DEVICE, 0, null);

        assertFalse(userDataService.isVO2MaxCharacteristicSupporeted());
    }

    @Test
    public void test_isHeartRateMaxCharacteristicSupporeted_00001() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);

        assertFalse(userDataService.isHeartRateMaxCharacteristicSupporeted());
    }

    @Test
    public void test_isHeartRateMaxCharacteristicSupporeted_00002() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(HEART_RATE_MAX_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertTrue(userDataService.isHeartRateMaxCharacteristicSupporeted());
    }

    @Test
    public void test_isHeartRateMaxCharacteristicSupporeted_00003() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(HEART_RATE_MAX_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        userDataService.onBLEDisconnected(1, MockBLEConnection.MOCK_DEVICE, 0, null);

        assertFalse(userDataService.isHeartRateMaxCharacteristicSupporeted());
    }

    @Test
    public void test_isRestingHeartRateCharacteristicSupporeted_00001() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);

        assertFalse(userDataService.isRestingHeartRateCharacteristicSupporeted());
    }

    @Test
    public void test_isRestingHeartRateCharacteristicSupporeted_00002() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(RESTING_HEART_RATE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertTrue(userDataService.isRestingHeartRateCharacteristicSupporeted());
    }

    @Test
    public void test_isRestingHeartRateCharacteristicSupporeted_00003() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(RESTING_HEART_RATE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        userDataService.onBLEDisconnected(1, MockBLEConnection.MOCK_DEVICE, 0, null);

        assertFalse(userDataService.isRestingHeartRateCharacteristicSupporeted());
    }

    @Test
    public void test_isMaximumRecommendedHeartRateCharacteristicSupporeted_00001() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);

        assertFalse(userDataService.isMaximumRecommendedHeartRateCharacteristicSupporeted());
    }

    @Test
    public void test_isMaximumRecommendedHeartRateCharacteristicSupporeted_00002() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(MAXIMUM_RECOMMENDED_HEART_RATE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertTrue(userDataService.isMaximumRecommendedHeartRateCharacteristicSupporeted());
    }

    @Test
    public void test_isMaximumRecommendedHeartRateCharacteristicSupporeted_00003() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(MAXIMUM_RECOMMENDED_HEART_RATE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        userDataService.onBLEDisconnected(1, MockBLEConnection.MOCK_DEVICE, 0, null);

        assertFalse(userDataService.isMaximumRecommendedHeartRateCharacteristicSupporeted());
    }

    @Test
    public void test_isAerobicThresholdCharacteristicSupporeted_00001() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);

        assertFalse(userDataService.isAerobicThresholdCharacteristicSupporeted());
    }

    @Test
    public void test_isAerobicThresholdCharacteristicSupporeted_00002() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(AEROBIC_THRESHOLD_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertTrue(userDataService.isAerobicThresholdCharacteristicSupporeted());
    }

    @Test
    public void test_isAerobicThresholdCharacteristicSupporeted_00003() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(AEROBIC_THRESHOLD_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        userDataService.onBLEDisconnected(1, MockBLEConnection.MOCK_DEVICE, 0, null);

        assertFalse(userDataService.isAerobicThresholdCharacteristicSupporeted());
    }

    @Test
    public void test_isAnaerobicThresholdCharacteristicSupporeted_00001() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);

        assertFalse(userDataService.isAnaerobicThresholdCharacteristicSupporeted());
    }

    @Test
    public void test_isAnaerobicThresholdCharacteristicSupporeted_00002() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(ANAEROBIC_THRESHOLD_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertTrue(userDataService.isAnaerobicThresholdCharacteristicSupporeted());
    }

    @Test
    public void test_isAnaerobicThresholdCharacteristicSupporeted_00003() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(ANAEROBIC_THRESHOLD_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        userDataService.onBLEDisconnected(1, MockBLEConnection.MOCK_DEVICE, 0, null);

        assertFalse(userDataService.isAnaerobicThresholdCharacteristicSupporeted());
    }

    @Test
    public void test_isSportTypeForAerobicAndAnaerobicThresholdsCharacteristicSupporeted_00001() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);

        assertFalse(userDataService.isSportTypeForAerobicAndAnaerobicThresholdsCharacteristicSupporeted());
    }

    @Test
    public void test_isSportTypeForAerobicAndAnaerobicThresholdsCharacteristicSupporeted_00002() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(SPORT_TYPE_FOR_AEROBIC_AND_ANAEROBIC_THRESHOLDS_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertTrue(userDataService.isSportTypeForAerobicAndAnaerobicThresholdsCharacteristicSupporeted());
    }

    @Test
    public void test_isSportTypeForAerobicAndAnaerobicThresholdsCharacteristicSupporeted_00003() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(SPORT_TYPE_FOR_AEROBIC_AND_ANAEROBIC_THRESHOLDS_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        userDataService.onBLEDisconnected(1, MockBLEConnection.MOCK_DEVICE, 0, null);

        assertFalse(userDataService.isSportTypeForAerobicAndAnaerobicThresholdsCharacteristicSupporeted());
    }

    @Test
    public void test_isDateOfThresholdAssessmentCharacteristicSupporeted_00001() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);

        assertFalse(userDataService.isDateOfThresholdAssessmentCharacteristicSupporeted());
    }

    @Test
    public void test_isDateOfThresholdAssessmentCharacteristicSupporeted_00002() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(DATE_OF_THRESHOLD_ASSESSMENT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertTrue(userDataService.isDateOfThresholdAssessmentCharacteristicSupporeted());
    }

    @Test
    public void test_isDateOfThresholdAssessmentCharacteristicSupporeted_00003() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(DATE_OF_THRESHOLD_ASSESSMENT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        userDataService.onBLEDisconnected(1, MockBLEConnection.MOCK_DEVICE, 0, null);

        assertFalse(userDataService.isDateOfThresholdAssessmentCharacteristicSupporeted());
    }

    @Test
    public void test_isWaistCircumferenceCharacteristicSupporeted_00001() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);

        assertFalse(userDataService.isWaistCircumferenceCharacteristicSupporeted());
    }

    @Test
    public void test_isWaistCircumferenceCharacteristicSupporeted_00002() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(WAIST_CIRCUMFERENCE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertTrue(userDataService.isWaistCircumferenceCharacteristicSupporeted());
    }

    @Test
    public void test_isWaistCircumferenceCharacteristicSupporeted_00003() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(WAIST_CIRCUMFERENCE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        userDataService.onBLEDisconnected(1, MockBLEConnection.MOCK_DEVICE, 0, null);

        assertFalse(userDataService.isWaistCircumferenceCharacteristicSupporeted());
    }

    @Test
    public void test_isHipCircumferenceCharacteristicSupporeted_00001() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);

        assertFalse(userDataService.isHipCircumferenceCharacteristicSupporeted());
    }

    @Test
    public void test_isHipCircumferenceCharacteristicSupporeted_00002() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(HIP_CIRCUMFERENCE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertTrue(userDataService.isHipCircumferenceCharacteristicSupporeted());
    }

    @Test
    public void test_isHipCircumferenceCharacteristicSupporeted_00003() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(HIP_CIRCUMFERENCE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        userDataService.onBLEDisconnected(1, MockBLEConnection.MOCK_DEVICE, 0, null);

        assertFalse(userDataService.isHipCircumferenceCharacteristicSupporeted());
    }

    @Test
    public void test_isFatBurnHeartRateLowerLimitCharacteristicSupporeted_00001() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);

        assertFalse(userDataService.isFatBurnHeartRateLowerLimitCharacteristicSupporeted());
    }

    @Test
    public void test_isFatBurnHeartRateLowerLimitCharacteristicSupporeted_00002() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(FAT_BURN_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertTrue(userDataService.isFatBurnHeartRateLowerLimitCharacteristicSupporeted());
    }

    @Test
    public void test_isFatBurnHeartRateLowerLimitCharacteristicSupporeted_00003() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(FAT_BURN_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        userDataService.onBLEDisconnected(1, MockBLEConnection.MOCK_DEVICE, 0, null);

        assertFalse(userDataService.isFatBurnHeartRateLowerLimitCharacteristicSupporeted());
    }

    @Test
    public void test_isFatBurnHeartRateUpperLimitCharacteristicSupporeted_00001() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);

        assertFalse(userDataService.isFatBurnHeartRateUpperLimitCharacteristicSupporeted());
    }

    @Test
    public void test_isFatBurnHeartRateUpperLimitCharacteristicSupporeted_00002() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(FAT_BURN_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertTrue(userDataService.isFatBurnHeartRateUpperLimitCharacteristicSupporeted());
    }

    @Test
    public void test_isFatBurnHeartRateUpperLimitCharacteristicSupporeted_00003() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(FAT_BURN_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        userDataService.onBLEDisconnected(1, MockBLEConnection.MOCK_DEVICE, 0, null);

        assertFalse(userDataService.isFatBurnHeartRateUpperLimitCharacteristicSupporeted());
    }

    @Test
    public void test_isAerobicHeartRateLowerLimitCharacteristicSupporeted_00001() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);

        assertFalse(userDataService.isAerobicHeartRateLowerLimitCharacteristicSupporeted());
    }

    @Test
    public void test_isAerobicHeartRateLowerLimitCharacteristicSupporeted_00002() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(AEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertTrue(userDataService.isAerobicHeartRateLowerLimitCharacteristicSupporeted());
    }

    @Test
    public void test_isAerobicHeartRateLowerLimitCharacteristicSupporeted_00003() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(AEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        userDataService.onBLEDisconnected(1, MockBLEConnection.MOCK_DEVICE, 0, null);

        assertFalse(userDataService.isAerobicHeartRateLowerLimitCharacteristicSupporeted());
    }

    @Test
    public void test_isAerobicHeartRateUpperLimitCharacteristicSupporeted_00001() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);

        assertFalse(userDataService.isAerobicHeartRateUpperLimitCharacteristicSupporeted());
    }

    @Test
    public void test_isAerobicHeartRateUpperLimitCharacteristicSupporeted_00002() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(AEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertTrue(userDataService.isAerobicHeartRateUpperLimitCharacteristicSupporeted());
    }

    @Test
    public void test_isAerobicHeartRateUpperLimitCharacteristicSupporeted_00003() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(AEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        userDataService.onBLEDisconnected(1, MockBLEConnection.MOCK_DEVICE, 0, null);

        assertFalse(userDataService.isAerobicHeartRateUpperLimitCharacteristicSupporeted());
    }

    @Test
    public void test_isAnaerobicHeartRateLowerLimitCharacteristicSupporeted_00001() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);

        assertFalse(userDataService.isAnaerobicHeartRateLowerLimitCharacteristicSupporeted());
    }

    @Test
    public void test_isAnaerobicHeartRateLowerLimitCharacteristicSupporeted_00002() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(ANAEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertTrue(userDataService.isAnaerobicHeartRateLowerLimitCharacteristicSupporeted());
    }

    @Test
    public void test_isAnaerobicHeartRateLowerLimitCharacteristicSupporeted_00003() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(ANAEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        userDataService.onBLEDisconnected(1, MockBLEConnection.MOCK_DEVICE, 0, null);

        assertFalse(userDataService.isAnaerobicHeartRateLowerLimitCharacteristicSupporeted());
    }

    @Test
    public void test_isAnaerobicHeartRateUpperLimitCharacteristicSupporeted_00001() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);

        assertFalse(userDataService.isAnaerobicHeartRateUpperLimitCharacteristicSupporeted());
    }

    @Test
    public void test_isAnaerobicHeartRateUpperLimitCharacteristicSupporeted_00002() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(ANAEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertTrue(userDataService.isAnaerobicHeartRateUpperLimitCharacteristicSupporeted());
    }

    @Test
    public void test_isAnaerobicHeartRateUpperLimitCharacteristicSupporeted_00003() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(ANAEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        userDataService.onBLEDisconnected(1, MockBLEConnection.MOCK_DEVICE, 0, null);

        assertFalse(userDataService.isAnaerobicHeartRateUpperLimitCharacteristicSupporeted());
    }

    @Test
    public void test_isFiveZoneHeartRateLimitsCharacteristicSupporeted_00001() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);

        assertFalse(userDataService.isFiveZoneHeartRateLimitsCharacteristicSupporeted());
    }

    @Test
    public void test_isFiveZoneHeartRateLimitsCharacteristicSupporeted_00002() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(FIVE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertTrue(userDataService.isFiveZoneHeartRateLimitsCharacteristicSupporeted());
    }

    @Test
    public void test_isFiveZoneHeartRateLimitsCharacteristicSupporeted_00003() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(FIVE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        userDataService.onBLEDisconnected(1, MockBLEConnection.MOCK_DEVICE, 0, null);

        assertFalse(userDataService.isFiveZoneHeartRateLimitsCharacteristicSupporeted());
    }

    @Test
    public void test_isThreeZoneHeartRateLimitsCharacteristicSupporeted_00001() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);

        assertFalse(userDataService.isThreeZoneHeartRateLimitsCharacteristicSupporeted());
    }

    @Test
    public void test_isThreeZoneHeartRateLimitsCharacteristicSupporeted_00002() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(THREE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertTrue(userDataService.isThreeZoneHeartRateLimitsCharacteristicSupporeted());
    }

    @Test
    public void test_isThreeZoneHeartRateLimitsCharacteristicSupporeted_00003() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(THREE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        userDataService.onBLEDisconnected(1, MockBLEConnection.MOCK_DEVICE, 0, null);

        assertFalse(userDataService.isThreeZoneHeartRateLimitsCharacteristicSupporeted());
    }

    @Test
    public void test_isTwoZoneHeartRateLimitCharacteristicSupporeted_00001() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);

        assertFalse(userDataService.isTwoZoneHeartRateLimitCharacteristicSupporeted());
    }

    @Test
    public void test_isTwoZoneHeartRateLimitCharacteristicSupporeted_00002() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(TWO_ZONE_HEART_RATE_LIMIT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertTrue(userDataService.isTwoZoneHeartRateLimitCharacteristicSupporeted());
    }

    @Test
    public void test_isTwoZoneHeartRateLimitCharacteristicSupporeted_00003() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(TWO_ZONE_HEART_RATE_LIMIT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        userDataService.onBLEDisconnected(1, MockBLEConnection.MOCK_DEVICE, 0, null);

        assertFalse(userDataService.isTwoZoneHeartRateLimitCharacteristicSupporeted());
    }

    @Test
    public void test_isLanguageCharacteristicSupporeted_00001() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);

        assertFalse(userDataService.isLanguageCharacteristicSupporeted());
    }

    @Test
    public void test_isLanguageCharacteristicSupporeted_00002() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(LANGUAGE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertTrue(userDataService.isLanguageCharacteristicSupporeted());
    }

    @Test
    public void test_isLanguageCharacteristicSupporeted_00003() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(LANGUAGE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        userDataService.onBLEDisconnected(1, MockBLEConnection.MOCK_DEVICE, 0, null);

        assertFalse(userDataService.isLanguageCharacteristicSupporeted());
    }

    @Test
    public void test_isDatabaseChangeIncrementCharacteristicNotifySupporeted_00001() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);

        assertFalse(userDataService.isDatabaseChangeIncrementCharacteristicNotifySupporeted());
    }

    @Test
    public void test_isDatabaseChangeIncrementCharacteristicNotifySupporeted_00002() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(DATABASE_CHANGE_INCREMENT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertTrue(userDataService.isDatabaseChangeIncrementCharacteristicNotifySupporeted());
    }

    @Test
    public void test_isDatabaseChangeIncrementCharacteristicNotifySupporeted_00003() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(DATABASE_CHANGE_INCREMENT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        userDataService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        userDataService.onBLEDisconnected(1, MockBLEConnection.MOCK_DEVICE, 0, null);

        assertFalse(userDataService.isDatabaseChangeIncrementCharacteristicNotifySupporeted());
    }

    @Test
    public void test_getFirstName_000001() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);

        assertNull(userDataService.getFirstName());
    }

    @Test
    public void test_getFirstName_000002() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.getFirstName());
    }

    @Test
    public void test_getFirstName_000003() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isFirstNameCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.getFirstName());
    }

    @Test
    public void test_getFirstName_000004() {
        final Integer originalTaskId = 1;
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {

            @Override
            public synchronized Integer createReadCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isFirstNameCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = userDataService.getFirstName();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_setFirstName_000001() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);
        FirstName firstName = new FirstName("a");

        assertNull(userDataService.setFirstName(firstName));
    }

    @Test
    public void test_setFirstName_000002() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        FirstName firstName = new FirstName("a");

        assertNull(userDataService.setFirstName(firstName));
    }

    @Test
    public void test_setFirstName_000003() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isFirstNameCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        FirstName firstName = new FirstName("a");

        assertNull(userDataService.setFirstName(firstName));
    }

    @Test
    public void test_setFirstName_000004() {
        final Integer originalTaskId = 1;
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {

            @Override
            public synchronized Integer createWriteCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull ByteArrayInterface byteArrayInterface, int writeType, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isFirstNameCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        FirstName firstName = new FirstName("a");

        Integer taskId = userDataService.setFirstName(firstName);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_getLastName_000001() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);

        assertNull(userDataService.getLastName());
    }

    @Test
    public void test_getLastName_000002() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.getLastName());
    }

    @Test
    public void test_getLastName_000003() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isLastNameCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.getLastName());
    }

    @Test
    public void test_getLastName_000004() {
        final Integer originalTaskId = 1;
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {

            @Override
            public synchronized Integer createReadCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isLastNameCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = userDataService.getLastName();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_setLastName_000001() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);
        LastName lastName = new LastName("a");

        assertNull(userDataService.setLastName(lastName));
    }

    @Test
    public void test_setLastName_000002() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        LastName lastName = new LastName("a");

        assertNull(userDataService.setLastName(lastName));
    }

    @Test
    public void test_setLastName_000003() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isLastNameCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        LastName lastName = new LastName("a");

        assertNull(userDataService.setLastName(lastName));
    }

    @Test
    public void test_setLastName_000004() {
        final Integer originalTaskId = 1;
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {

            @Override
            public synchronized Integer createWriteCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull ByteArrayInterface byteArrayInterface, int writeType, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isLastNameCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        LastName lastName = new LastName("a");

        Integer taskId = userDataService.setLastName(lastName);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_getEmailAddress_000001() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);

        assertNull(userDataService.getEmailAddress());
    }

    @Test
    public void test_getEmailAddress_000002() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.getEmailAddress());
    }

    @Test
    public void test_getEmailAddress_000003() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isLastNameCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.getEmailAddress());
    }

    @Test
    public void test_getEmailAddress_000004() {
        final Integer originalTaskId = 1;
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {

            @Override
            public synchronized Integer createReadCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isEmailAddressCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = userDataService.getEmailAddress();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_setEmailAddress_000001() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);
        EmailAddress emailAddress = new EmailAddress("a");

        assertNull(userDataService.setEmailAddress(emailAddress));
    }

    @Test
    public void test_setEmailAddress_000002() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        EmailAddress emailAddress = new EmailAddress("a");

        assertNull(userDataService.setEmailAddress(emailAddress));
    }

    @Test
    public void test_setEmailAddress_000003() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isEmailAddressCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        EmailAddress emailAddress = new EmailAddress("a");

        assertNull(userDataService.setEmailAddress(emailAddress));
    }

    @Test
    public void test_setEmailAddress_000004() {
        final Integer originalTaskId = 1;
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {

            @Override
            public synchronized Integer createWriteCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull ByteArrayInterface byteArrayInterface, int writeType, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isEmailAddressCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        EmailAddress emailAddress = new EmailAddress("a");

        Integer taskId = userDataService.setEmailAddress(emailAddress);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_getAge_000001() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);

        assertNull(userDataService.getAge());
    }

    @Test
    public void test_getAge_000002() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.getAge());
    }

    @Test
    public void test_getAge_000003() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isLastNameCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.getAge());
    }

    @Test
    public void test_getAge_000004() {
        final Integer originalTaskId = 1;
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {

            @Override
            public synchronized Integer createReadCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isAgeCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = userDataService.getAge();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_setAge_000001() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);
        Age age = new Age(1);

        assertNull(userDataService.setAge(age));
    }

    @Test
    public void test_setAge_000002() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        Age age = new Age(1);

        assertNull(userDataService.setAge(age));
    }

    @Test
    public void test_setAge_000003() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isAgeCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        Age age = new Age(1);

        assertNull(userDataService.setAge(age));
    }

    @Test
    public void test_setAge_000004() {
        final Integer originalTaskId = 1;
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {

            @Override
            public synchronized Integer createWriteCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull ByteArrayInterface byteArrayInterface, int writeType, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isAgeCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        Age age = new Age(1);

        Integer taskId = userDataService.setAge(age);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_getDateOfBirth_000001() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);

        assertNull(userDataService.getDateOfBirth());
    }

    @Test
    public void test_getDateOfBirth_000002() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.getDateOfBirth());
    }

    @Test
    public void test_getDateOfBirth_000003() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isDateOfBirthCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.getDateOfBirth());
    }

    @Test
    public void test_getDateOfBirth_000004() {
        final Integer originalTaskId = 1;
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {

            @Override
            public synchronized Integer createReadCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isDateOfBirthCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = userDataService.getDateOfBirth();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_setDateOfBirth_000001() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);
        DateOfBirth dateOfBirth = new DateOfBirth(1, 2, 3);

        assertNull(userDataService.setDateOfBirth(dateOfBirth));
    }

    @Test
    public void test_setDateOfBirth_000002() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        DateOfBirth dateOfBirth = new DateOfBirth(1, 2, 3);

        assertNull(userDataService.setDateOfBirth(dateOfBirth));
    }

    @Test
    public void test_setDateOfBirth_000003() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isDateOfBirthCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        DateOfBirth dateOfBirth = new DateOfBirth(1, 2, 3);

        assertNull(userDataService.setDateOfBirth(dateOfBirth));
    }

    @Test
    public void test_setDateOfBirth_000004() {
        final Integer originalTaskId = 1;
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {

            @Override
            public synchronized Integer createWriteCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull ByteArrayInterface byteArrayInterface, int writeType, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isDateOfBirthCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        DateOfBirth dateOfBirth = new DateOfBirth(1, 2, 3);

        Integer taskId = userDataService.setDateOfBirth(dateOfBirth);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_getGender_000001() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);

        assertNull(userDataService.getGender());
    }

    @Test
    public void test_getGender_000002() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.getGender());
    }

    @Test
    public void test_getGender_000003() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isGenderCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.getGender());
    }

    @Test
    public void test_getGender_000004() {
        final Integer originalTaskId = 1;
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {

            @Override
            public synchronized Integer createReadCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isGenderCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = userDataService.getGender();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_setGender_000001() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);
        Gender gender = new Gender(Gender.GENDER_MALE);

        assertNull(userDataService.setGender(gender));
    }

    @Test
    public void test_setGender_000002() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        Gender gender = new Gender(Gender.GENDER_MALE);

        assertNull(userDataService.setGender(gender));
    }

    @Test
    public void test_setGender_000003() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isGenderCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        Gender gender = new Gender(Gender.GENDER_MALE);

        assertNull(userDataService.setGender(gender));
    }

    @Test
    public void test_setGender_000004() {
        final Integer originalTaskId = 1;
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {

            @Override
            public synchronized Integer createWriteCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull ByteArrayInterface byteArrayInterface, int writeType, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isGenderCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        Gender gender = new Gender(Gender.GENDER_MALE);

        Integer taskId = userDataService.setGender(gender);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_getWeight_000001() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);

        assertNull(userDataService.getWeight());
    }

    @Test
    public void test_getWeight_000002() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.getWeight());
    }

    @Test
    public void test_getWeight_000003() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isWeightCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.getWeight());
    }

    @Test
    public void test_getWeight_000004() {
        final Integer originalTaskId = 1;
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {

            @Override
            public synchronized Integer createReadCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isWeightCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = userDataService.getWeight();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_setWeight_000001() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);
        Weight weight = new Weight(0);

        assertNull(userDataService.setWeight(weight));
    }

    @Test
    public void test_setWeight_000002() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        Weight weight = new Weight(0);

        assertNull(userDataService.setWeight(weight));
    }

    @Test
    public void test_setWeight_000003() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isWeightCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        Weight weight = new Weight(0);

        assertNull(userDataService.setWeight(weight));
    }

    @Test
    public void test_setWeight_000004() {
        final Integer originalTaskId = 1;
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {

            @Override
            public synchronized Integer createWriteCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull ByteArrayInterface byteArrayInterface, int writeType, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isWeightCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        Weight weight = new Weight(0);

        Integer taskId = userDataService.setWeight(weight);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_getHeight_000001() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);

        assertNull(userDataService.getHeight());
    }

    @Test
    public void test_getHeight_000002() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.getHeight());
    }

    @Test
    public void test_getHeight_000003() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isHeightCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.getHeight());
    }

    @Test
    public void test_getHeight_000004() {
        final Integer originalTaskId = 1;
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {

            @Override
            public synchronized Integer createReadCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isHeightCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = userDataService.getHeight();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_setHeight_000001() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);
        Height height = new Height(0);

        assertNull(userDataService.setHeight(height));
    }

    @Test
    public void test_setHeight_000002() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        Height height = new Height(0);

        assertNull(userDataService.setHeight(height));
    }

    @Test
    public void test_setHeight_000003() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isHeightCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        Height height = new Height(0);

        assertNull(userDataService.setHeight(height));
    }

    @Test
    public void test_setHeight_000004() {
        final Integer originalTaskId = 1;
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {

            @Override
            public synchronized Integer createWriteCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull ByteArrayInterface byteArrayInterface, int writeType, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isHeightCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        Height height = new Height(0);

        Integer taskId = userDataService.setHeight(height);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_getVO2Max_000001() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);

        assertNull(userDataService.getVO2Max());
    }

    @Test
    public void test_getVO2Max_000002() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.getVO2Max());
    }

    @Test
    public void test_getVO2Max_000003() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isVO2MaxCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.getVO2Max());
    }

    @Test
    public void test_getVO2Max_000004() {
        final Integer originalTaskId = 1;
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {

            @Override
            public synchronized Integer createReadCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isVO2MaxCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = userDataService.getVO2Max();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_setVO2Max_000001() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);
        VO2Max vo2Max = new VO2Max(0);

        assertNull(userDataService.setVO2Max(vo2Max));
    }

    @Test
    public void test_setVO2Max_000002() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        VO2Max vo2Max = new VO2Max(0);

        assertNull(userDataService.setVO2Max(vo2Max));
    }

    @Test
    public void test_setVO2Max_000003() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isVO2MaxCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        VO2Max vo2Max = new VO2Max(0);

        assertNull(userDataService.setVO2Max(vo2Max));
    }

    @Test
    public void test_setVO2Max_000004() {
        final Integer originalTaskId = 1;
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {

            @Override
            public synchronized Integer createWriteCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull ByteArrayInterface byteArrayInterface, int writeType, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isVO2MaxCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        VO2Max vo2Max = new VO2Max(0);

        Integer taskId = userDataService.setVO2Max(vo2Max);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_getHeartRateMax_000001() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);

        assertNull(userDataService.getHeartRateMax());
    }

    @Test
    public void test_getHeartRateMax_000002() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.getHeartRateMax());
    }

    @Test
    public void test_getHeartRateMax_000003() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isHeartRateMaxCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.getHeartRateMax());
    }

    @Test
    public void test_getHeartRateMax_000004() {
        final Integer originalTaskId = 1;
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {

            @Override
            public synchronized Integer createReadCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isHeartRateMaxCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = userDataService.getHeartRateMax();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_setHeartRateMax_000001() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);
        HeartRateMax heartRateMax = new HeartRateMax(0);

        assertNull(userDataService.setHeartRateMax(heartRateMax));
    }

    @Test
    public void test_setHeartRateMax_000002() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        HeartRateMax heartRateMax = new HeartRateMax(0);

        assertNull(userDataService.setHeartRateMax(heartRateMax));
    }

    @Test
    public void test_setHeartRateMax_000003() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isHeartRateMaxCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        HeartRateMax heartRateMax = new HeartRateMax(0);

        assertNull(userDataService.setHeartRateMax(heartRateMax));
    }

    @Test
    public void test_setHeartRateMax_000004() {
        final Integer originalTaskId = 1;
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {

            @Override
            public synchronized Integer createWriteCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull ByteArrayInterface byteArrayInterface, int writeType, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isHeartRateMaxCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        HeartRateMax heartRateMax = new HeartRateMax(0);

        Integer taskId = userDataService.setHeartRateMax(heartRateMax);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_getRestingHeartRate_000001() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);

        assertNull(userDataService.getRestingHeartRate());
    }

    @Test
    public void test_getRestingHeartRate_000002() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.getRestingHeartRate());
    }

    @Test
    public void test_getRestingHeartRate_000003() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isRestingHeartRateCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.getRestingHeartRate());
    }

    @Test
    public void test_getRestingHeartRate_000004() {
        final Integer originalTaskId = 1;
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {

            @Override
            public synchronized Integer createReadCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isRestingHeartRateCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = userDataService.getRestingHeartRate();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_setRestingHeartRate_000001() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);
        RestingHeartRate restingHeartRate = new RestingHeartRate(0);

        assertNull(userDataService.setRestingHeartRate(restingHeartRate));
    }

    @Test
    public void test_setRestingHeartRate_000002() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        RestingHeartRate restingHeartRate = new RestingHeartRate(0);

        assertNull(userDataService.setRestingHeartRate(restingHeartRate));
    }

    @Test
    public void test_setRestingHeartRate_000003() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isRestingHeartRateCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        RestingHeartRate restingHeartRate = new RestingHeartRate(0);

        assertNull(userDataService.setRestingHeartRate(restingHeartRate));
    }

    @Test
    public void test_setRestingHeartRate_000004() {
        final Integer originalTaskId = 1;
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {

            @Override
            public synchronized Integer createWriteCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull ByteArrayInterface byteArrayInterface, int writeType, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isRestingHeartRateCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        RestingHeartRate restingHeartRate = new RestingHeartRate(0);

        Integer taskId = userDataService.setRestingHeartRate(restingHeartRate);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_getMaximumRecommendedHeartRate_000001() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);

        assertNull(userDataService.getMaximumRecommendedHeartRate());
    }

    @Test
    public void test_getMaximumRecommendedHeartRate_000002() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.getMaximumRecommendedHeartRate());
    }

    @Test
    public void test_getMaximumRecommendedHeartRate_000003() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isMaximumRecommendedHeartRateCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.getMaximumRecommendedHeartRate());
    }

    @Test
    public void test_getMaximumRecommendedHeartRate_000004() {
        final Integer originalTaskId = 1;
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {

            @Override
            public synchronized Integer createReadCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isMaximumRecommendedHeartRateCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = userDataService.getMaximumRecommendedHeartRate();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_setMaximumRecommendedHeartRate_000001() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);
        MaximumRecommendedHeartRate maximumRecommendedHeartRate = new MaximumRecommendedHeartRate(0);

        assertNull(userDataService.setMaximumRecommendedHeartRate(maximumRecommendedHeartRate));
    }

    @Test
    public void test_setMaximumRecommendedHeartRate_000002() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        MaximumRecommendedHeartRate maximumRecommendedHeartRate = new MaximumRecommendedHeartRate(0);

        assertNull(userDataService.setMaximumRecommendedHeartRate(maximumRecommendedHeartRate));
    }

    @Test
    public void test_setMaximumRecommendedHeartRate_000003() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isMaximumRecommendedHeartRateCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        MaximumRecommendedHeartRate maximumRecommendedHeartRate = new MaximumRecommendedHeartRate(0);

        assertNull(userDataService.setMaximumRecommendedHeartRate(maximumRecommendedHeartRate));
    }

    @Test
    public void test_setMaximumRecommendedHeartRate_000004() {
        final Integer originalTaskId = 1;
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {

            @Override
            public synchronized Integer createWriteCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull ByteArrayInterface byteArrayInterface, int writeType, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isMaximumRecommendedHeartRateCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        MaximumRecommendedHeartRate maximumRecommendedHeartRate = new MaximumRecommendedHeartRate(0);

        Integer taskId = userDataService.setMaximumRecommendedHeartRate(maximumRecommendedHeartRate);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_getAerobicThreshold_000001() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);

        assertNull(userDataService.getAerobicThreshold());
    }

    @Test
    public void test_getAerobicThreshold_000002() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.getAerobicThreshold());
    }

    @Test
    public void test_getAerobicThreshold_000003() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isAerobicThresholdCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.getAerobicThreshold());
    }

    @Test
    public void test_getAerobicThreshold_000004() {
        final Integer originalTaskId = 1;
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {

            @Override
            public synchronized Integer createReadCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isAerobicThresholdCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = userDataService.getAerobicThreshold();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_setAerobicThreshold_000001() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);
        AerobicThreshold aerobicThreshold = new AerobicThreshold(0);

        assertNull(userDataService.setAerobicThreshold(aerobicThreshold));
    }

    @Test
    public void test_setAerobicThreshold_000002() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        AerobicThreshold aerobicThreshold = new AerobicThreshold(0);

        assertNull(userDataService.setAerobicThreshold(aerobicThreshold));
    }

    @Test
    public void test_setAerobicThreshold_000003() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isAerobicThresholdCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        AerobicThreshold aerobicThreshold = new AerobicThreshold(0);

        assertNull(userDataService.setAerobicThreshold(aerobicThreshold));
    }

    @Test
    public void test_setAerobicThreshold_000004() {
        final Integer originalTaskId = 1;
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {

            @Override
            public synchronized Integer createWriteCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull ByteArrayInterface byteArrayInterface, int writeType, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isAerobicThresholdCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        AerobicThreshold aerobicThreshold = new AerobicThreshold(0);

        Integer taskId = userDataService.setAerobicThreshold(aerobicThreshold);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_getAnaerobicThreshold_000001() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);

        assertNull(userDataService.getAnaerobicThreshold());
    }

    @Test
    public void test_getAnaerobicThreshold_000002() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.getAnaerobicThreshold());
    }

    @Test
    public void test_getAnaerobicThreshold_000003() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isAnaerobicThresholdCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.getAnaerobicThreshold());
    }

    @Test
    public void test_getAnaerobicThreshold_000004() {
        final Integer originalTaskId = 1;
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {

            @Override
            public synchronized Integer createReadCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isAnaerobicThresholdCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = userDataService.getAnaerobicThreshold();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_setAnaerobicThreshold_000001() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);
        AnaerobicThreshold anaerobicThreshold = new AnaerobicThreshold(0);

        assertNull(userDataService.setAnaerobicThreshold(anaerobicThreshold));
    }

    @Test
    public void test_setAnaerobicThreshold_000002() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        AnaerobicThreshold anaerobicThreshold = new AnaerobicThreshold(0);

        assertNull(userDataService.setAnaerobicThreshold(anaerobicThreshold));
    }

    @Test
    public void test_setAnaerobicThreshold_000003() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isAnaerobicThresholdCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        AnaerobicThreshold anaerobicThreshold = new AnaerobicThreshold(0);

        assertNull(userDataService.setAnaerobicThreshold(anaerobicThreshold));
    }

    @Test
    public void test_setAnaerobicThreshold_000004() {
        final Integer originalTaskId = 1;
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {

            @Override
            public synchronized Integer createWriteCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull ByteArrayInterface byteArrayInterface, int writeType, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isAnaerobicThresholdCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        AnaerobicThreshold anaerobicThreshold = new AnaerobicThreshold(0);

        Integer taskId = userDataService.setAnaerobicThreshold(anaerobicThreshold);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_getSportTypeForAerobicAndAnaerobicThresholds_000001() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);

        assertNull(userDataService.getSportTypeForAerobicAndAnaerobicThresholds());
    }

    @Test
    public void test_getSportTypeForAerobicAndAnaerobicThresholds_000002() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.getSportTypeForAerobicAndAnaerobicThresholds());
    }

    @Test
    public void test_getSportTypeForAerobicAndAnaerobicThresholds_000003() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isSportTypeForAerobicAndAnaerobicThresholdsCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.getSportTypeForAerobicAndAnaerobicThresholds());
    }

    @Test
    public void test_getSportTypeForAerobicAndAnaerobicThresholds_000004() {
        final Integer originalTaskId = 1;
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {

            @Override
            public synchronized Integer createReadCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isSportTypeForAerobicAndAnaerobicThresholdsCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = userDataService.getSportTypeForAerobicAndAnaerobicThresholds();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_setSportTypeForAerobicAndAnaerobicThresholds_000001() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);
        SportTypeForAerobicAndAnaerobicThresholds sportTypeForAerobicAndAnaerobicThresholds = new SportTypeForAerobicAndAnaerobicThresholds(0);

        assertNull(userDataService.setSportTypeForAerobicAndAnaerobicThresholds(sportTypeForAerobicAndAnaerobicThresholds));
    }

    @Test
    public void test_setSportTypeForAerobicAndAnaerobicThresholds_000002() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        SportTypeForAerobicAndAnaerobicThresholds sportTypeForAerobicAndAnaerobicThresholds = new SportTypeForAerobicAndAnaerobicThresholds(0);

        assertNull(userDataService.setSportTypeForAerobicAndAnaerobicThresholds(sportTypeForAerobicAndAnaerobicThresholds));
    }

    @Test
    public void test_setSportTypeForAerobicAndAnaerobicThresholds_000003() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isSportTypeForAerobicAndAnaerobicThresholdsCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        SportTypeForAerobicAndAnaerobicThresholds sportTypeForAerobicAndAnaerobicThresholds = new SportTypeForAerobicAndAnaerobicThresholds(0);

        assertNull(userDataService.setSportTypeForAerobicAndAnaerobicThresholds(sportTypeForAerobicAndAnaerobicThresholds));
    }

    @Test
    public void test_setSportTypeForAerobicAndAnaerobicThresholds_000004() {
        final Integer originalTaskId = 1;
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {

            @Override
            public synchronized Integer createWriteCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull ByteArrayInterface byteArrayInterface, int writeType, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isSportTypeForAerobicAndAnaerobicThresholdsCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        SportTypeForAerobicAndAnaerobicThresholds sportTypeForAerobicAndAnaerobicThresholds = new SportTypeForAerobicAndAnaerobicThresholds(0);

        Integer taskId = userDataService.setSportTypeForAerobicAndAnaerobicThresholds(sportTypeForAerobicAndAnaerobicThresholds);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_getDateOfThresholdAssessment_000001() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);

        assertNull(userDataService.getDateOfThresholdAssessment());
    }

    @Test
    public void test_getDateOfThresholdAssessment_000002() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.getDateOfThresholdAssessment());
    }

    @Test
    public void test_getDateOfThresholdAssessment_000003() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isDateOfThresholdAssessmentCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.getDateOfThresholdAssessment());
    }

    @Test
    public void test_getDateOfThresholdAssessment_000004() {
        final Integer originalTaskId = 1;
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {

            @Override
            public synchronized Integer createReadCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isDateOfThresholdAssessmentCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = userDataService.getDateOfThresholdAssessment();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_setDateOfThresholdAssessment_000001() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);
        DateOfThresholdAssessment dateOfThresholdAssessment = new DateOfThresholdAssessment(0, 1, 2);

        assertNull(userDataService.setDateOfThresholdAssessment(dateOfThresholdAssessment));
    }

    @Test
    public void test_setDateOfThresholdAssessment_000002() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        DateOfThresholdAssessment dateOfThresholdAssessment = new DateOfThresholdAssessment(0, 1, 2);

        assertNull(userDataService.setDateOfThresholdAssessment(dateOfThresholdAssessment));
    }

    @Test
    public void test_setDateOfThresholdAssessment_000003() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isDateOfThresholdAssessmentCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        DateOfThresholdAssessment dateOfThresholdAssessment = new DateOfThresholdAssessment(0, 1, 2);

        assertNull(userDataService.setDateOfThresholdAssessment(dateOfThresholdAssessment));
    }

    @Test
    public void test_setDateOfThresholdAssessment_000004() {
        final Integer originalTaskId = 1;
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {

            @Override
            public synchronized Integer createWriteCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull ByteArrayInterface byteArrayInterface, int writeType, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isDateOfThresholdAssessmentCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        DateOfThresholdAssessment dateOfThresholdAssessment = new DateOfThresholdAssessment(0, 1, 2);

        Integer taskId = userDataService.setDateOfThresholdAssessment(dateOfThresholdAssessment);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_getWaistCircumference_000001() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);

        assertNull(userDataService.getWaistCircumference());
    }

    @Test
    public void test_getWaistCircumference_000002() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.getWaistCircumference());
    }

    @Test
    public void test_getWaistCircumference_000003() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isWaistCircumferenceCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.getWaistCircumference());
    }

    @Test
    public void test_getWaistCircumference_000004() {
        final Integer originalTaskId = 1;
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {

            @Override
            public synchronized Integer createReadCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isWaistCircumferenceCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = userDataService.getWaistCircumference();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_setWaistCircumference_000001() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);
        WaistCircumference waistCircumference = new WaistCircumference(0);

        assertNull(userDataService.setWaistCircumference(waistCircumference));
    }

    @Test
    public void test_setWaistCircumference_000002() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        WaistCircumference waistCircumference = new WaistCircumference(0);

        assertNull(userDataService.setWaistCircumference(waistCircumference));
    }

    @Test
    public void test_setWaistCircumference_000003() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isWaistCircumferenceCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        WaistCircumference waistCircumference = new WaistCircumference(0);

        assertNull(userDataService.setWaistCircumference(waistCircumference));
    }

    @Test
    public void test_setWaistCircumference_000004() {
        final Integer originalTaskId = 1;
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {

            @Override
            public synchronized Integer createWriteCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull ByteArrayInterface byteArrayInterface, int writeType, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isWaistCircumferenceCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        WaistCircumference waistCircumference = new WaistCircumference(0);

        Integer taskId = userDataService.setWaistCircumference(waistCircumference);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_getHipCircumference_000001() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);

        assertNull(userDataService.getHipCircumference());
    }

    @Test
    public void test_getHipCircumference_000002() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.getHipCircumference());
    }

    @Test
    public void test_getHipCircumference_000003() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isHipCircumferenceCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.getHipCircumference());
    }

    @Test
    public void test_getHipCircumference_000004() {
        final Integer originalTaskId = 1;
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {

            @Override
            public synchronized Integer createReadCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isHipCircumferenceCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = userDataService.getHipCircumference();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_setHipCircumference_000001() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);
        HipCircumference hipCircumference = new HipCircumference(0);

        assertNull(userDataService.setHipCircumference(hipCircumference));
    }

    @Test
    public void test_setHipCircumference_000002() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        HipCircumference hipCircumference = new HipCircumference(0);

        assertNull(userDataService.setHipCircumference(hipCircumference));
    }

    @Test
    public void test_setHipCircumference_000003() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isHipCircumferenceCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        HipCircumference hipCircumference = new HipCircumference(0);

        assertNull(userDataService.setHipCircumference(hipCircumference));
    }

    @Test
    public void test_setHipCircumference_000004() {
        final Integer originalTaskId = 1;
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {

            @Override
            public synchronized Integer createWriteCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull ByteArrayInterface byteArrayInterface, int writeType, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isHipCircumferenceCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        HipCircumference hipCircumference = new HipCircumference(0);

        Integer taskId = userDataService.setHipCircumference(hipCircumference);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_getFatBurnHeartRateLowerLimit_000001() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);

        assertNull(userDataService.getFatBurnHeartRateLowerLimit());
    }

    @Test
    public void test_getFatBurnHeartRateLowerLimit_000002() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.getFatBurnHeartRateLowerLimit());
    }

    @Test
    public void test_getFatBurnHeartRateLowerLimit_000003() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isFatBurnHeartRateLowerLimitCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.getFatBurnHeartRateLowerLimit());
    }

    @Test
    public void test_getFatBurnHeartRateLowerLimit_000004() {
        final Integer originalTaskId = 1;
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {

            @Override
            public synchronized Integer createReadCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isFatBurnHeartRateLowerLimitCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = userDataService.getFatBurnHeartRateLowerLimit();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_setFatBurnHeartRateLowerLimit_000001() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);
        FatBurnHeartRateLowerLimit fatBurnHeartRateLowerLimit = new FatBurnHeartRateLowerLimit(0);

        assertNull(userDataService.setFatBurnHeartRateLowerLimit(fatBurnHeartRateLowerLimit));
    }

    @Test
    public void test_setFatBurnHeartRateLowerLimit_000002() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        FatBurnHeartRateLowerLimit fatBurnHeartRateLowerLimit = new FatBurnHeartRateLowerLimit(0);

        assertNull(userDataService.setFatBurnHeartRateLowerLimit(fatBurnHeartRateLowerLimit));
    }

    @Test
    public void test_setFatBurnHeartRateLowerLimit_000003() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isFatBurnHeartRateLowerLimitCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        FatBurnHeartRateLowerLimit fatBurnHeartRateLowerLimit = new FatBurnHeartRateLowerLimit(0);

        assertNull(userDataService.setFatBurnHeartRateLowerLimit(fatBurnHeartRateLowerLimit));
    }

    @Test
    public void test_setFatBurnHeartRateLowerLimit_000004() {
        final Integer originalTaskId = 1;
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {

            @Override
            public synchronized Integer createWriteCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull ByteArrayInterface byteArrayInterface, int writeType, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isFatBurnHeartRateLowerLimitCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        FatBurnHeartRateLowerLimit fatBurnHeartRateLowerLimit = new FatBurnHeartRateLowerLimit(0);

        Integer taskId = userDataService.setFatBurnHeartRateLowerLimit(fatBurnHeartRateLowerLimit);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_getFatBurnHeartRateUpperLimit_000001() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);

        assertNull(userDataService.getFatBurnHeartRateUpperLimit());
    }

    @Test
    public void test_getFatBurnHeartRateUpperLimit_000002() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.getFatBurnHeartRateUpperLimit());
    }

    @Test
    public void test_getFatBurnHeartRateUpperLimit_000003() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isFatBurnHeartRateUpperLimitCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.getFatBurnHeartRateUpperLimit());
    }

    @Test
    public void test_getFatBurnHeartRateUpperLimit_000004() {
        final Integer originalTaskId = 1;
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {

            @Override
            public synchronized Integer createReadCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isFatBurnHeartRateUpperLimitCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = userDataService.getFatBurnHeartRateUpperLimit();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_setFatBurnHeartRateUpperLimit_000001() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);
        FatBurnHeartRateUpperLimit fatBurnHeartRateUpperLimit = new FatBurnHeartRateUpperLimit(0);

        assertNull(userDataService.setFatBurnHeartRateUpperLimit(fatBurnHeartRateUpperLimit));
    }

    @Test
    public void test_setFatBurnHeartRateUpperLimit_000002() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        FatBurnHeartRateUpperLimit fatBurnHeartRateUpperLimit = new FatBurnHeartRateUpperLimit(0);

        assertNull(userDataService.setFatBurnHeartRateUpperLimit(fatBurnHeartRateUpperLimit));
    }

    @Test
    public void test_setFatBurnHeartRateUpperLimit_000003() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isFatBurnHeartRateUpperLimitCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        FatBurnHeartRateUpperLimit fatBurnHeartRateUpperLimit = new FatBurnHeartRateUpperLimit(0);

        assertNull(userDataService.setFatBurnHeartRateUpperLimit(fatBurnHeartRateUpperLimit));
    }

    @Test
    public void test_setFatBurnHeartRateUpperLimit_000004() {
        final Integer originalTaskId = 1;
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {

            @Override
            public synchronized Integer createWriteCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull ByteArrayInterface byteArrayInterface, int writeType, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isFatBurnHeartRateUpperLimitCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        FatBurnHeartRateUpperLimit fatBurnHeartRateUpperLimit = new FatBurnHeartRateUpperLimit(0);

        Integer taskId = userDataService.setFatBurnHeartRateUpperLimit(fatBurnHeartRateUpperLimit);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_getAerobicHeartRateLowerLimit_000001() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);

        assertNull(userDataService.getAerobicHeartRateLowerLimit());
    }

    @Test
    public void test_getAerobicHeartRateLowerLimit_000002() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.getAerobicHeartRateLowerLimit());
    }

    @Test
    public void test_getAerobicHeartRateLowerLimit_000003() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isAerobicHeartRateLowerLimitCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.getAerobicHeartRateLowerLimit());
    }

    @Test
    public void test_getAerobicHeartRateLowerLimit_000004() {
        final Integer originalTaskId = 1;
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {

            @Override
            public synchronized Integer createReadCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isAerobicHeartRateLowerLimitCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = userDataService.getAerobicHeartRateLowerLimit();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_setAerobicHeartRateLowerLimit_000001() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);
        AerobicHeartRateLowerLimit aerobicHeartRateLowerLimit = new AerobicHeartRateLowerLimit(0);

        assertNull(userDataService.setAerobicHeartRateLowerLimit(aerobicHeartRateLowerLimit));
    }

    @Test
    public void test_setAerobicHeartRateLowerLimit_000002() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        AerobicHeartRateLowerLimit aerobicHeartRateLowerLimit = new AerobicHeartRateLowerLimit(0);

        assertNull(userDataService.setAerobicHeartRateLowerLimit(aerobicHeartRateLowerLimit));
    }

    @Test
    public void test_setAerobicHeartRateLowerLimit_000003() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isAerobicHeartRateLowerLimitCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        AerobicHeartRateLowerLimit aerobicHeartRateLowerLimit = new AerobicHeartRateLowerLimit(0);

        assertNull(userDataService.setAerobicHeartRateLowerLimit(aerobicHeartRateLowerLimit));
    }

    @Test
    public void test_setAerobicHeartRateLowerLimit_000004() {
        final Integer originalTaskId = 1;
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {

            @Override
            public synchronized Integer createWriteCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull ByteArrayInterface byteArrayInterface, int writeType, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isAerobicHeartRateLowerLimitCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        AerobicHeartRateLowerLimit aerobicHeartRateLowerLimit = new AerobicHeartRateLowerLimit(0);

        Integer taskId = userDataService.setAerobicHeartRateLowerLimit(aerobicHeartRateLowerLimit);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_getAerobicHeartRateUpperLimit_000001() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);

        assertNull(userDataService.getAerobicHeartRateUpperLimit());
    }

    @Test
    public void test_getAerobicHeartRateUpperLimit_000002() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.getAerobicHeartRateUpperLimit());
    }

    @Test
    public void test_getAerobicHeartRateUpperLimit_000003() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isAerobicHeartRateUpperLimitCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.getAerobicHeartRateUpperLimit());
    }

    @Test
    public void test_getAerobicHeartRateUpperLimit_000004() {
        final Integer originalTaskId = 1;
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {

            @Override
            public synchronized Integer createReadCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isAerobicHeartRateUpperLimitCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = userDataService.getAerobicHeartRateUpperLimit();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_setAerobicHeartRateUpperLimit_000001() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);
        AerobicHeartRateUpperLimit aerobicHeartRateUpperLimit = new AerobicHeartRateUpperLimit(0);

        assertNull(userDataService.setAerobicHeartRateUpperLimit(aerobicHeartRateUpperLimit));
    }

    @Test
    public void test_setAerobicHeartRateUpperLimit_000002() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        AerobicHeartRateUpperLimit aerobicHeartRateUpperLimit = new AerobicHeartRateUpperLimit(0);

        assertNull(userDataService.setAerobicHeartRateUpperLimit(aerobicHeartRateUpperLimit));
    }

    @Test
    public void test_setAerobicHeartRateUpperLimit_000003() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isAerobicHeartRateUpperLimitCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        AerobicHeartRateUpperLimit aerobicHeartRateUpperLimit = new AerobicHeartRateUpperLimit(0);

        assertNull(userDataService.setAerobicHeartRateUpperLimit(aerobicHeartRateUpperLimit));
    }

    @Test
    public void test_setAerobicHeartRateUpperLimit_000004() {
        final Integer originalTaskId = 1;
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {

            @Override
            public synchronized Integer createWriteCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull ByteArrayInterface byteArrayInterface, int writeType, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isAerobicHeartRateUpperLimitCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        AerobicHeartRateUpperLimit aerobicHeartRateUpperLimit = new AerobicHeartRateUpperLimit(0);

        Integer taskId = userDataService.setAerobicHeartRateUpperLimit(aerobicHeartRateUpperLimit);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_getAnaerobicHeartRateLowerLimit_000001() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);

        assertNull(userDataService.getAnaerobicHeartRateLowerLimit());
    }

    @Test
    public void test_getAnaerobicHeartRateLowerLimit_000002() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.getAnaerobicHeartRateLowerLimit());
    }

    @Test
    public void test_getAnaerobicHeartRateLowerLimit_000003() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isAnaerobicHeartRateLowerLimitCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.getAnaerobicHeartRateLowerLimit());
    }

    @Test
    public void test_getAnaerobicHeartRateLowerLimit_000004() {
        final Integer originalTaskId = 1;
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {

            @Override
            public synchronized Integer createReadCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isAnaerobicHeartRateLowerLimitCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = userDataService.getAnaerobicHeartRateLowerLimit();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_setAnaerobicHeartRateLowerLimit_000001() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);
        AnaerobicHeartRateLowerLimit anaerobicHeartRateLowerLimit = new AnaerobicHeartRateLowerLimit(0);

        assertNull(userDataService.setAnaerobicHeartRateLowerLimit(anaerobicHeartRateLowerLimit));
    }

    @Test
    public void test_setAnaerobicHeartRateLowerLimit_000002() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        AnaerobicHeartRateLowerLimit anaerobicHeartRateLowerLimit = new AnaerobicHeartRateLowerLimit(0);

        assertNull(userDataService.setAnaerobicHeartRateLowerLimit(anaerobicHeartRateLowerLimit));
    }

    @Test
    public void test_setAnaerobicHeartRateLowerLimit_000003() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isAnaerobicHeartRateLowerLimitCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        AnaerobicHeartRateLowerLimit anaerobicHeartRateLowerLimit = new AnaerobicHeartRateLowerLimit(0);

        assertNull(userDataService.setAnaerobicHeartRateLowerLimit(anaerobicHeartRateLowerLimit));
    }

    @Test
    public void test_setAnaerobicHeartRateLowerLimit_000004() {
        final Integer originalTaskId = 1;
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {

            @Override
            public synchronized Integer createWriteCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull ByteArrayInterface byteArrayInterface, int writeType, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isAnaerobicHeartRateLowerLimitCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        AnaerobicHeartRateLowerLimit anaerobicHeartRateLowerLimit = new AnaerobicHeartRateLowerLimit(0);

        Integer taskId = userDataService.setAnaerobicHeartRateLowerLimit(anaerobicHeartRateLowerLimit);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_getAnaerobicHeartRateUpperLimit_000001() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);

        assertNull(userDataService.getAnaerobicHeartRateUpperLimit());
    }

    @Test
    public void test_getAnaerobicHeartRateUpperLimit_000002() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.getAnaerobicHeartRateUpperLimit());
    }

    @Test
    public void test_getAnaerobicHeartRateUpperLimit_000003() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isAnaerobicHeartRateUpperLimitCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.getAnaerobicHeartRateUpperLimit());
    }

    @Test
    public void test_getAnaerobicHeartRateUpperLimit_000004() {
        final Integer originalTaskId = 1;
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {

            @Override
            public synchronized Integer createReadCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isAnaerobicHeartRateUpperLimitCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = userDataService.getAnaerobicHeartRateUpperLimit();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_setAnaerobicHeartRateUpperLimit_000001() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);
        AnaerobicHeartRateUpperLimit anaerobicHeartRateUpperLimit = new AnaerobicHeartRateUpperLimit(0);

        assertNull(userDataService.setAnaerobicHeartRateUpperLimit(anaerobicHeartRateUpperLimit));
    }

    @Test
    public void test_setAnaerobicHeartRateUpperLimit_000002() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        AnaerobicHeartRateUpperLimit anaerobicHeartRateUpperLimit = new AnaerobicHeartRateUpperLimit(0);

        assertNull(userDataService.setAnaerobicHeartRateUpperLimit(anaerobicHeartRateUpperLimit));
    }

    @Test
    public void test_setAnaerobicHeartRateUpperLimit_000003() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isAnaerobicHeartRateUpperLimitCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        AnaerobicHeartRateUpperLimit anaerobicHeartRateUpperLimit = new AnaerobicHeartRateUpperLimit(0);

        assertNull(userDataService.setAnaerobicHeartRateUpperLimit(anaerobicHeartRateUpperLimit));
    }

    @Test
    public void test_setAnaerobicHeartRateUpperLimit_000004() {
        final Integer originalTaskId = 1;
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {

            @Override
            public synchronized Integer createWriteCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull ByteArrayInterface byteArrayInterface, int writeType, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isAnaerobicHeartRateUpperLimitCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        AnaerobicHeartRateUpperLimit anaerobicHeartRateUpperLimit = new AnaerobicHeartRateUpperLimit(0);

        Integer taskId = userDataService.setAnaerobicHeartRateUpperLimit(anaerobicHeartRateUpperLimit);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_getFiveZoneHeartRateLimits_000001() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);

        assertNull(userDataService.getFiveZoneHeartRateLimits());
    }

    @Test
    public void test_getFiveZoneHeartRateLimits_000002() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.getFiveZoneHeartRateLimits());
    }

    @Test
    public void test_getFiveZoneHeartRateLimits_000003() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isFiveZoneHeartRateLimitsCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.getFiveZoneHeartRateLimits());
    }

    @Test
    public void test_getFiveZoneHeartRateLimits_000004() {
        final Integer originalTaskId = 1;
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {

            @Override
            public synchronized Integer createReadCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isFiveZoneHeartRateLimitsCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = userDataService.getFiveZoneHeartRateLimits();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_setFiveZoneHeartRateLimits_000001() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);
        FiveZoneHeartRateLimits fiveZoneHeartRateLimits = new FiveZoneHeartRateLimits(0, 1, 2, 3);

        assertNull(userDataService.setFiveZoneHeartRateLimits(fiveZoneHeartRateLimits));
    }

    @Test
    public void test_setFiveZoneHeartRateLimits_000002() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        FiveZoneHeartRateLimits fiveZoneHeartRateLimits = new FiveZoneHeartRateLimits(0, 1, 2, 3);

        assertNull(userDataService.setFiveZoneHeartRateLimits(fiveZoneHeartRateLimits));
    }

    @Test
    public void test_setFiveZoneHeartRateLimits_000003() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isFiveZoneHeartRateLimitsCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        FiveZoneHeartRateLimits fiveZoneHeartRateLimits = new FiveZoneHeartRateLimits(0, 1, 2, 3);

        assertNull(userDataService.setFiveZoneHeartRateLimits(fiveZoneHeartRateLimits));
    }

    @Test
    public void test_setFiveZoneHeartRateLimits_000004() {
        final Integer originalTaskId = 1;
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {

            @Override
            public synchronized Integer createWriteCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull ByteArrayInterface byteArrayInterface, int writeType, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isFiveZoneHeartRateLimitsCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        FiveZoneHeartRateLimits fiveZoneHeartRateLimits = new FiveZoneHeartRateLimits(0, 1, 2, 3);

        Integer taskId = userDataService.setFiveZoneHeartRateLimits(fiveZoneHeartRateLimits);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_getThreeZoneHeartRateLimits_000001() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);

        assertNull(userDataService.getThreeZoneHeartRateLimits());
    }

    @Test
    public void test_getThreeZoneHeartRateLimits_000002() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.getThreeZoneHeartRateLimits());
    }

    @Test
    public void test_getThreeZoneHeartRateLimits_000003() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isThreeZoneHeartRateLimitsCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.getThreeZoneHeartRateLimits());
    }

    @Test
    public void test_getThreeZoneHeartRateLimits_000004() {
        final Integer originalTaskId = 1;
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {

            @Override
            public synchronized Integer createReadCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isThreeZoneHeartRateLimitsCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = userDataService.getThreeZoneHeartRateLimits();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_setThreeZoneHeartRateLimits_000001() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);
        ThreeZoneHeartRateLimits threeZoneHeartRateLimits = new ThreeZoneHeartRateLimits(0, 1);

        assertNull(userDataService.setThreeZoneHeartRateLimits(threeZoneHeartRateLimits));
    }

    @Test
    public void test_setThreeZoneHeartRateLimits_000002() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        ThreeZoneHeartRateLimits threeZoneHeartRateLimits = new ThreeZoneHeartRateLimits(0, 1);

        assertNull(userDataService.setThreeZoneHeartRateLimits(threeZoneHeartRateLimits));
    }

    @Test
    public void test_setThreeZoneHeartRateLimits_000003() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isThreeZoneHeartRateLimitsCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        ThreeZoneHeartRateLimits threeZoneHeartRateLimits = new ThreeZoneHeartRateLimits(0, 1);

        assertNull(userDataService.setThreeZoneHeartRateLimits(threeZoneHeartRateLimits));
    }

    @Test
    public void test_setThreeZoneHeartRateLimits_000004() {
        final Integer originalTaskId = 1;
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {

            @Override
            public synchronized Integer createWriteCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull ByteArrayInterface byteArrayInterface, int writeType, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isThreeZoneHeartRateLimitsCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        ThreeZoneHeartRateLimits threeZoneHeartRateLimits = new ThreeZoneHeartRateLimits(0, 1);

        Integer taskId = userDataService.setThreeZoneHeartRateLimits(threeZoneHeartRateLimits);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_getTwoZoneHeartRateLimit_000001() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);

        assertNull(userDataService.getTwoZoneHeartRateLimit());
    }

    @Test
    public void test_getTwoZoneHeartRateLimit_000002() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.getTwoZoneHeartRateLimit());
    }

    @Test
    public void test_getTwoZoneHeartRateLimit_000003() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isTwoZoneHeartRateLimitCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.getTwoZoneHeartRateLimit());
    }

    @Test
    public void test_getTwoZoneHeartRateLimit_000004() {
        final Integer originalTaskId = 1;
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {

            @Override
            public synchronized Integer createReadCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isTwoZoneHeartRateLimitCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = userDataService.getTwoZoneHeartRateLimit();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_setTwoZoneHeartRateLimit_000001() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);
        TwoZoneHeartRateLimit twoZoneHeartRateLimit = new TwoZoneHeartRateLimit(0);

        assertNull(userDataService.setTwoZoneHeartRateLimit(twoZoneHeartRateLimit));
    }

    @Test
    public void test_setTwoZoneHeartRateLimit_000002() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        TwoZoneHeartRateLimit twoZoneHeartRateLimit = new TwoZoneHeartRateLimit(0);

        assertNull(userDataService.setTwoZoneHeartRateLimit(twoZoneHeartRateLimit));
    }

    @Test
    public void test_setTwoZoneHeartRateLimit_000003() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isTwoZoneHeartRateLimitCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        TwoZoneHeartRateLimit twoZoneHeartRateLimit = new TwoZoneHeartRateLimit(0);

        assertNull(userDataService.setTwoZoneHeartRateLimit(twoZoneHeartRateLimit));
    }

    @Test
    public void test_setTwoZoneHeartRateLimit_000004() {
        final Integer originalTaskId = 1;
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {

            @Override
            public synchronized Integer createWriteCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull ByteArrayInterface byteArrayInterface, int writeType, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isTwoZoneHeartRateLimitCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        TwoZoneHeartRateLimit twoZoneHeartRateLimit = new TwoZoneHeartRateLimit(0);

        Integer taskId = userDataService.setTwoZoneHeartRateLimit(twoZoneHeartRateLimit);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_getLanguage_000001() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);

        assertNull(userDataService.getLanguage());
    }

    @Test
    public void test_getLanguage_000002() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.getLanguage());
    }

    @Test
    public void test_getLanguage_000003() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isLanguageCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.getLanguage());
    }

    @Test
    public void test_getLanguage_000004() {
        final Integer originalTaskId = 1;
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {

            @Override
            public synchronized Integer createReadCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isLanguageCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = userDataService.getLanguage();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_setLanguage_000001() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);
        Language language = new Language("a");

        assertNull(userDataService.setLanguage(language));
    }

    @Test
    public void test_setLanguage_000002() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        Language language = new Language("a");

        assertNull(userDataService.setLanguage(language));
    }

    @Test
    public void test_setLanguage_000003() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isLanguageCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        Language language = new Language("a");

        assertNull(userDataService.setLanguage(language));
    }

    @Test
    public void test_setLanguage_000004() {
        final Integer originalTaskId = 1;
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {

            @Override
            public synchronized Integer createWriteCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull ByteArrayInterface byteArrayInterface, int writeType, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isLanguageCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        Language language = new Language("a");

        Integer taskId = userDataService.setLanguage(language);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_getDatabaseChangeIncrement_000001() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);

        assertNull(userDataService.getDatabaseChangeIncrement());
    }

    @Test
    public void test_getDatabaseChangeIncrement_000002() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.getDatabaseChangeIncrement());
    }

    @Test
    public void test_getDatabaseChangeIncrement_000003() {
        final Integer originalTaskId = 1;
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {

            @Override
            public synchronized Integer createReadCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = userDataService.getDatabaseChangeIncrement();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_setDatabaseChangeIncrement_000001() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);
        DatabaseChangeIncrement databaseChangeIncrement = new DatabaseChangeIncrement(0);

        assertNull(userDataService.setDatabaseChangeIncrement(databaseChangeIncrement));
    }

    @Test
    public void test_setDatabaseChangeIncrement_000002() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        DatabaseChangeIncrement databaseChangeIncrement = new DatabaseChangeIncrement(0);

        assertNull(userDataService.setDatabaseChangeIncrement(databaseChangeIncrement));
    }

    @Test
    public void test_setDatabaseChangeIncrement_000003() {
        final Integer originalTaskId = 1;
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {

            @Override
            public synchronized Integer createWriteCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull ByteArrayInterface byteArrayInterface, int writeType, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        DatabaseChangeIncrement databaseChangeIncrement = new DatabaseChangeIncrement(0);

        Integer taskId = userDataService.setDatabaseChangeIncrement(databaseChangeIncrement);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_getDatabaseChangeIncrementClientCharacteristicConfiguration_000001() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);

        assertNull(userDataService.getDatabaseChangeIncrementClientCharacteristicConfiguration());
    }

    @Test
    public void test_getDatabaseChangeIncrementClientCharacteristicConfiguration_000002() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.getDatabaseChangeIncrementClientCharacteristicConfiguration());
    }

    @Test
    public void test_getDatabaseChangeIncrementClientCharacteristicConfiguration_000003() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isDatabaseChangeIncrementCharacteristicNotifySupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.getDatabaseChangeIncrementClientCharacteristicConfiguration());
    }

    @Test
    public void test_getDatabaseChangeIncrementClientCharacteristicConfiguration_000004() {
        final Integer originalTaskId = 1;
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {

            @Override
            public synchronized Integer createReadDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isDatabaseChangeIncrementCharacteristicNotifySupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = userDataService.getDatabaseChangeIncrementClientCharacteristicConfiguration();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_startDatabaseChangeIncrementNotification_000001() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);

        assertNull(userDataService.startDatabaseChangeIncrementNotification());
    }

    @Test
    public void test_startDatabaseChangeIncrementNotification_000002() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.startDatabaseChangeIncrementNotification());
    }

    @Test
    public void test_startDatabaseChangeIncrementNotification_000003() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isDatabaseChangeIncrementCharacteristicNotifySupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.startDatabaseChangeIncrementNotification());
    }

    @Test
    public void test_startDatabaseChangeIncrementNotification_000004() {
        final Integer originalTaskId = 1;
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {

            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isDatabaseChangeIncrementCharacteristicNotifySupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = userDataService.startDatabaseChangeIncrementNotification();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_stopDatabaseChangeIncrementNotification_000001() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);

        assertNull(userDataService.stopDatabaseChangeIncrementNotification());
    }

    @Test
    public void test_stopDatabaseChangeIncrementNotification_000002() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.stopDatabaseChangeIncrementNotification());
    }

    @Test
    public void test_stopDatabaseChangeIncrementNotification_000003() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isDatabaseChangeIncrementCharacteristicNotifySupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.stopDatabaseChangeIncrementNotification());
    }

    @Test
    public void test_stopDatabaseChangeIncrementNotification_000004() {
        final Integer originalTaskId = 1;
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {

            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isDatabaseChangeIncrementCharacteristicNotifySupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = userDataService.stopDatabaseChangeIncrementNotification();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_getUserIndex_000001() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);

        assertNull(userDataService.getUserIndex());
    }

    @Test
    public void test_getUserIndex_000002() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.getUserIndex());
    }

    @Test
    public void test_getUserIndex_000003() {
        final Integer originalTaskId = 1;
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {

            @Override
            public synchronized Integer createReadCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = userDataService.getUserIndex();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_getRegisteredUserClientCharacteristicConfiguration_000001() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);

        assertNull(userDataService.getRegisteredUserClientCharacteristicConfiguration());
    }

    @Test
    public void test_getRegisteredUserClientCharacteristicConfiguration_000002() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.getRegisteredUserClientCharacteristicConfiguration());
    }

    @Test
    public void test_getRegisteredUserClientCharacteristicConfiguration_000003() {
        final Integer originalTaskId = 1;
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {

            @Override
            public synchronized Integer createReadDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = userDataService.getRegisteredUserClientCharacteristicConfiguration();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_startRegisteredUserIndication_000001() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);

        assertNull(userDataService.startRegisteredUserIndication());
    }

    @Test
    public void test_startRegisteredUserIndication_000002() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.startRegisteredUserIndication());
    }

    @Test
    public void test_startRegisteredUserIndication_000003() {
        final Integer originalTaskId = 1;
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {

            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = userDataService.startRegisteredUserIndication();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_stopRegisteredUserIndication_000001() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);

        assertNull(userDataService.stopRegisteredUserIndication());
    }

    @Test
    public void test_stopRegisteredUserIndication_000002() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.stopRegisteredUserIndication());
    }

    @Test
    public void test_stopRegisteredUserIndication_000003() {
        final Integer originalTaskId = 1;
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {

            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = userDataService.stopRegisteredUserIndication();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_setUserControlPoint_000001() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);
        UserControlPoint userControlPoint = new UserControlPoint(UserControlPoint.OP_CODE_REGISTER_NEW_USER, 0, 1, 2, 3, 4);

        assertNull(userDataService.setUserControlPoint(userControlPoint));
    }

    @Test
    public void test_setUserControlPoint_000002() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        UserControlPoint userControlPoint = new UserControlPoint(UserControlPoint.OP_CODE_REGISTER_NEW_USER, 0, 1, 2, 3, 4);

        assertNull(userDataService.setUserControlPoint(userControlPoint));
    }

    @Test
    public void test_setUserControlPoint_000003() {
        final Integer originalTaskId = 1;
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {

            @Override
            public synchronized Integer createWriteCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull ByteArrayInterface byteArrayInterface, int writeType, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        UserControlPoint userControlPoint = new UserControlPoint(UserControlPoint.OP_CODE_REGISTER_NEW_USER, 0, 1, 2, 3, 4);

        Integer taskId = userDataService.setUserControlPoint(userControlPoint);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_getUserControlPointClientCharacteristicConfiguration_000001() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);

        assertNull(userDataService.getUserControlPointClientCharacteristicConfiguration());
    }

    @Test
    public void test_getUserControlPointClientCharacteristicConfiguration_000002() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.getUserControlPointClientCharacteristicConfiguration());
    }

    @Test
    public void test_getUserControlPointClientCharacteristicConfiguration_000003() {
        final Integer originalTaskId = 1;
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {

            @Override
            public synchronized Integer createReadDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = userDataService.getUserControlPointClientCharacteristicConfiguration();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_startUserControlPointIndication_000001() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);

        assertNull(userDataService.startUserControlPointIndication());
    }

    @Test
    public void test_startUserControlPointIndication_000002() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.startUserControlPointIndication());
    }

    @Test
    public void test_startUserControlPointIndication_000003() {
        final Integer originalTaskId = 1;
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {

            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = userDataService.startUserControlPointIndication();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_stopUserControlPointIndication_000001() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null);

        assertNull(userDataService.stopUserControlPointIndication());
    }

    @Test
    public void test_stopUserControlPointIndication_000002() {
        UserDataService userDataService = new UserDataService(new MockBLEConnection(), new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.stopUserControlPointIndication());
    }

    @Test
    public void test_stopUserControlPointIndication_000003() {
        final Integer originalTaskId = 1;
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {

            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }

        };
        UserDataService userDataService = new UserDataService(mockBLEConnection, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = userDataService.stopUserControlPointIndication();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

}
