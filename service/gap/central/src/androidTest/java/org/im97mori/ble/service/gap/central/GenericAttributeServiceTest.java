package org.im97mori.ble.service.gap.central;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.test.filters.RequiresDevice;

import org.im97mori.ble.characteristic.u2a05.ServiceChangedAndroid;
import org.im97mori.ble.characteristic.u2b29.ClientSupportedFeatures;
import org.im97mori.ble.characteristic.u2b29.ClientSupportedFeaturesAndroid;
import org.im97mori.ble.characteristic.u2b2a.DatabaseHashAndroid;
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfigurationAndroid;
import org.im97mori.ble.test.BLETestUtilsAndroid;
import org.im97mori.ble.test.central.AbstractCentralTest;
import org.im97mori.ble.test.TestBase;
import org.junit.Test;

import java.util.Collections;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.im97mori.ble.constants.CharacteristicUUID.CLIENT_SUPPORTED_FEATURES_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.DATABASE_HASH_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.SERVICE_CHANGED_CHARACTERISTIC;
import static org.im97mori.ble.constants.DescriptorUUID.CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
import static org.im97mori.ble.constants.ServiceUUID.GENERIC_ACCESS_SERVICE;
import static org.im97mori.ble.constants.ServiceUUID.GENERIC_ATTRIBUTE_SERVICE;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

@SuppressWarnings("UnnecessaryLocalVariable")
public class GenericAttributeServiceTest extends AbstractCentralTest {

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00001() {
        GenericAttributeService genericAttributeService = new GenericAttributeService(MOCK_BLE_CONNECTION, new MockGenericAttributeServiceCallback(), null);
        genericAttributeService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.emptyList(), null);

