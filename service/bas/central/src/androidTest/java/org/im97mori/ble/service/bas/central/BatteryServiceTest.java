package org.im97mori.ble.service.bas.central;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.characteristic.u2a19.BatteryLevelAndroid;
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfigurationAndroid;
import org.im97mori.ble.descriptor.u2904.CharacteristicPresentationFormatAndroid;
import org.im97mori.ble.test.BLETestUtilsAndroid;
import org.im97mori.ble.test.central.AbstractCentralTest;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

import static org.im97mori.ble.constants.CharacteristicUUID.BATTERY_LEVEL_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.CURRENT_TIME_CHARACTERISTIC;
import static org.im97mori.ble.constants.DescriptorUUID.CHARACTERISTIC_PRESENTATION_FORMAT_DESCRIPTOR;
import static org.im97mori.ble.constants.DescriptorUUID.CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
import static org.im97mori.ble.constants.ServiceUUID.BATTERY_SERVICE;
import static org.im97mori.ble.constants.ServiceUUID.GENERIC_ACCESS_SERVICE;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

@SuppressWarnings("UnnecessaryLocalVariable")
public class BatteryServiceTest extends AbstractCentralTest {

    @Test
    public void test_onDiscoverServiceSuccess_00001() {
        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, new MockBatteryServiceCallback(), null);
        batteryService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.emptyList(), null);

        assertNull(batteryService.getBatteryLevelCount());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00002() {
        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, new MockBatteryServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        batteryService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNull(batteryService.getBatteryLevelCount());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00003() {
        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, new MockBatteryServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(BATTERY_SERVICE, 0);
        batteryService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNull(batteryService.getBatteryLevelCount());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00004() {
        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, new MockBatteryServiceCallback(), null) {
            @Override
            public boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(BATTERY_SERVICE, 0);
        batteryService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(batteryService.getBatteryLevelCount());
        assertEquals(1, batteryService.getBatteryLevelCount().intValue());
    }

    @Test
    public void test_onCharacteristicReadSuccess_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = BATTERY_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = BATTERY_LEVEL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};
        final Bundle originalBundle = new Bundle();
        MockBatteryServiceCallback mockBatteryServiceCallback = new MockBatteryServiceCallback() {

            @Override
            public void onBatteryLevelReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull BatteryLevelAndroid batteryLevelAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertArrayEquals(originalValues, batteryLevelAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, mockBatteryServiceCallback, null);
        batteryService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadSuccess_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = BATTERY_SERVICE;
        final Integer originalServiceInstanceId = 0;
        final UUID originalCharacteristicUUID = BATTERY_LEVEL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 0;
        final byte[] originalValues = new byte[]{4};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(BATTERY_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BATTERY_LEVEL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGattCharacteristic.PERMISSION_READ);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        MockBatteryServiceCallback mockBatteryServiceCallback = new MockBatteryServiceCallback() {

            @Override
            public void onBatteryLevelReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull BatteryLevelAndroid batteryLevelAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertArrayEquals(originalValues, batteryLevelAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, mockBatteryServiceCallback, null);
        batteryService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        batteryService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadSuccess_00003() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 0;
        final UUID originalCharacteristicUUID = BATTERY_LEVEL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 0;
        final byte[] originalValues = new byte[]{4};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(BATTERY_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BATTERY_LEVEL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGattCharacteristic.PERMISSION_READ);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        MockBatteryServiceCallback mockBatteryServiceCallback = new MockBatteryServiceCallback() {

            @Override
            public void onBatteryLevelReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull BatteryLevelAndroid batteryLevelAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, mockBatteryServiceCallback, null);
        batteryService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        batteryService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadSuccess_00004() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = BATTERY_SERVICE;
        final Integer originalServiceInstanceId = 0;
        final UUID originalCharacteristicUUID = CURRENT_TIME_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 0;
        final byte[] originalValues = new byte[]{4};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(BATTERY_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BATTERY_LEVEL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGattCharacteristic.PERMISSION_READ);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        MockBatteryServiceCallback mockBatteryServiceCallback = new MockBatteryServiceCallback() {

            @Override
            public void onBatteryLevelReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull BatteryLevelAndroid batteryLevelAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, mockBatteryServiceCallback, null);
        batteryService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        batteryService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadSuccess_00005() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 0;
        final UUID originalCharacteristicUUID = CURRENT_TIME_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 0;
        final byte[] originalValues = new byte[]{4};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(BATTERY_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BATTERY_LEVEL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGattCharacteristic.PERMISSION_READ);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        MockBatteryServiceCallback mockBatteryServiceCallback = new MockBatteryServiceCallback() {

            @Override
            public void onBatteryLevelReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull BatteryLevelAndroid batteryLevelAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, mockBatteryServiceCallback, null);
        batteryService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        batteryService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadFailed_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = BATTERY_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = BATTERY_LEVEL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBatteryServiceCallback mockBatteryServiceCallback = new MockBatteryServiceCallback() {

            @Override
            public void onBatteryLevelReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, mockBatteryServiceCallback, null);
        batteryService.onCharacteristicReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadFailed_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = BATTERY_SERVICE;
        final Integer originalServiceInstanceId = 0;
        final UUID originalCharacteristicUUID = BATTERY_LEVEL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 0;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(BATTERY_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BATTERY_LEVEL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGattCharacteristic.PERMISSION_READ);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        MockBatteryServiceCallback mockBatteryServiceCallback = new MockBatteryServiceCallback() {

            @Override
            public void onBatteryLevelReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, mockBatteryServiceCallback, null);
        batteryService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        batteryService.onCharacteristicReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadFailed_00003() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 0;
        final UUID originalCharacteristicUUID = BATTERY_LEVEL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 0;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(BATTERY_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BATTERY_LEVEL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGattCharacteristic.PERMISSION_READ);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        MockBatteryServiceCallback mockBatteryServiceCallback = new MockBatteryServiceCallback() {

            @Override
            public void onBatteryLevelReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, mockBatteryServiceCallback, null);
        batteryService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        batteryService.onCharacteristicReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadFailed_00004() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = BATTERY_LEVEL_CHARACTERISTIC;
        final Integer originalServiceInstanceId = 0;
        final UUID originalCharacteristicUUID = CURRENT_TIME_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 0;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(BATTERY_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BATTERY_LEVEL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGattCharacteristic.PERMISSION_READ);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        MockBatteryServiceCallback mockBatteryServiceCallback = new MockBatteryServiceCallback() {

            @Override
            public void onBatteryLevelReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, mockBatteryServiceCallback, null);
        batteryService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        batteryService.onCharacteristicReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadFailed_00005() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 0;
        final UUID originalCharacteristicUUID = CURRENT_TIME_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 0;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(BATTERY_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BATTERY_LEVEL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGattCharacteristic.PERMISSION_READ);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        MockBatteryServiceCallback mockBatteryServiceCallback = new MockBatteryServiceCallback() {

            @Override
            public void onBatteryLevelReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, mockBatteryServiceCallback, null);
        batteryService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        batteryService.onCharacteristicReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadTimeout_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = BATTERY_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = BATTERY_LEVEL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockBatteryServiceCallback mockBatteryServiceCallback = new MockBatteryServiceCallback() {

            @Override
            public void onBatteryLevelReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, mockBatteryServiceCallback, null);
        batteryService.onCharacteristicReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadTimeout_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = BATTERY_SERVICE;
        final Integer originalServiceInstanceId = 0;
        final UUID originalCharacteristicUUID = BATTERY_LEVEL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 0;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(BATTERY_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BATTERY_LEVEL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGattCharacteristic.PERMISSION_READ);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        MockBatteryServiceCallback mockBatteryServiceCallback = new MockBatteryServiceCallback() {

            @Override
            public void onBatteryLevelReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, mockBatteryServiceCallback, null);
        batteryService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        batteryService.onCharacteristicReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadTimeout_00003() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 0;
        final UUID originalCharacteristicUUID = BATTERY_LEVEL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 0;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(BATTERY_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BATTERY_LEVEL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGattCharacteristic.PERMISSION_READ);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        MockBatteryServiceCallback mockBatteryServiceCallback = new MockBatteryServiceCallback() {

            @Override
            public void onBatteryLevelReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, long timeout, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, mockBatteryServiceCallback, null);
        batteryService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        batteryService.onCharacteristicReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadTimeout_00004() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = BATTERY_LEVEL_CHARACTERISTIC;
        final Integer originalServiceInstanceId = 0;
        final UUID originalCharacteristicUUID = CURRENT_TIME_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 0;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(BATTERY_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BATTERY_LEVEL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGattCharacteristic.PERMISSION_READ);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        MockBatteryServiceCallback mockBatteryServiceCallback = new MockBatteryServiceCallback() {

            @Override
            public void onBatteryLevelReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, long timeout, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, mockBatteryServiceCallback, null);
        batteryService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        batteryService.onCharacteristicReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadTimeout_00005() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 0;
        final UUID originalCharacteristicUUID = CURRENT_TIME_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 0;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(BATTERY_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BATTERY_LEVEL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGattCharacteristic.PERMISSION_READ);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        MockBatteryServiceCallback mockBatteryServiceCallback = new MockBatteryServiceCallback() {

            @Override
            public void onBatteryLevelReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, long timeout, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, mockBatteryServiceCallback, null);
        batteryService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        batteryService.onCharacteristicReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = BATTERY_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = BATTERY_LEVEL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        MockBatteryServiceCallback mockBatteryServiceCallback = new MockBatteryServiceCallback() {

            @Override
            public void onBatteryLevelClientCharacteristicConfigurationReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull ClientCharacteristicConfigurationAndroid clientCharacteristicConfigurationAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertArrayEquals(originalValues, clientCharacteristicConfigurationAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, mockBatteryServiceCallback, null);
        batteryService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = BATTERY_SERVICE;
        final Integer originalServiceInstanceId = 0;
        final UUID originalCharacteristicUUID = BATTERY_LEVEL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 0;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(BATTERY_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BATTERY_LEVEL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGattCharacteristic.PERMISSION_READ);
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        MockBatteryServiceCallback mockBatteryServiceCallback = new MockBatteryServiceCallback() {

            @Override
            public void onBatteryLevelClientCharacteristicConfigurationReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull ClientCharacteristicConfigurationAndroid clientCharacteristicConfigurationAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertArrayEquals(originalValues, clientCharacteristicConfigurationAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, mockBatteryServiceCallback, null);
        batteryService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        batteryService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00003() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = BATTERY_LEVEL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(BATTERY_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BATTERY_LEVEL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGattCharacteristic.PERMISSION_READ);
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        MockBatteryServiceCallback mockBatteryServiceCallback = new MockBatteryServiceCallback() {

            @Override
            public void onBatteryLevelClientCharacteristicConfigurationReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull ClientCharacteristicConfigurationAndroid clientCharacteristicConfigurationAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, mockBatteryServiceCallback, null);
        batteryService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        batteryService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00004() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = BATTERY_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CURRENT_TIME_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(BATTERY_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BATTERY_LEVEL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGattCharacteristic.PERMISSION_READ);
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        MockBatteryServiceCallback mockBatteryServiceCallback = new MockBatteryServiceCallback() {

            @Override
            public void onBatteryLevelClientCharacteristicConfigurationReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull ClientCharacteristicConfigurationAndroid clientCharacteristicConfigurationAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, mockBatteryServiceCallback, null);
        batteryService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        batteryService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00005() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CURRENT_TIME_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(BATTERY_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BATTERY_LEVEL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGattCharacteristic.PERMISSION_READ);
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        MockBatteryServiceCallback mockBatteryServiceCallback = new MockBatteryServiceCallback() {

            @Override
            public void onBatteryLevelClientCharacteristicConfigurationReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull ClientCharacteristicConfigurationAndroid clientCharacteristicConfigurationAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, mockBatteryServiceCallback, null);
        batteryService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        batteryService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00101() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = BATTERY_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = BATTERY_LEVEL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_PRESENTATION_FORMAT_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6, 7, 8, 9, 10, 11};
        final Bundle originalBundle = new Bundle();
        MockBatteryServiceCallback mockBatteryServiceCallback = new MockBatteryServiceCallback() {

            @Override
            public void onBatteryLevelCharacteristicPresentationFormatReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull CharacteristicPresentationFormatAndroid characteristicPresentationFormatAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertArrayEquals(originalValues, characteristicPresentationFormatAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, mockBatteryServiceCallback, null);
        batteryService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00102() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = BATTERY_SERVICE;
        final Integer originalServiceInstanceId = 0;
        final UUID originalCharacteristicUUID = BATTERY_LEVEL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 0;
        final UUID originalDescriptorUUID = CHARACTERISTIC_PRESENTATION_FORMAT_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6, 7, 8, 9, 10, 11};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(BATTERY_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BATTERY_LEVEL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGattCharacteristic.PERMISSION_READ);
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        MockBatteryServiceCallback mockBatteryServiceCallback = new MockBatteryServiceCallback() {

            @Override
            public void onBatteryLevelCharacteristicPresentationFormatReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull CharacteristicPresentationFormatAndroid characteristicPresentationFormatAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertArrayEquals(originalValues, characteristicPresentationFormatAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, mockBatteryServiceCallback, null);
        batteryService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        batteryService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00103() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = BATTERY_LEVEL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_PRESENTATION_FORMAT_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6, 7, 8, 9, 10, 11};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(BATTERY_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BATTERY_LEVEL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGattCharacteristic.PERMISSION_READ);
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        MockBatteryServiceCallback mockBatteryServiceCallback = new MockBatteryServiceCallback() {

            @Override
            public void onBatteryLevelCharacteristicPresentationFormatReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull CharacteristicPresentationFormatAndroid characteristicPresentationFormatAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, mockBatteryServiceCallback, null);
        batteryService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        batteryService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00104() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = BATTERY_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CURRENT_TIME_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_PRESENTATION_FORMAT_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6, 7, 8, 9, 10, 11};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(BATTERY_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BATTERY_LEVEL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGattCharacteristic.PERMISSION_READ);
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        MockBatteryServiceCallback mockBatteryServiceCallback = new MockBatteryServiceCallback() {

            @Override
            public void onBatteryLevelCharacteristicPresentationFormatReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull CharacteristicPresentationFormatAndroid characteristicPresentationFormatAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, mockBatteryServiceCallback, null);
        batteryService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        batteryService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00105() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CURRENT_TIME_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_PRESENTATION_FORMAT_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6, 7, 8, 9, 10, 11};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(BATTERY_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BATTERY_LEVEL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGattCharacteristic.PERMISSION_READ);
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        MockBatteryServiceCallback mockBatteryServiceCallback = new MockBatteryServiceCallback() {

            @Override
            public void onBatteryLevelCharacteristicPresentationFormatReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull CharacteristicPresentationFormatAndroid characteristicPresentationFormatAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, mockBatteryServiceCallback, null);
        batteryService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        batteryService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadFailed_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = BATTERY_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = BATTERY_LEVEL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        MockBatteryServiceCallback mockBatteryServiceCallback = new MockBatteryServiceCallback() {

            @Override
            public void onBatteryLevelClientCharacteristicConfigurationReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, mockBatteryServiceCallback, null);
        batteryService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadFailed_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = BATTERY_SERVICE;
        final Integer originalServiceInstanceId = 0;
        final UUID originalCharacteristicUUID = BATTERY_LEVEL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 0;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(BATTERY_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BATTERY_LEVEL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGattCharacteristic.PERMISSION_READ);
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        MockBatteryServiceCallback mockBatteryServiceCallback = new MockBatteryServiceCallback() {

            @Override
            public void onBatteryLevelClientCharacteristicConfigurationReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, mockBatteryServiceCallback, null);
        batteryService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        batteryService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadFailed_00003() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = BATTERY_LEVEL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(BATTERY_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BATTERY_LEVEL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGattCharacteristic.PERMISSION_READ);
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        MockBatteryServiceCallback mockBatteryServiceCallback = new MockBatteryServiceCallback() {

            @Override
            public void onBatteryLevelClientCharacteristicConfigurationReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, mockBatteryServiceCallback, null);
        batteryService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        batteryService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadFailed_00004() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = BATTERY_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CURRENT_TIME_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(BATTERY_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BATTERY_LEVEL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGattCharacteristic.PERMISSION_READ);
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        MockBatteryServiceCallback mockBatteryServiceCallback = new MockBatteryServiceCallback() {

            @Override
            public void onBatteryLevelClientCharacteristicConfigurationReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, mockBatteryServiceCallback, null);
        batteryService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        batteryService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadFailed_00005() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CURRENT_TIME_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(BATTERY_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BATTERY_LEVEL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGattCharacteristic.PERMISSION_READ);
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        MockBatteryServiceCallback mockBatteryServiceCallback = new MockBatteryServiceCallback() {

            @Override
            public void onBatteryLevelClientCharacteristicConfigurationReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, mockBatteryServiceCallback, null);
        batteryService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        batteryService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadFailed_00101() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = BATTERY_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = BATTERY_LEVEL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_PRESENTATION_FORMAT_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        MockBatteryServiceCallback mockBatteryServiceCallback = new MockBatteryServiceCallback() {

            @Override
            public void onBatteryLevelCharacteristicPresentationFormatReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, mockBatteryServiceCallback, null);
        batteryService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadFailed_00102() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = BATTERY_SERVICE;
        final Integer originalServiceInstanceId = 0;
        final UUID originalCharacteristicUUID = BATTERY_LEVEL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 0;
        final UUID originalDescriptorUUID = CHARACTERISTIC_PRESENTATION_FORMAT_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(BATTERY_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BATTERY_LEVEL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGattCharacteristic.PERMISSION_READ);
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        MockBatteryServiceCallback mockBatteryServiceCallback = new MockBatteryServiceCallback() {

            @Override
            public void onBatteryLevelCharacteristicPresentationFormatReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, mockBatteryServiceCallback, null);
        batteryService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        batteryService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadFailed_00103() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = BATTERY_LEVEL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_PRESENTATION_FORMAT_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(BATTERY_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BATTERY_LEVEL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGattCharacteristic.PERMISSION_READ);
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        MockBatteryServiceCallback mockBatteryServiceCallback = new MockBatteryServiceCallback() {

            @Override
            public void onBatteryLevelCharacteristicPresentationFormatReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, mockBatteryServiceCallback, null);
        batteryService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        batteryService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadFailed_00104() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = BATTERY_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CURRENT_TIME_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_PRESENTATION_FORMAT_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(BATTERY_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BATTERY_LEVEL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGattCharacteristic.PERMISSION_READ);
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        MockBatteryServiceCallback mockBatteryServiceCallback = new MockBatteryServiceCallback() {

            @Override
            public void onBatteryLevelCharacteristicPresentationFormatReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, mockBatteryServiceCallback, null);
        batteryService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        batteryService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadFailed_00105() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CURRENT_TIME_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_PRESENTATION_FORMAT_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(BATTERY_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BATTERY_LEVEL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGattCharacteristic.PERMISSION_READ);
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        MockBatteryServiceCallback mockBatteryServiceCallback = new MockBatteryServiceCallback() {

            @Override
            public void onBatteryLevelCharacteristicPresentationFormatReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, mockBatteryServiceCallback, null);
        batteryService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        batteryService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadTimeout_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = BATTERY_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = BATTERY_LEVEL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final long originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        MockBatteryServiceCallback mockBatteryServiceCallback = new MockBatteryServiceCallback() {

            @Override
            public void onBatteryLevelClientCharacteristicConfigurationReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, mockBatteryServiceCallback, null);
        batteryService.onDescriptorReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadTimeout_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = BATTERY_SERVICE;
        final Integer originalServiceInstanceId = 0;
        final UUID originalCharacteristicUUID = BATTERY_LEVEL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 0;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final long originalTimeout = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(BATTERY_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BATTERY_LEVEL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGattCharacteristic.PERMISSION_READ);
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        MockBatteryServiceCallback mockBatteryServiceCallback = new MockBatteryServiceCallback() {

            @Override
            public void onBatteryLevelClientCharacteristicConfigurationReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, mockBatteryServiceCallback, null);
        batteryService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        batteryService.onDescriptorReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadTimeout_00003() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = BATTERY_LEVEL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final long originalTimeout = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(BATTERY_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BATTERY_LEVEL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGattCharacteristic.PERMISSION_READ);
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        MockBatteryServiceCallback mockBatteryServiceCallback = new MockBatteryServiceCallback() {

            @Override
            public void onBatteryLevelClientCharacteristicConfigurationReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, mockBatteryServiceCallback, null);
        batteryService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        batteryService.onDescriptorReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadTimeout_00004() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = BATTERY_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CURRENT_TIME_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final long originalTimeout = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(BATTERY_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BATTERY_LEVEL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGattCharacteristic.PERMISSION_READ);
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        MockBatteryServiceCallback mockBatteryServiceCallback = new MockBatteryServiceCallback() {

            @Override
            public void onBatteryLevelClientCharacteristicConfigurationReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, mockBatteryServiceCallback, null);
        batteryService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        batteryService.onDescriptorReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadTimeout_00005() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CURRENT_TIME_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final long originalTimeout = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(BATTERY_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BATTERY_LEVEL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGattCharacteristic.PERMISSION_READ);
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        MockBatteryServiceCallback mockBatteryServiceCallback = new MockBatteryServiceCallback() {

            @Override
            public void onBatteryLevelClientCharacteristicConfigurationReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, mockBatteryServiceCallback, null);
        batteryService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        batteryService.onDescriptorReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadTimeout_00101() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = BATTERY_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = BATTERY_LEVEL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_PRESENTATION_FORMAT_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final long originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        MockBatteryServiceCallback mockBatteryServiceCallback = new MockBatteryServiceCallback() {

            @Override
            public void onBatteryLevelCharacteristicPresentationFormatReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, mockBatteryServiceCallback, null);
        batteryService.onDescriptorReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadTimeout_00102() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = BATTERY_SERVICE;
        final Integer originalServiceInstanceId = 0;
        final UUID originalCharacteristicUUID = BATTERY_LEVEL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 0;
        final UUID originalDescriptorUUID = CHARACTERISTIC_PRESENTATION_FORMAT_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final long originalTimeout = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(BATTERY_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BATTERY_LEVEL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGattCharacteristic.PERMISSION_READ);
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        MockBatteryServiceCallback mockBatteryServiceCallback = new MockBatteryServiceCallback() {

            @Override
            public void onBatteryLevelCharacteristicPresentationFormatReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, mockBatteryServiceCallback, null);
        batteryService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        batteryService.onDescriptorReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadTimeout_00103() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = BATTERY_LEVEL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_PRESENTATION_FORMAT_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final long originalTimeout = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(BATTERY_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BATTERY_LEVEL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGattCharacteristic.PERMISSION_READ);
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        MockBatteryServiceCallback mockBatteryServiceCallback = new MockBatteryServiceCallback() {

            @Override
            public void onBatteryLevelCharacteristicPresentationFormatReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, mockBatteryServiceCallback, null);
        batteryService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        batteryService.onDescriptorReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadTimeout_00104() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = BATTERY_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CURRENT_TIME_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_PRESENTATION_FORMAT_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final long originalTimeout = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(BATTERY_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BATTERY_LEVEL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGattCharacteristic.PERMISSION_READ);
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        MockBatteryServiceCallback mockBatteryServiceCallback = new MockBatteryServiceCallback() {

            @Override
            public void onBatteryLevelCharacteristicPresentationFormatReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, mockBatteryServiceCallback, null);
        batteryService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        batteryService.onDescriptorReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadTimeout_00105() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CURRENT_TIME_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_PRESENTATION_FORMAT_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final long originalTimeout = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(BATTERY_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BATTERY_LEVEL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGattCharacteristic.PERMISSION_READ);
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        MockBatteryServiceCallback mockBatteryServiceCallback = new MockBatteryServiceCallback() {

            @Override
            public void onBatteryLevelCharacteristicPresentationFormatReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, mockBatteryServiceCallback, null);
        batteryService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        batteryService.onDescriptorReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteSuccess_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = BATTERY_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = BATTERY_LEVEL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MockBatteryServiceCallback mockBatteryServiceCallback = new MockBatteryServiceCallback() {

            @Override
            public void onBatteryLevelNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, mockBatteryServiceCallback, null);
        batteryService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteSuccess_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = BATTERY_SERVICE;
        final Integer originalServiceInstanceId = 0;
        final UUID originalCharacteristicUUID = BATTERY_LEVEL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 0;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);

        BluetoothGattService bluetoothGattService = new BluetoothGattService(BATTERY_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BATTERY_LEVEL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGattCharacteristic.PERMISSION_READ);
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        MockBatteryServiceCallback mockBatteryServiceCallback = new MockBatteryServiceCallback() {

            @Override
            public void onBatteryLevelNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, mockBatteryServiceCallback, null);
        batteryService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        batteryService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteSuccess_00003() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = BATTERY_LEVEL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);

        BluetoothGattService bluetoothGattService = new BluetoothGattService(BATTERY_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BATTERY_LEVEL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGattCharacteristic.PERMISSION_READ);
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        MockBatteryServiceCallback mockBatteryServiceCallback = new MockBatteryServiceCallback() {

            @Override
            public void onBatteryLevelNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, mockBatteryServiceCallback, null);
        batteryService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        batteryService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteSuccess_00004() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = BATTERY_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CURRENT_TIME_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);

        BluetoothGattService bluetoothGattService = new BluetoothGattService(BATTERY_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BATTERY_LEVEL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGattCharacteristic.PERMISSION_READ);
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        MockBatteryServiceCallback mockBatteryServiceCallback = new MockBatteryServiceCallback() {

            @Override
            public void onBatteryLevelNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, mockBatteryServiceCallback, null);
        batteryService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        batteryService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteSuccess_00005() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CURRENT_TIME_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);

        BluetoothGattService bluetoothGattService = new BluetoothGattService(BATTERY_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BATTERY_LEVEL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGattCharacteristic.PERMISSION_READ);
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        MockBatteryServiceCallback mockBatteryServiceCallback = new MockBatteryServiceCallback() {

            @Override
            public void onBatteryLevelNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, mockBatteryServiceCallback, null);
        batteryService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        batteryService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteSuccess_00101() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = BATTERY_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = BATTERY_LEVEL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MockBatteryServiceCallback mockBatteryServiceCallback = new MockBatteryServiceCallback() {

            @Override
            public void onBatteryLevelNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, mockBatteryServiceCallback, null);
        batteryService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteSuccess_00102() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = BATTERY_SERVICE;
        final Integer originalServiceInstanceId = 0;
        final UUID originalCharacteristicUUID = BATTERY_LEVEL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 0;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);

        BluetoothGattService bluetoothGattService = new BluetoothGattService(BATTERY_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BATTERY_LEVEL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGattCharacteristic.PERMISSION_READ);
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        MockBatteryServiceCallback mockBatteryServiceCallback = new MockBatteryServiceCallback() {

            @Override
            public void onBatteryLevelNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, mockBatteryServiceCallback, null);
        batteryService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        batteryService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteSuccess_00103() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = BATTERY_LEVEL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);

        BluetoothGattService bluetoothGattService = new BluetoothGattService(BATTERY_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BATTERY_LEVEL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGattCharacteristic.PERMISSION_READ);
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        MockBatteryServiceCallback mockBatteryServiceCallback = new MockBatteryServiceCallback() {

            @Override
            public void onBatteryLevelNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, mockBatteryServiceCallback, null);
        batteryService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        batteryService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteSuccess_00104() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = BATTERY_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CURRENT_TIME_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);

        BluetoothGattService bluetoothGattService = new BluetoothGattService(BATTERY_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BATTERY_LEVEL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGattCharacteristic.PERMISSION_READ);
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        MockBatteryServiceCallback mockBatteryServiceCallback = new MockBatteryServiceCallback() {

            @Override
            public void onBatteryLevelNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, mockBatteryServiceCallback, null);
        batteryService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        batteryService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteSuccess_00105() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CURRENT_TIME_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);

        BluetoothGattService bluetoothGattService = new BluetoothGattService(BATTERY_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BATTERY_LEVEL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGattCharacteristic.PERMISSION_READ);
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        MockBatteryServiceCallback mockBatteryServiceCallback = new MockBatteryServiceCallback() {

            @Override
            public void onBatteryLevelNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, mockBatteryServiceCallback, null);
        batteryService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        batteryService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteSuccess_00201() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = BATTERY_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = BATTERY_LEVEL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        MockBatteryServiceCallback mockBatteryServiceCallback = new MockBatteryServiceCallback() {

            @Override
            public void onBatteryLevelNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @Nullable Bundle argument) {
                isCalled.set(true);
            }

            @Override
            public void onBatteryLevelNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, mockBatteryServiceCallback, null);
        batteryService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteSuccess_00202() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = BATTERY_SERVICE;
        final Integer originalServiceInstanceId = 0;
        final UUID originalCharacteristicUUID = BATTERY_LEVEL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 0;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(BATTERY_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BATTERY_LEVEL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGattCharacteristic.PERMISSION_READ);
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        MockBatteryServiceCallback mockBatteryServiceCallback = new MockBatteryServiceCallback() {

            @Override
            public void onBatteryLevelNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @Nullable Bundle argument) {
                isCalled.set(true);
            }

            @Override
            public void onBatteryLevelNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, mockBatteryServiceCallback, null);
        batteryService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        batteryService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteSuccess_00203() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = BATTERY_LEVEL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(BATTERY_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BATTERY_LEVEL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGattCharacteristic.PERMISSION_READ);
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        MockBatteryServiceCallback mockBatteryServiceCallback = new MockBatteryServiceCallback() {

            @Override
            public void onBatteryLevelNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @Nullable Bundle argument) {
                isCalled.set(true);
            }

            @Override
            public void onBatteryLevelNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, mockBatteryServiceCallback, null);
        batteryService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        batteryService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteSuccess_00204() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = BATTERY_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CURRENT_TIME_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(BATTERY_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BATTERY_LEVEL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGattCharacteristic.PERMISSION_READ);
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        MockBatteryServiceCallback mockBatteryServiceCallback = new MockBatteryServiceCallback() {

            @Override
            public void onBatteryLevelNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @Nullable Bundle argument) {
                isCalled.set(true);
            }

            @Override
            public void onBatteryLevelNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, mockBatteryServiceCallback, null);
        batteryService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        batteryService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteSuccess_00205() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CURRENT_TIME_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(BATTERY_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BATTERY_LEVEL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGattCharacteristic.PERMISSION_READ);
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        MockBatteryServiceCallback mockBatteryServiceCallback = new MockBatteryServiceCallback() {

            @Override
            public void onBatteryLevelNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @Nullable Bundle argument) {
                isCalled.set(true);
            }

            @Override
            public void onBatteryLevelNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, mockBatteryServiceCallback, null);
        batteryService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        batteryService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteFailed_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = BATTERY_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = BATTERY_LEVEL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MockBatteryServiceCallback mockBatteryServiceCallback = new MockBatteryServiceCallback() {

            @Override
            public void onBatteryLevelNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, mockBatteryServiceCallback, null);
        batteryService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteFailed_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = BATTERY_SERVICE;
        final Integer originalServiceInstanceId = 0;
        final UUID originalCharacteristicUUID = BATTERY_LEVEL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 0;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);

        BluetoothGattService bluetoothGattService = new BluetoothGattService(BATTERY_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BATTERY_LEVEL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGattCharacteristic.PERMISSION_READ);
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        MockBatteryServiceCallback mockBatteryServiceCallback = new MockBatteryServiceCallback() {

            @Override
            public void onBatteryLevelNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, mockBatteryServiceCallback, null);
        batteryService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        batteryService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteFailed_00003() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = BATTERY_LEVEL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);

        BluetoothGattService bluetoothGattService = new BluetoothGattService(BATTERY_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BATTERY_LEVEL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGattCharacteristic.PERMISSION_READ);
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        MockBatteryServiceCallback mockBatteryServiceCallback = new MockBatteryServiceCallback() {

            @Override
            public void onBatteryLevelNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, mockBatteryServiceCallback, null);
        batteryService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        batteryService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteFailed_00004() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = BATTERY_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CURRENT_TIME_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);

        BluetoothGattService bluetoothGattService = new BluetoothGattService(BATTERY_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BATTERY_LEVEL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGattCharacteristic.PERMISSION_READ);
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        MockBatteryServiceCallback mockBatteryServiceCallback = new MockBatteryServiceCallback() {

            @Override
            public void onBatteryLevelNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, mockBatteryServiceCallback, null);
        batteryService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        batteryService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteFailed_00005() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CURRENT_TIME_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);

        BluetoothGattService bluetoothGattService = new BluetoothGattService(BATTERY_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BATTERY_LEVEL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGattCharacteristic.PERMISSION_READ);
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        MockBatteryServiceCallback mockBatteryServiceCallback = new MockBatteryServiceCallback() {

            @Override
            public void onBatteryLevelNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, mockBatteryServiceCallback, null);
        batteryService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        batteryService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteFailed_00101() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = BATTERY_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = BATTERY_LEVEL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MockBatteryServiceCallback mockBatteryServiceCallback = new MockBatteryServiceCallback() {

            @Override
            public void onBatteryLevelNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, mockBatteryServiceCallback, null);
        batteryService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteFailed_00102() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = BATTERY_SERVICE;
        final Integer originalServiceInstanceId = 0;
        final UUID originalCharacteristicUUID = BATTERY_LEVEL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 0;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);

        BluetoothGattService bluetoothGattService = new BluetoothGattService(BATTERY_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BATTERY_LEVEL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGattCharacteristic.PERMISSION_READ);
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        MockBatteryServiceCallback mockBatteryServiceCallback = new MockBatteryServiceCallback() {

            @Override
            public void onBatteryLevelNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, mockBatteryServiceCallback, null);
        batteryService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        batteryService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteFailed_00103() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = BATTERY_LEVEL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);

        BluetoothGattService bluetoothGattService = new BluetoothGattService(BATTERY_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BATTERY_LEVEL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGattCharacteristic.PERMISSION_READ);
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        MockBatteryServiceCallback mockBatteryServiceCallback = new MockBatteryServiceCallback() {

            @Override
            public void onBatteryLevelNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, mockBatteryServiceCallback, null);
        batteryService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        batteryService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteFailed_00104() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = BATTERY_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CURRENT_TIME_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);

        BluetoothGattService bluetoothGattService = new BluetoothGattService(BATTERY_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BATTERY_LEVEL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGattCharacteristic.PERMISSION_READ);
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        MockBatteryServiceCallback mockBatteryServiceCallback = new MockBatteryServiceCallback() {

            @Override
            public void onBatteryLevelNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, mockBatteryServiceCallback, null);
        batteryService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        batteryService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteFailed_00105() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CURRENT_TIME_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);

        BluetoothGattService bluetoothGattService = new BluetoothGattService(BATTERY_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BATTERY_LEVEL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGattCharacteristic.PERMISSION_READ);
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        MockBatteryServiceCallback mockBatteryServiceCallback = new MockBatteryServiceCallback() {

            @Override
            public void onBatteryLevelNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, mockBatteryServiceCallback, null);
        batteryService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        batteryService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteFailed_00201() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = BATTERY_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = BATTERY_LEVEL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        MockBatteryServiceCallback mockBatteryServiceCallback = new MockBatteryServiceCallback() {

            @Override
            public void onBatteryLevelNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

            @Override
            public void onBatteryLevelNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, mockBatteryServiceCallback, null);
        batteryService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteFailed_00202() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = BATTERY_SERVICE;
        final Integer originalServiceInstanceId = 0;
        final UUID originalCharacteristicUUID = BATTERY_LEVEL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 0;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(BATTERY_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BATTERY_LEVEL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGattCharacteristic.PERMISSION_READ);
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        MockBatteryServiceCallback mockBatteryServiceCallback = new MockBatteryServiceCallback() {

            @Override
            public void onBatteryLevelNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

            @Override
            public void onBatteryLevelNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, mockBatteryServiceCallback, null);
        batteryService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        batteryService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteFailed_00203() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = BATTERY_LEVEL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(BATTERY_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BATTERY_LEVEL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGattCharacteristic.PERMISSION_READ);
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        MockBatteryServiceCallback mockBatteryServiceCallback = new MockBatteryServiceCallback() {

            @Override
            public void onBatteryLevelNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

            @Override
            public void onBatteryLevelNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, mockBatteryServiceCallback, null);
        batteryService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        batteryService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteFailed_00204() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = BATTERY_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CURRENT_TIME_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(BATTERY_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BATTERY_LEVEL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGattCharacteristic.PERMISSION_READ);
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        MockBatteryServiceCallback mockBatteryServiceCallback = new MockBatteryServiceCallback() {

            @Override
            public void onBatteryLevelNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

            @Override
            public void onBatteryLevelNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, mockBatteryServiceCallback, null);
        batteryService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        batteryService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteFailed_00205() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CURRENT_TIME_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(BATTERY_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BATTERY_LEVEL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGattCharacteristic.PERMISSION_READ);
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        MockBatteryServiceCallback mockBatteryServiceCallback = new MockBatteryServiceCallback() {

            @Override
            public void onBatteryLevelNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

            @Override
            public void onBatteryLevelNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, mockBatteryServiceCallback, null);
        batteryService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        batteryService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }


    @Test
    public void test_onDescriptorWriteTimeout_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = BATTERY_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = BATTERY_LEVEL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final long originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MockBatteryServiceCallback mockBatteryServiceCallback = new MockBatteryServiceCallback() {

            @Override
            public void onBatteryLevelNotifyStartTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, mockBatteryServiceCallback, null);
        batteryService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteTimeout_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = BATTERY_SERVICE;
        final Integer originalServiceInstanceId = 0;
        final UUID originalCharacteristicUUID = BATTERY_LEVEL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 0;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final long originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);

        BluetoothGattService bluetoothGattService = new BluetoothGattService(BATTERY_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BATTERY_LEVEL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGattCharacteristic.PERMISSION_READ);
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        MockBatteryServiceCallback mockBatteryServiceCallback = new MockBatteryServiceCallback() {

            @Override
            public void onBatteryLevelNotifyStartTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, mockBatteryServiceCallback, null);
        batteryService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        batteryService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteTimeout_00003() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = BATTERY_LEVEL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final long originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);

        BluetoothGattService bluetoothGattService = new BluetoothGattService(BATTERY_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BATTERY_LEVEL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGattCharacteristic.PERMISSION_READ);
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        MockBatteryServiceCallback mockBatteryServiceCallback = new MockBatteryServiceCallback() {

            @Override
            public void onBatteryLevelNotifyStartTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, mockBatteryServiceCallback, null);
        batteryService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        batteryService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteTimeout_00004() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = BATTERY_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CURRENT_TIME_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final long originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);

        BluetoothGattService bluetoothGattService = new BluetoothGattService(BATTERY_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BATTERY_LEVEL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGattCharacteristic.PERMISSION_READ);
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        MockBatteryServiceCallback mockBatteryServiceCallback = new MockBatteryServiceCallback() {

            @Override
            public void onBatteryLevelNotifyStartTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, mockBatteryServiceCallback, null);
        batteryService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        batteryService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteTimeout_00005() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CURRENT_TIME_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final long originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);

        BluetoothGattService bluetoothGattService = new BluetoothGattService(BATTERY_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BATTERY_LEVEL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGattCharacteristic.PERMISSION_READ);
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        MockBatteryServiceCallback mockBatteryServiceCallback = new MockBatteryServiceCallback() {

            @Override
            public void onBatteryLevelNotifyStartTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, mockBatteryServiceCallback, null);
        batteryService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        batteryService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteTimeout_00101() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = BATTERY_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = BATTERY_LEVEL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final long originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MockBatteryServiceCallback mockBatteryServiceCallback = new MockBatteryServiceCallback() {

            @Override
            public void onBatteryLevelNotifyStopTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, mockBatteryServiceCallback, null);
        batteryService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteTimeout_00102() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = BATTERY_SERVICE;
        final Integer originalServiceInstanceId = 0;
        final UUID originalCharacteristicUUID = BATTERY_LEVEL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 0;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final long originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);

        BluetoothGattService bluetoothGattService = new BluetoothGattService(BATTERY_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BATTERY_LEVEL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGattCharacteristic.PERMISSION_READ);
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        MockBatteryServiceCallback mockBatteryServiceCallback = new MockBatteryServiceCallback() {

            @Override
            public void onBatteryLevelNotifyStopTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, mockBatteryServiceCallback, null);
        batteryService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        batteryService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteTimeout_00103() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = BATTERY_LEVEL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final long originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);

        BluetoothGattService bluetoothGattService = new BluetoothGattService(BATTERY_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BATTERY_LEVEL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGattCharacteristic.PERMISSION_READ);
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        MockBatteryServiceCallback mockBatteryServiceCallback = new MockBatteryServiceCallback() {

            @Override
            public void onBatteryLevelNotifyStopTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, mockBatteryServiceCallback, null);
        batteryService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        batteryService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteTimeout_00104() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = BATTERY_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CURRENT_TIME_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final long originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);

        BluetoothGattService bluetoothGattService = new BluetoothGattService(BATTERY_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BATTERY_LEVEL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGattCharacteristic.PERMISSION_READ);
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        MockBatteryServiceCallback mockBatteryServiceCallback = new MockBatteryServiceCallback() {

            @Override
            public void onBatteryLevelNotifyStopTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, mockBatteryServiceCallback, null);
        batteryService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        batteryService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteTimeout_00105() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CURRENT_TIME_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final long originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);

        BluetoothGattService bluetoothGattService = new BluetoothGattService(BATTERY_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BATTERY_LEVEL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGattCharacteristic.PERMISSION_READ);
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        MockBatteryServiceCallback mockBatteryServiceCallback = new MockBatteryServiceCallback() {

            @Override
            public void onBatteryLevelNotifyStopTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, mockBatteryServiceCallback, null);
        batteryService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        batteryService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteTimeout_00201() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = BATTERY_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = BATTERY_LEVEL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final long originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        MockBatteryServiceCallback mockBatteryServiceCallback = new MockBatteryServiceCallback() {

            @Override
            public void onBatteryLevelNotifyStartTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                isCalled.set(true);
            }

            @Override
            public void onBatteryLevelNotifyStopTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, mockBatteryServiceCallback, null);
        batteryService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteTimeout_00202() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = BATTERY_SERVICE;
        final Integer originalServiceInstanceId = 0;
        final UUID originalCharacteristicUUID = BATTERY_LEVEL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 0;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final long originalTimeout = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(BATTERY_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BATTERY_LEVEL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGattCharacteristic.PERMISSION_READ);
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        MockBatteryServiceCallback mockBatteryServiceCallback = new MockBatteryServiceCallback() {

            @Override
            public void onBatteryLevelNotifyStartTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                isCalled.set(true);
            }

            @Override
            public void onBatteryLevelNotifyStopTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, mockBatteryServiceCallback, null);
        batteryService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        batteryService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteTimeout_00203() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = BATTERY_LEVEL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final long originalTimeout = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(BATTERY_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BATTERY_LEVEL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGattCharacteristic.PERMISSION_READ);
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        MockBatteryServiceCallback mockBatteryServiceCallback = new MockBatteryServiceCallback() {

            @Override
            public void onBatteryLevelNotifyStartTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                isCalled.set(true);
            }

            @Override
            public void onBatteryLevelNotifyStopTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, mockBatteryServiceCallback, null);
        batteryService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        batteryService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteTimeout_00204() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = BATTERY_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CURRENT_TIME_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final long originalTimeout = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(BATTERY_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BATTERY_LEVEL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGattCharacteristic.PERMISSION_READ);
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        MockBatteryServiceCallback mockBatteryServiceCallback = new MockBatteryServiceCallback() {

            @Override
            public void onBatteryLevelNotifyStartTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                isCalled.set(true);
            }

            @Override
            public void onBatteryLevelNotifyStopTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, mockBatteryServiceCallback, null);
        batteryService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        batteryService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteTimeout_00205() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CURRENT_TIME_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final long originalTimeout = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(BATTERY_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BATTERY_LEVEL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGattCharacteristic.PERMISSION_READ);
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        MockBatteryServiceCallback mockBatteryServiceCallback = new MockBatteryServiceCallback() {

            @Override
            public void onBatteryLevelNotifyStartTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                isCalled.set(true);
            }

            @Override
            public void onBatteryLevelNotifyStopTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, mockBatteryServiceCallback, null);
        batteryService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        batteryService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertFalse(isCalled.get());
    }


    @Test
    public void test_onCharacteristicNotified_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = BATTERY_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = BATTERY_LEVEL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};
        MockBatteryServiceCallback mockBatteryServiceCallback = new MockBatteryServiceCallback() {

            @Override
            public void onBatteryLevelNotified(@NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull BatteryLevelAndroid batteryLevelAndroid) {
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertArrayEquals(originalValues, batteryLevelAndroid.getBytes());
                isCalled.set(true);
            }

        };

        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, mockBatteryServiceCallback, null);
        batteryService.onCharacteristicNotified(originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues);
        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicNotified_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = BATTERY_SERVICE;
        final Integer originalServiceInstanceId = 0;
        final UUID originalCharacteristicUUID = BATTERY_LEVEL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 0;
        final byte[] originalValues = new byte[]{4};

        BluetoothGattService bluetoothGattService = new BluetoothGattService(BATTERY_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BATTERY_LEVEL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGattCharacteristic.PERMISSION_READ);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        MockBatteryServiceCallback mockBatteryServiceCallback = new MockBatteryServiceCallback() {

            @Override
            public void onBatteryLevelNotified(@NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull BatteryLevelAndroid batteryLevelAndroid) {
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertArrayEquals(originalValues, batteryLevelAndroid.getBytes());
                isCalled.set(true);
            }

        };
        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, mockBatteryServiceCallback, null);
        batteryService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        batteryService.onCharacteristicNotified(originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicNotified_00003() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = BATTERY_LEVEL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};

        BluetoothGattService bluetoothGattService = new BluetoothGattService(BATTERY_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BATTERY_LEVEL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGattCharacteristic.PERMISSION_READ);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        MockBatteryServiceCallback mockBatteryServiceCallback = new MockBatteryServiceCallback() {

            @Override
            public void onBatteryLevelNotified(@NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull BatteryLevelAndroid batteryLevelAndroid) {
                isCalled.set(true);
            }

        };
        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, mockBatteryServiceCallback, null);

        batteryService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        batteryService.onCharacteristicNotified(originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onCharacteristicNotified_00004() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = BATTERY_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CURRENT_TIME_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};

        BluetoothGattService bluetoothGattService = new BluetoothGattService(BATTERY_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BATTERY_LEVEL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGattCharacteristic.PERMISSION_READ);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        MockBatteryServiceCallback mockBatteryServiceCallback = new MockBatteryServiceCallback() {

            @Override
            public void onBatteryLevelNotified(@NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull BatteryLevelAndroid batteryLevelAndroid) {
                isCalled.set(true);
            }

        };
        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, mockBatteryServiceCallback, null);

        batteryService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        batteryService.onCharacteristicNotified(originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onCharacteristicNotified_00005() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CURRENT_TIME_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};

        BluetoothGattService bluetoothGattService = new BluetoothGattService(BATTERY_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BATTERY_LEVEL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGattCharacteristic.PERMISSION_READ);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        MockBatteryServiceCallback mockBatteryServiceCallback = new MockBatteryServiceCallback() {

            @Override
            public void onBatteryLevelNotified(@NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull BatteryLevelAndroid batteryLevelAndroid) {
                isCalled.set(true);
            }

        };
        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, mockBatteryServiceCallback, null);

        batteryService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        batteryService.onCharacteristicNotified(originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_getBatteryLevelCount_00001() {
        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, new MockBatteryServiceCallback(), null);

        assertNull(batteryService.getBatteryLevelCount());
    }

    @Test
    public void test_getBatteryLevelCount_00002() {
        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, new MockBatteryServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }
        };

        assertNotNull(batteryService.getBatteryLevelCount());
        assertEquals(0, batteryService.getBatteryLevelCount().intValue());
    }

    @Test
    public void test_getBatteryLevelCount_00003() {
        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, new MockBatteryServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }
        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(BATTERY_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BATTERY_LEVEL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGattCharacteristic.PERMISSION_READ);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        batteryService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(batteryService.getBatteryLevelCount());
        assertEquals(1, batteryService.getBatteryLevelCount().intValue());
    }

    @Test
    public void test_getBatteryLevelCount_00004() {
        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, new MockBatteryServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }
        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(BATTERY_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BATTERY_LEVEL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGattCharacteristic.PERMISSION_READ);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        batteryService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Arrays.asList(bluetoothGattService, bluetoothGattService), null);

        assertNotNull(batteryService.getBatteryLevelCount());
        assertEquals(2, batteryService.getBatteryLevelCount().intValue());
    }

    @Test
    public void test_getBatteryLevel_00001() {
        final AtomicInteger originalIndex = new AtomicInteger(-1);
        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, new MockBatteryServiceCallback(), null) {

            @Nullable
            @Override
            public synchronized Integer getBatteryLevel(int index) {
                originalIndex.set(index);
                return super.getBatteryLevel(index);
            }
        };

        assertNull(batteryService.getBatteryLevel());
        assertEquals(0, originalIndex.get());
    }

    @Test
    public void test_getBatteryLevel_00002() {
        final int originalLevel = 1;
        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, new MockBatteryServiceCallback(), null) {

            @Override
            public synchronized Integer getBatteryLevel(int index) {
                return originalLevel;
            }

        };

        assertNotNull(batteryService.getBatteryLevel());
        assertEquals(originalLevel, batteryService.getBatteryLevel().intValue());
    }

    @Test
    public void test_getBatteryLevel_00101() {
        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, new MockBatteryServiceCallback(), null);

        assertNull(batteryService.getBatteryLevel(0));
    }

    @Test
    public void test_getBatteryLevel_00102() {
        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, new MockBatteryServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }
        };

        assertNull(batteryService.getBatteryLevel(-1));
    }

    @Test
    public void test_getBatteryLevel_00103() {
        final int originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateReadCharacteristicTaskId(originalTaskId);
        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, new MockBatteryServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }
        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(BATTERY_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BATTERY_LEVEL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGattCharacteristic.PERMISSION_READ);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        batteryService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Arrays.asList(bluetoothGattService, bluetoothGattService), null);

        Integer taskId = batteryService.getBatteryLevel(0);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    public void test_isBatteryLevelNotificatable_00001() {
        final AtomicInteger originalIndex = new AtomicInteger(-1);
        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, new MockBatteryServiceCallback(), null) {

            @Override
            public synchronized boolean isBatteryLevelNotificatable(int index) {
                originalIndex.set(index);
                return super.isBatteryLevelNotificatable(index);
            }

        };

        assertFalse(batteryService.isBatteryLevelNotificatable());
        assertEquals(0, originalIndex.get());
    }

    @Test
    public void test_isBatteryLevelNotificatable_00002() {
        final boolean originaNotificatable = true;
        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, new MockBatteryServiceCallback(), null) {

            @Override
            public synchronized boolean isBatteryLevelNotificatable(int index) {
                return originaNotificatable;
            }

        };

        assertEquals(originaNotificatable, batteryService.isBatteryLevelNotificatable());
    }

    @Test
    public void test_isBatteryLevelNotificatable_00101() {
        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, new MockBatteryServiceCallback(), null);

        assertFalse(batteryService.isBatteryLevelNotificatable(0));
    }

    @Test
    public void test_isBatteryLevelNotificatable_00102() {
        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, new MockBatteryServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }
        };

        assertFalse(batteryService.isBatteryLevelNotificatable(-1));
    }

    @Test
    public void test_isBatteryLevelNotificatable_00103() {
        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, new MockBatteryServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }
        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(BATTERY_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BATTERY_LEVEL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        assertFalse(batteryService.isBatteryLevelNotificatable(0));
    }

    @Test
    public void test_isBatteryLevelNotificatable_00104() {
        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, new MockBatteryServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }
        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(BATTERY_SERVICE, 0);
        batteryService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(batteryService.isBatteryLevelNotificatable(0));
    }

    @Test
    public void test_isBatteryLevelNotificatable_00105() {
        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, new MockBatteryServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }
        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(BATTERY_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BATTERY_LEVEL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        batteryService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(batteryService.isBatteryLevelNotificatable(0));
    }

    @Test
    public void test_isBatteryLevelNotificatable_00106() {
        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, new MockBatteryServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }
        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(BATTERY_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BATTERY_LEVEL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGattCharacteristic.PERMISSION_READ);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        batteryService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(batteryService.isBatteryLevelNotificatable(0));
    }

    @Test
    public void test_isBatteryLevelNotificatable_00107() {
        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, new MockBatteryServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }
        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(BATTERY_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BATTERY_LEVEL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGattCharacteristic.PERMISSION_READ);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        batteryService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertTrue(batteryService.isBatteryLevelNotificatable(0));
    }

    @Test
    public void test_getBatteryLevelCharacteristicPresentationFormat_00001() {
        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, new MockBatteryServiceCallback(), null);

        assertNull(batteryService.getBatteryLevelCharacteristicPresentationFormat());
    }

    @Test
    public void test_getBatteryLevelCharacteristicPresentationFormat_00002() {
        final int originalTaskId = 1;

        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, new MockBatteryServiceCallback(), null) {

            @Override
            public synchronized Integer getBatteryLevelCharacteristicPresentationFormat(int index) {
                return originalTaskId;
            }
        };

        assertNotNull(batteryService.getBatteryLevelCharacteristicPresentationFormat());
        assertEquals(originalTaskId, batteryService.getBatteryLevelCharacteristicPresentationFormat().intValue());
    }

    @Test
    public void test_getBatteryLevelCharacteristicPresentationFormat_00101() {
        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, new MockBatteryServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }
        };

        assertNull(batteryService.getBatteryLevelCharacteristicPresentationFormat(0));
    }

    @Test
    public void test_getBatteryLevelCharacteristicPresentationFormat_00102() {
        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, new MockBatteryServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }
        };

        assertNull(batteryService.getBatteryLevelCharacteristicPresentationFormat(-1));
    }

    @Test
    public void test_getBatteryLevelCharacteristicPresentationFormat_00103() {
        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, new MockBatteryServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }
        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(BATTERY_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BATTERY_LEVEL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        batteryService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNull(batteryService.getBatteryLevelCharacteristicPresentationFormat(0));
    }

    @Test
    public void test_getBatteryLevelCharacteristicPresentationFormat_00104() {
        final int originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateReadDescriptorTaskId(originalTaskId);

        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, new MockBatteryServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }
        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(BATTERY_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BATTERY_LEVEL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CHARACTERISTIC_PRESENTATION_FORMAT_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        batteryService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = batteryService.getBatteryLevelCharacteristicPresentationFormat(0);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    public void test_getBatteryLevelClientCharacteristicConfiguration_00001() {
        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, new MockBatteryServiceCallback(), null);

        assertNull(batteryService.getBatteryLevelClientCharacteristicConfiguration());
    }

    @Test
    public void test_getBatteryLevelClientCharacteristicConfiguration_00002() {
        final int originalTaskId = 1;

        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, new MockBatteryServiceCallback(), null) {

            @Override
            public synchronized Integer getBatteryLevelClientCharacteristicConfiguration(int index) {
                return originalTaskId;
            }
        };

        assertNotNull(batteryService.getBatteryLevelClientCharacteristicConfiguration());
        assertEquals(originalTaskId, batteryService.getBatteryLevelClientCharacteristicConfiguration().intValue());
    }

    @Test
    public void test_getBatteryLevelClientCharacteristicConfiguration_00101() {
        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, new MockBatteryServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }
        };

        assertNull(batteryService.getBatteryLevelClientCharacteristicConfiguration(0));
    }

    @Test
    public void test_getBatteryLevelClientCharacteristicConfiguration_00102() {
        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, new MockBatteryServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }
        };

        assertNull(batteryService.getBatteryLevelClientCharacteristicConfiguration(-1));
    }

    @Test
    public void test_getBatteryLevelClientCharacteristicConfiguration_00103() {
        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, new MockBatteryServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }
        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(BATTERY_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BATTERY_LEVEL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        batteryService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNull(batteryService.getBatteryLevelClientCharacteristicConfiguration(0));
    }

    @Test
    public void test_getBatteryLevelClientCharacteristicConfiguration_00104() {
        final int originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateReadDescriptorTaskId(originalTaskId);
        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, new MockBatteryServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }
        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(BATTERY_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BATTERY_LEVEL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGattCharacteristic.PERMISSION_READ);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        batteryService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = batteryService.getBatteryLevelClientCharacteristicConfiguration(0);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    public void test_startBatteryLevelNotification_00001() {
        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, new MockBatteryServiceCallback(), null);

        assertNull(batteryService.startBatteryLevelNotification());
    }

    @Test
    public void test_startBatteryLevelNotification_00002() {
        final int originalTaskId = 1;

        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, new MockBatteryServiceCallback(), null) {

            @Override
            public synchronized Integer startBatteryLevelNotification(int index) {
                return originalTaskId;
            }
        };

        Integer taskId = batteryService.startBatteryLevelNotification();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    public void test_startBatteryLevelNotification_00101() {
        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, new MockBatteryServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }
        };

        assertNull(batteryService.startBatteryLevelNotification(0));
    }

    @Test
    public void test_startBatteryLevelNotification_00102() {
        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, new MockBatteryServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }
        };

        assertNull(batteryService.startBatteryLevelNotification(-1));
    }

    @Test
    public void test_startBatteryLevelNotification_00103() {
        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, new MockBatteryServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }
        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(BATTERY_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BATTERY_LEVEL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        batteryService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNull(batteryService.startBatteryLevelNotification(0));
    }

    @Test
    public void test_startBatteryLevelNotification_00104() {
        final int originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateWriteDescriptorTaskId(originalTaskId);
        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, new MockBatteryServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }
        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(BATTERY_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BATTERY_LEVEL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGattCharacteristic.PERMISSION_READ);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        batteryService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = batteryService.startBatteryLevelNotification(0);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    public void test_stopBatteryLevelNotification_00001() {
        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, new MockBatteryServiceCallback(), null);

        assertNull(batteryService.stopBatteryLevelNotification());
    }

    @Test
    public void test_stopBatteryLevelNotification_00002() {
        final int originalTaskId = 1;

        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, new MockBatteryServiceCallback(), null) {

            @Override
            public synchronized Integer stopBatteryLevelNotification(int index) {
                return originalTaskId;
            }
        };

        Integer taskId = batteryService.stopBatteryLevelNotification();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    public void test_stopBatteryLevelNotification_00101() {
        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, new MockBatteryServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }
        };

        assertNull(batteryService.stopBatteryLevelNotification(0));
    }

    @Test
    public void test_stopBatteryLevelNotification_00102() {
        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, new MockBatteryServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }
        };

        assertNull(batteryService.stopBatteryLevelNotification(-1));
    }

    @Test
    public void test_stopBatteryLevelNotification_00103() {
        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, new MockBatteryServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }
        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(BATTERY_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BATTERY_LEVEL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        batteryService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNull(batteryService.stopBatteryLevelNotification(0));
    }

    @Test
    public void test_stopBatteryLevelNotification_00104() {
        final int originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateWriteDescriptorTaskId(originalTaskId);

        BatteryService batteryService = new BatteryService(MOCK_BLE_CONNECTION, new MockBatteryServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }
        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(BATTERY_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BATTERY_LEVEL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGattCharacteristic.PERMISSION_READ);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        batteryService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = batteryService.stopBatteryLevelNotification(0);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

}
