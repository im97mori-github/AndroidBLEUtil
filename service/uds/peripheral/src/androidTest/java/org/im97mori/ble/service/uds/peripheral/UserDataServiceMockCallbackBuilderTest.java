package org.im97mori.ble.service.uds.peripheral;

import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;

import org.im97mori.ble.MockData;
import org.im97mori.ble.characteristic.u2a7e.AerobicHeartRateLowerLimit;
import org.im97mori.ble.characteristic.u2a7f.AerobicThreshold;
import org.im97mori.ble.characteristic.u2a80.Age;
import org.im97mori.ble.characteristic.u2a81.AnaerobicHeartRateLowerLimit;
import org.im97mori.ble.characteristic.u2a82.AnaerobicHeartRateUpperLimit;
import org.im97mori.ble.characteristic.u2a83.AnaerobicThreshold;
import org.im97mori.ble.characteristic.u2a84.AerobicHeartRateUpperLimit;
import org.im97mori.ble.characteristic.u2a85.DateOfBirth;
import org.im97mori.ble.characteristic.u2a86.DateOfThresholdAssessment;
import org.im97mori.ble.characteristic.u2a87.EmailAddress;
import org.im97mori.ble.characteristic.u2a88.FatBurnHeartRateLowerLimit;
import org.im97mori.ble.characteristic.u2a89.FatBurnHeartRateUpperLimit;
import org.im97mori.ble.characteristic.u2a8a.FirstName;
import org.im97mori.ble.characteristic.u2a8b.FiveZoneHeartRateLimits;
import org.im97mori.ble.characteristic.u2a8c.Gender;
import org.im97mori.ble.characteristic.u2a8d.HeartRateMax;
import org.im97mori.ble.characteristic.u2a8e.Height;
import org.im97mori.ble.characteristic.u2a8f.HipCircumference;
import org.im97mori.ble.characteristic.u2a90.LastName;
import org.im97mori.ble.characteristic.u2a91.MaximumRecommendedHeartRate;
import org.im97mori.ble.characteristic.u2a92.RestingHeartRate;
import org.im97mori.ble.characteristic.u2a93.SportTypeForAerobicAndAnaerobicThresholds;
import org.im97mori.ble.characteristic.u2a94.ThreeZoneHeartRateLimits;
import org.im97mori.ble.characteristic.u2a95.TwoZoneHeartRateLimit;
import org.im97mori.ble.characteristic.u2a96.VO2Max;
import org.im97mori.ble.characteristic.u2a97.WaistCircumference;
import org.im97mori.ble.characteristic.u2a98.Weight;
import org.im97mori.ble.characteristic.u2a9f.UserControlPoint;
import org.im97mori.ble.characteristic.u2aa2.Language;
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfiguration;
import org.im97mori.ble.test.BLETestUtilsAndroid;
import org.im97mori.ble.test.peripheral.AbstractPeripherallTest;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

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
import static org.im97mori.ble.constants.CharacteristicUUID.USER_CONTROL_POINT_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.USER_INDEX_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.VO2_MAX_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.WAIST_CIRCUMFERENCE_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.WEIGHT_CHARACTERISTIC;
import static org.im97mori.ble.constants.DescriptorUUID.CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
import static org.im97mori.ble.constants.ServiceUUID.USER_DATA_SERVICE;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

@SuppressWarnings("ConstantConditions")
public class UserDataServiceMockCallbackBuilderTest extends AbstractPeripherallTest {

