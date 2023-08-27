package org.im97mori.ble.service.uds.central;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.test.filters.RequiresDevice;

import org.im97mori.ble.characteristic.u2a7e.AerobicHeartRateLowerLimitAndroid;
import org.im97mori.ble.characteristic.u2a7f.AerobicThresholdAndroid;
import org.im97mori.ble.characteristic.u2a80.AgeAndroid;
import org.im97mori.ble.characteristic.u2a81.AnaerobicHeartRateLowerLimitAndroid;
import org.im97mori.ble.characteristic.u2a82.AnaerobicHeartRateUpperLimitAndroid;
import org.im97mori.ble.characteristic.u2a83.AnaerobicThresholdAndroid;
import org.im97mori.ble.characteristic.u2a84.AerobicHeartRateUpperLimitAndroid;
import org.im97mori.ble.characteristic.u2a85.DateOfBirthAndroid;
import org.im97mori.ble.characteristic.u2a86.DateOfThresholdAssessmentAndroid;
import org.im97mori.ble.characteristic.u2a87.EmailAddressAndroid;
import org.im97mori.ble.characteristic.u2a88.FatBurnHeartRateLowerLimitAndroid;
import org.im97mori.ble.characteristic.u2a89.FatBurnHeartRateUpperLimitAndroid;
import org.im97mori.ble.characteristic.u2a8a.FirstNameAndroid;
import org.im97mori.ble.characteristic.u2a8b.FiveZoneHeartRateLimitsAndroid;
import org.im97mori.ble.characteristic.u2a8c.GenderAndroid;
import org.im97mori.ble.characteristic.u2a8d.HeartRateMaxAndroid;
import org.im97mori.ble.characteristic.u2a8e.HeightAndroid;
import org.im97mori.ble.characteristic.u2a8f.HipCircumferenceAndroid;
import org.im97mori.ble.characteristic.u2a90.LastNameAndroid;
import org.im97mori.ble.characteristic.u2a91.MaximumRecommendedHeartRateAndroid;
import org.im97mori.ble.characteristic.u2a92.RestingHeartRateAndroid;
import org.im97mori.ble.characteristic.u2a93.SportTypeForAerobicAndAnaerobicThresholdsAndroid;
import org.im97mori.ble.characteristic.u2a94.ThreeZoneHeartRateLimitsAndroid;
import org.im97mori.ble.characteristic.u2a95.TwoZoneHeartRateLimitAndroid;
import org.im97mori.ble.characteristic.u2a96.VO2MaxAndroid;
import org.im97mori.ble.characteristic.u2a97.WaistCircumferenceAndroid;
import org.im97mori.ble.characteristic.u2a98.WeightAndroid;
import org.im97mori.ble.characteristic.u2a99.DatabaseChangeIncrementAndroid;
import org.im97mori.ble.characteristic.u2a9a.UserIndexAndroid;
import org.im97mori.ble.characteristic.u2aa2.LanguageAndroid;
import org.im97mori.ble.characteristic.u2b37.RegisteredUser;
import org.im97mori.ble.test.BLETestUtilsAndroid;
import org.im97mori.ble.test.central.AbstractCentralTest;
import org.im97mori.ble.test.TestBase;
import org.junit.Test;

