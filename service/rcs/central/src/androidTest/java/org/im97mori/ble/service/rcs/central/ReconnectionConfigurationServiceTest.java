package org.im97mori.ble.service.rcs.central;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.test.filters.RequiresDevice;

import org.im97mori.ble.characteristic.u2b1d.RCFeatureAndroid;
import org.im97mori.ble.characteristic.u2b1e.RCSettingsAndroid;
import org.im97mori.ble.characteristic.u2b1f.ReconnectionConfigurationControlPoint;
import org.im97mori.ble.characteristic.u2b1f.ReconnectionConfigurationControlPointAndroid;
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfigurationAndroid;
import org.im97mori.ble.test.BLETestUtilsAndroid;
import org.im97mori.ble.test.central.AbstractCentralTest;
import org.im97mori.ble.test.TestBase;
import org.junit.Test;

import java.util.Collections;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.im97mori.ble.constants.CharacteristicUUID.RC_FEATURE_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.RC_SETTINGS_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.RECONNECTION_CONFIGURATION_CONTROL_POINT_CHARACTERISTIC;
import static org.im97mori.ble.constants.DescriptorUUID.CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
import static org.im97mori.ble.constants.ServiceUUID.GENERIC_ACCESS_SERVICE;
import static org.im97mori.ble.constants.ServiceUUID.RECONNECTION_CONFIGURATION_SERVICE;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

@SuppressWarnings("UnnecessaryLocalVariable")
public class ReconnectionConfigurationServiceTest extends AbstractCentralTest {