    @Test
    public void test_exception_00001() {
        Exception exception = null;
        try {
            new UserDataServiceMockCallback.Builder<>().build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("At least one UDS Characteristic shall be exposed", exception.getMessage());
    }

    @Test
    public void test_exception_00002() {
        Exception exception = null;
        try {
            new UserDataServiceMockCallback.Builder<>()
                    .addFirstName("First Name")
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Database Change Increment data", exception.getMessage());
    }

    @Test
    public void test_exception_00003() {
        Exception exception = null;
        try {
            new UserDataServiceMockCallback.Builder<>()
                    .addFirstName("First Name")
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no User Index data", exception.getMessage());
    }

    @Test
    public void test_exception_00004() {
        Exception exception = null;
        try {
            new UserDataServiceMockCallback.Builder<>()
                    .addFirstName("First Name")
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no User Control Point data", exception.getMessage());
    }

    @Test
    public void test_exception_00005() {
        Exception exception = null;
        try {
            new UserDataServiceMockCallback.Builder<>()
                    .addFirstName("First Name")
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Registered User data", exception.getMessage());
    }

    @Test
    public void test_exception_00006() {
        Exception exception = null;
        try {
            new UserDataServiceMockCallback.Builder<>()
                    .addFirstName("First Name")
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_addFirstName_00001() {
        String firstNameString = "First Name";
        FirstName firstName = new FirstName(firstNameString);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            UserDataServiceMockCallback userDataServiceMockCallback = new UserDataServiceMockCallback.Builder<>()
                    .addFirstName(firstNameString)
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            userDataServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(USER_DATA_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(FIRST_NAME_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(FIRST_NAME_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(firstName.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_addFirstName_00101() {
        String firstNameString = "First Name";
        FirstName firstName = new FirstName(firstNameString);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            UserDataServiceMockCallback userDataServiceMockCallback = new UserDataServiceMockCallback.Builder<>()
                    .addFirstName(firstName)
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            userDataServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(USER_DATA_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(FIRST_NAME_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(FIRST_NAME_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(firstName.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_addFirstName_00201() {
        String firstNameString = "First Name";
        FirstName firstName = new FirstName(firstNameString);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            UserDataServiceMockCallback userDataServiceMockCallback = new UserDataServiceMockCallback.Builder<>()
                    .addFirstName(firstName.getBytes())
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            userDataServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(USER_DATA_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(FIRST_NAME_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(FIRST_NAME_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(firstName.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_addFirstName_00301() {
        String firstNameString = "First Name";
        FirstName firstName = new FirstName(firstNameString);
        int responseCode = 1;
        long delay = 2;

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            UserDataServiceMockCallback userDataServiceMockCallback = new UserDataServiceMockCallback.Builder<>()
                    .addFirstName(responseCode, delay, firstName.getBytes())
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            userDataServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(USER_DATA_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(FIRST_NAME_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(FIRST_NAME_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(firstName.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_removeFirstName_00001() {
        String firstNameString = "First Name";
        FirstName firstName = new FirstName(firstNameString);

        Exception exception = null;
        try {
            new UserDataServiceMockCallback.Builder<>()
                    .addFirstName(firstName)
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .removeFirstName()
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("At least one UDS Characteristic shall be exposed", exception.getMessage());
    }

    @Test
    public void test_addLastName_00001() {
        String lastNameString = "Last Name";
        LastName lastName = new LastName(lastNameString);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            UserDataServiceMockCallback userDataServiceMockCallback = new UserDataServiceMockCallback.Builder<>()
                    .addLastName(lastNameString)
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            userDataServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(USER_DATA_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(LAST_NAME_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(LAST_NAME_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(lastName.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_addLastName_00101() {
        String lastNameString = "Last Name";
        LastName lastName = new LastName(lastNameString);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            UserDataServiceMockCallback userDataServiceMockCallback = new UserDataServiceMockCallback.Builder<>()
                    .addLastName(lastName)
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            userDataServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(USER_DATA_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(LAST_NAME_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(LAST_NAME_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(lastName.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_addLastName_00201() {
        String lastNameString = "Last Name";
        LastName lastName = new LastName(lastNameString);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            UserDataServiceMockCallback userDataServiceMockCallback = new UserDataServiceMockCallback.Builder<>()
                    .addLastName(lastName.getBytes())
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            userDataServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(USER_DATA_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(LAST_NAME_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(LAST_NAME_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(lastName.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_addLastName_00301() {
        String lastNameString = "Last Name";
        LastName lastName = new LastName(lastNameString);
        int responseCode = 1;
        long delay = 2;

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            UserDataServiceMockCallback userDataServiceMockCallback = new UserDataServiceMockCallback.Builder<>()
                    .addLastName(responseCode, delay, lastName.getBytes())
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            userDataServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(USER_DATA_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(LAST_NAME_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(LAST_NAME_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(lastName.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_removeLastName_00001() {
        String lastNameString = "Last Name";
        LastName lastName = new LastName(lastNameString);

        Exception exception = null;
        try {
            new UserDataServiceMockCallback.Builder<>()
                    .addLastName(lastName)
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .removeLastName()
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("At least one UDS Characteristic shall be exposed", exception.getMessage());
    }

    @Test
    public void test_addEmailAddress_00001() {
        String emailAddressString = "Email Address";
        EmailAddress emailAddress = new EmailAddress(emailAddressString);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            UserDataServiceMockCallback userDataServiceMockCallback = new UserDataServiceMockCallback.Builder<>()
                    .addEmailAddress(emailAddressString)
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            userDataServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(USER_DATA_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(EMAIL_ADDRESS_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(EMAIL_ADDRESS_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(emailAddress.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_addEmailAddress_00101() {
        String emailAddressString = "Email Address";
        EmailAddress emailAddress = new EmailAddress(emailAddressString);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            UserDataServiceMockCallback userDataServiceMockCallback = new UserDataServiceMockCallback.Builder<>()
                    .addEmailAddress(emailAddress)
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            userDataServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(USER_DATA_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(EMAIL_ADDRESS_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(EMAIL_ADDRESS_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(emailAddress.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_addEmailAddress_00201() {
        String emailAddressString = "Email Address";
        EmailAddress emailAddress = new EmailAddress(emailAddressString);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            UserDataServiceMockCallback userDataServiceMockCallback = new UserDataServiceMockCallback.Builder<>()
                    .addEmailAddress(emailAddress.getBytes())
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            userDataServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(USER_DATA_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(EMAIL_ADDRESS_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(EMAIL_ADDRESS_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(emailAddress.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_addEmailAddress_00301() {
        String emailAddressString = "Email Address";
        EmailAddress emailAddress = new EmailAddress(emailAddressString);
        int responseCode = 1;
        long delay = 2;

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            UserDataServiceMockCallback userDataServiceMockCallback = new UserDataServiceMockCallback.Builder<>()
                    .addEmailAddress(responseCode, delay, emailAddress.getBytes())
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            userDataServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(USER_DATA_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(EMAIL_ADDRESS_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(EMAIL_ADDRESS_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(emailAddress.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_removeEmailAddress_00001() {
        String emailAddressString = "Email Address";
        EmailAddress emailAddress = new EmailAddress(emailAddressString);

        Exception exception = null;
        try {
            new UserDataServiceMockCallback.Builder<>()
                    .addEmailAddress(emailAddress)
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .removeEmailAddress()
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("At least one UDS Characteristic shall be exposed", exception.getMessage());
    }

    @Test
    public void test_addAge_00001() {
        int ageInt = 1;
        Age age = new Age(ageInt);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            UserDataServiceMockCallback userDataServiceMockCallback = new UserDataServiceMockCallback.Builder<>()
                    .addAge(ageInt)
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            userDataServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(USER_DATA_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(AGE_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(AGE_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(age.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_addAge_00101() {
        int ageInt = 1;
        Age age = new Age(ageInt);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            UserDataServiceMockCallback userDataServiceMockCallback = new UserDataServiceMockCallback.Builder<>()
                    .addAge(age)
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            userDataServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(USER_DATA_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(AGE_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(AGE_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(age.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_addAge_00201() {
        int ageInt = 1;
        Age age = new Age(ageInt);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            UserDataServiceMockCallback userDataServiceMockCallback = new UserDataServiceMockCallback.Builder<>()
                    .addAge(age.getBytes())
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            userDataServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(USER_DATA_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(AGE_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(AGE_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(age.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_addAge_00301() {
        int ageInt = 1;
        Age age = new Age(ageInt);
        int responseCode = 1;
        long delay = 2;

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            UserDataServiceMockCallback userDataServiceMockCallback = new UserDataServiceMockCallback.Builder<>()
                    .addAge(responseCode, delay, age.getBytes())
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            userDataServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(USER_DATA_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(AGE_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(AGE_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(age.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_removeAge_00001() {
        int ageInt = 1;
        Age age = new Age(ageInt);

        Exception exception = null;
        try {
            new UserDataServiceMockCallback.Builder<>()
                    .addAge(age)
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .removeAge()
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("At least one UDS Characteristic shall be exposed", exception.getMessage());
    }

    @Test
    public void test_addDateOfBirth_00001() {
        int yearInt = 1;
        int monthInt = 2;
        int dayInt = 3;
        DateOfBirth dateOfBirth = new DateOfBirth(yearInt, monthInt, dayInt);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            UserDataServiceMockCallback userDataServiceMockCallback = new UserDataServiceMockCallback.Builder<>()
                    .addDateOfBirth(yearInt, monthInt, dayInt)
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            userDataServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(USER_DATA_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(DATE_OF_BIRTH_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(DATE_OF_BIRTH_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(dateOfBirth.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_addDateOfBirth_00101() {
        int yearInt = 1;
        int monthInt = 2;
        int dayInt = 3;
        DateOfBirth dateOfBirth = new DateOfBirth(yearInt, monthInt, dayInt);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            UserDataServiceMockCallback userDataServiceMockCallback = new UserDataServiceMockCallback.Builder<>()
                    .addDateOfBirth(dateOfBirth)
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            userDataServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(USER_DATA_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(DATE_OF_BIRTH_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(DATE_OF_BIRTH_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(dateOfBirth.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_addDateOfBirth_00201() {
        int yearInt = 1;
        int monthInt = 2;
        int dayInt = 3;
        DateOfBirth dateOfBirth = new DateOfBirth(yearInt, monthInt, dayInt);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            UserDataServiceMockCallback userDataServiceMockCallback = new UserDataServiceMockCallback.Builder<>()
                    .addDateOfBirth(dateOfBirth.getBytes())
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            userDataServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(USER_DATA_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(DATE_OF_BIRTH_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(DATE_OF_BIRTH_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(dateOfBirth.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_addDateOfBirth_00301() {
        int yearInt = 1;
        int monthInt = 2;
        int dayInt = 3;
        DateOfBirth dateOfBirth = new DateOfBirth(yearInt, monthInt, dayInt);
        int responseCode = 1;
        long delay = 2;

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            UserDataServiceMockCallback userDataServiceMockCallback = new UserDataServiceMockCallback.Builder<>()
                    .addDateOfBirth(responseCode, delay, dateOfBirth.getBytes())
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            userDataServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(USER_DATA_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(DATE_OF_BIRTH_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(DATE_OF_BIRTH_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(dateOfBirth.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_removeDateOfBirth_00001() {
        int yearInt = 1;
        int monthInt = 2;
        int dayInt = 3;
        DateOfBirth dateOfBirth = new DateOfBirth(yearInt, monthInt, dayInt);

        Exception exception = null;
        try {
            new UserDataServiceMockCallback.Builder<>()
                    .addDateOfBirth(dateOfBirth)
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .removeDateOfBirth()
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("At least one UDS Characteristic shall be exposed", exception.getMessage());
    }

    @Test
    public void test_addGender_00001() {
        int genderInt = Gender.GENDER_MALE;
        Gender gender = new Gender(genderInt);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            UserDataServiceMockCallback userDataServiceMockCallback = new UserDataServiceMockCallback.Builder<>()
                    .addGender(genderInt)
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            userDataServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(USER_DATA_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(GENDER_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(GENDER_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(gender.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_addGender_00101() {
        int genderInt = Gender.GENDER_MALE;
        Gender gender = new Gender(genderInt);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            UserDataServiceMockCallback userDataServiceMockCallback = new UserDataServiceMockCallback.Builder<>()
                    .addGender(gender)
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            userDataServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(USER_DATA_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(GENDER_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(GENDER_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(gender.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_addGender_00201() {
        int genderInt = Gender.GENDER_MALE;
        Gender gender = new Gender(genderInt);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            UserDataServiceMockCallback userDataServiceMockCallback = new UserDataServiceMockCallback.Builder<>()
                    .addGender(gender.getBytes())
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            userDataServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(USER_DATA_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(GENDER_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(GENDER_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(gender.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_addGender_00301() {
        int genderInt = Gender.GENDER_MALE;
        Gender gender = new Gender(genderInt);
        int responseCode = 1;
        long delay = 2;

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            UserDataServiceMockCallback userDataServiceMockCallback = new UserDataServiceMockCallback.Builder<>()
                    .addGender(responseCode, delay, gender.getBytes())
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            userDataServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(USER_DATA_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(GENDER_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(GENDER_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(gender.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_removeGender_00001() {
        int genderInt = Gender.GENDER_MALE;
        Gender gender = new Gender(genderInt);

        Exception exception = null;
        try {
            new UserDataServiceMockCallback.Builder<>()
                    .addGender(gender)
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .removeGender()
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("At least one UDS Characteristic shall be exposed", exception.getMessage());
    }

    @Test
    public void test_addWeight_00001() {
        int weightInt = 1;
        Weight weight = new Weight(weightInt);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            UserDataServiceMockCallback userDataServiceMockCallback = new UserDataServiceMockCallback.Builder<>()
                    .addWeight(weightInt)
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            userDataServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(USER_DATA_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(WEIGHT_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(WEIGHT_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(weight.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_addWeight_00101() {
        int weightInt = 1;
        Weight weight = new Weight(weightInt);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            UserDataServiceMockCallback userDataServiceMockCallback = new UserDataServiceMockCallback.Builder<>()
                    .addWeight(weight)
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            userDataServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(USER_DATA_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(WEIGHT_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(WEIGHT_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(weight.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_addWeight_00201() {
        int weightInt = 1;
        Weight weight = new Weight(weightInt);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            UserDataServiceMockCallback userDataServiceMockCallback = new UserDataServiceMockCallback.Builder<>()
                    .addWeight(weight.getBytes())
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            userDataServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(USER_DATA_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(WEIGHT_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(WEIGHT_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(weight.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_addWeight_00301() {
        int weightInt = 1;
        Weight weight = new Weight(weightInt);
        int responseCode = 1;
        long delay = 2;

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            UserDataServiceMockCallback userDataServiceMockCallback = new UserDataServiceMockCallback.Builder<>()
                    .addWeight(responseCode, delay, weight.getBytes())
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            userDataServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(USER_DATA_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(WEIGHT_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(WEIGHT_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(weight.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_removeWeight_00001() {
        int weightInt = 1;
        Weight weight = new Weight(weightInt);

        Exception exception = null;
        try {
            new UserDataServiceMockCallback.Builder<>()
                    .addWeight(weight)
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .removeWeight()
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("At least one UDS Characteristic shall be exposed", exception.getMessage());
    }

    @Test
    public void test_addHeight_00001() {
        int heightInt = 1;
        Height height = new Height(heightInt);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            UserDataServiceMockCallback userDataServiceMockCallback = new UserDataServiceMockCallback.Builder<>()
                    .addHeight(heightInt)
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            userDataServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(USER_DATA_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(HEIGHT_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(HEIGHT_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(height.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_addHeight_00101() {
        int heightInt = 1;
        Height height = new Height(heightInt);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            UserDataServiceMockCallback userDataServiceMockCallback = new UserDataServiceMockCallback.Builder<>()
                    .addHeight(height)
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            userDataServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(USER_DATA_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(HEIGHT_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(HEIGHT_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(height.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_addHeight_00201() {
        int heightInt = 1;
        Height height = new Height(heightInt);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            UserDataServiceMockCallback userDataServiceMockCallback = new UserDataServiceMockCallback.Builder<>()
                    .addHeight(height.getBytes())
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            userDataServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(USER_DATA_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(HEIGHT_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(HEIGHT_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(height.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_addHeight_00301() {
        int heightInt = 1;
        Height height = new Height(heightInt);
        int responseCode = 1;
        long delay = 2;

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            UserDataServiceMockCallback userDataServiceMockCallback = new UserDataServiceMockCallback.Builder<>()
                    .addHeight(responseCode, delay, height.getBytes())
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            userDataServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(USER_DATA_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(HEIGHT_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(HEIGHT_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(height.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_removeHeight_00001() {
        int heightInt = 1;
        Height height = new Height(heightInt);

        Exception exception = null;
        try {
            new UserDataServiceMockCallback.Builder<>()
                    .addHeight(height)
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .removeHeight()
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("At least one UDS Characteristic shall be exposed", exception.getMessage());
    }

    @Test
    public void test_addVO2Max_00001() {
        int vo2MaxInt = 1;
        VO2Max vo2Max = new VO2Max(vo2MaxInt);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            UserDataServiceMockCallback userDataServiceMockCallback = new UserDataServiceMockCallback.Builder<>()
                    .addVO2Max(vo2MaxInt)
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            userDataServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(USER_DATA_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(VO2_MAX_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(VO2_MAX_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(vo2Max.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_addVO2Max_00101() {
        int vo2MaxInt = 1;
        VO2Max vo2Max = new VO2Max(vo2MaxInt);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            UserDataServiceMockCallback userDataServiceMockCallback = new UserDataServiceMockCallback.Builder<>()
                    .addVO2Max(vo2Max)
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            userDataServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(USER_DATA_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(VO2_MAX_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(VO2_MAX_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(vo2Max.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_addVO2Max_00201() {
        int vo2MaxInt = 1;
        VO2Max vo2Max = new VO2Max(vo2MaxInt);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            UserDataServiceMockCallback userDataServiceMockCallback = new UserDataServiceMockCallback.Builder<>()
                    .addVO2Max(vo2Max.getBytes())
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            userDataServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(USER_DATA_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(VO2_MAX_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(VO2_MAX_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(vo2Max.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_addVO2Max_00301() {
        int vo2MaxInt = 1;
        VO2Max vo2Max = new VO2Max(vo2MaxInt);
        int responseCode = 1;
        long delay = 2;

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            UserDataServiceMockCallback userDataServiceMockCallback = new UserDataServiceMockCallback.Builder<>()
                    .addVO2Max(responseCode, delay, vo2Max.getBytes())
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            userDataServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(USER_DATA_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(VO2_MAX_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(VO2_MAX_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(vo2Max.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_removeVO2Max_00001() {
        int vo2MaxInt = 1;
        VO2Max vo2Max = new VO2Max(vo2MaxInt);

        Exception exception = null;
        try {
            new UserDataServiceMockCallback.Builder<>()
                    .addVO2Max(vo2Max)
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .removeVO2Max()
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("At least one UDS Characteristic shall be exposed", exception.getMessage());
    }

    @Test
    public void test_addHeartRateMax_00001() {
        int heartRateMaxInt = 1;
        HeartRateMax heartRateMax = new HeartRateMax(heartRateMaxInt);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            UserDataServiceMockCallback userDataServiceMockCallback = new UserDataServiceMockCallback.Builder<>()
                    .addHeartRateMax(heartRateMaxInt)
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            userDataServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(USER_DATA_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(HEART_RATE_MAX_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(HEART_RATE_MAX_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(heartRateMax.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_addHeartRateMax_00101() {
        int heartRateMaxInt = 1;
        HeartRateMax heartRateMax = new HeartRateMax(heartRateMaxInt);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            UserDataServiceMockCallback userDataServiceMockCallback = new UserDataServiceMockCallback.Builder<>()
                    .addHeartRateMax(heartRateMax)
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            userDataServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(USER_DATA_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(HEART_RATE_MAX_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(HEART_RATE_MAX_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(heartRateMax.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_addHeartRateMax_00201() {
        int heartRateMaxInt = 1;
        HeartRateMax heartRateMax = new HeartRateMax(heartRateMaxInt);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            UserDataServiceMockCallback userDataServiceMockCallback = new UserDataServiceMockCallback.Builder<>()
                    .addHeartRateMax(heartRateMax.getBytes())
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            userDataServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(USER_DATA_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(HEART_RATE_MAX_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(HEART_RATE_MAX_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(heartRateMax.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_addHeartRateMax_00301() {
        int heartRateMaxInt = 1;
        HeartRateMax heartRateMax = new HeartRateMax(heartRateMaxInt);
        int responseCode = 1;
        long delay = 2;

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            UserDataServiceMockCallback userDataServiceMockCallback = new UserDataServiceMockCallback.Builder<>()
                    .addHeartRateMax(responseCode, delay, heartRateMax.getBytes())
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            userDataServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(USER_DATA_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(HEART_RATE_MAX_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(HEART_RATE_MAX_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(heartRateMax.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_removeHeartRateMax_00001() {
        int heartRateMaxInt = 1;
        HeartRateMax heartRateMax = new HeartRateMax(heartRateMaxInt);

        Exception exception = null;
        try {
            new UserDataServiceMockCallback.Builder<>()
                    .addHeartRateMax(heartRateMax)
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .removeHeartRateMax()
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("At least one UDS Characteristic shall be exposed", exception.getMessage());
    }

    @Test
    public void test_addRestingHeartRate_00001() {
        int restingHeartRateInt = 1;
        RestingHeartRate restingHeartRate = new RestingHeartRate(restingHeartRateInt);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            UserDataServiceMockCallback userDataServiceMockCallback = new UserDataServiceMockCallback.Builder<>()
                    .addRestingHeartRate(restingHeartRateInt)
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            userDataServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(USER_DATA_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(RESTING_HEART_RATE_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(RESTING_HEART_RATE_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(restingHeartRate.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_addRestingHeartRate_00101() {
        int restingHeartRateInt = 1;
        RestingHeartRate restingHeartRate = new RestingHeartRate(restingHeartRateInt);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            UserDataServiceMockCallback userDataServiceMockCallback = new UserDataServiceMockCallback.Builder<>()
                    .addRestingHeartRate(restingHeartRate)
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            userDataServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(USER_DATA_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(RESTING_HEART_RATE_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(RESTING_HEART_RATE_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(restingHeartRate.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_addRestingHeartRate_00201() {
        int restingHeartRateInt = 1;
        RestingHeartRate restingHeartRate = new RestingHeartRate(restingHeartRateInt);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            UserDataServiceMockCallback userDataServiceMockCallback = new UserDataServiceMockCallback.Builder<>()
                    .addRestingHeartRate(restingHeartRate.getBytes())
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            userDataServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(USER_DATA_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(RESTING_HEART_RATE_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(RESTING_HEART_RATE_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(restingHeartRate.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_addRestingHeartRate_00301() {
        int restingHeartRateInt = 1;
        RestingHeartRate restingHeartRate = new RestingHeartRate(restingHeartRateInt);
        int responseCode = 1;
        long delay = 2;

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            UserDataServiceMockCallback userDataServiceMockCallback = new UserDataServiceMockCallback.Builder<>()
                    .addRestingHeartRate(responseCode, delay, restingHeartRate.getBytes())
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            userDataServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(USER_DATA_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(RESTING_HEART_RATE_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(RESTING_HEART_RATE_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(restingHeartRate.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_removeRestingHeartRate_00001() {
        int restingHeartRateInt = 1;
        RestingHeartRate restingHeartRate = new RestingHeartRate(restingHeartRateInt);

        Exception exception = null;
        try {
            new UserDataServiceMockCallback.Builder<>()
                    .addRestingHeartRate(restingHeartRate)
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .removeRestingHeartRate()
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("At least one UDS Characteristic shall be exposed", exception.getMessage());
    }

    @Test
    public void test_addMaximumRecommendedHeartRate_00001() {
        int maximumRecommendedHeartRateInt = 1;
        MaximumRecommendedHeartRate maximumRecommendedHeartRate = new MaximumRecommendedHeartRate(maximumRecommendedHeartRateInt);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            UserDataServiceMockCallback userDataServiceMockCallback = new UserDataServiceMockCallback.Builder<>()
                    .addMaximumRecommendedHeartRate(maximumRecommendedHeartRateInt)
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            userDataServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(USER_DATA_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(MAXIMUM_RECOMMENDED_HEART_RATE_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(MAXIMUM_RECOMMENDED_HEART_RATE_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(maximumRecommendedHeartRate.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_addMaximumRecommendedHeartRate_00101() {
        int maximumRecommendedHeartRateInt = 1;
        MaximumRecommendedHeartRate maximumRecommendedHeartRate = new MaximumRecommendedHeartRate(maximumRecommendedHeartRateInt);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            UserDataServiceMockCallback userDataServiceMockCallback = new UserDataServiceMockCallback.Builder<>()
                    .addMaximumRecommendedHeartRate(maximumRecommendedHeartRate)
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            userDataServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(USER_DATA_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(MAXIMUM_RECOMMENDED_HEART_RATE_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(MAXIMUM_RECOMMENDED_HEART_RATE_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(maximumRecommendedHeartRate.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_addMaximumRecommendedHeartRate_00201() {
        int maximumRecommendedHeartRateInt = 1;
        MaximumRecommendedHeartRate maximumRecommendedHeartRate = new MaximumRecommendedHeartRate(maximumRecommendedHeartRateInt);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            UserDataServiceMockCallback userDataServiceMockCallback = new UserDataServiceMockCallback.Builder<>()
                    .addMaximumRecommendedHeartRate(maximumRecommendedHeartRate.getBytes())
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            userDataServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(USER_DATA_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(MAXIMUM_RECOMMENDED_HEART_RATE_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(MAXIMUM_RECOMMENDED_HEART_RATE_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(maximumRecommendedHeartRate.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_addMaximumRecommendedHeartRate_00301() {
        int maximumRecommendedHeartRateInt = 1;
        MaximumRecommendedHeartRate maximumRecommendedHeartRate = new MaximumRecommendedHeartRate(maximumRecommendedHeartRateInt);
        int responseCode = 1;
        long delay = 2;

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            UserDataServiceMockCallback userDataServiceMockCallback = new UserDataServiceMockCallback.Builder<>()
                    .addMaximumRecommendedHeartRate(responseCode, delay, maximumRecommendedHeartRate.getBytes())
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            userDataServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(USER_DATA_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(MAXIMUM_RECOMMENDED_HEART_RATE_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(MAXIMUM_RECOMMENDED_HEART_RATE_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(maximumRecommendedHeartRate.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_removeMaximumRecommendedHeartRate_00001() {
        int maximumRecommendedHeartRateInt = 1;
        MaximumRecommendedHeartRate maximumRecommendedHeartRate = new MaximumRecommendedHeartRate(maximumRecommendedHeartRateInt);

        Exception exception = null;
        try {
            new UserDataServiceMockCallback.Builder<>()
                    .addMaximumRecommendedHeartRate(maximumRecommendedHeartRate)
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .removeMaximumRecommendedHeartRate()
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("At least one UDS Characteristic shall be exposed", exception.getMessage());
    }

    @Test
    public void test_addAerobicThreshold_00001() {
        int aerobicThresholdInt = 1;
        AerobicThreshold aerobicThreshold = new AerobicThreshold(aerobicThresholdInt);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            UserDataServiceMockCallback userDataServiceMockCallback = new UserDataServiceMockCallback.Builder<>()
                    .addAerobicThreshold(aerobicThresholdInt)
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            userDataServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(USER_DATA_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(AEROBIC_THRESHOLD_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(AEROBIC_THRESHOLD_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(aerobicThreshold.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_addAerobicThreshold_00101() {
        int aerobicThresholdInt = 1;
        AerobicThreshold aerobicThreshold = new AerobicThreshold(aerobicThresholdInt);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            UserDataServiceMockCallback userDataServiceMockCallback = new UserDataServiceMockCallback.Builder<>()
                    .addAerobicThreshold(aerobicThreshold)
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            userDataServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(USER_DATA_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(AEROBIC_THRESHOLD_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(AEROBIC_THRESHOLD_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(aerobicThreshold.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_addAerobicThreshold_00201() {
        int aerobicThresholdInt = 1;
        AerobicThreshold aerobicThreshold = new AerobicThreshold(aerobicThresholdInt);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            UserDataServiceMockCallback userDataServiceMockCallback = new UserDataServiceMockCallback.Builder<>()
                    .addAerobicThreshold(aerobicThreshold.getBytes())
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            userDataServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(USER_DATA_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(AEROBIC_THRESHOLD_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(AEROBIC_THRESHOLD_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(aerobicThreshold.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_addAerobicThreshold_00301() {
        int aerobicThresholdInt = 1;
        AerobicThreshold aerobicThreshold = new AerobicThreshold(aerobicThresholdInt);
        int responseCode = 1;
        long delay = 2;

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            UserDataServiceMockCallback userDataServiceMockCallback = new UserDataServiceMockCallback.Builder<>()
                    .addAerobicThreshold(responseCode, delay, aerobicThreshold.getBytes())
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            userDataServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(USER_DATA_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(AEROBIC_THRESHOLD_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(AEROBIC_THRESHOLD_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(aerobicThreshold.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_removeAerobicThreshold_00001() {
        int aerobicThresholdInt = 1;
        AerobicThreshold aerobicThreshold = new AerobicThreshold(aerobicThresholdInt);

        Exception exception = null;
        try {
            new UserDataServiceMockCallback.Builder<>()
                    .addAerobicThreshold(aerobicThreshold)
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .removeAerobicThreshold()
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("At least one UDS Characteristic shall be exposed", exception.getMessage());
    }

    @Test
    public void test_addAnaerobicThreshold_00001() {
        int anaerobicThresholdInt = 1;
        AnaerobicThreshold anaerobicThreshold = new AnaerobicThreshold(anaerobicThresholdInt);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            UserDataServiceMockCallback userDataServiceMockCallback = new UserDataServiceMockCallback.Builder<>()
                    .addAnaerobicThreshold(anaerobicThresholdInt)
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            userDataServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(USER_DATA_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(ANAEROBIC_THRESHOLD_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(ANAEROBIC_THRESHOLD_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(anaerobicThreshold.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_addAnaerobicThreshold_00101() {
        int anaerobicThresholdInt = 1;
        AnaerobicThreshold anaerobicThreshold = new AnaerobicThreshold(anaerobicThresholdInt);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            UserDataServiceMockCallback userDataServiceMockCallback = new UserDataServiceMockCallback.Builder<>()
                    .addAnaerobicThreshold(anaerobicThreshold)
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            userDataServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(USER_DATA_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(ANAEROBIC_THRESHOLD_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(ANAEROBIC_THRESHOLD_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(anaerobicThreshold.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_addAnaerobicThreshold_00201() {
        int anaerobicThresholdInt = 1;
        AnaerobicThreshold anaerobicThreshold = new AnaerobicThreshold(anaerobicThresholdInt);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            UserDataServiceMockCallback userDataServiceMockCallback = new UserDataServiceMockCallback.Builder<>()
                    .addAnaerobicThreshold(anaerobicThreshold.getBytes())
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            userDataServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(USER_DATA_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(ANAEROBIC_THRESHOLD_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(ANAEROBIC_THRESHOLD_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(anaerobicThreshold.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_addAnaerobicThreshold_00301() {
        int anaerobicThresholdInt = 1;
        AnaerobicThreshold anaerobicThreshold = new AnaerobicThreshold(anaerobicThresholdInt);
        int responseCode = 1;
        long delay = 2;

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            UserDataServiceMockCallback userDataServiceMockCallback = new UserDataServiceMockCallback.Builder<>()
                    .addAnaerobicThreshold(responseCode, delay, anaerobicThreshold.getBytes())
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            userDataServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(USER_DATA_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(ANAEROBIC_THRESHOLD_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(ANAEROBIC_THRESHOLD_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(anaerobicThreshold.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_removeAnaerobicThreshold_00001() {
        int anaerobicThresholdInt = 1;
        AnaerobicThreshold anaerobicThreshold = new AnaerobicThreshold(anaerobicThresholdInt);

        Exception exception = null;
        try {
            new UserDataServiceMockCallback.Builder<>()
                    .addAnaerobicThreshold(anaerobicThreshold)
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .removeAnaerobicThreshold()
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("At least one UDS Characteristic shall be exposed", exception.getMessage());
    }

    @Test
    public void test_addSportTypeForAerobicAndAnaerobicThresholds_00001() {
        int sportTypeForAerobicAndAnaerobicThresholdsInt = SportTypeForAerobicAndAnaerobicThresholds.SPORT_TYPE_FOR_AEROBIC_AND_ANAEROBIC_THRESHOLDS_UNSPECIFIED;
        SportTypeForAerobicAndAnaerobicThresholds sportTypeForAerobicAndAnaerobicThresholds = new SportTypeForAerobicAndAnaerobicThresholds(sportTypeForAerobicAndAnaerobicThresholdsInt);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            UserDataServiceMockCallback userDataServiceMockCallback = new UserDataServiceMockCallback.Builder<>()
                    .addSportTypeForAerobicAndAnaerobicThresholds(sportTypeForAerobicAndAnaerobicThresholdsInt)
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            userDataServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(USER_DATA_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(SPORT_TYPE_FOR_AEROBIC_AND_ANAEROBIC_THRESHOLDS_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(SPORT_TYPE_FOR_AEROBIC_AND_ANAEROBIC_THRESHOLDS_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(sportTypeForAerobicAndAnaerobicThresholds.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_addSportTypeForAerobicAndAnaerobicThresholds_00101() {
        int sportTypeForAerobicAndAnaerobicThresholdsInt = SportTypeForAerobicAndAnaerobicThresholds.SPORT_TYPE_FOR_AEROBIC_AND_ANAEROBIC_THRESHOLDS_UNSPECIFIED;
        SportTypeForAerobicAndAnaerobicThresholds sportTypeForAerobicAndAnaerobicThresholds = new SportTypeForAerobicAndAnaerobicThresholds(sportTypeForAerobicAndAnaerobicThresholdsInt);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            UserDataServiceMockCallback userDataServiceMockCallback = new UserDataServiceMockCallback.Builder<>()
                    .addSportTypeForAerobicAndAnaerobicThresholds(sportTypeForAerobicAndAnaerobicThresholds)
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            userDataServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(USER_DATA_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(SPORT_TYPE_FOR_AEROBIC_AND_ANAEROBIC_THRESHOLDS_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(SPORT_TYPE_FOR_AEROBIC_AND_ANAEROBIC_THRESHOLDS_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(sportTypeForAerobicAndAnaerobicThresholds.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_addSportTypeForAerobicAndAnaerobicThresholds_00201() {
        int sportTypeForAerobicAndAnaerobicThresholdsInt = SportTypeForAerobicAndAnaerobicThresholds.SPORT_TYPE_FOR_AEROBIC_AND_ANAEROBIC_THRESHOLDS_UNSPECIFIED;
        SportTypeForAerobicAndAnaerobicThresholds sportTypeForAerobicAndAnaerobicThresholds = new SportTypeForAerobicAndAnaerobicThresholds(sportTypeForAerobicAndAnaerobicThresholdsInt);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            UserDataServiceMockCallback userDataServiceMockCallback = new UserDataServiceMockCallback.Builder<>()
                    .addSportTypeForAerobicAndAnaerobicThresholds(sportTypeForAerobicAndAnaerobicThresholds.getBytes())
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            userDataServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(USER_DATA_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(SPORT_TYPE_FOR_AEROBIC_AND_ANAEROBIC_THRESHOLDS_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(SPORT_TYPE_FOR_AEROBIC_AND_ANAEROBIC_THRESHOLDS_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(sportTypeForAerobicAndAnaerobicThresholds.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_addSportTypeForAerobicAndAnaerobicThresholds_00301() {
        int sportTypeForAerobicAndAnaerobicThresholdsInt = SportTypeForAerobicAndAnaerobicThresholds.SPORT_TYPE_FOR_AEROBIC_AND_ANAEROBIC_THRESHOLDS_UNSPECIFIED;
        SportTypeForAerobicAndAnaerobicThresholds sportTypeForAerobicAndAnaerobicThresholds = new SportTypeForAerobicAndAnaerobicThresholds(sportTypeForAerobicAndAnaerobicThresholdsInt);
        int responseCode = 1;
        long delay = 2;

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            UserDataServiceMockCallback userDataServiceMockCallback = new UserDataServiceMockCallback.Builder<>()
                    .addSportTypeForAerobicAndAnaerobicThresholds(responseCode, delay, sportTypeForAerobicAndAnaerobicThresholds.getBytes())
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            userDataServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(USER_DATA_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(SPORT_TYPE_FOR_AEROBIC_AND_ANAEROBIC_THRESHOLDS_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(SPORT_TYPE_FOR_AEROBIC_AND_ANAEROBIC_THRESHOLDS_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(sportTypeForAerobicAndAnaerobicThresholds.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_removeSportTypeForAerobicAndAnaerobicThresholds_00001() {
        int sportTypeForAerobicAndAnaerobicThresholdsInt = SportTypeForAerobicAndAnaerobicThresholds.SPORT_TYPE_FOR_AEROBIC_AND_ANAEROBIC_THRESHOLDS_UNSPECIFIED;
        SportTypeForAerobicAndAnaerobicThresholds sportTypeForAerobicAndAnaerobicThresholds = new SportTypeForAerobicAndAnaerobicThresholds(sportTypeForAerobicAndAnaerobicThresholdsInt);

        Exception exception = null;
        try {
            new UserDataServiceMockCallback.Builder<>()
                    .addSportTypeForAerobicAndAnaerobicThresholds(sportTypeForAerobicAndAnaerobicThresholds)
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .removeSportTypeForAerobicAndAnaerobicThresholds()
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("At least one UDS Characteristic shall be exposed", exception.getMessage());
    }

    @Test
    public void test_addDateOfThresholdAssessment_00001() {
        int yearInt = 1;
        int monthInt = 2;
        int dayInt = 3;
        DateOfThresholdAssessment dateOfThresholdAssessment = new DateOfThresholdAssessment(yearInt, monthInt, dayInt);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            UserDataServiceMockCallback userDataServiceMockCallback = new UserDataServiceMockCallback.Builder<>()
                    .addDateOfThresholdAssessment(yearInt, monthInt, dayInt)
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            userDataServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(USER_DATA_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(DATE_OF_THRESHOLD_ASSESSMENT_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(DATE_OF_THRESHOLD_ASSESSMENT_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(dateOfThresholdAssessment.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_addDateOfThresholdAssessment_00101() {
        int yearInt = 1;
        int monthInt = 2;
        int dayInt = 3;
        DateOfThresholdAssessment dateOfThresholdAssessment = new DateOfThresholdAssessment(yearInt, monthInt, dayInt);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            UserDataServiceMockCallback userDataServiceMockCallback = new UserDataServiceMockCallback.Builder<>()
                    .addDateOfThresholdAssessment(dateOfThresholdAssessment)
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            userDataServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(USER_DATA_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(DATE_OF_THRESHOLD_ASSESSMENT_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(DATE_OF_THRESHOLD_ASSESSMENT_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(dateOfThresholdAssessment.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_addDateOfThresholdAssessment_00201() {
        int yearInt = 1;
        int monthInt = 2;
        int dayInt = 3;
        DateOfThresholdAssessment dateOfThresholdAssessment = new DateOfThresholdAssessment(yearInt, monthInt, dayInt);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            UserDataServiceMockCallback userDataServiceMockCallback = new UserDataServiceMockCallback.Builder<>()
                    .addDateOfThresholdAssessment(dateOfThresholdAssessment.getBytes())
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            userDataServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(USER_DATA_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(DATE_OF_THRESHOLD_ASSESSMENT_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(DATE_OF_THRESHOLD_ASSESSMENT_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(dateOfThresholdAssessment.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_addDateOfThresholdAssessment_00301() {
        int yearInt = 1;
        int monthInt = 2;
        int dayInt = 3;
        DateOfThresholdAssessment dateOfThresholdAssessment = new DateOfThresholdAssessment(yearInt, monthInt, dayInt);
        int responseCode = 1;
        long delay = 2;

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            UserDataServiceMockCallback userDataServiceMockCallback = new UserDataServiceMockCallback.Builder<>()
                    .addDateOfThresholdAssessment(responseCode, delay, dateOfThresholdAssessment.getBytes())
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            userDataServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(USER_DATA_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(DATE_OF_THRESHOLD_ASSESSMENT_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(DATE_OF_THRESHOLD_ASSESSMENT_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(dateOfThresholdAssessment.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_removeDateOfThresholdAssessment_00001() {
        int yearInt = 1;
        int monthInt = 2;
        int dayInt = 3;
        DateOfThresholdAssessment dateOfThresholdAssessment = new DateOfThresholdAssessment(yearInt, monthInt, dayInt);

        Exception exception = null;
        try {
            new UserDataServiceMockCallback.Builder<>()
                    .addDateOfThresholdAssessment(dateOfThresholdAssessment)
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .removeDateOfThresholdAssessment()
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("At least one UDS Characteristic shall be exposed", exception.getMessage());
    }

    @Test
    public void test_addWaistCircumference_00001() {
        int waistCircumferenceInt = 1;
        WaistCircumference waistCircumference = new WaistCircumference(waistCircumferenceInt);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            UserDataServiceMockCallback userDataServiceMockCallback = new UserDataServiceMockCallback.Builder<>()
                    .addWaistCircumference(waistCircumferenceInt)
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            userDataServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(USER_DATA_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(WAIST_CIRCUMFERENCE_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(WAIST_CIRCUMFERENCE_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(waistCircumference.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_addWaistCircumference_00101() {
        int waistCircumferenceInt = 1;
        WaistCircumference waistCircumference = new WaistCircumference(waistCircumferenceInt);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            UserDataServiceMockCallback userDataServiceMockCallback = new UserDataServiceMockCallback.Builder<>()
                    .addWaistCircumference(waistCircumference)
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            userDataServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(USER_DATA_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(WAIST_CIRCUMFERENCE_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(WAIST_CIRCUMFERENCE_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(waistCircumference.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_addWaistCircumference_00201() {
        int waistCircumferenceInt = 1;
        WaistCircumference waistCircumference = new WaistCircumference(waistCircumferenceInt);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            UserDataServiceMockCallback userDataServiceMockCallback = new UserDataServiceMockCallback.Builder<>()
                    .addWaistCircumference(waistCircumference.getBytes())
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            userDataServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(USER_DATA_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(WAIST_CIRCUMFERENCE_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(WAIST_CIRCUMFERENCE_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(waistCircumference.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_addWaistCircumference_00301() {
        int waistCircumferenceInt = 1;
        WaistCircumference waistCircumference = new WaistCircumference(waistCircumferenceInt);
        int responseCode = 1;
        long delay = 2;

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            UserDataServiceMockCallback userDataServiceMockCallback = new UserDataServiceMockCallback.Builder<>()
                    .addWaistCircumference(responseCode, delay, waistCircumference.getBytes())
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            userDataServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(USER_DATA_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(WAIST_CIRCUMFERENCE_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(WAIST_CIRCUMFERENCE_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(waistCircumference.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_removeWaistCircumference00001() {
        int waistCircumferenceInt = 1;
        WaistCircumference waistCircumference = new WaistCircumference(waistCircumferenceInt);

        Exception exception = null;
        try {
            new UserDataServiceMockCallback.Builder<>()
                    .addWaistCircumference(waistCircumference)
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .removeWaistCircumference()
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("At least one UDS Characteristic shall be exposed", exception.getMessage());
    }

    @Test
    public void test_addHipCircumference_00001() {
        int hipCircumferenceInt = 1;
        HipCircumference hipCircumference = new HipCircumference(hipCircumferenceInt);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            UserDataServiceMockCallback userDataServiceMockCallback = new UserDataServiceMockCallback.Builder<>()
                    .addHipCircumference(hipCircumferenceInt)
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            userDataServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(USER_DATA_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(HIP_CIRCUMFERENCE_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(HIP_CIRCUMFERENCE_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(hipCircumference.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_addHipCircumference_00101() {
        int hipCircumferenceInt = 1;
        HipCircumference hipCircumference = new HipCircumference(hipCircumferenceInt);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            UserDataServiceMockCallback userDataServiceMockCallback = new UserDataServiceMockCallback.Builder<>()
                    .addHipCircumference(hipCircumference)
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            userDataServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(USER_DATA_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(HIP_CIRCUMFERENCE_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(HIP_CIRCUMFERENCE_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(hipCircumference.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_addHipCircumference_00201() {
        int hipCircumferenceInt = 1;
        HipCircumference hipCircumference = new HipCircumference(hipCircumferenceInt);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            UserDataServiceMockCallback userDataServiceMockCallback = new UserDataServiceMockCallback.Builder<>()
                    .addHipCircumference(hipCircumference.getBytes())
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            userDataServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(USER_DATA_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(HIP_CIRCUMFERENCE_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(HIP_CIRCUMFERENCE_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(hipCircumference.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_addHipCircumference_00301() {
        int hipCircumferenceInt = 1;
        HipCircumference hipCircumference = new HipCircumference(hipCircumferenceInt);
        int responseCode = 1;
        long delay = 2;

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            UserDataServiceMockCallback userDataServiceMockCallback = new UserDataServiceMockCallback.Builder<>()
                    .addHipCircumference(responseCode, delay, hipCircumference.getBytes())
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            userDataServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(USER_DATA_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(HIP_CIRCUMFERENCE_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(HIP_CIRCUMFERENCE_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(hipCircumference.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_removeHipCircumference_00001() {
        int hipCircumferenceInt = 1;
        HipCircumference hipCircumference = new HipCircumference(hipCircumferenceInt);

        Exception exception = null;
        try {
            new UserDataServiceMockCallback.Builder<>()
                    .addHipCircumference(hipCircumference)
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .removeHipCircumference()
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("At least one UDS Characteristic shall be exposed", exception.getMessage());
    }

    @Test
    public void test_addFatBurnHeartRateLowerLimit_00001() {
        int fatBurnHeartRateLowerLimitInt = 1;
        FatBurnHeartRateLowerLimit fatBurnHeartRateLowerLimit = new FatBurnHeartRateLowerLimit(fatBurnHeartRateLowerLimitInt);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            UserDataServiceMockCallback userDataServiceMockCallback = new UserDataServiceMockCallback.Builder<>()
                    .addFatBurnHeartRateLowerLimit(fatBurnHeartRateLowerLimitInt)
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            userDataServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(USER_DATA_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(FAT_BURN_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(FAT_BURN_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(fatBurnHeartRateLowerLimit.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_addFatBurnHeartRateLowerLimit_00101() {
        int fatBurnHeartRateLowerLimitInt = 1;
        FatBurnHeartRateLowerLimit fatBurnHeartRateLowerLimit = new FatBurnHeartRateLowerLimit(fatBurnHeartRateLowerLimitInt);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            UserDataServiceMockCallback userDataServiceMockCallback = new UserDataServiceMockCallback.Builder<>()
                    .addFatBurnHeartRateLowerLimit(fatBurnHeartRateLowerLimit)
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            userDataServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(USER_DATA_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(FAT_BURN_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(FAT_BURN_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(fatBurnHeartRateLowerLimit.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_addFatBurnHeartRateLowerLimit_00201() {
        int fatBurnHeartRateLowerLimitInt = 1;
        FatBurnHeartRateLowerLimit fatBurnHeartRateLowerLimit = new FatBurnHeartRateLowerLimit(fatBurnHeartRateLowerLimitInt);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            UserDataServiceMockCallback userDataServiceMockCallback = new UserDataServiceMockCallback.Builder<>()
                    .addFatBurnHeartRateLowerLimit(fatBurnHeartRateLowerLimit.getBytes())
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            userDataServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(USER_DATA_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(FAT_BURN_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(FAT_BURN_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(fatBurnHeartRateLowerLimit.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_addFatBurnHeartRateLowerLimit_00301() {
        int fatBurnHeartRateLowerLimitInt = 1;
        FatBurnHeartRateLowerLimit fatBurnHeartRateLowerLimit = new FatBurnHeartRateLowerLimit(fatBurnHeartRateLowerLimitInt);
        int responseCode = 1;
        long delay = 2;

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            UserDataServiceMockCallback userDataServiceMockCallback = new UserDataServiceMockCallback.Builder<>()
                    .addFatBurnHeartRateLowerLimit(responseCode, delay, fatBurnHeartRateLowerLimit.getBytes())
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            userDataServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(USER_DATA_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(FAT_BURN_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(FAT_BURN_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(fatBurnHeartRateLowerLimit.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_removeFatBurnHeartRateLowerLimit_00001() {
        int fatBurnHeartRateLowerLimitInt = 1;
        FatBurnHeartRateLowerLimit fatBurnHeartRateLowerLimit = new FatBurnHeartRateLowerLimit(fatBurnHeartRateLowerLimitInt);

        Exception exception = null;
        try {
            new UserDataServiceMockCallback.Builder<>()
                    .addFatBurnHeartRateLowerLimit(fatBurnHeartRateLowerLimit)
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .removeFatBurnHeartRateLowerLimit()
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("At least one UDS Characteristic shall be exposed", exception.getMessage());
    }

    @Test
    public void test_addFatBurnHeartRateUpperLimit_00001() {
        int fatBurnHeartRateUpperLimitInt = 1;
        FatBurnHeartRateUpperLimit fatBurnHeartRateUpperLimit = new FatBurnHeartRateUpperLimit(fatBurnHeartRateUpperLimitInt);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            UserDataServiceMockCallback userDataServiceMockCallback = new UserDataServiceMockCallback.Builder<>()
                    .addFatBurnHeartRateUpperLimit(fatBurnHeartRateUpperLimitInt)
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            userDataServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(USER_DATA_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(FAT_BURN_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(FAT_BURN_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(fatBurnHeartRateUpperLimit.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_addFatBurnHeartRateUpperLimit_00101() {
        int fatBurnHeartRateUpperLimitInt = 1;
        FatBurnHeartRateUpperLimit fatBurnHeartRateUpperLimit = new FatBurnHeartRateUpperLimit(fatBurnHeartRateUpperLimitInt);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            UserDataServiceMockCallback userDataServiceMockCallback = new UserDataServiceMockCallback.Builder<>()
                    .addFatBurnHeartRateUpperLimit(fatBurnHeartRateUpperLimit)
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            userDataServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(USER_DATA_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(FAT_BURN_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(FAT_BURN_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(fatBurnHeartRateUpperLimit.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_addFatBurnHeartRateUpperLimit_00201() {
        int fatBurnHeartRateUpperLimitInt = 1;
        FatBurnHeartRateUpperLimit fatBurnHeartRateUpperLimit = new FatBurnHeartRateUpperLimit(fatBurnHeartRateUpperLimitInt);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            UserDataServiceMockCallback userDataServiceMockCallback = new UserDataServiceMockCallback.Builder<>()
                    .addFatBurnHeartRateUpperLimit(fatBurnHeartRateUpperLimit.getBytes())
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            userDataServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(USER_DATA_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(FAT_BURN_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(FAT_BURN_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(fatBurnHeartRateUpperLimit.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_addFatBurnHeartRateUpperLimit_00301() {
        int fatBurnHeartRateUpperLimitInt = 1;
        FatBurnHeartRateUpperLimit fatBurnHeartRateUpperLimit = new FatBurnHeartRateUpperLimit(fatBurnHeartRateUpperLimitInt);
        int responseCode = 1;
        long delay = 2;

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            UserDataServiceMockCallback userDataServiceMockCallback = new UserDataServiceMockCallback.Builder<>()
                    .addFatBurnHeartRateUpperLimit(responseCode, delay, fatBurnHeartRateUpperLimit.getBytes())
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            userDataServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(USER_DATA_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(FAT_BURN_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(FAT_BURN_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(fatBurnHeartRateUpperLimit.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_removeFatBurnHeartRateUpperLimit_00001() {
        int fatBurnHeartRateUpperLimitInt = 1;
        FatBurnHeartRateUpperLimit fatBurnHeartRateUpperLimit = new FatBurnHeartRateUpperLimit(fatBurnHeartRateUpperLimitInt);

        Exception exception = null;
        try {
            new UserDataServiceMockCallback.Builder<>()
                    .addFatBurnHeartRateUpperLimit(fatBurnHeartRateUpperLimit)
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .removeFatBurnHeartRateUpperLimit()
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("At least one UDS Characteristic shall be exposed", exception.getMessage());
    }

    @Test
    public void test_addAerobicHeartRateLowerLimit_00001() {
        int aerobicHeartRateLowerLimitInt = 1;
        AerobicHeartRateLowerLimit aerobicHeartRateLowerLimit = new AerobicHeartRateLowerLimit(aerobicHeartRateLowerLimitInt);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            UserDataServiceMockCallback userDataServiceMockCallback = new UserDataServiceMockCallback.Builder<>()
                    .addAerobicHeartRateLowerLimit(aerobicHeartRateLowerLimitInt)
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            userDataServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(USER_DATA_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(AEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(AEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(aerobicHeartRateLowerLimit.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_addAerobicHeartRateLowerLimit_00101() {
        int aerobicHeartRateLowerLimitInt = 1;
        AerobicHeartRateLowerLimit aerobicHeartRateLowerLimit = new AerobicHeartRateLowerLimit(aerobicHeartRateLowerLimitInt);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            UserDataServiceMockCallback userDataServiceMockCallback = new UserDataServiceMockCallback.Builder<>()
                    .addAerobicHeartRateLowerLimit(aerobicHeartRateLowerLimit)
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            userDataServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(USER_DATA_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(AEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(AEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(aerobicHeartRateLowerLimit.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_addAerobicHeartRateLowerLimit_00201() {
        int aerobicHeartRateLowerLimitInt = 1;
        AerobicHeartRateLowerLimit aerobicHeartRateLowerLimit = new AerobicHeartRateLowerLimit(aerobicHeartRateLowerLimitInt);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            UserDataServiceMockCallback userDataServiceMockCallback = new UserDataServiceMockCallback.Builder<>()
                    .addAerobicHeartRateLowerLimit(aerobicHeartRateLowerLimit.getBytes())
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            userDataServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(USER_DATA_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(AEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(AEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(aerobicHeartRateLowerLimit.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_addAerobicHeartRateLowerLimit_00301() {
        int aerobicHeartRateLowerLimitInt = 1;
        AerobicHeartRateLowerLimit aerobicHeartRateLowerLimit = new AerobicHeartRateLowerLimit(aerobicHeartRateLowerLimitInt);
        int responseCode = 1;
        long delay = 2;

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            UserDataServiceMockCallback userDataServiceMockCallback = new UserDataServiceMockCallback.Builder<>()
                    .addAerobicHeartRateLowerLimit(responseCode, delay, aerobicHeartRateLowerLimit.getBytes())
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            userDataServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(USER_DATA_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(AEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(AEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(aerobicHeartRateLowerLimit.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_removeAerobicHeartRateLowerLimit_00001() {
        int aerobicHeartRateLowerLimitInt = 1;
        AerobicHeartRateLowerLimit aerobicHeartRateLowerLimit = new AerobicHeartRateLowerLimit(aerobicHeartRateLowerLimitInt);

        Exception exception = null;
        try {
            new UserDataServiceMockCallback.Builder<>()
                    .addAerobicHeartRateLowerLimit(aerobicHeartRateLowerLimit)
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .removeAerobicHeartRateLowerLimit()
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("At least one UDS Characteristic shall be exposed", exception.getMessage());
    }

    @Test
    public void test_addAerobicHeartRateUpperLimit_00001() {
        int aerobicHeartRateUpperLimitInt = 1;
        AerobicHeartRateUpperLimit aerobicHeartRateUpperLimit = new AerobicHeartRateUpperLimit(aerobicHeartRateUpperLimitInt);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            UserDataServiceMockCallback userDataServiceMockCallback = new UserDataServiceMockCallback.Builder<>()
                    .addAerobicHeartRateUpperLimit(aerobicHeartRateUpperLimitInt)
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            userDataServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(USER_DATA_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(AEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(AEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(aerobicHeartRateUpperLimit.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_addAerobicHeartRateUpperLimit_00101() {
        int aerobicHeartRateUpperLimitInt = 1;
        AerobicHeartRateUpperLimit aerobicHeartRateUpperLimit = new AerobicHeartRateUpperLimit(aerobicHeartRateUpperLimitInt);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            UserDataServiceMockCallback userDataServiceMockCallback = new UserDataServiceMockCallback.Builder<>()
                    .addAerobicHeartRateUpperLimit(aerobicHeartRateUpperLimit)
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            userDataServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(USER_DATA_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(AEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(AEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(aerobicHeartRateUpperLimit.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_addAerobicHeartRateUpperLimit_00201() {
        int aerobicHeartRateUpperLimitInt = 1;
        AerobicHeartRateUpperLimit aerobicHeartRateUpperLimit = new AerobicHeartRateUpperLimit(aerobicHeartRateUpperLimitInt);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            UserDataServiceMockCallback userDataServiceMockCallback = new UserDataServiceMockCallback.Builder<>()
                    .addAerobicHeartRateUpperLimit(aerobicHeartRateUpperLimit.getBytes())
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            userDataServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(USER_DATA_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(AEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(AEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(aerobicHeartRateUpperLimit.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_addAerobicHeartRateUpperLimit_00301() {
        int aerobicHeartRateUpperLimitInt = 1;
        AerobicHeartRateUpperLimit aerobicHeartRateUpperLimit = new AerobicHeartRateUpperLimit(aerobicHeartRateUpperLimitInt);
        int responseCode = 1;
        long delay = 2;

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            UserDataServiceMockCallback userDataServiceMockCallback = new UserDataServiceMockCallback.Builder<>()
                    .addAerobicHeartRateUpperLimit(responseCode, delay, aerobicHeartRateUpperLimit.getBytes())
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            userDataServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(USER_DATA_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(AEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(AEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(aerobicHeartRateUpperLimit.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_removeAerobicHeartRateUpperLimit_00001() {
        int aerobicHeartRateUpperLimitInt = 1;
        AerobicHeartRateUpperLimit aerobicHeartRateUpperLimit = new AerobicHeartRateUpperLimit(aerobicHeartRateUpperLimitInt);

        Exception exception = null;
        try {
            new UserDataServiceMockCallback.Builder<>()
                    .addAerobicHeartRateUpperLimit(aerobicHeartRateUpperLimit)
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .removeAerobicHeartRateUpperLimit()
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("At least one UDS Characteristic shall be exposed", exception.getMessage());
    }

    @Test
    public void test_addAnaerobicHeartRateLowerLimit_00001() {
        int anaerobicHeartRateLowerLimitInt = 1;
        AnaerobicHeartRateLowerLimit anaerobicHeartRateLowerLimit = new AnaerobicHeartRateLowerLimit(anaerobicHeartRateLowerLimitInt);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            UserDataServiceMockCallback userDataServiceMockCallback = new UserDataServiceMockCallback.Builder<>()
                    .addAnaerobicHeartRateLowerLimit(anaerobicHeartRateLowerLimitInt)
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            userDataServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(USER_DATA_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(ANAEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(ANAEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(anaerobicHeartRateLowerLimit.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_addAnaerobicHeartRateLowerLimit_00101() {
        int anaerobicHeartRateLowerLimitInt = 1;
        AnaerobicHeartRateLowerLimit anaerobicHeartRateLowerLimit = new AnaerobicHeartRateLowerLimit(anaerobicHeartRateLowerLimitInt);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            UserDataServiceMockCallback userDataServiceMockCallback = new UserDataServiceMockCallback.Builder<>()
                    .addAnaerobicHeartRateLowerLimit(anaerobicHeartRateLowerLimit)
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            userDataServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(USER_DATA_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(ANAEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(ANAEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(anaerobicHeartRateLowerLimit.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_addAnaerobicHeartRateLowerLimit_00201() {
        int anaerobicHeartRateLowerLimitInt = 1;
        AnaerobicHeartRateLowerLimit anaerobicHeartRateLowerLimit = new AnaerobicHeartRateLowerLimit(anaerobicHeartRateLowerLimitInt);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            UserDataServiceMockCallback userDataServiceMockCallback = new UserDataServiceMockCallback.Builder<>()
                    .addAnaerobicHeartRateLowerLimit(anaerobicHeartRateLowerLimit.getBytes())
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            userDataServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(USER_DATA_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(ANAEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(ANAEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(anaerobicHeartRateLowerLimit.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_addAnaerobicHeartRateLowerLimit_00301() {
        int anaerobicHeartRateLowerLimitInt = 1;
        AnaerobicHeartRateLowerLimit anaerobicHeartRateLowerLimit = new AnaerobicHeartRateLowerLimit(anaerobicHeartRateLowerLimitInt);
        int responseCode = 1;
        long delay = 2;

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            UserDataServiceMockCallback userDataServiceMockCallback = new UserDataServiceMockCallback.Builder<>()
                    .addAnaerobicHeartRateLowerLimit(responseCode, delay, anaerobicHeartRateLowerLimit.getBytes())
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            userDataServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(USER_DATA_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(ANAEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(ANAEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(anaerobicHeartRateLowerLimit.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_removeAnaerobicHeartRateLowerLimit_00001() {
        int anaerobicHeartRateLowerLimitInt = 1;
        AnaerobicHeartRateLowerLimit anaerobicHeartRateLowerLimit = new AnaerobicHeartRateLowerLimit(anaerobicHeartRateLowerLimitInt);

        Exception exception = null;
        try {
            new UserDataServiceMockCallback.Builder<>()
                    .addAnaerobicHeartRateLowerLimit(anaerobicHeartRateLowerLimit)
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .removeAnaerobicHeartRateLowerLimit()
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("At least one UDS Characteristic shall be exposed", exception.getMessage());
    }

    @Test
    public void test_addAnaerobicHeartRateUpperLimit_00001() {
        int anaerobicHeartRateUpperLimitInt = 1;
        AnaerobicHeartRateUpperLimit anaerobicHeartRateUpperLimit = new AnaerobicHeartRateUpperLimit(anaerobicHeartRateUpperLimitInt);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            UserDataServiceMockCallback userDataServiceMockCallback = new UserDataServiceMockCallback.Builder<>()
                    .addAnaerobicHeartRateUpperLimit(anaerobicHeartRateUpperLimitInt)
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            userDataServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(USER_DATA_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(ANAEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(ANAEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(anaerobicHeartRateUpperLimit.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_addAnaerobicHeartRateUpperLimit_00101() {
        int anaerobicHeartRateUpperLimitInt = 1;
        AnaerobicHeartRateUpperLimit anaerobicHeartRateUpperLimit = new AnaerobicHeartRateUpperLimit(anaerobicHeartRateUpperLimitInt);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            UserDataServiceMockCallback userDataServiceMockCallback = new UserDataServiceMockCallback.Builder<>()
                    .addAnaerobicHeartRateUpperLimit(anaerobicHeartRateUpperLimit)
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            userDataServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(USER_DATA_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(ANAEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(ANAEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(anaerobicHeartRateUpperLimit.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_addAnaerobicHeartRateUpperLimit_00201() {
        int anaerobicHeartRateUpperLimitInt = 1;
        AnaerobicHeartRateUpperLimit anaerobicHeartRateUpperLimit = new AnaerobicHeartRateUpperLimit(anaerobicHeartRateUpperLimitInt);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            UserDataServiceMockCallback userDataServiceMockCallback = new UserDataServiceMockCallback.Builder<>()
                    .addAnaerobicHeartRateUpperLimit(anaerobicHeartRateUpperLimit.getBytes())
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            userDataServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(USER_DATA_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(ANAEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(ANAEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(anaerobicHeartRateUpperLimit.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_addAnaerobicHeartRateUpperLimit_00301() {
        int anaerobicHeartRateUpperLimitInt = 1;
        AnaerobicHeartRateUpperLimit anaerobicHeartRateUpperLimit = new AnaerobicHeartRateUpperLimit(anaerobicHeartRateUpperLimitInt);
        int responseCode = 1;
        long delay = 2;

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            UserDataServiceMockCallback userDataServiceMockCallback = new UserDataServiceMockCallback.Builder<>()
                    .addAnaerobicHeartRateUpperLimit(responseCode, delay, anaerobicHeartRateUpperLimit.getBytes())
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            userDataServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(USER_DATA_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(ANAEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(ANAEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(anaerobicHeartRateUpperLimit.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_removeAnaerobicHeartRateUpperLimit_00001() {
        int anaerobicHeartRateUpperLimitInt = 1;
        AnaerobicHeartRateUpperLimit anaerobicHeartRateUpperLimit = new AnaerobicHeartRateUpperLimit(anaerobicHeartRateUpperLimitInt);

        Exception exception = null;
        try {
            new UserDataServiceMockCallback.Builder<>()
                    .addAnaerobicHeartRateUpperLimit(anaerobicHeartRateUpperLimit)
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .removeAnaerobicHeartRateUpperLimit()
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("At least one UDS Characteristic shall be exposed", exception.getMessage());
    }

    @Test
    public void test_addFiveZoneHeartRateLimits_00001() {
        int fiveZoneHeartRateLimitsVeryLightLightLimitInt = 1;
        int fiveZoneHeartRateLimitsLightModerateLimitInt = 2;
        int fiveZoneHeartRateLimitsModerateHardLimitInt = 3;
        int fiveZoneHeartRateLimitsHardMaximumLimitInt = 4;
        FiveZoneHeartRateLimits fiveZoneHeartRateLimits = new FiveZoneHeartRateLimits(fiveZoneHeartRateLimitsVeryLightLightLimitInt, fiveZoneHeartRateLimitsLightModerateLimitInt, fiveZoneHeartRateLimitsModerateHardLimitInt, fiveZoneHeartRateLimitsHardMaximumLimitInt);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            UserDataServiceMockCallback userDataServiceMockCallback = new UserDataServiceMockCallback.Builder<>()
                    .addFiveZoneHeartRateLimits(fiveZoneHeartRateLimitsVeryLightLightLimitInt, fiveZoneHeartRateLimitsLightModerateLimitInt, fiveZoneHeartRateLimitsModerateHardLimitInt, fiveZoneHeartRateLimitsHardMaximumLimitInt)
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            userDataServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(USER_DATA_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(FIVE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(FIVE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(fiveZoneHeartRateLimits.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_addFiveZoneHeartRateLimits_00101() {
        int fiveZoneHeartRateLimitsVeryLightLightLimitInt = 1;
        int fiveZoneHeartRateLimitsLightModerateLimitInt = 2;
        int fiveZoneHeartRateLimitsModerateHardLimitInt = 3;
        int fiveZoneHeartRateLimitsHardMaximumLimitInt = 4;
        FiveZoneHeartRateLimits fiveZoneHeartRateLimits = new FiveZoneHeartRateLimits(fiveZoneHeartRateLimitsVeryLightLightLimitInt, fiveZoneHeartRateLimitsLightModerateLimitInt, fiveZoneHeartRateLimitsModerateHardLimitInt, fiveZoneHeartRateLimitsHardMaximumLimitInt);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            UserDataServiceMockCallback userDataServiceMockCallback = new UserDataServiceMockCallback.Builder<>()
                    .addFiveZoneHeartRateLimits(fiveZoneHeartRateLimits)
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            userDataServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(USER_DATA_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(FIVE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(FIVE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(fiveZoneHeartRateLimits.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_addFiveZoneHeartRateLimits_00201() {
        int fiveZoneHeartRateLimitsVeryLightLightLimitInt = 1;
        int fiveZoneHeartRateLimitsLightModerateLimitInt = 2;
        int fiveZoneHeartRateLimitsModerateHardLimitInt = 3;
        int fiveZoneHeartRateLimitsHardMaximumLimitInt = 4;
        FiveZoneHeartRateLimits fiveZoneHeartRateLimits = new FiveZoneHeartRateLimits(fiveZoneHeartRateLimitsVeryLightLightLimitInt, fiveZoneHeartRateLimitsLightModerateLimitInt, fiveZoneHeartRateLimitsModerateHardLimitInt, fiveZoneHeartRateLimitsHardMaximumLimitInt);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            UserDataServiceMockCallback userDataServiceMockCallback = new UserDataServiceMockCallback.Builder<>()
                    .addFiveZoneHeartRateLimits(fiveZoneHeartRateLimits.getBytes())
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            userDataServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(USER_DATA_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(FIVE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(FIVE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(fiveZoneHeartRateLimits.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_addFiveZoneHeartRateLimits_00301() {
        int fiveZoneHeartRateLimitsVeryLightLightLimitInt = 1;
        int fiveZoneHeartRateLimitsLightModerateLimitInt = 2;
        int fiveZoneHeartRateLimitsModerateHardLimitInt = 3;
        int fiveZoneHeartRateLimitsHardMaximumLimitInt = 4;
        FiveZoneHeartRateLimits fiveZoneHeartRateLimits = new FiveZoneHeartRateLimits(fiveZoneHeartRateLimitsVeryLightLightLimitInt, fiveZoneHeartRateLimitsLightModerateLimitInt, fiveZoneHeartRateLimitsModerateHardLimitInt, fiveZoneHeartRateLimitsHardMaximumLimitInt);
        int responseCode = 1;
        long delay = 2;

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            UserDataServiceMockCallback userDataServiceMockCallback = new UserDataServiceMockCallback.Builder<>()
                    .addFiveZoneHeartRateLimits(responseCode, delay, fiveZoneHeartRateLimits.getBytes())
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            userDataServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(USER_DATA_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(FIVE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(FIVE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(fiveZoneHeartRateLimits.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_removeFiveZoneHeartRateLimits_00001() {
        int fiveZoneHeartRateLimitsVeryLightLightLimitInt = 1;
        int fiveZoneHeartRateLimitsLightModerateLimitInt = 2;
        int fiveZoneHeartRateLimitsModerateHardLimitInt = 3;
        int fiveZoneHeartRateLimitsHardMaximumLimitInt = 4;
        FiveZoneHeartRateLimits fiveZoneHeartRateLimits = new FiveZoneHeartRateLimits(fiveZoneHeartRateLimitsVeryLightLightLimitInt, fiveZoneHeartRateLimitsLightModerateLimitInt, fiveZoneHeartRateLimitsModerateHardLimitInt, fiveZoneHeartRateLimitsHardMaximumLimitInt);

        Exception exception = null;
        try {
            new UserDataServiceMockCallback.Builder<>()
                    .addFiveZoneHeartRateLimits(fiveZoneHeartRateLimits)
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .removeFiveZoneHeartRateLimits()
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("At least one UDS Characteristic shall be exposed", exception.getMessage());
    }

    @Test
    public void test_addThreeZoneHeartRateLimits_00001() {
        int threeZoneHeartRateLimitsLightFatBurnModerateAerobicLimitInt = 1;
        int threeZoneHeartRateLimitsModerateAerobicHardAnaerobicLimitInt = 2;
        ThreeZoneHeartRateLimits threeZoneHeartRateLimits = new ThreeZoneHeartRateLimits(threeZoneHeartRateLimitsLightFatBurnModerateAerobicLimitInt, threeZoneHeartRateLimitsModerateAerobicHardAnaerobicLimitInt);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            UserDataServiceMockCallback userDataServiceMockCallback = new UserDataServiceMockCallback.Builder<>()
                    .addThreeZoneHeartRateLimits(threeZoneHeartRateLimitsLightFatBurnModerateAerobicLimitInt, threeZoneHeartRateLimitsModerateAerobicHardAnaerobicLimitInt)
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            userDataServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(USER_DATA_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(THREE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(THREE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(threeZoneHeartRateLimits.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_addThreeZoneHeartRateLimits_00101() {
        int threeZoneHeartRateLimitsLightFatBurnModerateAerobicLimitInt = 1;
        int threeZoneHeartRateLimitsModerateAerobicHardAnaerobicLimitInt = 2;
        ThreeZoneHeartRateLimits threeZoneHeartRateLimits = new ThreeZoneHeartRateLimits(threeZoneHeartRateLimitsLightFatBurnModerateAerobicLimitInt, threeZoneHeartRateLimitsModerateAerobicHardAnaerobicLimitInt);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            UserDataServiceMockCallback userDataServiceMockCallback = new UserDataServiceMockCallback.Builder<>()
                    .addThreeZoneHeartRateLimits(threeZoneHeartRateLimits)
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            userDataServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(USER_DATA_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(THREE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(THREE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(threeZoneHeartRateLimits.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_addThreeZoneHeartRateLimits_00201() {
        int threeZoneHeartRateLimitsLightFatBurnModerateAerobicLimitInt = 1;
        int threeZoneHeartRateLimitsModerateAerobicHardAnaerobicLimitInt = 2;
        ThreeZoneHeartRateLimits threeZoneHeartRateLimits = new ThreeZoneHeartRateLimits(threeZoneHeartRateLimitsLightFatBurnModerateAerobicLimitInt, threeZoneHeartRateLimitsModerateAerobicHardAnaerobicLimitInt);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            UserDataServiceMockCallback userDataServiceMockCallback = new UserDataServiceMockCallback.Builder<>()
                    .addThreeZoneHeartRateLimits(threeZoneHeartRateLimits.getBytes())
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            userDataServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(USER_DATA_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(THREE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(THREE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(threeZoneHeartRateLimits.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_addThreeZoneHeartRateLimits_00301() {
        int threeZoneHeartRateLimitsLightFatBurnModerateAerobicLimitInt = 1;
        int threeZoneHeartRateLimitsModerateAerobicHardAnaerobicLimitInt = 2;
        ThreeZoneHeartRateLimits threeZoneHeartRateLimits = new ThreeZoneHeartRateLimits(threeZoneHeartRateLimitsLightFatBurnModerateAerobicLimitInt, threeZoneHeartRateLimitsModerateAerobicHardAnaerobicLimitInt);
        int responseCode = 1;
        long delay = 2;

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            UserDataServiceMockCallback userDataServiceMockCallback = new UserDataServiceMockCallback.Builder<>()
                    .addThreeZoneHeartRateLimits(responseCode, delay, threeZoneHeartRateLimits.getBytes())
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            userDataServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(USER_DATA_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(THREE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(THREE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(threeZoneHeartRateLimits.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_removeThreeZoneHeartRateLimits_00001() {
        int threeZoneHeartRateLimitsLightFatBurnModerateAerobicLimitInt = 1;
        int threeZoneHeartRateLimitsModerateAerobicHardAnaerobicLimitInt = 2;
        ThreeZoneHeartRateLimits threeZoneHeartRateLimits = new ThreeZoneHeartRateLimits(threeZoneHeartRateLimitsLightFatBurnModerateAerobicLimitInt, threeZoneHeartRateLimitsModerateAerobicHardAnaerobicLimitInt);

        Exception exception = null;
        try {
            new UserDataServiceMockCallback.Builder<>()
                    .addThreeZoneHeartRateLimits(threeZoneHeartRateLimits)
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .removeThreeZoneHeartRateLimits()
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("At least one UDS Characteristic shall be exposed", exception.getMessage());
    }

    @Test
    public void test_addTwoZoneHeartRateLimit_00001() {
        int twoZoneHeartRateLimitFatBurnFitnessLimitInt = 1;
        TwoZoneHeartRateLimit twoZoneHeartRateLimit = new TwoZoneHeartRateLimit(twoZoneHeartRateLimitFatBurnFitnessLimitInt);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            UserDataServiceMockCallback userDataServiceMockCallback = new UserDataServiceMockCallback.Builder<>()
                    .addTwoZoneHeartRateLimit(twoZoneHeartRateLimitFatBurnFitnessLimitInt)
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            userDataServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(USER_DATA_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(TWO_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(TWO_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(twoZoneHeartRateLimit.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_addTwoZoneHeartRateLimit_00101() {
        int twoZoneHeartRateLimitFatBurnFitnessLimitInt = 1;
        TwoZoneHeartRateLimit twoZoneHeartRateLimit = new TwoZoneHeartRateLimit(twoZoneHeartRateLimitFatBurnFitnessLimitInt);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            UserDataServiceMockCallback userDataServiceMockCallback = new UserDataServiceMockCallback.Builder<>()
                    .addTwoZoneHeartRateLimit(twoZoneHeartRateLimit)
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            userDataServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(USER_DATA_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(TWO_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(TWO_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(twoZoneHeartRateLimit.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_addTwoZoneHeartRateLimit_00201() {
        int twoZoneHeartRateLimitFatBurnFitnessLimitInt = 1;
        TwoZoneHeartRateLimit twoZoneHeartRateLimit = new TwoZoneHeartRateLimit(twoZoneHeartRateLimitFatBurnFitnessLimitInt);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            UserDataServiceMockCallback userDataServiceMockCallback = new UserDataServiceMockCallback.Builder<>()
                    .addTwoZoneHeartRateLimit(twoZoneHeartRateLimit.getBytes())
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            userDataServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(USER_DATA_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(TWO_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(TWO_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(twoZoneHeartRateLimit.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_addTwoZoneHeartRateLimit_00301() {
        int twoZoneHeartRateLimitFatBurnFitnessLimitInt = 1;
        TwoZoneHeartRateLimit twoZoneHeartRateLimit = new TwoZoneHeartRateLimit(twoZoneHeartRateLimitFatBurnFitnessLimitInt);
        int responseCode = 1;
        long delay = 2;

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            UserDataServiceMockCallback userDataServiceMockCallback = new UserDataServiceMockCallback.Builder<>()
                    .addTwoZoneHeartRateLimit(responseCode, delay, twoZoneHeartRateLimit.getBytes())
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            userDataServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(USER_DATA_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(TWO_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(TWO_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(twoZoneHeartRateLimit.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_removeTwoZoneHeartRateLimit_00001() {
        int twoZoneHeartRateLimitFatBurnFitnessLimitInt = 1;
        TwoZoneHeartRateLimit twoZoneHeartRateLimit = new TwoZoneHeartRateLimit(twoZoneHeartRateLimitFatBurnFitnessLimitInt);

        Exception exception = null;
        try {
            new UserDataServiceMockCallback.Builder<>()
                    .addTwoZoneHeartRateLimit(twoZoneHeartRateLimit)
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .removeTwoZoneHeartRateLimit()
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("At least one UDS Characteristic shall be exposed", exception.getMessage());
    }

    @Test
    public void test_addLanguage_00001() {
        String languageString = "language";
        Language language = new Language(languageString);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            UserDataServiceMockCallback userDataServiceMockCallback = new UserDataServiceMockCallback.Builder<>()
                    .addLanguage(languageString)
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            userDataServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(USER_DATA_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(LANGUAGE_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(LANGUAGE_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(language.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_addLanguage_00101() {
        String languageString = "language";
        Language language = new Language(languageString);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            UserDataServiceMockCallback userDataServiceMockCallback = new UserDataServiceMockCallback.Builder<>()
                    .addLanguage(language)
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            userDataServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(USER_DATA_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(LANGUAGE_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(LANGUAGE_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(language.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_addLanguage_00201() {
        String languageString = "language";
        Language language = new Language(languageString);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            UserDataServiceMockCallback userDataServiceMockCallback = new UserDataServiceMockCallback.Builder<>()
                    .addLanguage(language.getBytes())
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            userDataServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(USER_DATA_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(LANGUAGE_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(LANGUAGE_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(language.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_addLanguage_00301() {
        String languageString = "language";
        Language language = new Language(languageString);
        int responseCode = 1;
        long delay = 2;

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            UserDataServiceMockCallback userDataServiceMockCallback = new UserDataServiceMockCallback.Builder<>()
                    .addLanguage(responseCode, delay, language.getBytes())
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            userDataServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(USER_DATA_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(LANGUAGE_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(LANGUAGE_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(language.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_removeLanguage_00001() {
        String languageString = "language";
        Language language = new Language(languageString);

        Exception exception = null;
        try {
            new UserDataServiceMockCallback.Builder<>()
                    .addLanguage(language)
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .removeLanguage()
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("At least one UDS Characteristic shall be exposed", exception.getMessage());
    }

    @Test
    public void test_addDatabaseChangeIncrement_00001() {
        byte[] value = BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
        ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(value);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            UserDataServiceMockCallback userDataServiceMockCallback = new UserDataServiceMockCallback.Builder<>()
                    .addFirstName("First Name")
                    .addDatabaseChangeIncrement(clientCharacteristicConfiguration)
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            userDataServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(USER_DATA_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(DATABASE_CHANGE_INCREMENT_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(DATABASE_CHANGE_INCREMENT_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE | BluetoothGattCharacteristic.PROPERTY_NOTIFY, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(new byte[0], bluetoothGattCharacteristic.getValue());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(clientCharacteristicConfiguration.getBytes(), bluetoothGattDescriptor.getValue());
    }

    @Test
    public void test_addDatabaseChangeIncrement_00101() {
        byte[] value = BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
        ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(value);
        int characteristicResponseCode = 1;
        long characteristicDelay = 2;
        boolean isNotificatable = true;
        int descriptorResponseCode = 3;
        long descriptorDelay = 4;

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            UserDataServiceMockCallback userDataServiceMockCallback = new UserDataServiceMockCallback.Builder<>()
                    .addFirstName("First Name")
                    .addDatabaseChangeIncrement(characteristicResponseCode, characteristicDelay, isNotificatable, descriptorResponseCode, descriptorDelay, clientCharacteristicConfiguration.getBytes())
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            userDataServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(USER_DATA_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(DATABASE_CHANGE_INCREMENT_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(DATABASE_CHANGE_INCREMENT_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE | BluetoothGattCharacteristic.PROPERTY_NOTIFY, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(new byte[0], bluetoothGattCharacteristic.getValue());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(clientCharacteristicConfiguration.getBytes(), bluetoothGattDescriptor.getValue());
    }

    @Test
    public void test_addDatabaseChangeIncrement_00102() {
        byte[] value = BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
        ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(value);
        int characteristicResponseCode = 1;
        long characteristicDelay = 2;
        boolean isNotificatable = false;
        int descriptorResponseCode = 3;
        long descriptorDelay = 4;

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            UserDataServiceMockCallback userDataServiceMockCallback = new UserDataServiceMockCallback.Builder<>()
                    .addFirstName("First Name")
                    .addDatabaseChangeIncrement(characteristicResponseCode, characteristicDelay, isNotificatable, descriptorResponseCode, descriptorDelay, clientCharacteristicConfiguration.getBytes())
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            userDataServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(USER_DATA_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(DATABASE_CHANGE_INCREMENT_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(DATABASE_CHANGE_INCREMENT_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(new byte[0], bluetoothGattCharacteristic.getValue());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR);
        assertNull(bluetoothGattDescriptor);
    }

    @Test
    public void test_removeDatabaseChangeIncrement_00001() {
        byte[] value = BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
        ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(value);

        Exception exception = null;
        try {
            new UserDataServiceMockCallback.Builder<>()
                    .addFirstName("First Name")
                    .addDatabaseChangeIncrement(clientCharacteristicConfiguration)
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .removeDatabaseChangeIncrement()
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Database Change Increment data", exception.getMessage());
    }

    @Test
    public void test_addUserIndex_00001() {
        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            UserDataServiceMockCallback userDataServiceMockCallback = new UserDataServiceMockCallback.Builder<>()
                    .addUserIndex()
                    .addFirstName("First Name")
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            userDataServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(USER_DATA_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(USER_INDEX_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(USER_INDEX_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(new byte[0], bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_addUserIndex_00101() {
        int responseCode = 1;
        long delay = 2;

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            UserDataServiceMockCallback userDataServiceMockCallback = new UserDataServiceMockCallback.Builder<>()
                    .addUserIndex(responseCode, delay)
                    .addFirstName("First Name")
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            userDataServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(USER_DATA_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(USER_INDEX_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(USER_INDEX_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(new byte[0], bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_removeUserIndex_00001() {
        Exception exception = null;
        try {
            new UserDataServiceMockCallback.Builder<>()
                    .addUserIndex()
                    .addFirstName("First Name")
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .removeUserIndex()
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no User Index data", exception.getMessage());
    }

    @Test
    public void test_addRegisteredUser_00001() {
        byte[] value = BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
        ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(value);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            UserDataServiceMockCallback userDataServiceMockCallback = new UserDataServiceMockCallback.Builder<>()
                    .addRegisteredUser(clientCharacteristicConfiguration)
                    .addFirstName("First Name")
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .build();
            userDataServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(USER_DATA_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(REGISTERED_USER_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(REGISTERED_USER_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_INDICATE, bluetoothGattCharacteristic.getProperties());
        assertEquals(0, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(new byte[0], bluetoothGattCharacteristic.getValue());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(clientCharacteristicConfiguration.getBytes(), bluetoothGattDescriptor.getValue());
    }

    @Test
    public void test_addRegisteredUser_00101() {
        byte[] value = BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
        ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(value);
        int characteristicResponseCode = 1;
        long characteristicDelay = 2;
        int descriptorResponseCode = 3;
        long descriptorDelay = 4;

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            UserDataServiceMockCallback userDataServiceMockCallback = new UserDataServiceMockCallback.Builder<>()
                    .addRegisteredUser(characteristicResponseCode, characteristicDelay, descriptorResponseCode, descriptorDelay, clientCharacteristicConfiguration.getBytes())
                    .addFirstName("First Name")
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .build();
            userDataServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(USER_DATA_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(REGISTERED_USER_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(REGISTERED_USER_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_INDICATE, bluetoothGattCharacteristic.getProperties());
        assertEquals(0, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(new byte[0], bluetoothGattCharacteristic.getValue());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(clientCharacteristicConfiguration.getBytes(), bluetoothGattDescriptor.getValue());
    }

    @Test
    public void test_removeRegisteredUser_00001() {
        byte[] value = BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
        ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(value);

        Exception exception = null;
        try {
            new UserDataServiceMockCallback.Builder<>()
                    .addRegisteredUser(clientCharacteristicConfiguration)
                    .addFirstName("First Name")
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .removeRegisteredUser()
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Registered User data", exception.getMessage());
    }

    @Test
    public void test_removeRegisteredUser_00002() {
        byte[] value = BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
        ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(value);

        Exception exception = null;
        try {
            new UserDataServiceMockCallback.Builder<>()
                    .addRegisteredUser(clientCharacteristicConfiguration)
                    .addFirstName("First Name")
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .addUserControlPoint(0
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_OPERATION_FAILED
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , UserControlPoint.RESPONSE_VALUE_SUCCESS
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .removeRegisteredUser()
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_addUserControlPoint_00001() {
        long characteristicDelay = 1;
        int registerNewUserResponseValue = 2;
        int consentResponseValue = 3;
        int deleteUserDataResponseValue = 4;
        int listAllUsersResponseValue = 5;
        int deleteUsersResponseValue = 6;
        int descriptorResponseCode = 7;
        long descriptorDelay = 8;
        byte[] value = BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
        ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(value);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            UserDataServiceMockCallback userDataServiceMockCallback = new UserDataServiceMockCallback.Builder<>()
                    .addUserControlPoint(characteristicDelay
                            , registerNewUserResponseValue
                            , consentResponseValue
                            , deleteUserDataResponseValue
                            , listAllUsersResponseValue
                            , deleteUsersResponseValue
                            , descriptorResponseCode
                            , descriptorDelay
                            , clientCharacteristicConfiguration.getBytes())
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addFirstName("First Name")
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .build();
            userDataServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(USER_DATA_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(USER_CONTROL_POINT_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(USER_CONTROL_POINT_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_WRITE | BluetoothGattCharacteristic.PROPERTY_INDICATE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(new byte[0], bluetoothGattCharacteristic.getValue());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(clientCharacteristicConfiguration.getBytes(), bluetoothGattDescriptor.getValue());
    }

    @Test
    public void test_removeUserControlPoint_00001() {
        long characteristicDelay = 1;
        int registerNewUserResponseValue = 2;
        int consentResponseValue = 3;
        int deleteUserDataResponseValue = 4;
        int listAllUsersResponseValue = 5;
        int deleteUsersResponseValue = 6;
        int descriptorResponseCode = 7;
        long descriptorDelay = 8;
        byte[] value = BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
        ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(value);

        Exception exception = null;
        try {
            new UserDataServiceMockCallback.Builder<>()
                    .addUserControlPoint(characteristicDelay
                            , registerNewUserResponseValue
                            , consentResponseValue
                            , deleteUserDataResponseValue
                            , listAllUsersResponseValue
                            , deleteUsersResponseValue
                            , descriptorResponseCode
                            , descriptorDelay
                            , clientCharacteristicConfiguration.getBytes())
                    .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addFirstName("First Name")
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .removeUserControlPoint()
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no User Control Point data", exception.getMessage());
    }

    @Test
    public void test_hasNoConsent_00001() {
        ConsentTestUserDataServiceMockCallback userDataServiceMockCallback = new ConsentTestUserDataServiceMockCallback(new MockData(), false);

        assertTrue(userDataServiceMockCallback.hasNoConsent(BLETestUtilsAndroid.MOCK_DEVICE_0, null));
    }

    @Test
    public void test_hasNoConsent_00002() {
        ConsentTestUserDataServiceMockCallback userDataServiceMockCallback = new ConsentTestUserDataServiceMockCallback(new MockData(), false);

        Integer userIndex = 1;
        assertTrue(userDataServiceMockCallback.hasNoConsent(BLETestUtilsAndroid.MOCK_DEVICE_0, userIndex));
    }

    @Test
    public void test_hasNoConsent_00003() {
        ConsentTestUserDataServiceMockCallback userDataServiceMockCallback = new ConsentTestUserDataServiceMockCallback(new MockData(), false);

        Integer userIndex = 1;
        userDataServiceMockCallback.setConsent(BLETestUtilsAndroid.MOCK_DEVICE_1, 2);
        assertTrue(userDataServiceMockCallback.hasNoConsent(BLETestUtilsAndroid.MOCK_DEVICE_0, userIndex));
    }

    @Test
    public void test_hasNoConsent_00004() {
        ConsentTestUserDataServiceMockCallback userDataServiceMockCallback = new ConsentTestUserDataServiceMockCallback(new MockData(), false);

        Integer userIndex = 1;
        userDataServiceMockCallback.setConsent(BLETestUtilsAndroid.MOCK_DEVICE_0, 2);
        assertTrue(userDataServiceMockCallback.hasNoConsent(BLETestUtilsAndroid.MOCK_DEVICE_0, userIndex));
    }

    @Test
    public void test_hasNoConsent_00005() {
        ConsentTestUserDataServiceMockCallback userDataServiceMockCallback = new ConsentTestUserDataServiceMockCallback(new MockData(), false);

        Integer userIndex = 1;
        userDataServiceMockCallback.setConsent(BLETestUtilsAndroid.MOCK_DEVICE_1, userIndex);
        assertTrue(userDataServiceMockCallback.hasNoConsent(BLETestUtilsAndroid.MOCK_DEVICE_0, userIndex));
    }

    @Test
    public void test_hasNoConsent_00006() {
        ConsentTestUserDataServiceMockCallback userDataServiceMockCallback = new ConsentTestUserDataServiceMockCallback(new MockData(), false);

        Integer userIndex = 1;
        userDataServiceMockCallback.setConsent(BLETestUtilsAndroid.MOCK_DEVICE_0, userIndex);
        assertFalse(userDataServiceMockCallback.hasNoConsent(BLETestUtilsAndroid.MOCK_DEVICE_0, userIndex));
    }

}

