package org.im97mori.ble.service.gap.central;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.BLECallback;
import org.im97mori.ble.ByteArrayInterface;
import org.im97mori.ble.characteristic.u2a05.ServiceChangedAndroid;
import org.im97mori.ble.characteristic.u2b29.ClientSupportedFeatures;
import org.im97mori.ble.characteristic.u2b29.ClientSupportedFeaturesAndroid;
import org.im97mori.ble.characteristic.u2b2a.DatabaseHashAndroid;
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfigurationAndroid;
import org.im97mori.ble.test.central.MockBLEConnection;
import org.junit.Test;

import java.util.Collections;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.CLIENT_SUPPORTED_FEATURES_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.DATABASE_HASH_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.SERVICE_CHANGED_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.DescriptorUUID.CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
import static org.im97mori.ble.BLEConstants.ServiceUUID.GENERIC_ACCESS_SERVICE;
import static org.im97mori.ble.BLEConstants.ServiceUUID.GENERIC_ATTRIBUTE_SERVICE;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

@SuppressWarnings("UnnecessaryLocalVariable")
public class GenericAttributeServiceTest {

    @Test
    public void test_onDiscoverServiceSuccess_00001() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        GenericAttributeService genericAttributeService = new GenericAttributeService(mockBLEConnection, new MockGenericAttributeServiceCallback(), null);
        genericAttributeService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.<BluetoothGattService>emptyList(), null);

        assertFalse(genericAttributeService.isServiceChangedCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00002() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        GenericAttributeService genericAttributeService = new GenericAttributeService(mockBLEConnection, new MockGenericAttributeServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        genericAttributeService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(genericAttributeService.isServiceChangedCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00003() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        GenericAttributeService genericAttributeService = new GenericAttributeService(mockBLEConnection, new MockGenericAttributeServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ATTRIBUTE_SERVICE, 0);
        genericAttributeService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(genericAttributeService.isServiceChangedCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00004() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        GenericAttributeService genericAttributeService = new GenericAttributeService(mockBLEConnection, new MockGenericAttributeServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ATTRIBUTE_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(SERVICE_CHANGED_CHARACTERISTIC, 0, 0));
        genericAttributeService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(genericAttributeService.isServiceChangedCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00005() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        GenericAttributeService genericAttributeService = new GenericAttributeService(mockBLEConnection, new MockGenericAttributeServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ATTRIBUTE_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(SERVICE_CHANGED_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_INDICATE, 0));
        genericAttributeService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(genericAttributeService.isServiceChangedCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00006() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        GenericAttributeService genericAttributeService = new GenericAttributeService(mockBLEConnection, new MockGenericAttributeServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ATTRIBUTE_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(SERVICE_CHANGED_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_INDICATE, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        genericAttributeService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertTrue(genericAttributeService.isServiceChangedCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00101() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        GenericAttributeService genericAttributeService = new GenericAttributeService(mockBLEConnection, new MockGenericAttributeServiceCallback(), null);
        genericAttributeService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.<BluetoothGattService>emptyList(), null);

        assertFalse(genericAttributeService.isClientSupportedFeaturesCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00102() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        GenericAttributeService genericAttributeService = new GenericAttributeService(mockBLEConnection, new MockGenericAttributeServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        genericAttributeService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(genericAttributeService.isClientSupportedFeaturesCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00103() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        GenericAttributeService genericAttributeService = new GenericAttributeService(mockBLEConnection, new MockGenericAttributeServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ATTRIBUTE_SERVICE, 0);
        genericAttributeService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(genericAttributeService.isClientSupportedFeaturesCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00104() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        GenericAttributeService genericAttributeService = new GenericAttributeService(mockBLEConnection, new MockGenericAttributeServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ATTRIBUTE_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(CLIENT_SUPPORTED_FEATURES_CHARACTERISTIC, 0, 0));
        genericAttributeService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(genericAttributeService.isClientSupportedFeaturesCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00105() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        GenericAttributeService genericAttributeService = new GenericAttributeService(mockBLEConnection, new MockGenericAttributeServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ATTRIBUTE_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(CLIENT_SUPPORTED_FEATURES_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        genericAttributeService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(genericAttributeService.isClientSupportedFeaturesCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00106() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        GenericAttributeService genericAttributeService = new GenericAttributeService(mockBLEConnection, new MockGenericAttributeServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ATTRIBUTE_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(CLIENT_SUPPORTED_FEATURES_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        genericAttributeService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(genericAttributeService.isClientSupportedFeaturesCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00107() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        GenericAttributeService genericAttributeService = new GenericAttributeService(mockBLEConnection, new MockGenericAttributeServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ATTRIBUTE_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(CLIENT_SUPPORTED_FEATURES_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        genericAttributeService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertTrue(genericAttributeService.isClientSupportedFeaturesCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00201() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        GenericAttributeService genericAttributeService = new GenericAttributeService(mockBLEConnection, new MockGenericAttributeServiceCallback(), null);
        genericAttributeService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.<BluetoothGattService>emptyList(), null);

        assertFalse(genericAttributeService.isDatabaseHashCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00202() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        GenericAttributeService genericAttributeService = new GenericAttributeService(mockBLEConnection, new MockGenericAttributeServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        genericAttributeService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(genericAttributeService.isDatabaseHashCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00203() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        GenericAttributeService genericAttributeService = new GenericAttributeService(mockBLEConnection, new MockGenericAttributeServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ATTRIBUTE_SERVICE, 0);
        genericAttributeService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(genericAttributeService.isDatabaseHashCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00204() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        GenericAttributeService genericAttributeService = new GenericAttributeService(mockBLEConnection, new MockGenericAttributeServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ATTRIBUTE_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(DATABASE_HASH_CHARACTERISTIC, 0, 0));
        genericAttributeService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(genericAttributeService.isDatabaseHashCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00205() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        GenericAttributeService genericAttributeService = new GenericAttributeService(mockBLEConnection, new MockGenericAttributeServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ATTRIBUTE_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(DATABASE_HASH_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        genericAttributeService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertTrue(genericAttributeService.isDatabaseHashCharacteristicSupporeted());
    }

    @Test
    public void test_onCharacteristicReadSuccess_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ATTRIBUTE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CLIENT_SUPPORTED_FEATURES_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[4];
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
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
        GenericAttributeService genericAttributeService = new GenericAttributeService(mockBLEConnection, mockGenericAttributeServiceCallback, null);
        genericAttributeService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadSuccess_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ATTRIBUTE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DATABASE_HASH_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[4];
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
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
        GenericAttributeService genericAttributeService = new GenericAttributeService(mockBLEConnection, mockGenericAttributeServiceCallback, null);
        genericAttributeService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadFailed_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ATTRIBUTE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CLIENT_SUPPORTED_FEATURES_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
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
        GenericAttributeService genericAttributeService = new GenericAttributeService(mockBLEConnection, mockGenericAttributeServiceCallback, null);
        genericAttributeService.onCharacteristicReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadFailed_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ATTRIBUTE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DATABASE_HASH_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
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
        GenericAttributeService genericAttributeService = new GenericAttributeService(mockBLEConnection, mockGenericAttributeServiceCallback, null);
        genericAttributeService.onCharacteristicReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadTimeout_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ATTRIBUTE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CLIENT_SUPPORTED_FEATURES_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
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
        GenericAttributeService genericAttributeService = new GenericAttributeService(mockBLEConnection, mockGenericAttributeServiceCallback, null);
        genericAttributeService.onCharacteristicReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadTimeout_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ATTRIBUTE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DATABASE_HASH_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
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
        GenericAttributeService genericAttributeService = new GenericAttributeService(mockBLEConnection, mockGenericAttributeServiceCallback, null);
        genericAttributeService.onCharacteristicReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteSuccess_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ATTRIBUTE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CLIENT_SUPPORTED_FEATURES_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[4];
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
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
        GenericAttributeService genericAttributeService = new GenericAttributeService(mockBLEConnection, mockGenericAttributeServiceCallback, null);
        genericAttributeService.onCharacteristicWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }


    @Test
    public void test_onCharacteristicWriteFailed_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ATTRIBUTE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CLIENT_SUPPORTED_FEATURES_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
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
        GenericAttributeService genericAttributeService = new GenericAttributeService(mockBLEConnection, mockGenericAttributeServiceCallback, null);
        genericAttributeService.onCharacteristicWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteTimeout_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ATTRIBUTE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CLIENT_SUPPORTED_FEATURES_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
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
        GenericAttributeService genericAttributeService = new GenericAttributeService(mockBLEConnection, mockGenericAttributeServiceCallback, null);
        genericAttributeService.onCharacteristicWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ATTRIBUTE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = SERVICE_CHANGED_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
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
        GenericAttributeService genericAttributeService = new GenericAttributeService(mockBLEConnection, mockGenericAttributeServiceCallback, null);
        genericAttributeService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadFailed_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ATTRIBUTE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = SERVICE_CHANGED_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
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
        GenericAttributeService genericAttributeService = new GenericAttributeService(mockBLEConnection, mockGenericAttributeServiceCallback, null);
        genericAttributeService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadTimeout_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ATTRIBUTE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = SERVICE_CHANGED_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final long originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
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
        GenericAttributeService genericAttributeService = new GenericAttributeService(mockBLEConnection, mockGenericAttributeServiceCallback, null);
        genericAttributeService.onDescriptorReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteSuccess_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ATTRIBUTE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = SERVICE_CHANGED_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
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
        GenericAttributeService genericAttributeService = new GenericAttributeService(mockBLEConnection, mockGenericAttributeServiceCallback, null);
        genericAttributeService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteSuccess_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ATTRIBUTE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = SERVICE_CHANGED_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
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
        GenericAttributeService genericAttributeService = new GenericAttributeService(mockBLEConnection, mockGenericAttributeServiceCallback, null);
        genericAttributeService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteFailed_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ATTRIBUTE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = SERVICE_CHANGED_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
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
        GenericAttributeService genericAttributeService = new GenericAttributeService(mockBLEConnection, mockGenericAttributeServiceCallback, null);
        genericAttributeService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteFailed_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ATTRIBUTE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = SERVICE_CHANGED_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
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
        GenericAttributeService genericAttributeService = new GenericAttributeService(mockBLEConnection, mockGenericAttributeServiceCallback, null);
        genericAttributeService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteTimeout_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ATTRIBUTE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = SERVICE_CHANGED_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final long originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
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
        GenericAttributeService genericAttributeService = new GenericAttributeService(mockBLEConnection, mockGenericAttributeServiceCallback, null);
        genericAttributeService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteTimeout_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ATTRIBUTE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = SERVICE_CHANGED_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final long originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
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
        GenericAttributeService genericAttributeService = new GenericAttributeService(mockBLEConnection, mockGenericAttributeServiceCallback, null);
        genericAttributeService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicNotified_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ATTRIBUTE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = SERVICE_CHANGED_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5, 6, 7};

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
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

        GenericAttributeService genericAttributeService = new GenericAttributeService(mockBLEConnection, mockGenericAttributeServiceCallback, null);
        genericAttributeService.onCharacteristicNotified(originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_isServiceChangedCharacteristicSupporeted_00001() {
        GenericAttributeService genericAttributeService = new GenericAttributeService(new MockBLEConnection(), new MockGenericAttributeServiceCallback(), null);

        assertFalse(genericAttributeService.isServiceChangedCharacteristicSupporeted());
    }

    @Test
    public void test_isServiceChangedCharacteristicSupporeted_00002() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        GenericAttributeService genericAttributeService = new GenericAttributeService(mockBLEConnection, new MockGenericAttributeServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ATTRIBUTE_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(SERVICE_CHANGED_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_INDICATE, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        genericAttributeService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertTrue(genericAttributeService.isServiceChangedCharacteristicSupporeted());
    }

    @Test
    public void test_isServiceChangedCharacteristicSupporeted_00003() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        GenericAttributeService genericAttributeService = new GenericAttributeService(mockBLEConnection, new MockGenericAttributeServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ATTRIBUTE_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(SERVICE_CHANGED_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_INDICATE, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        genericAttributeService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        genericAttributeService.onBLEDisconnected(1, MockBLEConnection.MOCK_DEVICE, 0, null);

        assertFalse(genericAttributeService.isServiceChangedCharacteristicSupporeted());
    }

    @Test
    public void test_isClientSupportedFeaturesCharacteristicSupporeted_00001() {
        GenericAttributeService genericAttributeService = new GenericAttributeService(new MockBLEConnection(), new MockGenericAttributeServiceCallback(), null);

        assertFalse(genericAttributeService.isClientSupportedFeaturesCharacteristicSupporeted());
    }

    @Test
    public void test_isClientSupportedFeaturesCharacteristicSupporeted_00002() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        GenericAttributeService genericAttributeService = new GenericAttributeService(mockBLEConnection, new MockGenericAttributeServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ATTRIBUTE_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(CLIENT_SUPPORTED_FEATURES_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        genericAttributeService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertTrue(genericAttributeService.isClientSupportedFeaturesCharacteristicSupporeted());
    }

    @Test
    public void test_isClientSupportedFeaturesCharacteristicSupporeted_00003() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        GenericAttributeService genericAttributeService = new GenericAttributeService(mockBLEConnection, new MockGenericAttributeServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ATTRIBUTE_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(CLIENT_SUPPORTED_FEATURES_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        genericAttributeService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        genericAttributeService.onBLEDisconnected(1, MockBLEConnection.MOCK_DEVICE, 0, null);

        assertFalse(genericAttributeService.isClientSupportedFeaturesCharacteristicSupporeted());
    }

    @Test
    public void test_isDatabaseHashCharacteristicSupporeted_00001() {
        GenericAttributeService genericAttributeService = new GenericAttributeService(new MockBLEConnection(), new MockGenericAttributeServiceCallback(), null);

        assertFalse(genericAttributeService.isDatabaseHashCharacteristicSupporeted());
    }

    @Test
    public void test_isDatabaseHashCharacteristicSupporeted_00002() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        GenericAttributeService genericAttributeService = new GenericAttributeService(mockBLEConnection, new MockGenericAttributeServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ATTRIBUTE_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(DATABASE_HASH_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        genericAttributeService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertTrue(genericAttributeService.isDatabaseHashCharacteristicSupporeted());
    }

    @Test
    public void test_isDatabaseHashCharacteristicSupporeted_00003() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        GenericAttributeService genericAttributeService = new GenericAttributeService(mockBLEConnection, new MockGenericAttributeServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ATTRIBUTE_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(DATABASE_HASH_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        genericAttributeService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        genericAttributeService.onBLEDisconnected(1, MockBLEConnection.MOCK_DEVICE, 0, null);

        assertFalse(genericAttributeService.isDatabaseHashCharacteristicSupporeted());
    }

    @Test
    public void test_getServiceChangedClientCharacteristicConfiguration_00001() {
        GenericAttributeService genericAttributeService = new GenericAttributeService(new MockBLEConnection(), new MockGenericAttributeServiceCallback(), null);

        assertNull(genericAttributeService.getServiceChangedClientCharacteristicConfiguration());
    }

    @Test
    public void test_getServiceChangedClientCharacteristicConfiguration_00002() {
        GenericAttributeService genericAttributeService = new GenericAttributeService(new MockBLEConnection(), new MockGenericAttributeServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(genericAttributeService.getServiceChangedClientCharacteristicConfiguration());
    }

    @Test
    public void test_getServiceChangedClientCharacteristicConfiguration_00003() {
        GenericAttributeService genericAttributeService = new GenericAttributeService(new MockBLEConnection(), new MockGenericAttributeServiceCallback(), null) {

            @Override
            public boolean isServiceChangedCharacteristicSupporeted() {
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
    public void test_getServiceChangedClientCharacteristicConfiguration_00004() {
        final Integer originalTaskId = 1;
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {

            @Override
            public synchronized Integer createReadDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }

        };
        GenericAttributeService genericAttributeService = new GenericAttributeService(mockBLEConnection, new MockGenericAttributeServiceCallback(), null) {

            @Override
            public boolean isServiceChangedCharacteristicSupporeted() {
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
    public void test_startServiceChangedIndication_00001() {
        GenericAttributeService genericAttributeService = new GenericAttributeService(new MockBLEConnection(), new MockGenericAttributeServiceCallback(), null);

        assertNull(genericAttributeService.startServiceChangedIndication());
    }

    @Test
    public void test_startServiceChangedIndication_00002() {
        GenericAttributeService genericAttributeService = new GenericAttributeService(new MockBLEConnection(), new MockGenericAttributeServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(genericAttributeService.startServiceChangedIndication());
    }

    @Test
    public void test_startServiceChangedIndication_00003() {
        GenericAttributeService genericAttributeService = new GenericAttributeService(new MockBLEConnection(), new MockGenericAttributeServiceCallback(), null) {

            @Override
            public boolean isServiceChangedCharacteristicSupporeted() {
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
    public void test_startServiceChangedIndication_00004() {
        final Integer originalTaskId = 1;
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {

            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }

        };
        GenericAttributeService genericAttributeService = new GenericAttributeService(mockBLEConnection, new MockGenericAttributeServiceCallback(), null) {


            @Override
            public boolean isServiceChangedCharacteristicSupporeted() {
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
    public void test_stopServiceChangedIndication_00001() {
        GenericAttributeService genericAttributeService = new GenericAttributeService(new MockBLEConnection(), new MockGenericAttributeServiceCallback(), null);

        assertNull(genericAttributeService.stopServiceChangedIndication());
    }

    @Test
    public void test_stopServiceChangedIndication_00002() {
        GenericAttributeService genericAttributeService = new GenericAttributeService(new MockBLEConnection(), new MockGenericAttributeServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(genericAttributeService.stopServiceChangedIndication());
    }

    @Test
    public void test_stopServiceChangedIndication_00003() {
        GenericAttributeService genericAttributeService = new GenericAttributeService(new MockBLEConnection(), new MockGenericAttributeServiceCallback(), null) {

            @Override
            public boolean isServiceChangedCharacteristicSupporeted() {
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
    public void test_stopServiceChangedIndication_00004() {
        final Integer originalTaskId = 1;
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {

            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }

        };
        GenericAttributeService genericAttributeService = new GenericAttributeService(mockBLEConnection, new MockGenericAttributeServiceCallback(), null) {

            @Override
            public boolean isServiceChangedCharacteristicSupporeted() {
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
    public void test_getClientSupportedFeatures_00001() {
        GenericAttributeService genericAttributeService = new GenericAttributeService(new MockBLEConnection(), new MockGenericAttributeServiceCallback(), null);

        assertNull(genericAttributeService.getClientSupportedFeatures());
    }

    @Test
    public void test_getClientSupportedFeatures_00002() {
        GenericAttributeService genericAttributeService = new GenericAttributeService(new MockBLEConnection(), new MockGenericAttributeServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(genericAttributeService.getClientSupportedFeatures());
    }

    @Test
    public void test_getClientSupportedFeatures_00003() {
        GenericAttributeService genericAttributeService = new GenericAttributeService(new MockBLEConnection(), new MockGenericAttributeServiceCallback(), null) {

            @Override
            public boolean isClientSupportedFeaturesCharacteristicSupporeted() {
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
    public void test_getClientSupportedFeatures_00004() {
        final Integer originalTaskId = 1;
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {

            @Override
            public synchronized Integer createReadCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }

        };
        GenericAttributeService genericAttributeService = new GenericAttributeService(mockBLEConnection, new MockGenericAttributeServiceCallback(), null) {

            @Override
            public boolean isClientSupportedFeaturesCharacteristicSupporeted() {
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
    public void test_setClientSupportedFeatures_00001() {
        GenericAttributeService genericAttributeService = new GenericAttributeService(new MockBLEConnection(), new MockGenericAttributeServiceCallback(), null);
        ClientSupportedFeatures clientSupportedFeatures = new ClientSupportedFeatures(new byte[]{1});

        assertNull(genericAttributeService.setClientSupportedFeatures(clientSupportedFeatures));
    }

    @Test
    public void test_setClientSupportedFeatures_00002() {
        GenericAttributeService genericAttributeService = new GenericAttributeService(new MockBLEConnection(), new MockGenericAttributeServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        ClientSupportedFeatures clientSupportedFeatures = new ClientSupportedFeatures(new byte[]{1});

        assertNull(genericAttributeService.setClientSupportedFeatures(clientSupportedFeatures));
    }

    @Test
    public void test_setClientSupportedFeatures_00003() {
        GenericAttributeService genericAttributeService = new GenericAttributeService(new MockBLEConnection(), new MockGenericAttributeServiceCallback(), null) {

            @Override
            public boolean isClientSupportedFeaturesCharacteristicSupporeted() {
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
    public void test_setClientSupportedFeatures_00004() {
        final Integer originalTaskId = 1;
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {

            @Override
            public synchronized Integer createWriteCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull ByteArrayInterface byteArrayInterface, int writeType, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }

        };
        GenericAttributeService genericAttributeService = new GenericAttributeService(mockBLEConnection, new MockGenericAttributeServiceCallback(), null) {

            @Override
            public boolean isClientSupportedFeaturesCharacteristicSupporeted() {
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
    public void test_getDatabaseHash_00001() {
        GenericAttributeService genericAttributeService = new GenericAttributeService(new MockBLEConnection(), new MockGenericAttributeServiceCallback(), null);

        assertNull(genericAttributeService.getDatabaseHash());
    }

    @Test
    public void test_getDatabaseHash_00002() {
        GenericAttributeService genericAttributeService = new GenericAttributeService(new MockBLEConnection(), new MockGenericAttributeServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(genericAttributeService.getDatabaseHash());
    }

    @Test
    public void test_getDatabaseHash_00003() {
        GenericAttributeService genericAttributeService = new GenericAttributeService(new MockBLEConnection(), new MockGenericAttributeServiceCallback(), null) {

            @Override
            public boolean isDatabaseHashCharacteristicSupporeted() {
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
    public void test_getDatabaseHash_00004() {
        final Integer originalTaskId = 1;
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {

            @Override
            public synchronized Integer createReadCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }

        };
        GenericAttributeService genericAttributeService = new GenericAttributeService(mockBLEConnection, new MockGenericAttributeServiceCallback(), null) {

            @Override
            public boolean isDatabaseHashCharacteristicSupporeted() {
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