    @Test
    @RequiresDevice
    public void test_onBLEDisconnected_00001() {
        ReconnectionConfigurationService reconnectionConfigurationService = new ReconnectionConfigurationService(MOCK_BLE_CONNECTION, new MockReconnectionConfigurationServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(RECONNECTION_CONFIGURATION_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(RC_SETTINGS_CHARACTERISTIC
                , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY
                , 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        bluetoothGattCharacteristic = new BluetoothGattCharacteristic(RECONNECTION_CONFIGURATION_CONTROL_POINT_CHARACTERISTIC
                , BluetoothGattCharacteristic.PROPERTY_WRITE | BluetoothGattCharacteristic.PROPERTY_INDICATE
                , 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        reconnectionConfigurationService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        reconnectionConfigurationService.onBLEDisconnected(1, BLETestUtilsAndroid.MOCK_DEVICE_0, 0, null);

        assertFalse(reconnectionConfigurationService.isRCSettingsCharacteristicSupported());
        assertFalse(reconnectionConfigurationService.isRCSettingsCharacteristicNotifySupported());
        assertFalse(reconnectionConfigurationService.isReconnectionConfigurationControlPointCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00001() {
        ReconnectionConfigurationService reconnectionConfigurationService = new ReconnectionConfigurationService(MOCK_BLE_CONNECTION, new MockReconnectionConfigurationServiceCallback(), null);
        reconnectionConfigurationService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.emptyList(), null);

        assertFalse(reconnectionConfigurationService.isRCSettingsCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00002() {
        ReconnectionConfigurationService reconnectionConfigurationService = new ReconnectionConfigurationService(MOCK_BLE_CONNECTION, new MockReconnectionConfigurationServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        reconnectionConfigurationService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(reconnectionConfigurationService.isRCSettingsCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00003() {
        ReconnectionConfigurationService reconnectionConfigurationService = new ReconnectionConfigurationService(MOCK_BLE_CONNECTION, new MockReconnectionConfigurationServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(RECONNECTION_CONFIGURATION_SERVICE, 0);
        reconnectionConfigurationService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(reconnectionConfigurationService.isRCSettingsCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00004() {
        ReconnectionConfigurationService reconnectionConfigurationService = new ReconnectionConfigurationService(MOCK_BLE_CONNECTION, new MockReconnectionConfigurationServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(RECONNECTION_CONFIGURATION_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(RC_SETTINGS_CHARACTERISTIC, 0, 0));
        reconnectionConfigurationService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(reconnectionConfigurationService.isRCSettingsCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00005() {
        ReconnectionConfigurationService reconnectionConfigurationService = new ReconnectionConfigurationService(MOCK_BLE_CONNECTION, new MockReconnectionConfigurationServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(RECONNECTION_CONFIGURATION_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(RC_SETTINGS_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        reconnectionConfigurationService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertTrue(reconnectionConfigurationService.isRCSettingsCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00101() {
        ReconnectionConfigurationService reconnectionConfigurationService = new ReconnectionConfigurationService(MOCK_BLE_CONNECTION, new MockReconnectionConfigurationServiceCallback(), null);
        reconnectionConfigurationService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.emptyList(), null);

        assertFalse(reconnectionConfigurationService.isRCSettingsCharacteristicNotifySupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00102() {
        ReconnectionConfigurationService reconnectionConfigurationService = new ReconnectionConfigurationService(MOCK_BLE_CONNECTION, new MockReconnectionConfigurationServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        reconnectionConfigurationService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(reconnectionConfigurationService.isRCSettingsCharacteristicNotifySupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00103() {
        ReconnectionConfigurationService reconnectionConfigurationService = new ReconnectionConfigurationService(MOCK_BLE_CONNECTION, new MockReconnectionConfigurationServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(RECONNECTION_CONFIGURATION_SERVICE, 0);
        reconnectionConfigurationService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(reconnectionConfigurationService.isRCSettingsCharacteristicNotifySupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00104() {
        ReconnectionConfigurationService reconnectionConfigurationService = new ReconnectionConfigurationService(MOCK_BLE_CONNECTION, new MockReconnectionConfigurationServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(RECONNECTION_CONFIGURATION_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(RC_SETTINGS_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        reconnectionConfigurationService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(reconnectionConfigurationService.isRCSettingsCharacteristicNotifySupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00105() {
        ReconnectionConfigurationService reconnectionConfigurationService = new ReconnectionConfigurationService(MOCK_BLE_CONNECTION, new MockReconnectionConfigurationServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(RECONNECTION_CONFIGURATION_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(RC_SETTINGS_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0));
        reconnectionConfigurationService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(reconnectionConfigurationService.isRCSettingsCharacteristicNotifySupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00106() {
        ReconnectionConfigurationService reconnectionConfigurationService = new ReconnectionConfigurationService(MOCK_BLE_CONNECTION, new MockReconnectionConfigurationServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(RECONNECTION_CONFIGURATION_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(RC_SETTINGS_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        reconnectionConfigurationService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertTrue(reconnectionConfigurationService.isRCSettingsCharacteristicNotifySupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00201() {
        ReconnectionConfigurationService reconnectionConfigurationService = new ReconnectionConfigurationService(MOCK_BLE_CONNECTION, new MockReconnectionConfigurationServiceCallback(), null);
        reconnectionConfigurationService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.emptyList(), null);

        assertFalse(reconnectionConfigurationService.isReconnectionConfigurationControlPointCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00202() {
        ReconnectionConfigurationService reconnectionConfigurationService = new ReconnectionConfigurationService(MOCK_BLE_CONNECTION, new MockReconnectionConfigurationServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        reconnectionConfigurationService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(reconnectionConfigurationService.isReconnectionConfigurationControlPointCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00203() {
        ReconnectionConfigurationService reconnectionConfigurationService = new ReconnectionConfigurationService(MOCK_BLE_CONNECTION, new MockReconnectionConfigurationServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(RECONNECTION_CONFIGURATION_SERVICE, 0);
        reconnectionConfigurationService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(reconnectionConfigurationService.isReconnectionConfigurationControlPointCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00204() {
        ReconnectionConfigurationService reconnectionConfigurationService = new ReconnectionConfigurationService(MOCK_BLE_CONNECTION, new MockReconnectionConfigurationServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(RECONNECTION_CONFIGURATION_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(RECONNECTION_CONFIGURATION_CONTROL_POINT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        reconnectionConfigurationService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(reconnectionConfigurationService.isReconnectionConfigurationControlPointCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00205() {
        ReconnectionConfigurationService reconnectionConfigurationService = new ReconnectionConfigurationService(MOCK_BLE_CONNECTION, new MockReconnectionConfigurationServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(RECONNECTION_CONFIGURATION_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(RECONNECTION_CONFIGURATION_CONTROL_POINT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_WRITE | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0));
        reconnectionConfigurationService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(reconnectionConfigurationService.isReconnectionConfigurationControlPointCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00206() {
        ReconnectionConfigurationService reconnectionConfigurationService = new ReconnectionConfigurationService(MOCK_BLE_CONNECTION, new MockReconnectionConfigurationServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(RECONNECTION_CONFIGURATION_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(RECONNECTION_CONFIGURATION_CONTROL_POINT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_WRITE | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        reconnectionConfigurationService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertTrue(reconnectionConfigurationService.isReconnectionConfigurationControlPointCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadSuccess_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = RECONNECTION_CONFIGURATION_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = RC_FEATURE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[5];
        final Bundle originalBundle = new Bundle();
        MockReconnectionConfigurationServiceCallback mockReconnectionConfigurationServiceCallback = new MockReconnectionConfigurationServiceCallback() {

            @Override
            public void onRCFeatureReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull RCFeatureAndroid rcFeatureAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, rcFeatureAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        ReconnectionConfigurationService reconnectionConfigurationService = new ReconnectionConfigurationService(MOCK_BLE_CONNECTION, mockReconnectionConfigurationServiceCallback, null);
        reconnectionConfigurationService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadSuccess_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = RECONNECTION_CONFIGURATION_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = RC_SETTINGS_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{3, 0, 0};
        final Bundle originalBundle = new Bundle();
        MockReconnectionConfigurationServiceCallback mockReconnectionConfigurationServiceCallback = new MockReconnectionConfigurationServiceCallback() {

            @Override
            public void onRCSettingsReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull RCSettingsAndroid rcSettingsAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, rcSettingsAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        ReconnectionConfigurationService reconnectionConfigurationService = new ReconnectionConfigurationService(MOCK_BLE_CONNECTION, mockReconnectionConfigurationServiceCallback, null);
        reconnectionConfigurationService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadFailed_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = RECONNECTION_CONFIGURATION_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = RC_FEATURE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockReconnectionConfigurationServiceCallback mockReconnectionConfigurationServiceCallback = new MockReconnectionConfigurationServiceCallback() {

            @Override
            public void onRCFeatureReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
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
        ReconnectionConfigurationService reconnectionConfigurationService = new ReconnectionConfigurationService(MOCK_BLE_CONNECTION, mockReconnectionConfigurationServiceCallback, null);
        reconnectionConfigurationService.onCharacteristicReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadFailed_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = RECONNECTION_CONFIGURATION_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = RC_SETTINGS_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockReconnectionConfigurationServiceCallback mockReconnectionConfigurationServiceCallback = new MockReconnectionConfigurationServiceCallback() {

            @Override
            public void onRCSettingsReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
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
        ReconnectionConfigurationService reconnectionConfigurationService = new ReconnectionConfigurationService(MOCK_BLE_CONNECTION, mockReconnectionConfigurationServiceCallback, null);
        reconnectionConfigurationService.onCharacteristicReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadTimeout_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = RECONNECTION_CONFIGURATION_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = RC_FEATURE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockReconnectionConfigurationServiceCallback mockReconnectionConfigurationServiceCallback = new MockReconnectionConfigurationServiceCallback() {

            @Override
            public void onRCFeatureReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
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
        ReconnectionConfigurationService reconnectionConfigurationService = new ReconnectionConfigurationService(MOCK_BLE_CONNECTION, mockReconnectionConfigurationServiceCallback, null);
        reconnectionConfigurationService.onCharacteristicReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadTimeout_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = RECONNECTION_CONFIGURATION_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = RC_SETTINGS_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockReconnectionConfigurationServiceCallback mockReconnectionConfigurationServiceCallback = new MockReconnectionConfigurationServiceCallback() {

            @Override
            public void onRCSettingsReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
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
        ReconnectionConfigurationService reconnectionConfigurationService = new ReconnectionConfigurationService(MOCK_BLE_CONNECTION, mockReconnectionConfigurationServiceCallback, null);
        reconnectionConfigurationService.onCharacteristicReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicWriteSuccess_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = RECONNECTION_CONFIGURATION_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = RECONNECTION_CONFIGURATION_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_ENABLE_DISCONNECT, new byte[0], null, 0, 0, new byte[0]).getBytes();
        final Bundle originalBundle = new Bundle();
        MockReconnectionConfigurationServiceCallback mockReconnectionConfigurationServiceCallback = new MockReconnectionConfigurationServiceCallback() {

            @Override
            public void onReconnectionConfigurationControlPointWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull ReconnectionConfigurationControlPointAndroid reconnectionConfigurationControlPointAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, reconnectionConfigurationControlPointAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        ReconnectionConfigurationService reconnectionConfigurationService = new ReconnectionConfigurationService(MOCK_BLE_CONNECTION, mockReconnectionConfigurationServiceCallback, null);
        reconnectionConfigurationService.onCharacteristicWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicWriteFailed_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = RECONNECTION_CONFIGURATION_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = RECONNECTION_CONFIGURATION_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockReconnectionConfigurationServiceCallback mockReconnectionConfigurationServiceCallback = new MockReconnectionConfigurationServiceCallback() {

            @Override
            public void onReconnectionConfigurationControlPointWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
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
        ReconnectionConfigurationService reconnectionConfigurationService = new ReconnectionConfigurationService(MOCK_BLE_CONNECTION, mockReconnectionConfigurationServiceCallback, null);
        reconnectionConfigurationService.onCharacteristicWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicWriteTimeout_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = RECONNECTION_CONFIGURATION_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = RECONNECTION_CONFIGURATION_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockReconnectionConfigurationServiceCallback mockReconnectionConfigurationServiceCallback = new MockReconnectionConfigurationServiceCallback() {

            @Override
            public void onReconnectionConfigurationControlPointWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
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
        ReconnectionConfigurationService reconnectionConfigurationService = new ReconnectionConfigurationService(MOCK_BLE_CONNECTION, mockReconnectionConfigurationServiceCallback, null);
        reconnectionConfigurationService.onCharacteristicWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorReadSuccess_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = RECONNECTION_CONFIGURATION_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = RC_SETTINGS_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        MockReconnectionConfigurationServiceCallback mockReconnectionConfigurationServiceCallback = new MockReconnectionConfigurationServiceCallback() {

            @Override
            public void onRCSettingsClientCharacteristicConfigurationReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull Integer descriptorInstanceId, @NonNull ClientCharacteristicConfigurationAndroid clientCharacteristicConfigurationAndroid, @Nullable Bundle argument) {
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
        ReconnectionConfigurationService reconnectionConfigurationService = new ReconnectionConfigurationService(MOCK_BLE_CONNECTION, mockReconnectionConfigurationServiceCallback, null);
        reconnectionConfigurationService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorReadSuccess_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = RECONNECTION_CONFIGURATION_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = RECONNECTION_CONFIGURATION_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        MockReconnectionConfigurationServiceCallback mockReconnectionConfigurationServiceCallback = new MockReconnectionConfigurationServiceCallback() {

            @Override
            public void onReconnectionConfigurationControlPointClientCharacteristicConfigurationReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull Integer descriptorInstanceId, @NonNull ClientCharacteristicConfigurationAndroid clientCharacteristicConfigurationAndroid, @Nullable Bundle argument) {
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
        ReconnectionConfigurationService reconnectionConfigurationService = new ReconnectionConfigurationService(MOCK_BLE_CONNECTION, mockReconnectionConfigurationServiceCallback, null);
        reconnectionConfigurationService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorReadFailed_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = RECONNECTION_CONFIGURATION_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = RC_SETTINGS_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        MockReconnectionConfigurationServiceCallback mockReconnectionConfigurationServiceCallback = new MockReconnectionConfigurationServiceCallback() {

            @Override
            public void onRCSettingsClientCharacteristicConfigurationReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
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
        ReconnectionConfigurationService reconnectionConfigurationService = new ReconnectionConfigurationService(MOCK_BLE_CONNECTION, mockReconnectionConfigurationServiceCallback, null);
        reconnectionConfigurationService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorReadFailed_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = RECONNECTION_CONFIGURATION_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = RECONNECTION_CONFIGURATION_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        MockReconnectionConfigurationServiceCallback mockReconnectionConfigurationServiceCallback = new MockReconnectionConfigurationServiceCallback() {

            @Override
            public void onReconnectionConfigurationControlPointClientCharacteristicConfigurationReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
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
        ReconnectionConfigurationService reconnectionConfigurationService = new ReconnectionConfigurationService(MOCK_BLE_CONNECTION, mockReconnectionConfigurationServiceCallback, null);
        reconnectionConfigurationService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorReadTimeout_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = RECONNECTION_CONFIGURATION_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = RC_SETTINGS_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final long originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        MockReconnectionConfigurationServiceCallback mockReconnectionConfigurationServiceCallback = new MockReconnectionConfigurationServiceCallback() {

            @Override
            public void onRCSettingsClientCharacteristicConfigurationReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
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
        ReconnectionConfigurationService reconnectionConfigurationService = new ReconnectionConfigurationService(MOCK_BLE_CONNECTION, mockReconnectionConfigurationServiceCallback, null);
        reconnectionConfigurationService.onDescriptorReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorReadTimeout_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = RECONNECTION_CONFIGURATION_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = RECONNECTION_CONFIGURATION_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final long originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        MockReconnectionConfigurationServiceCallback mockReconnectionConfigurationServiceCallback = new MockReconnectionConfigurationServiceCallback() {

            @Override
            public void onReconnectionConfigurationControlPointClientCharacteristicConfigurationReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
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
        ReconnectionConfigurationService reconnectionConfigurationService = new ReconnectionConfigurationService(MOCK_BLE_CONNECTION, mockReconnectionConfigurationServiceCallback, null);
        reconnectionConfigurationService.onDescriptorReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteSuccess_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = RECONNECTION_CONFIGURATION_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = RC_SETTINGS_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MockReconnectionConfigurationServiceCallback mockReconnectionConfigurationServiceCallback = new MockReconnectionConfigurationServiceCallback() {

            @Override
            public void onRCSettingsNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull Integer descriptorInstanceId, @Nullable Bundle argument) {
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
        ReconnectionConfigurationService reconnectionConfigurationService = new ReconnectionConfigurationService(MOCK_BLE_CONNECTION, mockReconnectionConfigurationServiceCallback, null);
        reconnectionConfigurationService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteSuccess_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = RECONNECTION_CONFIGURATION_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = RECONNECTION_CONFIGURATION_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MockReconnectionConfigurationServiceCallback mockReconnectionConfigurationServiceCallback = new MockReconnectionConfigurationServiceCallback() {

            @Override
            public void onReconnectionConfigurationControlPointIndicateStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull Integer descriptorInstanceId, @Nullable Bundle argument) {
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
        ReconnectionConfigurationService reconnectionConfigurationService = new ReconnectionConfigurationService(MOCK_BLE_CONNECTION, mockReconnectionConfigurationServiceCallback, null);
        reconnectionConfigurationService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteSuccess_00101() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = RECONNECTION_CONFIGURATION_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = RC_SETTINGS_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MockReconnectionConfigurationServiceCallback mockReconnectionConfigurationServiceCallback = new MockReconnectionConfigurationServiceCallback() {

            @Override
            public void onRCSettingsNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull Integer descriptorInstanceId, @Nullable Bundle argument) {
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
        ReconnectionConfigurationService reconnectionConfigurationService = new ReconnectionConfigurationService(MOCK_BLE_CONNECTION, mockReconnectionConfigurationServiceCallback, null);
        reconnectionConfigurationService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteSuccess_00102() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = RECONNECTION_CONFIGURATION_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = RECONNECTION_CONFIGURATION_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MockReconnectionConfigurationServiceCallback mockReconnectionConfigurationServiceCallback = new MockReconnectionConfigurationServiceCallback() {

            @Override
            public void onReconnectionConfigurationControlPointIndicateStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull Integer descriptorInstanceId, @Nullable Bundle argument) {
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
        ReconnectionConfigurationService reconnectionConfigurationService = new ReconnectionConfigurationService(MOCK_BLE_CONNECTION, mockReconnectionConfigurationServiceCallback, null);
        reconnectionConfigurationService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteFailed_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = RECONNECTION_CONFIGURATION_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = RC_SETTINGS_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MockReconnectionConfigurationServiceCallback mockReconnectionConfigurationServiceCallback = new MockReconnectionConfigurationServiceCallback() {

            @Override
            public void onRCSettingsNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
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
        ReconnectionConfigurationService reconnectionConfigurationService = new ReconnectionConfigurationService(MOCK_BLE_CONNECTION, mockReconnectionConfigurationServiceCallback, null);
        reconnectionConfigurationService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteFailed_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = RECONNECTION_CONFIGURATION_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = RECONNECTION_CONFIGURATION_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MockReconnectionConfigurationServiceCallback mockReconnectionConfigurationServiceCallback = new MockReconnectionConfigurationServiceCallback() {

            @Override
            public void onReconnectionConfigurationControlPointIndicateStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
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
        ReconnectionConfigurationService reconnectionConfigurationService = new ReconnectionConfigurationService(MOCK_BLE_CONNECTION, mockReconnectionConfigurationServiceCallback, null);
        reconnectionConfigurationService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteFailed_00101() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = RECONNECTION_CONFIGURATION_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = RC_SETTINGS_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MockReconnectionConfigurationServiceCallback mockReconnectionConfigurationServiceCallback = new MockReconnectionConfigurationServiceCallback() {

            @Override
            public void onRCSettingsNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
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
        ReconnectionConfigurationService reconnectionConfigurationService = new ReconnectionConfigurationService(MOCK_BLE_CONNECTION, mockReconnectionConfigurationServiceCallback, null);
        reconnectionConfigurationService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteFailed_00102() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = RECONNECTION_CONFIGURATION_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = RECONNECTION_CONFIGURATION_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MockReconnectionConfigurationServiceCallback mockReconnectionConfigurationServiceCallback = new MockReconnectionConfigurationServiceCallback() {

            @Override
            public void onReconnectionConfigurationControlPointIndicateStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
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
        ReconnectionConfigurationService reconnectionConfigurationService = new ReconnectionConfigurationService(MOCK_BLE_CONNECTION, mockReconnectionConfigurationServiceCallback, null);
        reconnectionConfigurationService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteTimeout_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = RECONNECTION_CONFIGURATION_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = RC_SETTINGS_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final long originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MockReconnectionConfigurationServiceCallback mockReconnectionConfigurationServiceCallback = new MockReconnectionConfigurationServiceCallback() {

            @Override
            public void onRCSettingsNotifyStartTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
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
        ReconnectionConfigurationService reconnectionConfigurationService = new ReconnectionConfigurationService(MOCK_BLE_CONNECTION, mockReconnectionConfigurationServiceCallback, null);
        reconnectionConfigurationService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteTimeout_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = RECONNECTION_CONFIGURATION_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = RECONNECTION_CONFIGURATION_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final long originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MockReconnectionConfigurationServiceCallback mockReconnectionConfigurationServiceCallback = new MockReconnectionConfigurationServiceCallback() {

            @Override
            public void onReconnectionConfigurationControlPointIndicateStartTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
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
        ReconnectionConfigurationService reconnectionConfigurationService = new ReconnectionConfigurationService(MOCK_BLE_CONNECTION, mockReconnectionConfigurationServiceCallback, null);
        reconnectionConfigurationService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteTimeout_00101() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = RECONNECTION_CONFIGURATION_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = RC_SETTINGS_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final long originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MockReconnectionConfigurationServiceCallback mockReconnectionConfigurationServiceCallback = new MockReconnectionConfigurationServiceCallback() {

            @Override
            public void onRCSettingsNotifyStopTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
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
        ReconnectionConfigurationService reconnectionConfigurationService = new ReconnectionConfigurationService(MOCK_BLE_CONNECTION, mockReconnectionConfigurationServiceCallback, null);
        reconnectionConfigurationService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteTimeout_00102() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = RECONNECTION_CONFIGURATION_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = RECONNECTION_CONFIGURATION_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final long originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MockReconnectionConfigurationServiceCallback mockReconnectionConfigurationServiceCallback = new MockReconnectionConfigurationServiceCallback() {

            @Override
            public void onReconnectionConfigurationControlPointIndicateStopTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
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
        ReconnectionConfigurationService reconnectionConfigurationService = new ReconnectionConfigurationService(MOCK_BLE_CONNECTION, mockReconnectionConfigurationServiceCallback, null);
        reconnectionConfigurationService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicNotified_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = RECONNECTION_CONFIGURATION_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = RC_SETTINGS_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{3, 0, 0};
        MockReconnectionConfigurationServiceCallback mockReconnectionConfigurationServiceCallback = new MockReconnectionConfigurationServiceCallback() {

            @Override
            public void onRCSettingsNotified(@NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull RCSettingsAndroid rcSettingsAndroid) {
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, rcSettingsAndroid.getBytes());
                isCalled.set(true);
            }

        };

        ReconnectionConfigurationService reconnectionConfigurationService = new ReconnectionConfigurationService(MOCK_BLE_CONNECTION, mockReconnectionConfigurationServiceCallback, null);
        reconnectionConfigurationService.onCharacteristicNotified(originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicNotified_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = RECONNECTION_CONFIGURATION_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = RECONNECTION_CONFIGURATION_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_ENABLE_DISCONNECT, new byte[0], null, 0, 0, new byte[0]).getBytes();
        MockReconnectionConfigurationServiceCallback mockReconnectionConfigurationServiceCallback = new MockReconnectionConfigurationServiceCallback() {

            @Override
            public void onReconnectionConfigurationControlPointIndicated(@NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull ReconnectionConfigurationControlPointAndroid reconnectionConfigurationControlPointAndroid) {
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, reconnectionConfigurationControlPointAndroid.getBytes());
                isCalled.set(true);
            }

        };

        ReconnectionConfigurationService reconnectionConfigurationService = new ReconnectionConfigurationService(MOCK_BLE_CONNECTION, mockReconnectionConfigurationServiceCallback, null);
        reconnectionConfigurationService.onCharacteristicNotified(originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_isRCSettingsCharacteristicSupported_00001() {
        ReconnectionConfigurationService reconnectionConfigurationService = new ReconnectionConfigurationService(MOCK_BLE_CONNECTION, new MockReconnectionConfigurationServiceCallback(), null);

        assertFalse(reconnectionConfigurationService.isRCSettingsCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_isRCSettingsCharacteristicSupported_00002() {
        ReconnectionConfigurationService reconnectionConfigurationService = new ReconnectionConfigurationService(MOCK_BLE_CONNECTION, new MockReconnectionConfigurationServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(RECONNECTION_CONFIGURATION_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(RC_SETTINGS_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        reconnectionConfigurationService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertTrue(reconnectionConfigurationService.isRCSettingsCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_isRCSettingsCharacteristicSupported_00003() {
        ReconnectionConfigurationService reconnectionConfigurationService = new ReconnectionConfigurationService(MOCK_BLE_CONNECTION, new MockReconnectionConfigurationServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(RECONNECTION_CONFIGURATION_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(RC_SETTINGS_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        reconnectionConfigurationService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        reconnectionConfigurationService.onBLEDisconnected(1, BLETestUtilsAndroid.MOCK_DEVICE_0, 0, null);

        assertFalse(reconnectionConfigurationService.isRCSettingsCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_isRCSettingsCharacteristicNotifySupported_00001() {
        ReconnectionConfigurationService reconnectionConfigurationService = new ReconnectionConfigurationService(MOCK_BLE_CONNECTION, new MockReconnectionConfigurationServiceCallback(), null);

        assertFalse(reconnectionConfigurationService.isRCSettingsCharacteristicNotifySupported());
    }

    @Test
    @RequiresDevice
    public void test_isRCSettingsCharacteristicNotifySupported_00002() {
        ReconnectionConfigurationService reconnectionConfigurationService = new ReconnectionConfigurationService(MOCK_BLE_CONNECTION, new MockReconnectionConfigurationServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(RECONNECTION_CONFIGURATION_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(RC_SETTINGS_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        reconnectionConfigurationService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertTrue(reconnectionConfigurationService.isRCSettingsCharacteristicNotifySupported());
    }

    @Test
    @RequiresDevice
    public void test_isRCSettingsCharacteristicNotifySupported_00003() {
        ReconnectionConfigurationService reconnectionConfigurationService = new ReconnectionConfigurationService(MOCK_BLE_CONNECTION, new MockReconnectionConfigurationServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(RECONNECTION_CONFIGURATION_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(RC_SETTINGS_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        reconnectionConfigurationService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        reconnectionConfigurationService.onBLEDisconnected(1, BLETestUtilsAndroid.MOCK_DEVICE_0, 0, null);

        assertFalse(reconnectionConfigurationService.isRCSettingsCharacteristicNotifySupported());
    }

    @Test
    @RequiresDevice
    public void test_isReconnectionConfigurationControlPointCharacteristicSupported_00001() {
        ReconnectionConfigurationService reconnectionConfigurationService = new ReconnectionConfigurationService(MOCK_BLE_CONNECTION, new MockReconnectionConfigurationServiceCallback(), null);

        assertFalse(reconnectionConfigurationService.isReconnectionConfigurationControlPointCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_isReconnectionConfigurationControlPointCharacteristicSupported_00002() {
        ReconnectionConfigurationService reconnectionConfigurationService = new ReconnectionConfigurationService(MOCK_BLE_CONNECTION, new MockReconnectionConfigurationServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(RECONNECTION_CONFIGURATION_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(RECONNECTION_CONFIGURATION_CONTROL_POINT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_WRITE | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        reconnectionConfigurationService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertTrue(reconnectionConfigurationService.isReconnectionConfigurationControlPointCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_isReconnectionConfigurationControlPointCharacteristicSupported_00003() {
        ReconnectionConfigurationService reconnectionConfigurationService = new ReconnectionConfigurationService(MOCK_BLE_CONNECTION, new MockReconnectionConfigurationServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(RECONNECTION_CONFIGURATION_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(RECONNECTION_CONFIGURATION_CONTROL_POINT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_WRITE | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        reconnectionConfigurationService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        reconnectionConfigurationService.onBLEDisconnected(1, BLETestUtilsAndroid.MOCK_DEVICE_0, 0, null);

        assertFalse(reconnectionConfigurationService.isReconnectionConfigurationControlPointCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_getRCFeature_000001() {
        ReconnectionConfigurationService reconnectionConfigurationService = new ReconnectionConfigurationService(MOCK_BLE_CONNECTION, new MockReconnectionConfigurationServiceCallback(), null);

        assertNull(reconnectionConfigurationService.getRCFeature());
    }

    @Test
    @RequiresDevice
    public void test_getRCFeature_000002() {
        ReconnectionConfigurationService reconnectionConfigurationService = new ReconnectionConfigurationService(MOCK_BLE_CONNECTION, new MockReconnectionConfigurationServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(reconnectionConfigurationService.getRCFeature());
    }

    @Test
    @RequiresDevice
    public void test_getRCFeature_000003() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateReadCharacteristicTaskId(originalTaskId);
        ReconnectionConfigurationService reconnectionConfigurationService = new ReconnectionConfigurationService(MOCK_BLE_CONNECTION, new MockReconnectionConfigurationServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNotNull(reconnectionConfigurationService.getRCFeature());
    }

    @Test
    @RequiresDevice
    public void test_getRCSettings_000001() {
        ReconnectionConfigurationService reconnectionConfigurationService = new ReconnectionConfigurationService(MOCK_BLE_CONNECTION, new MockReconnectionConfigurationServiceCallback(), null);

        assertNull(reconnectionConfigurationService.getRCSettings());
    }

    @Test
    @RequiresDevice
    public void test_getRCSettings_000002() {
        ReconnectionConfigurationService reconnectionConfigurationService = new ReconnectionConfigurationService(MOCK_BLE_CONNECTION, new MockReconnectionConfigurationServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(reconnectionConfigurationService.getRCSettings());
    }

    @Test
    @RequiresDevice
    public void test_getRCSettings_000003() {
        ReconnectionConfigurationService reconnectionConfigurationService = new ReconnectionConfigurationService(MOCK_BLE_CONNECTION, new MockReconnectionConfigurationServiceCallback(), null) {

            @Override
            public boolean isRCSettingsCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(reconnectionConfigurationService.getRCSettings());
    }

    @Test
    @RequiresDevice
    public void test_getRCSettings_000004() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateReadCharacteristicTaskId(originalTaskId);
        ReconnectionConfigurationService reconnectionConfigurationService = new ReconnectionConfigurationService(MOCK_BLE_CONNECTION, new MockReconnectionConfigurationServiceCallback(), null) {

            @Override
            public boolean isRCSettingsCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNotNull(reconnectionConfigurationService.getRCSettings());
    }

    @Test
    @RequiresDevice
    public void test_getRCSettingsClientCharacteristicConfiguration_000001() {
        ReconnectionConfigurationService reconnectionConfigurationService = new ReconnectionConfigurationService(MOCK_BLE_CONNECTION, new MockReconnectionConfigurationServiceCallback(), null);

        assertNull(reconnectionConfigurationService.getRCSettingsClientCharacteristicConfiguration());
    }

    @Test
    @RequiresDevice
    public void test_getRCSettingsClientCharacteristicConfiguration_000002() {
        ReconnectionConfigurationService reconnectionConfigurationService = new ReconnectionConfigurationService(MOCK_BLE_CONNECTION, new MockReconnectionConfigurationServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(reconnectionConfigurationService.getRCSettingsClientCharacteristicConfiguration());
    }

    @Test
    @RequiresDevice
    public void test_getRCSettingsClientCharacteristicConfiguration_000003() {
        ReconnectionConfigurationService reconnectionConfigurationService = new ReconnectionConfigurationService(MOCK_BLE_CONNECTION, new MockReconnectionConfigurationServiceCallback(), null) {

            @Override
            public boolean isRCSettingsCharacteristicNotifySupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(reconnectionConfigurationService.getRCSettingsClientCharacteristicConfiguration());
    }

    @Test
    @RequiresDevice
    public void test_getFitnessMachineControlPointClientCharacteristicConfiguration_000004() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateReadDescriptorTaskId(originalTaskId);
        ReconnectionConfigurationService reconnectionConfigurationService = new ReconnectionConfigurationService(MOCK_BLE_CONNECTION, new MockReconnectionConfigurationServiceCallback(), null) {

            @Override
            public boolean isRCSettingsCharacteristicNotifySupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = reconnectionConfigurationService.getRCSettingsClientCharacteristicConfiguration();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    @RequiresDevice
    public void test_startRCSettingsNotification_000001() {
        ReconnectionConfigurationService reconnectionConfigurationService = new ReconnectionConfigurationService(MOCK_BLE_CONNECTION, new MockReconnectionConfigurationServiceCallback(), null);

        assertNull(reconnectionConfigurationService.startRCSettingsNotification());
    }

    @Test
    @RequiresDevice
    public void test_startRCSettingsNotification_000002() {
        ReconnectionConfigurationService reconnectionConfigurationService = new ReconnectionConfigurationService(MOCK_BLE_CONNECTION, new MockReconnectionConfigurationServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(reconnectionConfigurationService.startRCSettingsNotification());
    }

    @Test
    @RequiresDevice
    public void test_startRCSettingsNotification_000003() {
        ReconnectionConfigurationService reconnectionConfigurationService = new ReconnectionConfigurationService(MOCK_BLE_CONNECTION, new MockReconnectionConfigurationServiceCallback(), null) {

            @Override
            public boolean isRCSettingsCharacteristicNotifySupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(reconnectionConfigurationService.startRCSettingsNotification());
    }

    @Test
    @RequiresDevice
    public void test_startRCSettingsNotification_000004() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateWriteDescriptorTaskId(originalTaskId);
        ReconnectionConfigurationService reconnectionConfigurationService = new ReconnectionConfigurationService(MOCK_BLE_CONNECTION, new MockReconnectionConfigurationServiceCallback(), null) {

            @Override
            public boolean isRCSettingsCharacteristicNotifySupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = reconnectionConfigurationService.startRCSettingsNotification();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    @RequiresDevice
    public void test_stopRCSettingsNotification_000001() {
        ReconnectionConfigurationService reconnectionConfigurationService = new ReconnectionConfigurationService(MOCK_BLE_CONNECTION, new MockReconnectionConfigurationServiceCallback(), null);

        assertNull(reconnectionConfigurationService.stopRCSettingsNotification());
    }

    @Test
    @RequiresDevice
    public void test_stopRCSettingsNotification_000002() {
        ReconnectionConfigurationService reconnectionConfigurationService = new ReconnectionConfigurationService(MOCK_BLE_CONNECTION, new MockReconnectionConfigurationServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(reconnectionConfigurationService.stopRCSettingsNotification());
    }

    @Test
    @RequiresDevice
    public void test_stopRCSettingsNotification_000003() {
        ReconnectionConfigurationService reconnectionConfigurationService = new ReconnectionConfigurationService(MOCK_BLE_CONNECTION, new MockReconnectionConfigurationServiceCallback(), null) {

            @Override
            public boolean isRCSettingsCharacteristicNotifySupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(reconnectionConfigurationService.stopRCSettingsNotification());
    }

    @Test
    @RequiresDevice
    public void test_stopRCSettingsNotification_000004() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateWriteDescriptorTaskId(originalTaskId);
        ReconnectionConfigurationService reconnectionConfigurationService = new ReconnectionConfigurationService(MOCK_BLE_CONNECTION, new MockReconnectionConfigurationServiceCallback(), null) {

            @Override
            public boolean isRCSettingsCharacteristicNotifySupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = reconnectionConfigurationService.stopRCSettingsNotification();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    @RequiresDevice
    public void test_setReconnectionConfigurationControlPoint_000001() {
        ReconnectionConfigurationService reconnectionConfigurationService = new ReconnectionConfigurationService(MOCK_BLE_CONNECTION, new MockReconnectionConfigurationServiceCallback(), null);

        assertNull(reconnectionConfigurationService.setReconnectionConfigurationControlPoint(new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_ENABLE_DISCONNECT, new byte[0], null, 0, 0, new byte[0])));
    }

    @Test
    @RequiresDevice
    public void test_setReconnectionConfigurationControlPoint_000002() {
        ReconnectionConfigurationService reconnectionConfigurationService = new ReconnectionConfigurationService(MOCK_BLE_CONNECTION, new MockReconnectionConfigurationServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(reconnectionConfigurationService.setReconnectionConfigurationControlPoint(new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_ENABLE_DISCONNECT, new byte[0], null, 0, 0, new byte[0])));
    }

    @Test
    @RequiresDevice
    public void test_setReconnectionConfigurationControlPoint_000003() {
        ReconnectionConfigurationService reconnectionConfigurationService = new ReconnectionConfigurationService(MOCK_BLE_CONNECTION, new MockReconnectionConfigurationServiceCallback(), null) {

            @Override
            public boolean isReconnectionConfigurationControlPointCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(reconnectionConfigurationService.setReconnectionConfigurationControlPoint(new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_ENABLE_DISCONNECT, new byte[0], null, 0, 0, new byte[0])));
    }

    @Test
    @RequiresDevice
    public void test_setReconnectionConfigurationControlPoint_000004() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateWriteCharacteristicTaskId(originalTaskId);
        ReconnectionConfigurationService reconnectionConfigurationService = new ReconnectionConfigurationService(MOCK_BLE_CONNECTION, new MockReconnectionConfigurationServiceCallback(), null) {

            @Override
            public boolean isReconnectionConfigurationControlPointCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = reconnectionConfigurationService.setReconnectionConfigurationControlPoint(new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_ENABLE_DISCONNECT, new byte[0], null, 0, 0, new byte[0]));
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    @RequiresDevice
    public void test_getReconnectionConfigurationControlPointClientCharacteristicConfiguration_00001() {
        ReconnectionConfigurationService reconnectionConfigurationService = new ReconnectionConfigurationService(MOCK_BLE_CONNECTION, new MockReconnectionConfigurationServiceCallback(), null);

        assertNull(reconnectionConfigurationService.getReconnectionConfigurationControlPointClientCharacteristicConfiguration());
    }

    @Test
    @RequiresDevice
    public void test_getReconnectionConfigurationControlPointClientCharacteristicConfiguration_00002() {
        ReconnectionConfigurationService reconnectionConfigurationService = new ReconnectionConfigurationService(MOCK_BLE_CONNECTION, new MockReconnectionConfigurationServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(reconnectionConfigurationService.getReconnectionConfigurationControlPointClientCharacteristicConfiguration());
    }

    @Test
    @RequiresDevice
    public void test_getReconnectionConfigurationControlPointClientCharacteristicConfiguration_00003() {
        ReconnectionConfigurationService reconnectionConfigurationService = new ReconnectionConfigurationService(MOCK_BLE_CONNECTION, new MockReconnectionConfigurationServiceCallback(), null) {

            @Override
            public boolean isReconnectionConfigurationControlPointCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(reconnectionConfigurationService.getReconnectionConfigurationControlPointClientCharacteristicConfiguration());
    }

    @Test
    @RequiresDevice
    public void test_getReconnectionConfigurationControlPointClientCharacteristicConfiguration_00004() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateReadDescriptorTaskId(originalTaskId);
        ReconnectionConfigurationService reconnectionConfigurationService = new ReconnectionConfigurationService(MOCK_BLE_CONNECTION, new MockReconnectionConfigurationServiceCallback(), null) {

            @Override
            public boolean isReconnectionConfigurationControlPointCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = reconnectionConfigurationService.getReconnectionConfigurationControlPointClientCharacteristicConfiguration();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    @RequiresDevice
    public void test_startReconnectionConfigurationControlPointIndication_00001() {
        ReconnectionConfigurationService reconnectionConfigurationService = new ReconnectionConfigurationService(MOCK_BLE_CONNECTION, new MockReconnectionConfigurationServiceCallback(), null);

        assertNull(reconnectionConfigurationService.startReconnectionConfigurationControlPointIndication());
    }

    @Test
    @RequiresDevice
    public void test_startReconnectionConfigurationControlPointIndication_00002() {
        ReconnectionConfigurationService reconnectionConfigurationService = new ReconnectionConfigurationService(MOCK_BLE_CONNECTION, new MockReconnectionConfigurationServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(reconnectionConfigurationService.startReconnectionConfigurationControlPointIndication());
    }

    @Test
    @RequiresDevice
    public void test_startReconnectionConfigurationControlPointIndication_00003() {
        ReconnectionConfigurationService reconnectionConfigurationService = new ReconnectionConfigurationService(MOCK_BLE_CONNECTION, new MockReconnectionConfigurationServiceCallback(), null) {

            @Override
            public boolean isReconnectionConfigurationControlPointCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(reconnectionConfigurationService.startReconnectionConfigurationControlPointIndication());
    }

    @Test
    @RequiresDevice
    public void test_startReconnectionConfigurationControlPointIndication_00004() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateWriteDescriptorTaskId(originalTaskId);
        ReconnectionConfigurationService reconnectionConfigurationService = new ReconnectionConfigurationService(MOCK_BLE_CONNECTION, new MockReconnectionConfigurationServiceCallback(), null) {

            @Override
            public boolean isReconnectionConfigurationControlPointCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = reconnectionConfigurationService.startReconnectionConfigurationControlPointIndication();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    @RequiresDevice
    public void test_stopReconnectionConfigurationControlPointIndication_00001() {
        ReconnectionConfigurationService reconnectionConfigurationService = new ReconnectionConfigurationService(MOCK_BLE_CONNECTION, new MockReconnectionConfigurationServiceCallback(), null);

        assertNull(reconnectionConfigurationService.stopReconnectionConfigurationControlPointIndication());
    }

    @Test
    @RequiresDevice
    public void test_stopReconnectionConfigurationControlPointIndication_00002() {
        ReconnectionConfigurationService reconnectionConfigurationService = new ReconnectionConfigurationService(MOCK_BLE_CONNECTION, new MockReconnectionConfigurationServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(reconnectionConfigurationService.stopReconnectionConfigurationControlPointIndication());
    }

    @Test
    @RequiresDevice
    public void test_stopReconnectionConfigurationControlPointIndication_00003() {
        ReconnectionConfigurationService reconnectionConfigurationService = new ReconnectionConfigurationService(MOCK_BLE_CONNECTION, new MockReconnectionConfigurationServiceCallback(), null) {

            @Override
            public boolean isReconnectionConfigurationControlPointCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(reconnectionConfigurationService.stopReconnectionConfigurationControlPointIndication());
    }

    @Test
    @RequiresDevice
    public void test_stopReconnectionConfigurationControlPointIndication_00004() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateWriteDescriptorTaskId(originalTaskId);
        ReconnectionConfigurationService reconnectionConfigurationService = new ReconnectionConfigurationService(MOCK_BLE_CONNECTION, new MockReconnectionConfigurationServiceCallback(), null) {

            @Override
            public boolean isReconnectionConfigurationControlPointCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = reconnectionConfigurationService.stopReconnectionConfigurationControlPointIndication();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

}