        assertFalse(genericAttributeService.isServiceChangedCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00002() {
        GenericAttributeService genericAttributeService = new GenericAttributeService(MOCK_BLE_CONNECTION, new MockGenericAttributeServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        genericAttributeService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(genericAttributeService.isServiceChangedCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00003() {
        GenericAttributeService genericAttributeService = new GenericAttributeService(MOCK_BLE_CONNECTION, new MockGenericAttributeServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ATTRIBUTE_SERVICE, 0);
        genericAttributeService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(genericAttributeService.isServiceChangedCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00004() {
        GenericAttributeService genericAttributeService = new GenericAttributeService(MOCK_BLE_CONNECTION, new MockGenericAttributeServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ATTRIBUTE_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(SERVICE_CHANGED_CHARACTERISTIC, 0, 0));
        genericAttributeService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(genericAttributeService.isServiceChangedCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00005() {
        GenericAttributeService genericAttributeService = new GenericAttributeService(MOCK_BLE_CONNECTION, new MockGenericAttributeServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ATTRIBUTE_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(SERVICE_CHANGED_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_INDICATE, 0));
        genericAttributeService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(genericAttributeService.isServiceChangedCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00006() {
        GenericAttributeService genericAttributeService = new GenericAttributeService(MOCK_BLE_CONNECTION, new MockGenericAttributeServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ATTRIBUTE_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(SERVICE_CHANGED_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_INDICATE, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        genericAttributeService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertTrue(genericAttributeService.isServiceChangedCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00101() {
        GenericAttributeService genericAttributeService = new GenericAttributeService(MOCK_BLE_CONNECTION, new MockGenericAttributeServiceCallback(), null);
        genericAttributeService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.emptyList(), null);

        assertFalse(genericAttributeService.isClientSupportedFeaturesCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00102() {
        GenericAttributeService genericAttributeService = new GenericAttributeService(MOCK_BLE_CONNECTION, new MockGenericAttributeServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        genericAttributeService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(genericAttributeService.isClientSupportedFeaturesCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00103() {
        GenericAttributeService genericAttributeService = new GenericAttributeService(MOCK_BLE_CONNECTION, new MockGenericAttributeServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ATTRIBUTE_SERVICE, 0);
        genericAttributeService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(genericAttributeService.isClientSupportedFeaturesCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00104() {
        GenericAttributeService genericAttributeService = new GenericAttributeService(MOCK_BLE_CONNECTION, new MockGenericAttributeServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ATTRIBUTE_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(CLIENT_SUPPORTED_FEATURES_CHARACTERISTIC, 0, 0));
        genericAttributeService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(genericAttributeService.isClientSupportedFeaturesCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00105() {
        GenericAttributeService genericAttributeService = new GenericAttributeService(MOCK_BLE_CONNECTION, new MockGenericAttributeServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ATTRIBUTE_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(CLIENT_SUPPORTED_FEATURES_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        genericAttributeService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(genericAttributeService.isClientSupportedFeaturesCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00106() {
        GenericAttributeService genericAttributeService = new GenericAttributeService(MOCK_BLE_CONNECTION, new MockGenericAttributeServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ATTRIBUTE_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(CLIENT_SUPPORTED_FEATURES_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        genericAttributeService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(genericAttributeService.isClientSupportedFeaturesCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00107() {
        GenericAttributeService genericAttributeService = new GenericAttributeService(MOCK_BLE_CONNECTION, new MockGenericAttributeServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ATTRIBUTE_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(CLIENT_SUPPORTED_FEATURES_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        genericAttributeService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertTrue(genericAttributeService.isClientSupportedFeaturesCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00201() {
        GenericAttributeService genericAttributeService = new GenericAttributeService(MOCK_BLE_CONNECTION, new MockGenericAttributeServiceCallback(), null);
        genericAttributeService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.emptyList(), null);

        assertFalse(genericAttributeService.isDatabaseHashCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00202() {
        GenericAttributeService genericAttributeService = new GenericAttributeService(MOCK_BLE_CONNECTION, new MockGenericAttributeServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        genericAttributeService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(genericAttributeService.isDatabaseHashCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00203() {
        GenericAttributeService genericAttributeService = new GenericAttributeService(MOCK_BLE_CONNECTION, new MockGenericAttributeServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ATTRIBUTE_SERVICE, 0);
        genericAttributeService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(genericAttributeService.isDatabaseHashCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00204() {
        GenericAttributeService genericAttributeService = new GenericAttributeService(MOCK_BLE_CONNECTION, new MockGenericAttributeServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ATTRIBUTE_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(DATABASE_HASH_CHARACTERISTIC, 0, 0));
        genericAttributeService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(genericAttributeService.isDatabaseHashCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00205() {
        GenericAttributeService genericAttributeService = new GenericAttributeService(MOCK_BLE_CONNECTION, new MockGenericAttributeServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ATTRIBUTE_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(DATABASE_HASH_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        genericAttributeService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertTrue(genericAttributeService.isDatabaseHashCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadSuccess_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ATTRIBUTE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CLIENT_SUPPORTED_FEATURES_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[4];
        final Bundle originalBundle = new Bundle();
        MockGenericAttributeServiceCallback mockGenericAttributeServiceCallback = new MockGenericAttributeServiceCallback() {

            @Override
            public void onClientSupportedFeaturesReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull ClientSupportedFeaturesAndroid clientSupportedFeaturesAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, clientSupportedFeaturesAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        GenericAttributeService genericAttributeService = new GenericAttributeService(MOCK_BLE_CONNECTION, mockGenericAttributeServiceCallback, null);
        genericAttributeService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadSuccess_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ATTRIBUTE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DATABASE_HASH_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[4];
        final Bundle originalBundle = new Bundle();
        MockGenericAttributeServiceCallback mockGenericAttributeServiceCallback = new MockGenericAttributeServiceCallback() {

            @Override
            public void onDatabaseHashReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull DatabaseHashAndroid databaseHashAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, databaseHashAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        GenericAttributeService genericAttributeService = new GenericAttributeService(MOCK_BLE_CONNECTION, mockGenericAttributeServiceCallback, null);
        genericAttributeService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadFailed_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ATTRIBUTE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CLIENT_SUPPORTED_FEATURES_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockGenericAttributeServiceCallback mockGenericAttributeServiceCallback = new MockGenericAttributeServiceCallback() {

            @Override
            public void onClientSupportedFeaturesReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
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
        GenericAttributeService genericAttributeService = new GenericAttributeService(MOCK_BLE_CONNECTION, mockGenericAttributeServiceCallback, null);
        genericAttributeService.onCharacteristicReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadFailed_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ATTRIBUTE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DATABASE_HASH_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockGenericAttributeServiceCallback mockGenericAttributeServiceCallback = new MockGenericAttributeServiceCallback() {

            @Override
            public void onDatabaseHashReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
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
        GenericAttributeService genericAttributeService = new GenericAttributeService(MOCK_BLE_CONNECTION, mockGenericAttributeServiceCallback, null);
        genericAttributeService.onCharacteristicReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadTimeout_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ATTRIBUTE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CLIENT_SUPPORTED_FEATURES_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockGenericAttributeServiceCallback mockGenericAttributeServiceCallback = new MockGenericAttributeServiceCallback() {

            @Override
            public void onClientSupportedFeaturesReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
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
        GenericAttributeService genericAttributeService = new GenericAttributeService(MOCK_BLE_CONNECTION, mockGenericAttributeServiceCallback, null);
        genericAttributeService.onCharacteristicReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadTimeout_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ATTRIBUTE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DATABASE_HASH_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockGenericAttributeServiceCallback mockGenericAttributeServiceCallback = new MockGenericAttributeServiceCallback() {

            @Override
            public void onDatabaseHashReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
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
        GenericAttributeService genericAttributeService = new GenericAttributeService(MOCK_BLE_CONNECTION, mockGenericAttributeServiceCallback, null);
        genericAttributeService.onCharacteristicReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicWriteSuccess_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ATTRIBUTE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CLIENT_SUPPORTED_FEATURES_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[4];
        final Bundle originalBundle = new Bundle();
        MockGenericAttributeServiceCallback mockGenericAttributeServiceCallback = new MockGenericAttributeServiceCallback() {

            @Override
            public void onClientSupportedFeaturesWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull ClientSupportedFeaturesAndroid clientSupportedFeaturesAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, clientSupportedFeaturesAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        GenericAttributeService genericAttributeService = new GenericAttributeService(MOCK_BLE_CONNECTION, mockGenericAttributeServiceCallback, null);
        genericAttributeService.onCharacteristicWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }


    @Test
    @RequiresDevice
    public void test_onCharacteristicWriteFailed_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ATTRIBUTE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CLIENT_SUPPORTED_FEATURES_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockGenericAttributeServiceCallback mockGenericAttributeServiceCallback = new MockGenericAttributeServiceCallback() {

            @Override
            public void onClientSupportedFeaturesWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
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
        GenericAttributeService genericAttributeService = new GenericAttributeService(MOCK_BLE_CONNECTION, mockGenericAttributeServiceCallback, null);
        genericAttributeService.onCharacteristicWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicWriteTimeout_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ATTRIBUTE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CLIENT_SUPPORTED_FEATURES_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockGenericAttributeServiceCallback mockGenericAttributeServiceCallback = new MockGenericAttributeServiceCallback() {

            @Override
            public void onClientSupportedFeaturesWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
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
        GenericAttributeService genericAttributeService = new GenericAttributeService(MOCK_BLE_CONNECTION, mockGenericAttributeServiceCallback, null);
        genericAttributeService.onCharacteristicWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorReadSuccess_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ATTRIBUTE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = SERVICE_CHANGED_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        MockGenericAttributeServiceCallback mockGenericAttributeServiceCallback = new MockGenericAttributeServiceCallback() {

            @Override
            public void onServiceChangedClientCharacteristicConfigurationReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull Integer descriptorInstanceId, @NonNull ClientCharacteristicConfigurationAndroid clientCharacteristicConfigurationAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertArrayEquals(originalValues, clientCharacteristicConfigurationAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        GenericAttributeService genericAttributeService = new GenericAttributeService(MOCK_BLE_CONNECTION, mockGenericAttributeServiceCallback, null);
        genericAttributeService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorReadFailed_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ATTRIBUTE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = SERVICE_CHANGED_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        MockGenericAttributeServiceCallback mockGenericAttributeServiceCallback = new MockGenericAttributeServiceCallback() {

            @Override
            public void onServiceChangedClientCharacteristicConfigurationReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        GenericAttributeService genericAttributeService = new GenericAttributeService(MOCK_BLE_CONNECTION, mockGenericAttributeServiceCallback, null);
        genericAttributeService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorReadTimeout_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ATTRIBUTE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = SERVICE_CHANGED_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final long originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        MockGenericAttributeServiceCallback mockGenericAttributeServiceCallback = new MockGenericAttributeServiceCallback() {

            @Override
            public void onServiceChangedClientCharacteristicConfigurationReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        GenericAttributeService genericAttributeService = new GenericAttributeService(MOCK_BLE_CONNECTION, mockGenericAttributeServiceCallback, null);
        genericAttributeService.onDescriptorReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteSuccess_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ATTRIBUTE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = SERVICE_CHANGED_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MockGenericAttributeServiceCallback mockGenericAttributeServiceCallback = new MockGenericAttributeServiceCallback() {

            @Override
            public void onServiceChangedIndicateStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull Integer descriptorInstanceId, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        GenericAttributeService genericAttributeService = new GenericAttributeService(MOCK_BLE_CONNECTION, mockGenericAttributeServiceCallback, null);
        genericAttributeService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteSuccess_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ATTRIBUTE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = SERVICE_CHANGED_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MockGenericAttributeServiceCallback mockGenericAttributeServiceCallback = new MockGenericAttributeServiceCallback() {

            @Override
            public void onServiceChangedIndicateStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull Integer descriptorInstanceId, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        GenericAttributeService genericAttributeService = new GenericAttributeService(MOCK_BLE_CONNECTION, mockGenericAttributeServiceCallback, null);
        genericAttributeService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteFailed_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ATTRIBUTE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = SERVICE_CHANGED_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MockGenericAttributeServiceCallback mockGenericAttributeServiceCallback = new MockGenericAttributeServiceCallback() {

            @Override
            public void onServiceChangedIndicateStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        GenericAttributeService genericAttributeService = new GenericAttributeService(MOCK_BLE_CONNECTION, mockGenericAttributeServiceCallback, null);
        genericAttributeService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteFailed_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ATTRIBUTE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = SERVICE_CHANGED_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MockGenericAttributeServiceCallback mockGenericAttributeServiceCallback = new MockGenericAttributeServiceCallback() {

            @Override
            public void onServiceChangedIndicateStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        GenericAttributeService genericAttributeService = new GenericAttributeService(MOCK_BLE_CONNECTION, mockGenericAttributeServiceCallback, null);
        genericAttributeService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteTimeout_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ATTRIBUTE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = SERVICE_CHANGED_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final long originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MockGenericAttributeServiceCallback mockGenericAttributeServiceCallback = new MockGenericAttributeServiceCallback() {

            @Override
            public void onServiceChangedIndicateStartTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        GenericAttributeService genericAttributeService = new GenericAttributeService(MOCK_BLE_CONNECTION, mockGenericAttributeServiceCallback, null);
        genericAttributeService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteTimeout_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ATTRIBUTE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = SERVICE_CHANGED_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final long originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MockGenericAttributeServiceCallback mockGenericAttributeServiceCallback = new MockGenericAttributeServiceCallback() {

            @Override
            public void onServiceChangedIndicateStopTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        GenericAttributeService genericAttributeService = new GenericAttributeService(MOCK_BLE_CONNECTION, mockGenericAttributeServiceCallback, null);
        genericAttributeService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicNotified_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ATTRIBUTE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = SERVICE_CHANGED_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5, 6, 7};
        MockGenericAttributeServiceCallback mockGenericAttributeServiceCallback = new MockGenericAttributeServiceCallback() {

            @Override
            public void onServiceChangedIndicated(@NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull ServiceChangedAndroid serviceChangedAndroid) {
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, serviceChangedAndroid.getBytes());
                isCalled.set(true);
            }


        };

        GenericAttributeService genericAttributeService = new GenericAttributeService(MOCK_BLE_CONNECTION, mockGenericAttributeServiceCallback, null);
        genericAttributeService.onCharacteristicNotified(originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_isServiceChangedCharacteristicSupported_00001() {
        GenericAttributeService genericAttributeService = new GenericAttributeService(MOCK_BLE_CONNECTION, new MockGenericAttributeServiceCallback(), null);

        assertFalse(genericAttributeService.isServiceChangedCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_isServiceChangedCharacteristicSupported_00002() {
        GenericAttributeService genericAttributeService = new GenericAttributeService(MOCK_BLE_CONNECTION, new MockGenericAttributeServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ATTRIBUTE_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(SERVICE_CHANGED_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_INDICATE, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        genericAttributeService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertTrue(genericAttributeService.isServiceChangedCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_isServiceChangedCharacteristicSupported_00003() {
        GenericAttributeService genericAttributeService = new GenericAttributeService(MOCK_BLE_CONNECTION, new MockGenericAttributeServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ATTRIBUTE_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(SERVICE_CHANGED_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_INDICATE, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        genericAttributeService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        genericAttributeService.onBLEDisconnected(1, BLETestUtilsAndroid.MOCK_DEVICE_0, 0, null);

        assertFalse(genericAttributeService.isServiceChangedCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_isClientSupportedFeaturesCharacteristicSupported_00001() {
        GenericAttributeService genericAttributeService = new GenericAttributeService(MOCK_BLE_CONNECTION, new MockGenericAttributeServiceCallback(), null);

        assertFalse(genericAttributeService.isClientSupportedFeaturesCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_isClientSupportedFeaturesCharacteristicSupported_00002() {
        GenericAttributeService genericAttributeService = new GenericAttributeService(MOCK_BLE_CONNECTION, new MockGenericAttributeServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ATTRIBUTE_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(CLIENT_SUPPORTED_FEATURES_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        genericAttributeService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertTrue(genericAttributeService.isClientSupportedFeaturesCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_isClientSupportedFeaturesCharacteristicSupported_00003() {
        GenericAttributeService genericAttributeService = new GenericAttributeService(MOCK_BLE_CONNECTION, new MockGenericAttributeServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ATTRIBUTE_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(CLIENT_SUPPORTED_FEATURES_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        genericAttributeService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        genericAttributeService.onBLEDisconnected(1, BLETestUtilsAndroid.MOCK_DEVICE_0, 0, null);

        assertFalse(genericAttributeService.isClientSupportedFeaturesCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_isDatabaseHashCharacteristicSupported_00001() {
        GenericAttributeService genericAttributeService = new GenericAttributeService(MOCK_BLE_CONNECTION, new MockGenericAttributeServiceCallback(), null);

        assertFalse(genericAttributeService.isDatabaseHashCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_isDatabaseHashCharacteristicSupported_00002() {
        GenericAttributeService genericAttributeService = new GenericAttributeService(MOCK_BLE_CONNECTION, new MockGenericAttributeServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ATTRIBUTE_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(DATABASE_HASH_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        genericAttributeService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertTrue(genericAttributeService.isDatabaseHashCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_isDatabaseHashCharacteristicSupported_00003() {
        GenericAttributeService genericAttributeService = new GenericAttributeService(MOCK_BLE_CONNECTION, new MockGenericAttributeServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ATTRIBUTE_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(DATABASE_HASH_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        genericAttributeService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        genericAttributeService.onBLEDisconnected(1, BLETestUtilsAndroid.MOCK_DEVICE_0, 0, null);

        assertFalse(genericAttributeService.isDatabaseHashCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_getServiceChangedClientCharacteristicConfiguration_00001() {
        GenericAttributeService genericAttributeService = new GenericAttributeService(MOCK_BLE_CONNECTION, new MockGenericAttributeServiceCallback(), null);

        assertNull(genericAttributeService.getServiceChangedClientCharacteristicConfiguration());
    }

    @Test
    @RequiresDevice
    public void test_getServiceChangedClientCharacteristicConfiguration_00002() {
        GenericAttributeService genericAttributeService = new GenericAttributeService(MOCK_BLE_CONNECTION, new MockGenericAttributeServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(genericAttributeService.getServiceChangedClientCharacteristicConfiguration());
    }

    @Test
    @RequiresDevice
    public void test_getServiceChangedClientCharacteristicConfiguration_00003() {
        GenericAttributeService genericAttributeService = new GenericAttributeService(MOCK_BLE_CONNECTION, new MockGenericAttributeServiceCallback(), null) {

            @Override
            public boolean isServiceChangedCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(genericAttributeService.getServiceChangedClientCharacteristicConfiguration());
    }

    @Test
    @RequiresDevice
    public void test_getServiceChangedClientCharacteristicConfiguration_00004() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateReadDescriptorTaskId(originalTaskId);
        GenericAttributeService genericAttributeService = new GenericAttributeService(MOCK_BLE_CONNECTION, new MockGenericAttributeServiceCallback(), null) {

            @Override
            public boolean isServiceChangedCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = genericAttributeService.getServiceChangedClientCharacteristicConfiguration();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    @RequiresDevice
    public void test_startServiceChangedIndication_00001() {
        GenericAttributeService genericAttributeService = new GenericAttributeService(MOCK_BLE_CONNECTION, new MockGenericAttributeServiceCallback(), null);

        assertNull(genericAttributeService.startServiceChangedIndication());
    }

    @Test
    @RequiresDevice
    public void test_startServiceChangedIndication_00002() {
        GenericAttributeService genericAttributeService = new GenericAttributeService(MOCK_BLE_CONNECTION, new MockGenericAttributeServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(genericAttributeService.startServiceChangedIndication());
    }

    @Test
    @RequiresDevice
    public void test_startServiceChangedIndication_00003() {
        GenericAttributeService genericAttributeService = new GenericAttributeService(MOCK_BLE_CONNECTION, new MockGenericAttributeServiceCallback(), null) {

            @Override
            public boolean isServiceChangedCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(genericAttributeService.startServiceChangedIndication());
    }

    @Test
    @RequiresDevice
    public void test_startServiceChangedIndication_00004() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateWriteDescriptorTaskId(originalTaskId);
        GenericAttributeService genericAttributeService = new GenericAttributeService(MOCK_BLE_CONNECTION, new MockGenericAttributeServiceCallback(), null) {


            @Override
            public boolean isServiceChangedCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = genericAttributeService.startServiceChangedIndication();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    @RequiresDevice
    public void test_stopServiceChangedIndication_00001() {
        GenericAttributeService genericAttributeService = new GenericAttributeService(MOCK_BLE_CONNECTION, new MockGenericAttributeServiceCallback(), null);

        assertNull(genericAttributeService.stopServiceChangedIndication());
    }

    @Test
    @RequiresDevice
    public void test_stopServiceChangedIndication_00002() {
        GenericAttributeService genericAttributeService = new GenericAttributeService(MOCK_BLE_CONNECTION, new MockGenericAttributeServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(genericAttributeService.stopServiceChangedIndication());
    }

    @Test
    @RequiresDevice
    public void test_stopServiceChangedIndication_00003() {
        GenericAttributeService genericAttributeService = new GenericAttributeService(MOCK_BLE_CONNECTION, new MockGenericAttributeServiceCallback(), null) {

            @Override
            public boolean isServiceChangedCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(genericAttributeService.stopServiceChangedIndication());
    }

    @Test
    @RequiresDevice
    public void test_stopServiceChangedIndication_00004() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateWriteDescriptorTaskId(originalTaskId);
        GenericAttributeService genericAttributeService = new GenericAttributeService(MOCK_BLE_CONNECTION, new MockGenericAttributeServiceCallback(), null) {

            @Override
            public boolean isServiceChangedCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = genericAttributeService.stopServiceChangedIndication();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    @RequiresDevice
    public void test_getClientSupportedFeatures_00001() {
        GenericAttributeService genericAttributeService = new GenericAttributeService(MOCK_BLE_CONNECTION, new MockGenericAttributeServiceCallback(), null);

        assertNull(genericAttributeService.getClientSupportedFeatures());
    }

    @Test
    @RequiresDevice
    public void test_getClientSupportedFeatures_00002() {
        GenericAttributeService genericAttributeService = new GenericAttributeService(MOCK_BLE_CONNECTION, new MockGenericAttributeServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(genericAttributeService.getClientSupportedFeatures());
    }

    @Test
    @RequiresDevice
    public void test_getClientSupportedFeatures_00003() {
        GenericAttributeService genericAttributeService = new GenericAttributeService(MOCK_BLE_CONNECTION, new MockGenericAttributeServiceCallback(), null) {

            @Override
            public boolean isClientSupportedFeaturesCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(genericAttributeService.getClientSupportedFeatures());
    }

    @Test
    @RequiresDevice
    public void test_getClientSupportedFeatures_00004() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateReadCharacteristicTaskId(originalTaskId);
        GenericAttributeService genericAttributeService = new GenericAttributeService(MOCK_BLE_CONNECTION, new MockGenericAttributeServiceCallback(), null) {

            @Override
            public boolean isClientSupportedFeaturesCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = genericAttributeService.getClientSupportedFeatures();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    @RequiresDevice
    public void test_setClientSupportedFeatures_00001() {
        GenericAttributeService genericAttributeService = new GenericAttributeService(MOCK_BLE_CONNECTION, new MockGenericAttributeServiceCallback(), null);
        ClientSupportedFeatures clientSupportedFeatures = new ClientSupportedFeatures(new byte[]{1});

        assertNull(genericAttributeService.setClientSupportedFeatures(clientSupportedFeatures));
    }

    @Test
    @RequiresDevice
    public void test_setClientSupportedFeatures_00002() {
        GenericAttributeService genericAttributeService = new GenericAttributeService(MOCK_BLE_CONNECTION, new MockGenericAttributeServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        ClientSupportedFeatures clientSupportedFeatures = new ClientSupportedFeatures(new byte[]{1});

        assertNull(genericAttributeService.setClientSupportedFeatures(clientSupportedFeatures));
    }

    @Test
    @RequiresDevice
    public void test_setClientSupportedFeatures_00003() {
        GenericAttributeService genericAttributeService = new GenericAttributeService(MOCK_BLE_CONNECTION, new MockGenericAttributeServiceCallback(), null) {

            @Override
            public boolean isClientSupportedFeaturesCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        ClientSupportedFeatures clientSupportedFeatures = new ClientSupportedFeatures(new byte[]{1});

        assertNull(genericAttributeService.setClientSupportedFeatures(clientSupportedFeatures));
    }

    @Test
    @RequiresDevice
    public void test_setClientSupportedFeatures_00004() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateWriteCharacteristicTaskId(originalTaskId);
        GenericAttributeService genericAttributeService = new GenericAttributeService(MOCK_BLE_CONNECTION, new MockGenericAttributeServiceCallback(), null) {

            @Override
            public boolean isClientSupportedFeaturesCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        ClientSupportedFeatures clientSupportedFeatures = new ClientSupportedFeatures(new byte[]{1});

        Integer taskId = genericAttributeService.setClientSupportedFeatures(clientSupportedFeatures);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    @RequiresDevice
    public void test_getDatabaseHash_00001() {
        GenericAttributeService genericAttributeService = new GenericAttributeService(MOCK_BLE_CONNECTION, new MockGenericAttributeServiceCallback(), null);

        assertNull(genericAttributeService.getDatabaseHash());
    }

    @Test
    @RequiresDevice
    public void test_getDatabaseHash_00002() {
        GenericAttributeService genericAttributeService = new GenericAttributeService(MOCK_BLE_CONNECTION, new MockGenericAttributeServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(genericAttributeService.getDatabaseHash());
    }

    @Test
    @RequiresDevice
    public void test_getDatabaseHash_00003() {
        GenericAttributeService genericAttributeService = new GenericAttributeService(MOCK_BLE_CONNECTION, new MockGenericAttributeServiceCallback(), null) {

            @Override
            public boolean isDatabaseHashCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(genericAttributeService.getDatabaseHash());
    }

    @Test
    @RequiresDevice
    public void test_getDatabaseHash_00004() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateReadCharacteristicTaskId(originalTaskId);
        GenericAttributeService genericAttributeService = new GenericAttributeService(MOCK_BLE_CONNECTION, new MockGenericAttributeServiceCallback(), null) {

            @Override
            public boolean isDatabaseHashCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = genericAttributeService.getDatabaseHash();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

}