import java.util.Collections;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

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
import static org.im97mori.ble.constants.CharacteristicUUID.RESTING_HEART_RATE_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.SPORT_TYPE_FOR_AEROBIC_AND_ANAEROBIC_THRESHOLDS_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.THREE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.TWO_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.USER_INDEX_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.VO2_MAX_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.WAIST_CIRCUMFERENCE_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.WEIGHT_CHARACTERISTIC;
import static org.im97mori.ble.constants.DescriptorUUID.CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
import static org.im97mori.ble.constants.ServiceUUID.GENERIC_ACCESS_SERVICE;
import static org.im97mori.ble.constants.ServiceUUID.USER_DATA_SERVICE;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UserDataService001Test extends AbstractCentralTest {

    @Test
    @RequiresDevice
    public void test_onBLEDisconnected_00001() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(FIRST_NAME_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        userDataService.onBLEDisconnected(1, BLETestUtilsAndroid.MOCK_DEVICE_0, 0, null);

        assertFalse(userDataService.isFirstNameCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onBLEDisconnected_00101() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(LAST_NAME_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        userDataService.onBLEDisconnected(1, BLETestUtilsAndroid.MOCK_DEVICE_0, 0, null);

        assertFalse(userDataService.isLastNameCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onBLEDisconnected_00201() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(EMAIL_ADDRESS_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        userDataService.onBLEDisconnected(1, BLETestUtilsAndroid.MOCK_DEVICE_0, 0, null);

        assertFalse(userDataService.isEmailAddressCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onBLEDisconnected_00301() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(AGE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        userDataService.onBLEDisconnected(1, BLETestUtilsAndroid.MOCK_DEVICE_0, 0, null);

        assertFalse(userDataService.isAgeCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onBLEDisconnected_00401() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(DATE_OF_BIRTH_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        userDataService.onBLEDisconnected(1, BLETestUtilsAndroid.MOCK_DEVICE_0, 0, null);

        assertFalse(userDataService.isDateOfBirthCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onBLEDisconnected_00501() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(GENDER_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        userDataService.onBLEDisconnected(1, BLETestUtilsAndroid.MOCK_DEVICE_0, 0, null);

        assertFalse(userDataService.isGenderCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onBLEDisconnected_00601() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(WEIGHT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        userDataService.onBLEDisconnected(1, BLETestUtilsAndroid.MOCK_DEVICE_0, 0, null);

        assertFalse(userDataService.isWeightCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onBLEDisconnected_00701() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(HEIGHT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        userDataService.onBLEDisconnected(1, BLETestUtilsAndroid.MOCK_DEVICE_0, 0, null);

        assertFalse(userDataService.isHeightCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onBLEDisconnected_00801() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(VO2_MAX_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        userDataService.onBLEDisconnected(1, BLETestUtilsAndroid.MOCK_DEVICE_0, 0, null);

        assertFalse(userDataService.isVO2MaxCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onBLEDisconnected_00901() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(HEART_RATE_MAX_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        userDataService.onBLEDisconnected(1, BLETestUtilsAndroid.MOCK_DEVICE_0, 0, null);

        assertFalse(userDataService.isHeartRateMaxCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onBLEDisconnected_01001() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(RESTING_HEART_RATE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        userDataService.onBLEDisconnected(1, BLETestUtilsAndroid.MOCK_DEVICE_0, 0, null);

        assertFalse(userDataService.isRestingHeartRateCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onBLEDisconnected_01101() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(MAXIMUM_RECOMMENDED_HEART_RATE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        userDataService.onBLEDisconnected(1, BLETestUtilsAndroid.MOCK_DEVICE_0, 0, null);

        assertFalse(userDataService.isMaximumRecommendedHeartRateCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onBLEDisconnected_01201() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(AEROBIC_THRESHOLD_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        userDataService.onBLEDisconnected(1, BLETestUtilsAndroid.MOCK_DEVICE_0, 0, null);

        assertFalse(userDataService.isAerobicThresholdCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onBLEDisconnected_01301() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(ANAEROBIC_THRESHOLD_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        userDataService.onBLEDisconnected(1, BLETestUtilsAndroid.MOCK_DEVICE_0, 0, null);

        assertFalse(userDataService.isAnaerobicThresholdCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onBLEDisconnected_01401() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(SPORT_TYPE_FOR_AEROBIC_AND_ANAEROBIC_THRESHOLDS_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        userDataService.onBLEDisconnected(1, BLETestUtilsAndroid.MOCK_DEVICE_0, 0, null);

        assertFalse(userDataService.isSportTypeForAerobicAndAnaerobicThresholdsCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onBLEDisconnected_01501() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(DATE_OF_THRESHOLD_ASSESSMENT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        userDataService.onBLEDisconnected(1, BLETestUtilsAndroid.MOCK_DEVICE_0, 0, null);

        assertFalse(userDataService.isDateOfThresholdAssessmentCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onBLEDisconnected_01601() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(WAIST_CIRCUMFERENCE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        userDataService.onBLEDisconnected(1, BLETestUtilsAndroid.MOCK_DEVICE_0, 0, null);

        assertFalse(userDataService.isWaistCircumferenceCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onBLEDisconnected_01701() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(HIP_CIRCUMFERENCE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        userDataService.onBLEDisconnected(1, BLETestUtilsAndroid.MOCK_DEVICE_0, 0, null);

        assertFalse(userDataService.isHipCircumferenceCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onBLEDisconnected_01801() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(FAT_BURN_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        userDataService.onBLEDisconnected(1, BLETestUtilsAndroid.MOCK_DEVICE_0, 0, null);

        assertFalse(userDataService.isFatBurnHeartRateLowerLimitCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onBLEDisconnected_01901() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(FAT_BURN_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        userDataService.onBLEDisconnected(1, BLETestUtilsAndroid.MOCK_DEVICE_0, 0, null);

        assertFalse(userDataService.isFatBurnHeartRateUpperLimitCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onBLEDisconnected_02001() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(AEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        userDataService.onBLEDisconnected(1, BLETestUtilsAndroid.MOCK_DEVICE_0, 0, null);

        assertFalse(userDataService.isAerobicHeartRateLowerLimitCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onBLEDisconnected_02101() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(AEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        userDataService.onBLEDisconnected(1, BLETestUtilsAndroid.MOCK_DEVICE_0, 0, null);

        assertFalse(userDataService.isAerobicHeartRateUpperLimitCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onBLEDisconnected_02201() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(ANAEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        userDataService.onBLEDisconnected(1, BLETestUtilsAndroid.MOCK_DEVICE_0, 0, null);

        assertFalse(userDataService.isAnaerobicHeartRateLowerLimitCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onBLEDisconnected_02301() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(ANAEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        userDataService.onBLEDisconnected(1, BLETestUtilsAndroid.MOCK_DEVICE_0, 0, null);

        assertFalse(userDataService.isAnaerobicHeartRateUpperLimitCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onBLEDisconnected_02401() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(FIVE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        userDataService.onBLEDisconnected(1, BLETestUtilsAndroid.MOCK_DEVICE_0, 0, null);

        assertFalse(userDataService.isFiveZoneHeartRateLimitsCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onBLEDisconnected_02501() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(THREE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        userDataService.onBLEDisconnected(1, BLETestUtilsAndroid.MOCK_DEVICE_0, 0, null);

        assertFalse(userDataService.isThreeZoneHeartRateLimitsCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onBLEDisconnected_02601() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(TWO_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        userDataService.onBLEDisconnected(1, BLETestUtilsAndroid.MOCK_DEVICE_0, 0, null);

        assertFalse(userDataService.isTwoZoneHeartRateLimitCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onBLEDisconnected_02701() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(LANGUAGE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        userDataService.onBLEDisconnected(1, BLETestUtilsAndroid.MOCK_DEVICE_0, 0, null);

        assertFalse(userDataService.isLanguageCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onBLEDisconnected_02801() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(DATABASE_CHANGE_INCREMENT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        userDataService.onBLEDisconnected(1, BLETestUtilsAndroid.MOCK_DEVICE_0, 0, null);

        assertFalse(userDataService.isDatabaseChangeIncrementCharacteristicNotifySupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00001() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.emptyList(), null);

        assertFalse(userDataService.isFirstNameCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00002() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isFirstNameCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00003() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isFirstNameCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00004() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(FIRST_NAME_CHARACTERISTIC, 0, 0));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isFirstNameCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00005() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(FIRST_NAME_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isFirstNameCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00006() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(FIRST_NAME_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isFirstNameCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00007() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(FIRST_NAME_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertTrue(userDataService.isFirstNameCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00101() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.emptyList(), null);

        assertFalse(userDataService.isLastNameCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00102() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isLastNameCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00103() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isLastNameCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00104() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(LAST_NAME_CHARACTERISTIC, 0, 0));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isLastNameCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00105() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(LAST_NAME_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isLastNameCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00106() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(LAST_NAME_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isLastNameCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00107() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(LAST_NAME_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertTrue(userDataService.isLastNameCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00201() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.emptyList(), null);

        assertFalse(userDataService.isEmailAddressCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00202() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isEmailAddressCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00203() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isEmailAddressCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00204() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(EMAIL_ADDRESS_CHARACTERISTIC, 0, 0));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isEmailAddressCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00205() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(EMAIL_ADDRESS_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isEmailAddressCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00206() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(EMAIL_ADDRESS_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isEmailAddressCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00207() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(EMAIL_ADDRESS_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertTrue(userDataService.isEmailAddressCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00301() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.emptyList(), null);

        assertFalse(userDataService.isAgeCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00302() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isAgeCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00303() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isAgeCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00304() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(AGE_CHARACTERISTIC, 0, 0));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isAgeCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00305() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(AGE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isAgeCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00306() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(AGE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isAgeCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00307() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(AGE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertTrue(userDataService.isAgeCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00401() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.emptyList(), null);

        assertFalse(userDataService.isDateOfBirthCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00402() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isDateOfBirthCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00403() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isDateOfBirthCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00404() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(DATE_OF_BIRTH_CHARACTERISTIC, 0, 0));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isDateOfBirthCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00405() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(DATE_OF_BIRTH_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isDateOfBirthCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00406() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(DATE_OF_BIRTH_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isDateOfBirthCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00407() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(DATE_OF_BIRTH_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertTrue(userDataService.isDateOfBirthCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00501() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.emptyList(), null);

        assertFalse(userDataService.isGenderCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00502() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isGenderCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00503() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isGenderCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00504() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(GENDER_CHARACTERISTIC, 0, 0));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isGenderCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00505() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(GENDER_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isGenderCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00506() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(GENDER_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isGenderCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00507() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(GENDER_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertTrue(userDataService.isGenderCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00601() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.emptyList(), null);

        assertFalse(userDataService.isWeightCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00602() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isWeightCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00603() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isWeightCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00604() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(WEIGHT_CHARACTERISTIC, 0, 0));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isWeightCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00605() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(WEIGHT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isWeightCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00606() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(WEIGHT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isWeightCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00607() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(WEIGHT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertTrue(userDataService.isWeightCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00701() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.emptyList(), null);

        assertFalse(userDataService.isHeightCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00702() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isHeightCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00703() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isHeightCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00704() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(HEIGHT_CHARACTERISTIC, 0, 0));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isHeightCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00705() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(HEIGHT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isHeightCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00706() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(HEIGHT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isHeightCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00707() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(HEIGHT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertTrue(userDataService.isHeightCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00801() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.emptyList(), null);

        assertFalse(userDataService.isVO2MaxCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00802() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isVO2MaxCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00803() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isVO2MaxCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00804() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(VO2_MAX_CHARACTERISTIC, 0, 0));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isVO2MaxCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00805() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(VO2_MAX_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isVO2MaxCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00806() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(VO2_MAX_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isVO2MaxCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00807() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(VO2_MAX_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertTrue(userDataService.isVO2MaxCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00901() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.emptyList(), null);

        assertFalse(userDataService.isHeartRateMaxCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00902() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isHeartRateMaxCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00903() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isHeartRateMaxCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00904() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(HEART_RATE_MAX_CHARACTERISTIC, 0, 0));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isHeartRateMaxCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00905() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(HEART_RATE_MAX_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isHeartRateMaxCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00906() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(HEART_RATE_MAX_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isHeartRateMaxCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00907() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(HEART_RATE_MAX_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertTrue(userDataService.isHeartRateMaxCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_01001() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.emptyList(), null);

        assertFalse(userDataService.isRestingHeartRateCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_01002() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isRestingHeartRateCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_01003() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isRestingHeartRateCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_01004() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(RESTING_HEART_RATE_CHARACTERISTIC, 0, 0));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isRestingHeartRateCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_01005() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(RESTING_HEART_RATE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isRestingHeartRateCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_01006() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(RESTING_HEART_RATE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isRestingHeartRateCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_01007() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(RESTING_HEART_RATE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertTrue(userDataService.isRestingHeartRateCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_01101() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.emptyList(), null);

        assertFalse(userDataService.isMaximumRecommendedHeartRateCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_01102() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isMaximumRecommendedHeartRateCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_01103() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isMaximumRecommendedHeartRateCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_01104() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(MAXIMUM_RECOMMENDED_HEART_RATE_CHARACTERISTIC, 0, 0));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isMaximumRecommendedHeartRateCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_01105() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(MAXIMUM_RECOMMENDED_HEART_RATE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isMaximumRecommendedHeartRateCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_01106() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(MAXIMUM_RECOMMENDED_HEART_RATE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isMaximumRecommendedHeartRateCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_01107() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(MAXIMUM_RECOMMENDED_HEART_RATE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertTrue(userDataService.isMaximumRecommendedHeartRateCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_01201() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.emptyList(), null);

        assertFalse(userDataService.isAerobicThresholdCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_01202() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isAerobicThresholdCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_01203() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isAerobicThresholdCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_01204() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(AEROBIC_THRESHOLD_CHARACTERISTIC, 0, 0));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isAerobicThresholdCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_01205() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(AEROBIC_THRESHOLD_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isAerobicThresholdCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_01206() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(AEROBIC_THRESHOLD_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isAerobicThresholdCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_01207() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(AEROBIC_THRESHOLD_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertTrue(userDataService.isAerobicThresholdCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_01301() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.emptyList(), null);

        assertFalse(userDataService.isAnaerobicThresholdCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_01302() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isAnaerobicThresholdCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_01303() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isAnaerobicThresholdCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_01304() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(ANAEROBIC_THRESHOLD_CHARACTERISTIC, 0, 0));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isAnaerobicThresholdCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_01305() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(ANAEROBIC_THRESHOLD_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isAnaerobicThresholdCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_01306() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(ANAEROBIC_THRESHOLD_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isAnaerobicThresholdCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_01307() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(ANAEROBIC_THRESHOLD_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertTrue(userDataService.isAnaerobicThresholdCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_01401() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.emptyList(), null);

        assertFalse(userDataService.isSportTypeForAerobicAndAnaerobicThresholdsCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_01402() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isSportTypeForAerobicAndAnaerobicThresholdsCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_01403() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isSportTypeForAerobicAndAnaerobicThresholdsCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_01404() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(SPORT_TYPE_FOR_AEROBIC_AND_ANAEROBIC_THRESHOLDS_CHARACTERISTIC, 0, 0));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isSportTypeForAerobicAndAnaerobicThresholdsCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_01405() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(SPORT_TYPE_FOR_AEROBIC_AND_ANAEROBIC_THRESHOLDS_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isSportTypeForAerobicAndAnaerobicThresholdsCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_01406() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(SPORT_TYPE_FOR_AEROBIC_AND_ANAEROBIC_THRESHOLDS_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isSportTypeForAerobicAndAnaerobicThresholdsCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_01407() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(SPORT_TYPE_FOR_AEROBIC_AND_ANAEROBIC_THRESHOLDS_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertTrue(userDataService.isSportTypeForAerobicAndAnaerobicThresholdsCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_01501() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.emptyList(), null);

        assertFalse(userDataService.isDateOfThresholdAssessmentCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_01502() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isDateOfThresholdAssessmentCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_01503() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isDateOfThresholdAssessmentCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_01504() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(DATE_OF_THRESHOLD_ASSESSMENT_CHARACTERISTIC, 0, 0));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isDateOfThresholdAssessmentCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_01505() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(DATE_OF_THRESHOLD_ASSESSMENT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isDateOfThresholdAssessmentCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_01506() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(DATE_OF_THRESHOLD_ASSESSMENT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isDateOfThresholdAssessmentCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_01507() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(DATE_OF_THRESHOLD_ASSESSMENT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertTrue(userDataService.isDateOfThresholdAssessmentCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_01601() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.emptyList(), null);

        assertFalse(userDataService.isWaistCircumferenceCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_01602() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isWaistCircumferenceCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_01603() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isWaistCircumferenceCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_01604() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(WAIST_CIRCUMFERENCE_CHARACTERISTIC, 0, 0));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isWaistCircumferenceCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_01605() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(WAIST_CIRCUMFERENCE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isWaistCircumferenceCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_01606() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(WAIST_CIRCUMFERENCE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isWaistCircumferenceCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_01607() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(WAIST_CIRCUMFERENCE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertTrue(userDataService.isWaistCircumferenceCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_01701() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.emptyList(), null);

        assertFalse(userDataService.isHipCircumferenceCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_01702() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isHipCircumferenceCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_01703() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isHipCircumferenceCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_01704() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(HIP_CIRCUMFERENCE_CHARACTERISTIC, 0, 0));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isHipCircumferenceCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_01705() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(HIP_CIRCUMFERENCE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isHipCircumferenceCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_01706() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(HIP_CIRCUMFERENCE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isHipCircumferenceCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_01707() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(HIP_CIRCUMFERENCE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertTrue(userDataService.isHipCircumferenceCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_01801() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.emptyList(), null);

        assertFalse(userDataService.isFatBurnHeartRateLowerLimitCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_01802() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isFatBurnHeartRateLowerLimitCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_01803() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isFatBurnHeartRateLowerLimitCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_01804() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(FAT_BURN_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC, 0, 0));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isFatBurnHeartRateLowerLimitCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_01805() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(FAT_BURN_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isFatBurnHeartRateLowerLimitCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_01806() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(FAT_BURN_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isFatBurnHeartRateLowerLimitCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_01807() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(FAT_BURN_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertTrue(userDataService.isFatBurnHeartRateLowerLimitCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_01901() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.emptyList(), null);

        assertFalse(userDataService.isFatBurnHeartRateUpperLimitCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_01902() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isFatBurnHeartRateUpperLimitCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_01903() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isFatBurnHeartRateUpperLimitCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_01904() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(FAT_BURN_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC, 0, 0));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isFatBurnHeartRateUpperLimitCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_01905() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(FAT_BURN_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isFatBurnHeartRateUpperLimitCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_01906() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(FAT_BURN_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isFatBurnHeartRateUpperLimitCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_01907() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(FAT_BURN_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertTrue(userDataService.isFatBurnHeartRateUpperLimitCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_02001() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.emptyList(), null);

        assertFalse(userDataService.isAerobicHeartRateLowerLimitCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_02002() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isAerobicHeartRateLowerLimitCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_02003() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isAerobicHeartRateLowerLimitCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_02004() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(AEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC, 0, 0));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isAerobicHeartRateLowerLimitCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_02005() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(AEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isAerobicHeartRateLowerLimitCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_02006() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(AEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isAerobicHeartRateLowerLimitCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_02007() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(AEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertTrue(userDataService.isAerobicHeartRateLowerLimitCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_02101() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.emptyList(), null);

        assertFalse(userDataService.isAerobicHeartRateUpperLimitCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_02102() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isAerobicHeartRateUpperLimitCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_02103() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isAerobicHeartRateUpperLimitCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_02104() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(AEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC, 0, 0));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isAerobicHeartRateUpperLimitCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_02105() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(AEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isAerobicHeartRateUpperLimitCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_02106() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(AEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isAerobicHeartRateUpperLimitCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_02107() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(AEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertTrue(userDataService.isAerobicHeartRateUpperLimitCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_02201() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.emptyList(), null);

        assertFalse(userDataService.isAnaerobicHeartRateLowerLimitCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_02202() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isAnaerobicHeartRateLowerLimitCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_02203() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isAnaerobicHeartRateLowerLimitCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_02204() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(ANAEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC, 0, 0));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isAnaerobicHeartRateLowerLimitCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_02205() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(ANAEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isAnaerobicHeartRateLowerLimitCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_02206() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(ANAEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isAnaerobicHeartRateLowerLimitCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_02207() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(ANAEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertTrue(userDataService.isAnaerobicHeartRateLowerLimitCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_02301() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.emptyList(), null);

        assertFalse(userDataService.isAnaerobicHeartRateUpperLimitCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_02302() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isAnaerobicHeartRateUpperLimitCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_02303() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isAnaerobicHeartRateUpperLimitCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_02304() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(ANAEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC, 0, 0));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isAnaerobicHeartRateUpperLimitCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_02305() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(ANAEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isAnaerobicHeartRateUpperLimitCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_02306() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(ANAEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isAnaerobicHeartRateUpperLimitCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_02307() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(ANAEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertTrue(userDataService.isAnaerobicHeartRateUpperLimitCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_02401() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.emptyList(), null);

        assertFalse(userDataService.isFiveZoneHeartRateLimitsCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_02402() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isFiveZoneHeartRateLimitsCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_02403() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isFiveZoneHeartRateLimitsCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_02404() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(FIVE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC, 0, 0));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isFiveZoneHeartRateLimitsCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_02405() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(FIVE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isFiveZoneHeartRateLimitsCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_02406() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(FIVE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isFiveZoneHeartRateLimitsCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_02407() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(FIVE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertTrue(userDataService.isFiveZoneHeartRateLimitsCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_02501() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.emptyList(), null);

        assertFalse(userDataService.isThreeZoneHeartRateLimitsCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_02502() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isThreeZoneHeartRateLimitsCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_02503() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isThreeZoneHeartRateLimitsCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_02504() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(THREE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC, 0, 0));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isThreeZoneHeartRateLimitsCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_02505() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(THREE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isThreeZoneHeartRateLimitsCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_02506() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(THREE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isThreeZoneHeartRateLimitsCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_02507() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(THREE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertTrue(userDataService.isThreeZoneHeartRateLimitsCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_02601() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.emptyList(), null);

        assertFalse(userDataService.isTwoZoneHeartRateLimitCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_02602() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isTwoZoneHeartRateLimitCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_02603() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isTwoZoneHeartRateLimitCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_02604() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(TWO_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC, 0, 0));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isTwoZoneHeartRateLimitCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_02605() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(TWO_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isTwoZoneHeartRateLimitCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_02606() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(TWO_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isTwoZoneHeartRateLimitCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_02607() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(TWO_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertTrue(userDataService.isTwoZoneHeartRateLimitCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_02701() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.emptyList(), null);

        assertFalse(userDataService.isLanguageCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_02702() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isLanguageCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_02703() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isLanguageCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_02704() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(LANGUAGE_CHARACTERISTIC, 0, 0));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isLanguageCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_02705() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(LANGUAGE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isLanguageCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_02706() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(LANGUAGE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isLanguageCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_02707() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(LANGUAGE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertTrue(userDataService.isLanguageCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_02801() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.emptyList(), null);

        assertFalse(userDataService.isDatabaseChangeIncrementCharacteristicNotifySupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_02802() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isDatabaseChangeIncrementCharacteristicNotifySupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_02803() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isDatabaseChangeIncrementCharacteristicNotifySupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_02804() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(DATABASE_CHANGE_INCREMENT_CHARACTERISTIC, 0, 0));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isDatabaseChangeIncrementCharacteristicNotifySupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_02805() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(DATABASE_CHANGE_INCREMENT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0));
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(userDataService.isDatabaseChangeIncrementCharacteristicNotifySupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_02806() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(DATABASE_CHANGE_INCREMENT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        userDataService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertTrue(userDataService.isDatabaseChangeIncrementCharacteristicNotifySupported());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadSuccess_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = FIRST_NAME_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{RegisteredUser.SEGMENTATION_HEADER_FIRST_SEGMENT_TRUE | RegisteredUser.SEGMENTATION_HEADER_LAST_SEGMENT_TRUE
                , RegisteredUser.FLAGS_REGISTERED_USER_NAME_PRESENT_TRUE | RegisteredUser.FLAGS_USER_NAME_TRUNCATED_FALSE
                , 0
                , 5};
        final Bundle originalBundle = new Bundle();
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
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadSuccess_00101() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = LAST_NAME_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{RegisteredUser.SEGMENTATION_HEADER_FIRST_SEGMENT_TRUE | RegisteredUser.SEGMENTATION_HEADER_LAST_SEGMENT_TRUE
                , RegisteredUser.FLAGS_REGISTERED_USER_NAME_PRESENT_TRUE | RegisteredUser.FLAGS_USER_NAME_TRUNCATED_FALSE
                , 0
                , 5};
        final Bundle originalBundle = new Bundle();
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
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadSuccess_00201() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = EMAIL_ADDRESS_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{RegisteredUser.SEGMENTATION_HEADER_FIRST_SEGMENT_TRUE | RegisteredUser.SEGMENTATION_HEADER_LAST_SEGMENT_TRUE
                , RegisteredUser.FLAGS_REGISTERED_USER_NAME_PRESENT_TRUE | RegisteredUser.FLAGS_USER_NAME_TRUNCATED_FALSE
                , 0
                , 5};
        final Bundle originalBundle = new Bundle();
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
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadSuccess_00301() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = AGE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};
        final Bundle originalBundle = new Bundle();
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
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadSuccess_00401() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DATE_OF_BIRTH_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5, 6, 7};
        final Bundle originalBundle = new Bundle();
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
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadSuccess_00501() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = GENDER_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};
        final Bundle originalBundle = new Bundle();
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
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadSuccess_00601() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = WEIGHT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5};
        final Bundle originalBundle = new Bundle();
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
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadSuccess_00701() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HEIGHT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5};
        final Bundle originalBundle = new Bundle();
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
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadSuccess_00801() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = VO2_MAX_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};
        final Bundle originalBundle = new Bundle();
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
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadSuccess_00901() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HEART_RATE_MAX_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};
        final Bundle originalBundle = new Bundle();
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
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadSuccess_01001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = RESTING_HEART_RATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};
        final Bundle originalBundle = new Bundle();
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
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadSuccess_01101() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = MAXIMUM_RECOMMENDED_HEART_RATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};
        final Bundle originalBundle = new Bundle();
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
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadSuccess_01201() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = AEROBIC_THRESHOLD_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};
        final Bundle originalBundle = new Bundle();
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
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadSuccess_01301() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANAEROBIC_THRESHOLD_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};
        final Bundle originalBundle = new Bundle();
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
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadSuccess_01401() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = SPORT_TYPE_FOR_AEROBIC_AND_ANAEROBIC_THRESHOLDS_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};
        final Bundle originalBundle = new Bundle();
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
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadSuccess_01501() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DATE_OF_THRESHOLD_ASSESSMENT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5, 6, 7};
        final Bundle originalBundle = new Bundle();
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
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadSuccess_01601() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = WAIST_CIRCUMFERENCE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5};
        final Bundle originalBundle = new Bundle();
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
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadSuccess_01701() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HIP_CIRCUMFERENCE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5};
        final Bundle originalBundle = new Bundle();
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
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadSuccess_01801() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = FAT_BURN_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};
        final Bundle originalBundle = new Bundle();
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
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadSuccess_01901() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = FAT_BURN_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};
        final Bundle originalBundle = new Bundle();
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
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadSuccess_02001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = AEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};
        final Bundle originalBundle = new Bundle();
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
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadSuccess_02101() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = AEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};
        final Bundle originalBundle = new Bundle();
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
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadSuccess_02201() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANAEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};
        final Bundle originalBundle = new Bundle();
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
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadSuccess_02301() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANAEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};
        final Bundle originalBundle = new Bundle();
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
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadSuccess_02401() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = FIVE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5, 6, 7};
        final Bundle originalBundle = new Bundle();
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
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadSuccess_02501() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = THREE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5};
        final Bundle originalBundle = new Bundle();
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
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadSuccess_02601() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TWO_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};
        final Bundle originalBundle = new Bundle();
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
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadSuccess_02701() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = LANGUAGE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};
        final Bundle originalBundle = new Bundle();
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
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadSuccess_02801() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DATABASE_CHANGE_INCREMENT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5, 6, 7};
        final Bundle originalBundle = new Bundle();
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
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadSuccess_02901() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = USER_INDEX_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};
        final Bundle originalBundle = new Bundle();
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
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadFailed_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = FIRST_NAME_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
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
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadFailed_00101() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = LAST_NAME_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
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
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadFailed_00201() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = EMAIL_ADDRESS_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
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
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadFailed_00301() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = AGE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
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
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadFailed_00401() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DATE_OF_BIRTH_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
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
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadFailed_00501() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = GENDER_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
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
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadFailed_00601() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = WEIGHT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
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
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadFailed_00701() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HEIGHT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
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
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadFailed_00801() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = VO2_MAX_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
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
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadFailed_00901() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HEART_RATE_MAX_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
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
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadFailed_01001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = RESTING_HEART_RATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
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
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadFailed_01101() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = MAXIMUM_RECOMMENDED_HEART_RATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
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
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadFailed_01201() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = AEROBIC_THRESHOLD_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
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
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadFailed_01301() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANAEROBIC_THRESHOLD_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
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
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadFailed_01401() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = SPORT_TYPE_FOR_AEROBIC_AND_ANAEROBIC_THRESHOLDS_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
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
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadFailed_01501() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DATE_OF_THRESHOLD_ASSESSMENT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
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
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadFailed_01601() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = WAIST_CIRCUMFERENCE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
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
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadFailed_01701() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HIP_CIRCUMFERENCE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
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
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadFailed_01801() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = FAT_BURN_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
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
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadFailed_01901() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = FAT_BURN_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
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
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadFailed_02001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = AEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
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
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadFailed_02101() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = AEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
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
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadFailed_02201() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANAEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
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
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadFailed_02301() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANAEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
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
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadFailed_02401() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = FIVE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
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
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadFailed_02501() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = THREE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
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
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadFailed_02601() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TWO_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
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
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadFailed_02701() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = LANGUAGE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
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
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadFailed_02801() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DATABASE_CHANGE_INCREMENT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
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
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadFailed_02901() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = USER_INDEX_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
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
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadTimeout_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = FIRST_NAME_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
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
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadTimeout_00101() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = LAST_NAME_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
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
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadTimeout_00201() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = EMAIL_ADDRESS_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
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
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadTimeout_00301() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = AGE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
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
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadTimeout_00401() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DATE_OF_BIRTH_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
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
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadTimeout_00501() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = GENDER_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
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
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadTimeout_00601() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = WEIGHT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
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
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadTimeout_00701() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HEIGHT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
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
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadTimeout_00801() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = VO2_MAX_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
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
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadTimeout_00901() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HEART_RATE_MAX_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
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
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadTimeout_01001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = RESTING_HEART_RATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
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
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadTimeout_01101() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = MAXIMUM_RECOMMENDED_HEART_RATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
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
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadTimeout_01201() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = AEROBIC_THRESHOLD_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
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
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadTimeout_01301() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANAEROBIC_THRESHOLD_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
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
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadTimeout_01401() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = SPORT_TYPE_FOR_AEROBIC_AND_ANAEROBIC_THRESHOLDS_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
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
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadTimeout_01501() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DATE_OF_THRESHOLD_ASSESSMENT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
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
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadTimeout_01601() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = WAIST_CIRCUMFERENCE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
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
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadTimeout_01701() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HIP_CIRCUMFERENCE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
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
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadTimeout_01801() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = FAT_BURN_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
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
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadTimeout_01901() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = FAT_BURN_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
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
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadTimeout_02001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = AEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
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
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadTimeout_02101() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = AEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
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
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadTimeout_02201() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANAEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
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
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadTimeout_02301() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANAEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
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
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadTimeout_02401() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = FIVE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
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
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadTimeout_02501() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = THREE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
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
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadTimeout_02601() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TWO_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
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
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadTimeout_02701() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = LANGUAGE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
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
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadTimeout_02801() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DATABASE_CHANGE_INCREMENT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
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
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadTimeout_02901() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = USER_DATA_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = USER_INDEX_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
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
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, mockUserDataServiceCallback, null);
        userDataService.onCharacteristicReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

}
